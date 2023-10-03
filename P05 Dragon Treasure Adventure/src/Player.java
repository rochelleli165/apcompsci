//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Player
// Course:   CS 300 Fall 2022
//
// Author:   Derek Zhang
// Email:    dzhang366@wisc.edu
// Lecturer: Professor Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Rochelle Li
// Partner Email:   rli484@wisc.edu
// Partner Lecturer's Name: Professor Hobbes Legault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   x Write-up states that pair programming is allowed for this assignment.
//   x We have both read and understand the course Pair Programming Policy.
//   x We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////


/**
 * Class that represents a player in a Dragon Treasure game.
 *
 * @version 1.0
 */
public class Player extends Character implements Moveable
{
    // instance fields
    private boolean hasKey; // whether the player has the treasure key or not

    // constructor

    /**
     * Constructor for the player object. The label should be "PLAYER" and not have a key by default.
     *
     * @param currentRoom the room that the player should start in.
     * @throws IllegalArgumentException if the currentRoom is not a StartRoom.
     */
    public Player(Room currentRoom)
    {
        // call superconstructor
        super(currentRoom, "PLAYER");

        // check validity of input
        if(!(currentRoom instanceof StartRoom))
        {
            throw new IllegalArgumentException("currentRoom not a start room");
        }
    }

    // mutators/accessors

    /**
     * Determinnes if the player has the key.
     *
     * @return true if the player has the key, false otherwise
     */
    public boolean hasKey()
    {
        return this.hasKey;
    }

    /**
     * Gives the player the key.
     */
    public void obtainKey()
    {
        this.hasKey = true;
    }

    /**
     * Moves the Player to the destination room.
     *
     * @param destination the Room to move the player to.
     * @return true if the change was successful, false otherwise.
     */
    public boolean changeRoom(Room destination)
    {
        // check validity of room
        boolean valid = canMoveTo(destination);

        // if valid set current room to destination
        if(valid)
        {
            this.setCurrentRoom(destination);
        }

        // return the validity of the move, only true if a move was successfully made
        return valid;
    }

    /**
     * Checks if the player can move to the given destination. A valid move is to a room adjacent
     * to the player.
     *
     * @param destination the Room to check if the player can move to.
     * @return true if they can, false otherwise.
     */
    public boolean canMoveTo(Room destination)
    {
        // move invalid if destination room not adjacent to current room. IsAdjacent returns true or
        // false in exactly the way required
        return this.getCurrentRoom().isAdjacent(destination);
    }

    /**
     * Checks if the player needs to teleport and moves them if needed.
     *
     * @return true if the player was teleported, false otherwise.
     */
    public boolean teleport()
    {
        // if current room is a portal room, get the portal destination and then move the player to
        // the destination room.
        if(this.getCurrentRoom() instanceof PortalRoom)
        {
            PortalRoom portal = (PortalRoom) this.getCurrentRoom();
            this.setCurrentRoom(portal.getTeleportLocation());
            return true;
        }

        // there was no teleportation necessary.
        return false;
    }

    /**
     * Determines whether the given dragon is nearby or not. A dragon is considered nearby if it is
     * in one of the adjacent rooms.
     *
     * @param d the dragon to check if nearby.
     * @return true if the dragon is nearby, false otherwise.
     */
    public boolean isDragonNearby(Dragon d)
    {
        // return true if current room is adjacent to the dragon's current room.
        return this.getCurrentRoom().isAdjacent(d.getCurrentRoom());
    }

    /**
     * Determines whether a room of a certain type is nearby or not. A room is considered nearby if
     * it is one of the adjacent rooms.
     *
     * @param roomType the class of room to search for within the adjacent rooms list.
     * @return true if a room of the supplied type is nearby, false otherwise.
     */
    private boolean isRoomTypeNearby(Object roomType)
    {
        for(Room room : this.getAdjacentRooms())
        {
            // check if the classes are the same
            //    (classes are also objects and thus have .equals() methods)
            if(room.getClass().equals(roomType.getClass()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines whether a PortalRoom is nearby or not. A PortalRoom is considered nearby if it is
     * one of the adjacent rooms.
     *
     * @return true if a PortalRoom is nearby, false otherwise.
     */
    public boolean isPortalNearby()
    {
        // call helper method input search query PortalRoom
        return isRoomTypeNearby(PortalRoom.class);
    }

    /**
     * Determines whether a TreasureRoom is nearby or not. A TreasureRoom is considered nearby if
     * it is one of the adjacent rooms.
     *
     * @return true if a TreasureRoom is nearby, false otherwise.
     */
    public boolean isTreasureNearby()
    {
        // call helper method input search query TreasureRoom
        return isRoomTypeNearby(TreasureRoom.class);
    }
}

