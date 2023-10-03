//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    PortalRoom
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

import java.util.Random;
/**
 * Class that defines a portal room. Extends Room as a superclass.
 *
 * @version 1.0
 */
public class PortalRoom extends Room
{
    private Random randGen; //random number generator for location picking
    private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
    private static final String TELEPORT_MESSAGE = "The space distortion teleported" +
            "you to another room!\n";
    private static PImage portalImage; //image of a portal to be shown in all portal rooms

    /**
     * Constructor for the PortalRoom class.
     *
     * @param ID this new PortalRoom's ID.
     * @param description this new PortalRoom's description
     * @param image this is the new PortalRoom's image
     */
    public PortalRoom(int ID, String description, PImage image)
    {
        super(ID, description, image);
    }

    /**
     * Accessor for PORTAL_WARNING.
     *
     * @return the string for the warning of a nearby portal.
     */
    public static String getPortalWarning()
    {
        return PORTAL_WARNING;
    }

    /**
     * Accessor for TELEPORT_MESSAGE.
     *
     * @return the string for message about being teleported.
     */
    public static String getTeleportMessage()
    {
        return TELEPORT_MESSAGE;
    }

    /**
     * Accessor for ID of random teleported room.
     *
     * @return the random ID of one of the adjacent rooms in .
     */
    public Room getTeleportLocation()
    {
        int numRooms = getAdjacentRooms().size(); // the number of adjacent rooms
        int randomRoom = randGen.nextInt(numRooms); // a random number of one of the adjacent rooms
        // is picked out
        return getAdjacentRooms().get(randomRoom); // return the random room in adjacent rooms
    }

    /**
     * Overrides the Room draw to draw a portal on top of the default image
     * The room draw method draws this Room to the window by drawing the background image, a
     * rectangle, and some text.
     */
    @Override
    public void draw()
    {
        super.draw();
        // draw background image
        processing.image(this.portalImage, 325, 225);
    }

    /**
     * Mutator for the portalBackground field.
     *
     * @param portalImage the new image to be set as the portal background.
     */
    public static void setPortalImage(PImage portalImage)
    {
        PortalRoom.portalImage = portalImage;
    }
}

