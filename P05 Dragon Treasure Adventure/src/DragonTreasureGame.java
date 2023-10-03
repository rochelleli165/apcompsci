//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Dragon Treasure Game
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main class for the dragon treasure game.
 *
 * @version 1.0
 */
public class DragonTreasureGame extends PApplet
{
    // instance fields
    private ArrayList<Room> roomList; // the list of rooms in the current game
    private ArrayList<Character> characters; // the list of the characters in the game
    private File roomInfo; // mapping information
    private File mapInfo; // mapping information as well
    private boolean isDragonTurn; // whether it is the dragon's turn to move or not.
    private int gameState; // 0 for continue, 1 if the player won, 2 if the player lost.

    /**
     * Main method for the Dragon Treasure game. Starts up the application.
     *
     * @param args unused
     */
    public static void main (String[] args)
    {
        PApplet.main("DragonTreasureGame");
    }

    @Override
    public void settings()
    {
        size(800, 600);
    }

    @Override
    public void setup()
    {
        // set up instance fields
        this.getSurface().setTitle("Dragon Treasure Adventure"); // sets the title of the window
        this.imageMode(PApplet.CORNER); // Images are drawn using the x,y-coordinate
        // as the top-left corner
        this.rectMode(PApplet.CORNERS); // When drawing rectangles interprets args
        // as top-left corner and bottom-right corner respectively
        this.focused = true; // window will be active upon running program
        this.textAlign(CENTER); // sets the text alignment to center
        this.textSize(20); // sets the font size for the text
        this.roomInfo = new File("roominfo.txt"); // room save file load
        this.mapInfo = new File("map.txt"); // map save file load
        this.roomList = new ArrayList<Room>(); // initialize room list
        this.characters = new ArrayList<Character>(); // initialize characters list
        this.isDragonTurn = false; // it is not the dragon's turn by default
        this.gameState = 0; // the game has not ended by default

        // load files and set up characters
        this.loadRoomInfo();
        this.loadMap();
        this.loadCharacters();

        // set room papplet to this dragon treasur game
        Room.setProcessing(this);
        // set treasure picture to this file
        TreasureRoom.setTreasureBackground(loadImage("images" + File.separator
                + "treasure.jpg"));
        // set portal picture to this file
        PortalRoom.setPortalImage(loadImage("images" + File.separator + "portal.png"));
    }

    /**
     * Overridden version of draw method that also contains the game's logic.
     */
    @Override
    public void draw()
    {
        // variable declaration
        Character keyHolder = characters.get(0); // the keyholder character's position
        Player player = (Player) characters.get(1); // the player character
        Dragon dragon = (Dragon) characters.get(2); // the dragon

        player.getCurrentRoom().draw(); // draw the player's current room
        // print warnings

        // treasure warning
        if(player.isTreasureNearby())
        {
            System.out.println(TreasureRoom.getTreasureWarning());
        }

        // portal warning
        if(player.isPortalNearby())
        {
            System.out.println(PortalRoom.getPortalWarning());
        }

        // dragon warning
        if(player.isDragonNearby(dragon))
        {
            System.out.println(Dragon.getDragonWarning());
        }

        // check for keyholder status
        if(player.getCurrentRoom().equals(keyHolder.getCurrentRoom()))
        {
            player.obtainKey(); // give player key
            System.out.println("KEY OBTAINED");
        }

        // check teleport status
        if(player.teleport())
        {
            System.out.println(PortalRoom.getTeleportMessage()); // print if teleported
        }

        // if it is the dragon's turn attempt to move it to the target
        if(this.isDragonTurn && dragon.changeRoom(dragon.pickRoom()))
        {
            this.isDragonTurn = false; // it is now no longer the dragon's turn
        }

        // if the player is in the treasure room and player can open the chest
        if(player.getCurrentRoom() instanceof TreasureRoom)
        {
            TreasureRoom currentRoom = (TreasureRoom) player.getCurrentRoom();

            // if the player can grab treasure, set gameState to 1, else continue (keep at 0)
            this.gameState = (currentRoom.playerCanGrabTreasure(player)) ? 1 : this.gameState;
        }
        // if the player and the dragon are in the same room
        else if(player.getCurrentRoom().equals(dragon.getCurrentRoom()))
        {
            System.out.println(Dragon.getDragonEncounter()); // print death message
            this.gameState = 2; // the player loses
        }
        System.out.println("finished drawing");
    }

    /**
     * Runs if a key is pressed. Overrides default which does nothing.
     */
    @Override
    public void keyPressed()
    {
        System.out.println("hi");
        Player player = (Player) this.characters.get(1); // the player character
        Dragon dragon = (Dragon) this.characters.get(2); // the dragon

        // if the gamestate is not already won or lost, have the player option to move
        if(this.gameState == 0)
        {
            System.out.println("hihi");
            int ID = key - '0'; // id for the room the player attempts to enter
            // if the player can move to this room, then change rooms and have the dragon change rooms
            if(player.canMoveTo(player.getAdjacentRooms().get(ID)))
            {
                player.changeRoom(player.getAdjacentRooms().get(ID)); //change rooms for player
                this.isDragonTurn = true; // dragon's turn

                // the dragon will constantly pick a random room until it can enter a room
                while(isDragonTurn)
                {
                    Room roomtoChange = dragon.pickRoom(); //random room dragon has chosen to move
                    // if the dragon can move to this random room, change rooms. If not, try again. The
                    // dragon's turn is false once the dragon changes rooms.
                    if(dragon.canMoveTo(roomtoChange))
                    {
                        dragon.changeRoom(roomtoChange);
                        this.isDragonTurn = false;
                    }
                }
            }

            // the player entered a wrong key value
            else
            {
                System.out.println("Must pick valid room.");
            }
        }
    }

    /**
     * Loads in the characters into an ArrayList.
     *
     * Index 0 is the keyholder
     * Index 1 is the player
     * Index 2 is the dragon
     */
    private void loadCharacters()
    {
        System.out.println("Adding characters...");
        characters.add(new Character(getRoomByID(5), "KEYHOLDER"));
        characters.add(new Player(getRoomByID(1)));
        characters.add(new Dragon(getRoomByID(9)));
    }

    // loading copied code from p05 spec
    /** Loads in room info using the file stored in roomInfo
     *  @author Michelle
     */
    private void loadRoomInfo() {
        System.out.println("Loading rooms...");
        Scanner fileReader = null;
        try {

            //scanner to read from file
            fileReader= new Scanner(roomInfo);

            //read line by line until none left
            while(fileReader.hasNext()) {
                String nextLine = fileReader.nextLine();

                //parse info and create new room
                String[] parts = nextLine.split(" \\| ");
                int ID = Integer.parseInt(parts[1].trim()); //get the room id
                String imageName = null;
                String description = null;
                PImage image = null;
                Room newRoom = null;

                if(parts.length >= 3) {
                    imageName = parts[2].trim();
                    image = this.loadImage("images" + File.separator + imageName);

                }

                if(parts.length == 4) {
                    description = parts[3].trim(); //get the room description
                }

                switch(parts[0].trim()) {
                    case "S":
                        newRoom = new StartRoom(ID, image);
                        break;
                    case "R":
                        newRoom = new Room(ID, description, image);
                        break;
                    case "P":
                        newRoom = new PortalRoom(ID, description, image);
                        break;
                    case "T":
                        newRoom = new TreasureRoom(ID);
                        break;
                    default:
                        break;
                }

                if(newRoom != null) {
                    roomList.add(newRoom);
                }
            }
        }catch(IOException e) { //handle checked exception
            e.printStackTrace();
        }finally {
            if(fileReader != null)
                fileReader.close(); //close scanner regardless of what happened for security reasons :)
        }
    }

    /** Loads in room connections using the file stored in mapInfo
     *  @author Michelle
     */
    private void loadMap() {
        System.out.println("Loading map...");
        Scanner fileReader = null;
        try {
            //scanner to read from file
            fileReader= new Scanner(mapInfo);

            //read line by line until none left
            while(fileReader.hasNext()) {

                //parse info
                String nextLine = fileReader.nextLine();
                String parts[] = nextLine.split(" ");
                int id = Integer.parseInt(parts[0]);

                Room toEdit = getRoomByID(id); //get the room we need to update info for adjacent rooms

                //add all the rooms to the adj room list of toEdit
                for(int i=1; i<parts.length; i++) {
                    Room toAdjAdd = getRoomByID(Integer.parseInt(parts[i]));
                    toEdit.addToAdjacentRooms(toAdjAdd);
                }
            }
        }catch(IOException e) { //handle checked exception
            e.printStackTrace();
        }finally {    //close scanner regardless of what happened for security reasons :)
            if(fileReader != null)
                fileReader.close();
        }
    }

    /**
     * Get the room objected associated with the given ID.
     * @param id the ID of the room to retrieve
     * @return the Room that corresponds to that id
     * @author Michelle
     */
    private Room getRoomByID(int id){
        int indexToEdit = roomList.indexOf(new Room(id,"dummy", null));
        Room toEdit = roomList.get(indexToEdit);
        return toEdit;
    }
}

