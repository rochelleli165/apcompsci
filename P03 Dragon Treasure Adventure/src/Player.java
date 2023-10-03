import java.util.ArrayList;

/**
 * This class constructs a player, which is essentially the user's role in the game. The player
 * starts in a current room, and with that moves thoughout all the whole entire dungeon (adjacent
 * rooms). There are certain warnings that trigger if the player's location is close to treasure or
 * a portal is nearby
 */
public class Player {
  private Room currentRoom;

  /**
   * The constructor creates the object player, that has a currentRoom as where the player starts up
   * as, since they start in this room, the RoomType is START.
   * 
   * @param currentRoom the room the player starts in
   */
  public Player(Room currentRoom) {
    this.currentRoom = currentRoom;
    this.currentRoom.setRoomType(RoomType.START);
  }

  /**
   * The accessor helps us obtain and get the current room the player is in
   * 
   * @return the Room the player is in
   */
  public Room getCurrentRoom() {
    return this.currentRoom;
  }

  /**
   * The method switches the currentRoom the player is in to another room
   * 
   * @param newRoom the room the player is now inside
   */
  public void changeRoom(Room newRoom) {
    this.currentRoom = newRoom;
  }

  /**
   * The method checks if the player can move to that specific given room, and in order to check it
   * sees if the room is in the list of adjacent rooms
   * 
   * @param destination the specific room the player would like to enter
   * @return true if the player is adjacent and can move to that room, false otherwise
   */
  public boolean canMoveTo(Room destination) {
    if (currentRoom.getAdjacentRooms().contains(destination)) {
      return true;
    }
    return false;
  }

  /**
   * The method sees if the player has to teleport or not based on the room type (if it's portal,
   * then the player has to teleport)
   * 
   * @return true of the RoomType is PORTAL and the player must teleport or false otherwise
   */
  public boolean shouldTeleport() {
    if (currentRoom.getType().equals(RoomType.PORTAL)) {
      return true;
    }
    return false;
  }

  /**
   * The accessor returns the list of adjacent rooms the player is in based on what room the player
   * is currently in
   * 
   * @return the list of Rooms adjacent to the player/player's current room
   */
  public ArrayList<Room> getAdjacentRoomsToPlayer() {
    return currentRoom.getAdjacentRooms();
  }

  /**
   * Checks to see is the dragon is the player
   * 
   * @param d the dragon that resides in a random room
   * @return true if the dragon's current room is adjacent to the player's current room, false
   *         otherwise
   */
  public boolean isDragonNearby(Dragon d) {
    for (Room x : currentRoom.getAdjacentRooms()) {
      if (x.equals(d.getCurrentRoom())) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks the adjacent rooms to the player to see if they are a room that is a portal room (their
   * RoomType should be PORTAL)
   * 
   * @return true is an adjacent room in the list of adjacent rooms has a roomType portal, false
   *         otherwise
   */
  public boolean isPortalNearby() {
    for (Room adjRoom : getAdjacentRoomsToPlayer()) {
      if (adjRoom.getType().equals(RoomType.PORTAL)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks the adjacent rooms to the player to see if they are a room that is a treasure room
   * (their RoomType should be TREASURE)
   * 
   * @return true is an adjacent room in the list of adjacent rooms has a roomType treasure, false
   *         otherwise
   */
  public boolean isTreasureNearby() {
    for (Room adjRoom : getAdjacentRoomsToPlayer()) {
      if (adjRoom.getType().equals(RoomType.TREASURE)) {
        return true;
      }
    }
    return false;
  }
}
