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

import java.util.ArrayList;

/**
 * Class that defines a Character.
 *
 * @version 1.0
 */
public class Character
{
    private Room currentRoom; //current room the character is in
    private String label; //a label giving a basic description of the character

    /**
     * Constructor for the Character class.
     *
     * @param currentRoom this is the character's current room.
     * @param label this is the character's current label.
     * @throws IllegalArgumentException when the current room is null
     */
    public Character(Room currentRoom, String label)
    {
        if(currentRoom == null) // if the current room parameter is null, throw exception
        {
            throw new IllegalArgumentException("The current room is null.");
        }
        this.currentRoom = currentRoom;
        this.label = label;
    }

    /**
     * Accessor for currentRoom.
     *
     * @return the room for the player is currently in.
     */
    public Room getCurrentRoom()
    {
        return this.currentRoom;
    }

    /**
     * Accessor for label.
     *
     * @return the string for the label of the character.
     */
    public String getLabel()
    {
        return this.label;
    }

    /**
     * Accessor for adjacentRooms.
     *
     * @return an arraylist of adjacent rooms relative to the current room.
     */
    public ArrayList<Room> getAdjacentRooms()
    {
        return this.currentRoom.getAdjacentRooms();
    }

    /**
     * Mutator for the currentRoom field.
     *
     * @param newRoom the new room to be the current room of the character.
     */
    public void setCurrentRoom(Room newRoom)
    {
        this.currentRoom = newRoom;
    }
}

