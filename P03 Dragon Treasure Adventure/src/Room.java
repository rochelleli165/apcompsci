import java.util.ArrayList;

/**
 * This class constructs an object Room that a player and dragon enters It has a type, description,
 * a list of rooms that connect to the current room, Unique id, and a teleportation id if the room
 * is a portal Warnings are set of the portals and treasure
 */
public class Room {
  private RoomType type; // one of the four types a room could be
  private String roomDescription; // a brief description of the room
  private ArrayList<Room> adjRooms; // arraylist that holds the rooms adjacent
  private final int ID; // unique ID for each room to identify it
  private static int teleportLocationID; // place where all portal rooms will go to
  private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
  private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";

  /**
   * The constructor creates the object of Room
   * 
   * @param id the unique ID for each room to identify it
   * @param roomDescription the short description of the room
   */
  public Room(int id, String roomDescription) {
    adjRooms = new ArrayList<Room>();
    ID = id;
    this.roomDescription = roomDescription;
    this.type = RoomType.NORMAL;
  }

  /**
   * This accessor gives us access to the room type of the room
   * 
   * @return the RoomType of the room
   */
  public RoomType getType() {
    return this.type;
  }

  /**
   * This accessor returns the id of the room
   * 
   * @return id the of the room
   */
  public int getID() {
    return this.ID;
  }

  /**
   * This accessor returns a list of of adjacent rooms to the current room
   * 
   * @return a list adjRooms that represent a list of adjacent rooms to the current room
   */
  public ArrayList<Room> getAdjacentRooms() {
    return this.adjRooms;
  }

  /**
   * In the list of adjacent rooms to the current room, add another room toAdd to the list, so room
   * is next to toAdd (along with all the other rooms in the list adjRooms
   * 
   * @param toAdd the room being added to the list of adjacent rooms
   */
  public void addToAdjacentRooms(Room toAdd) {
    adjRooms.add(toAdd);
  }

  /**
   * A room has a description constructed, and to access it this method is used to return the
   * description
   * 
   * @return the String room Description
   */
  public String getRoomDescription() {
    return this.roomDescription;
  }

  /**
   * The mutator sets the a new RoomType to the room, ranging from the enum four types: NORMAL,
   * PORTAL, START, and TREASURE
   * 
   * @param newType RoomType ranging from NORMAL, PORTAL, START, and TREASURE only
   */
  public void setRoomType(RoomType newType) {
    this.type = newType;
  }

  /**
   * Gives a teleportation ID to the current room that will later direct the portal to the said ID
   * room
   * 
   * @param telepotID
   */
  public static void assignTeleportLocation(int telepotID) {
    teleportLocationID = telepotID;
  }

  /**
   * When called, returns the portal warning signifying that a portal is nearby
   * 
   * @return the String portal Warning
   */
  public static String getPortalWarning() {
    return PORTAL_WARNING;
  }

  /**
   * When called, returns the treasure warning signifying that treasure is nearby
   * 
   * @return the String treasure warning
   */
  public static String getTreasureWarning() {
    return TREASURE_WARNING;
  }

  /**
   * When called, gives out the location id of the room the portal teleports the player into
   * 
   * @return the ID of the room the portal teleports the player into
   */
  public static int getTeleportationRoom() {
    return teleportLocationID;
  }

  /**
   * Determines if the given room r is adjacent to the current chosen room.
   * 
   * @param r is presented room to check if it's adjacent
   * @return true if the room r is adjacent to the current room, false if otherwise
   */
  public boolean isAdjacent(Room r) {
    return adjRooms.contains(r);
  }

  /**
   * Determines if the given object is equal to this room. They are equal if other is a Room and
   * their IDs are the same.
   * 
   * @param other, another object to check if it is equal to this
   * @return true if the two rooms are equal, false otherwise
   * @author Michelle
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof Room) {
      Room otherRoom = (Room) other;
      return this.ID == otherRoom.ID;
    }
    return false;
  }

  /**
   * Returns a String representation of this room.
   * 
   * @return the string representation of this room and it’s object data field values
   * @author Michelle
   */
  @Override
  public String toString() {
    String s = this.ID + ": " + this.roomDescription + " (" + type + ")\n Adjacent Rooms: ";
    for (int i = 0; i < adjRooms.size(); i++) {
      s += adjRooms.get(i).ID + " ";
    }
    return s;
  }
}
