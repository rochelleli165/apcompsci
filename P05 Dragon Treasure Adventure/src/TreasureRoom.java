//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    TreasureRoom
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


import processing.core.PImage;

/**
 * Class that defines a treasure room. Extends Room as a superclass.
 *
 * @version 1.0
 */
public class TreasureRoom extends Room
{
    // instance and static fields
    private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
    private static PImage treasureBackground; // the image ALWAYS used for treasure rooms

    /**
     * Constructor for the TreasureRoom class.
     *
     * @param ID this new TreasureRoom's ID.
     */
    public TreasureRoom(int ID)
    {
        super(ID, TREASURE_WARNING, treasureBackground);
    }

    /**
     * Accessor for TREASURE_WARNING.
     *
     * @return the string for warning about treasure being nearby.
     */
    public static String getTreasureWarning()
    {
        return TREASURE_WARNING;
    }

    /**
     * Determines whether the player can acquire the treasure in this room or not.
     *
     * @param p the Player to check if they can acquire the treasure.
     * @return true if the player has the key and is in this TreasureRoom, false otherwise.
     */
    public boolean playerCanGrabTreasure(Player p)
    {
        // true if player has key and is in this room, false otherwise
        return p.hasKey() && p.getCurrentRoom().equals(this);
    }

    /**
     * Mutator for the treasureBackground field.
     *
     * @param treasureBackground the new image to be set as the treasure background.
     */
    public static void setTreasureBackground(PImage treasureBackground)
    {
        TreasureRoom.treasureBackground = treasureBackground;
    }
}

