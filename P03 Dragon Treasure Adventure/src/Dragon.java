import java.util.Random;

/**
 * This class creates an object Dragon that is the main enemy of the game. Like the player, it will
 * reside in a room full of treasure (the player's goal) and randomly move around adjacent rooms
 * until the player finds the treasure room or the player enters where the dragon is (in which case
 * the player loses and the dragon wins)
 */
public class Dragon {
  private Room currentRoom;
  private Random randGen;
  private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";

  /**
   * The constructor creates the Dragon object
   * 
   * @param currentRoom is the room the dragon starts in, and it has a RoomType TREASURE because the
   *        dragon owns that treasure
   */
  public Dragon(Room currentRoom) {
    this.currentRoom = currentRoom;
    this.currentRoom.setRoomType(RoomType.TREASURE);
    randGen = new Random();
  }

  /**
   * The accessor helps us get access to the dragon's current location of which room its in
   * 
   * @return a Room that the dragon is currently in
   */
  public Room getCurrentRoom() {
    return currentRoom;
  }

  /**
   * The dragon moves to a random adjacent room, if the room is a portal then it moves to another
   * random room until it lands in a room that is not a portal
   */
  public void changeRooms() {
    int length = currentRoom.getAdjacentRooms().size();
    boolean progress = true;
    while (progress) {
      int randIndex = randGen.nextInt(0, length);
      if (!currentRoom.getAdjacentRooms().get(randIndex).getType().equals(RoomType.PORTAL)) {
        currentRoom = currentRoom.getAdjacentRooms().get(randIndex);
        progress = false;
      }
    }
  }

  /**
   * The method gives us access to the warning that a dragon is nearby
   * 
   * @return the String of the dragon being nearby
   */
  public static String getDragonWarning() {
    return DRAGON_WARNING;
  }
}
