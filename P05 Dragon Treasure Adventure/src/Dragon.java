//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Character
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

import javax.sound.sampled.Port;
import java.util.Random;

/**
 * Class that represents a dragon in a Dragon Treasure game.
 *
 * @version 1.0
 */
public class Dragon extends Character implements Moveable
{
    private Random randGen; //random num generator used for moving
    private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";
    private static final String DRAGON_ENCOUNTER = "Oh no! You ran into the fire"
            + "breathing dragon!\n";

    /**
     * Constructor for the dragon object. The label should be "DRAGON"
     *
     * @param currentRoom the room that the dragon should start in.
     * @throws IllegalArgumentException if the currentRoom is not a TreasureRoom.
     */
    public Dragon(Room currentRoom)
    {
        // call super constructor for setting currentRoom and label
        super(currentRoom, "DRAGON");
        // if the starting current room is not a treasure room, return exception
        if(!(currentRoom instanceof TreasureRoom))
        {
            throw new IllegalArgumentException("Room is not treasure room");
        }
    }
    /**
     * Moves the Dragon to the destination room.
     *
     * @param destination the Room to move the dragon to.
     * @return true if the change was successful, false otherwise.
     */
    public boolean changeRoom(Room destination)
    {
        // checks to see if dragon can move to the destination or not;
        if(!canMoveTo(destination))
        {
            return false;
        }
        // moves the dragon to the destination room
        setCurrentRoom(destination);
        return true;
    }
    /**
     * Checks if the dragon can move to the given destination. A valid move is to a room adjacent
     * to the dragon.
     *
     * @param destination the Room to check if the dragon can move to.
     * @return true if they can, false otherwise.
     */
    public boolean canMoveTo(Room destination)
    {
        // if the destination is a portal Room or if destination not adjacent, return false
        if(destination instanceof PortalRoom || !this.getAdjacentRooms().contains(destination))
        {
            return false;
        }
        return true;
    }

    /**
     * Picks a random room out of the adjacents rooms of the current room to have the dragon try
     * and move
     *
     * @return a random room that dragon can move to
     */
    public Room pickRoom()
    {
        int numRooms = getCurrentRoom().getAdjacentRooms().size(); // the number of adjacent rooms
        int randomRoom = randGen.nextInt(numRooms); // a random number chosen between the number of
        // adjacent rooms
        return getAdjacentRooms().get(randomRoom);
    }

    /**
     * Accessor for the dragon warning
     *
     * @return a String DRAGON WARNING
     */
    public static String getDragonWarning()
    {
        return DRAGON_WARNING;
    }

    /**
     * Accessor for the the message when encountering the dragon
     *
     * @return the String message of dragon encounter
     */
    public static String getDragonEncounter()
    {
        return DRAGON_ENCOUNTER;
    }
}

