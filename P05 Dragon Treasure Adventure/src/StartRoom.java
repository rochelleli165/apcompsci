//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    StartRoom
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
 * Class that defines a starting room. Extends Room as a superclass
 *
 * @version 1.0
 */
public class StartRoom extends Room
{
    /**
     * Constructor for a StartRoom object. Initializes all instance data fields.
     *
     * @param ID          this StartRoom's ID.
     * @param image       this StartRoom's background image.
     */
    public StartRoom(int ID, PImage image)
    {
        super(ID, "You find yourself in the entrance to a cave holding treasure.", image);
    }
}
