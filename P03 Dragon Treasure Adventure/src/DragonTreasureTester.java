//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P03 Dragon Treasure Adventure
// Course: CS 300 Fall 2022
//
// Author: Rochelle Li
// Email: rli484@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: Rachelle by teaching me how Array.contains() worked
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;

/**
 * The tester class checks all of the methods written in Room.java, Player.java, and Dragon.java.
 */
public class DragonTreasureTester {
  /**
   * The main method runs all of the tester methods to see if they all work.
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testRoomInstanceMethods(): " + testRoomInstanceMethods());
    System.out.println("testRoomStaticMethods(): " + testRoomStaticMethods());
    System.out.println("testPlayerCanMoveTo(): " + testPlayerCanMoveTo());
    System.out.println("testPlayerShouldTeleport(): " + testPlayerShouldTeleport());
    System.out.println("testPlayerDetectNearbyRooms(): " + testPlayerDetectNearbyRooms());
    System.out.println("testDragonChangeRooms(): " + testDragonChangeRooms());
  }

  /**
   * Tests the instance methods in Room.java. This includes the constructors accessors setters, and
   * such.
   * 
   * @return true if all methods work as intended, false otherwise
   */
  public static boolean testRoomInstanceMethods() {
    Room test = new Room(0, "lots of carrots here");
    try {
      // case 1: check if the type by default is NORMAL
      if (test.getType() != RoomType.NORMAL) {
        System.out.println("The RoomType default should be normal");
        return false;
      }
      // case 2: check the constructed ID works and the getID function works
      if (test.getID() != 0) {
        System.out.println("The getID() function doesn't work!");
        return false;
      }
      // case 3: check is the room description constructor and accessor works
      if (!test.getRoomDescription().equals("lots of carrots here")) {
        System.out.println("The getRoomDescription() function doesn't work!");
        return false;
      }
      // case 4: adjacent rooms second is added to check addToAdjacent Rooms
      Room second = new Room(1, "a witch!");
      test.addToAdjacentRooms(second);
      ArrayList<Room> correctAdjRooms = new ArrayList<Room>();
      correctAdjRooms.add(second);
      // case 4.1: the corrected adjacent rooms are received
      if (!test.getAdjacentRooms().equals(correctAdjRooms)) {
        System.out.println("second room is not adjacent");
        return false;
      }
      // case 4.2 checks a specific room to be adjacent
      if (!test.isAdjacent(second)) {
        System.out.println("The second is not adjacent to test, but it should be.");
        return false;
      }
      test.setRoomType(RoomType.TREASURE);
      // case 5: checks the getType() function
      if (test.getType() != RoomType.TREASURE) {
        System.out.println("The setRoomType() function does not work, it was not set to TREASURE");
        return false;
      }
      return true;
    } catch (NullPointerException e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Tests all of the static methods in Room.java. This includes if the portal and treasure warnings
   * return the right phrases, and if the assignin/getting teleportation location and ID works as
   * well
   * 
   * @return true if all static methods work, false otherwise
   */
  public static boolean testRoomStaticMethods() {
    String portal_warning = Room.getPortalWarning();
    // case 1: the portal warning doesn't return the right quote
    if (!portal_warning.equals("You feel a distortion in space nearby.\n")) {
      System.out.println("The portal warning isn't returned properly");
      return false;
    }
    String treasure_warning = Room.getTreasureWarning();
    // case 2: the treasure warning doesn't return the right quote
    if (!treasure_warning.equals("You sense that there is treasure nearby.\n")) {
      System.out.println("The treasure warning doesn't return the right phrase");
      return false;
    }
    // case 3: the teleportlocation assignment and accessor doesn't work
    Room.assignTeleportLocation(6);
    if (Room.getTeleportationRoom() != 6) {
      System.out.println("THe teleportation static methods are wrong");
      return false;
    }
    return true;
  }

  /**
   * tests the Player.java method canMoveTo to see if the player can move to the room of not
   * 
   * @return true if the method works as intended, false otherwise
   */
  public static boolean testPlayerCanMoveTo() {
    Room test = new Room(0, "Wonderful sunny room");
    Room second = new Room(1, "Raining room");
    Room third = new Room(2, "Foggy room");
    test.addToAdjacentRooms(second);
    Player Bob = new Player(test);
    // case 1: can't move to adjacent room
    if (!Bob.canMoveTo(second)) {
      System.out.println("canMoveTo error, player move to adjacent room");
      return false;
    }
    // case 2: can move into non-adjacent room
    if (Bob.canMoveTo(third)) {
      System.out.println("can MoveTo error Bob shouldn't move to this non-adjacent room.");
      return false;
    }
    return true;
  }

  /**
   * Checks to see if Bob should teleport when the RoomType is PORTAL
   * 
   * @return true if Bob teleports when the room is a PORTAL, false otherwise
   */
  public static boolean testPlayerShouldTeleport() {
    Room test = new Room(0, "Wonderful sunny room");
    Player Bob = new Player(test);
    test.setRoomType(RoomType.PORTAL);
    // case 1: Bob does not react or return true when he should teleport
    if (!Bob.shouldTeleport()) {
      System.out.println("shouldTeleport() error: Bob should've teleported");
      return false;
    }
    return true;
  }

  /**
   * Checks to see if the warnings of treasure and portals appear in the player's vicinity (if those
   * RoomTypes appear in the adjacent rooms list)
   * 
   * @return true if the methods could detect nearby portal and treasure rooms faslse if otherwise
   */
  public static boolean testPlayerDetectNearbyRooms() {
    Room test = new Room(0, "Wonderful sunny room");
    Room second = new Room(1, "Raining room");
    second.setRoomType(RoomType.PORTAL);
    Room third = new Room(2, "hi");
    Player Bob = new Player(test);
    third.setRoomType(RoomType.TREASURE);
    test.addToAdjacentRooms(second);
    test.addToAdjacentRooms(third);
    // case 1: the portal warning does not trigger
    if (!Bob.isPortalNearby()) {
      System.out.println("isPortalNearby() error: Bob shouldn't be near portal.");
      return false;
    }
    // case 2: the treasure warning does not trigger
    if (!Bob.isTreasureNearby()) {
      System.out.println("isTreasureNearby() error: Bob shouldn't be near treasure.");
      return false;
    }
    return true;
  }

  /**
   * Checks to see if the dragon changes rooms correctly. It has to move into an adjacent room and
   * move into a room that is not a portal room
   * 
   * @return true if the dragon moved to the correct room, false if otherwise
   */
  public static boolean testDragonChangeRooms() {
    // case: the dragon does not move to another room if it enters the portal
    // this case is tested 100 times to ensure randomness
    for (int i = 0; i < 100; i++) {
      Room test = new Room(0, "Wonderful sunny room");
      Room second = new Room(1, "Raining room");
      second.setRoomType(RoomType.PORTAL);
      Room third = new Room(2, "hi");
      test.addToAdjacentRooms(second);
      test.addToAdjacentRooms(third);
      Dragon d = new Dragon(test);
      d.changeRooms();
      if (!d.getCurrentRoom().equals(third)) {
        return false;
      }
    }
    return true;

  }

}
