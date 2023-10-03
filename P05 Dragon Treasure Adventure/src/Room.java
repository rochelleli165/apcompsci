//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Room
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

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

/**
 * A class that represents a room within the dragon treasure game
 *
 * @version 1.0
 */
public class Room
{
    private String description; // verbal description of the room
    private ArrayList<Room> adjRooms; // list of all rooms directly connect
    private final int ID; // a "unique" identifier for each room
    protected static PApplet processing; // PApplet object which the rooms will use to
    //draw stuff to the GUI
    private PImage image; // stores the image that corresponds to the background of a room

    /**
     * Constructor for a Room object. Initializes all instance data fields.
     *
     * @param ID this Room's ID.
     * @param description this Room's verbal description.
     * @param image this Room's background image.
     */
    public Room(int ID, String description, processing.core.PImage image)
    {
        // initialize instance data fields
        this.ID = ID;
        this.description = description;
        this.image = image;
        this.adjRooms = new ArrayList<Room>();
    }

    /**
     * Accessor for the ID.
     *
     * @return this Room's ID.
     */
    public int getID()
    {
        return this.ID;
    }

    /**
     * Accessor for the description.
     *
     * @return this Room's description.
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Accessor for the list of adjacent rooms.
     *
     * @return this Room's list of adjacent lists.
     */
    public ArrayList<Room> getAdjacentRooms()
    {
        return this.adjRooms;
    }

    /**
     * Mutator that sets processing for Room
     * @param processing this is the set processing
     */
    public static void setProcessing(PApplet processing)
    {
        Room.processing = processing;
    }

    /**
     * Adds a new room to this Room's list of adjacent rooms.
     *
     * @param toAdd the room to add.
     */
    public void addToAdjacentRooms(Room toAdd)
    {
        // add new room
        this.adjRooms.add(toAdd);
    }

    /**
     * Checks whether or not the given room is adjacent to this room.
     *
     * @param r the room to check for adjacency.
     * @return true if adjacent, false otherwise.
     */
    public boolean isAdjacent(Room r)
    {
        // test if adjRooms contains r and return teh result of the contains method
        return this.adjRooms.contains(r);
    }

    /**
     * Overrides Object.equals. Determines if two objects are equal.
     *
     * @param other the object t.
     * @return true if other is of type Room and has the same ID, false otherwise.
     */
    public boolean equals(Object other)
    {
        // check for null
        if(other == null)
        {
            return false;
        }

        // check for type
        if(!(other instanceof Room))
        {
            return false;
        }

        // cast other to a Room and returns true if its ID is equal to this room's ID
        return ((Room) other).getID() == this.ID;
    }

    /**
     * Overrides toString() in object class, and prints out the ID, description, and
     * adjacent rooms
     *
     * @return the string form of "<ID>: <description>\n Adjacent Rooms: <r1's ID> <r2's ID>"
     *         list of adjacent room IDs continues for all rooms adjacent to this Room.
     */
    @Override
    public String toString()
    {
        String adjRoomsList = "";
        for(Room room : adjRooms)
        {
            adjRoomsList += room.getID() + " ";
        }
        return this.ID + ": " + this.description + "\n Adjacent Rooms: " + adjRoomsList;
    }

    /**
     * Draws this Room to the window by drawing the background image, a rectangle, and some text.
     */
    public void draw()
    {
        // draw background image
        processing.image(this.image, 0, 0);

        // set color to "flavescent"
        processing.fill(-7028);

        // draw the rectangle
        processing.rect(0,500,800,800);

        // set color to black
        processing.fill(0);

        // draw the description text
        processing.text(this.toString(), 300, 525);
        System.out.println("drew room.");
    }
}

