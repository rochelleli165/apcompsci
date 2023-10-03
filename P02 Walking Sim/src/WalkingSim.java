//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P02 Walking Simulator
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
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Random;
import java.io.File;
import processing.core.PImage;

/**
 * This class is the main file executing the assignment's methods for setting up the animation
 * [WalkingSim.setup()] and drawing the animation [WalkingSim.draw()] There are other methods such
 * as clicking a walker to initiate animation and keyboard inputs that can add a walker or make all
 * walkers stop walking.
 */
public class WalkingSim {
  private static Random randGen;
  private static int bgColor;
  private static PImage[] frames;
  private static Walker[] walkers;

  /**
   * The main method executes the utility application, opening another window for showcasing the
   * animation.
   * 
   * @param args
   */
  public static void main(String args[]) {
    Utility.runApplication();
  }

  /**
   * This method, as revealed by the name, sets up the animation but generating a random color
   * background, creating the frames field to refer to when calling for the animation, the random
   * ammount of walkers on screen, and the initial loading of frames for each walker.
   */
  public static void setup() {
    randGen = new Random();
    bgColor = randGen.nextInt();
    frames = new PImage[Walker.NUM_FRAMES];
    walkers = new Walker[8];
    Random randNumWalkers = new Random();
    Random randXCoord = new Random();
    Random randYCoord = new Random();
    int numWalkers = randNumWalkers.nextInt(1, 8);
    for (int i = 0; i < numWalkers; i++) {
      walkers[i] =
          new Walker(randXCoord.nextInt(Utility.width()), randYCoord.nextInt(Utility.height()));
    }
    for (int index = 0; index < 7; index++) {
      frames[index] = Utility.loadImage("images" + File.separator + "walk-" + index + ".png");
    }
  }

  /**
   * The draw method is in a continuous loop called forth in the main method. Inside loops through
   * all walkers and checks their walking status, making the animation changes (shifting postition
   * and updating frames) and showing the background.
   */
  public static void draw() {
    Utility.background(bgColor);
    int i = 0;
    while (walkers[i] != null) {
      if (walkers[i].isWalking()) {
        walkers[i].setPositionX((walkers[i].getPositionX() + 3) % 800);
      }
      Utility.image(frames[walkers[i].getCurrentFrame()], walkers[i].getPositionX(),
          walkers[i].getPositionY());
      if (walkers[i].isWalking()) {
        walkers[i].update();
      }
      i++;
    }
    /*
     * i = 0; while (walkers[i] != null) { if(isMouseOver(walkers[i])){
     * System.out.println("Mouse is over a walker!"); } i++; }
     */
  }

  /**
   * The isMouseOver checks if the mouse cursor lies on top of any walker
   * 
   * @param x is the current Walker the method is checking to see if the mouse lies on it.
   * @return false is the mouse is not on the walker image, true if it does.
   */
  public static boolean isMouseOver(Walker x) {
    int minWidth = (int) x.getPositionX() - frames[0].width / 2;
    int maxWidth = (int) x.getPositionX() + frames[0].width / 2;
    int minHeight = (int) x.getPositionY() - frames[0].height / 2;
    int maxHeight = (int) x.getPositionY() + frames[0].height / 2;
    if (Utility.mouseX() > minWidth && Utility.mouseX() < maxWidth && Utility.mouseY() > minHeight
        && Utility.mouseY() < maxHeight) {
      return true;
    }
    return false;
  }

  /**
   * When the mouse is pressed on the new window application of the animation and the mouse is on a
   * walker, the walker's status will be changed to isWwlking, meaning that they are eligible for
   * walking across the screen (to be updating and shown in the WalkingSim.draw() method.
   */
  public static void mousePressed() {
    int i = 0;
    while (walkers[i] != null) {
      Walker x = walkers[i];
      int minWidth = (int) x.getPositionX() - frames[0].width / 2;
      int maxWidth = (int) x.getPositionX() + frames[0].width / 2;
      int minHeight = (int) x.getPositionY() - frames[0].height / 2;
      int maxHeight = (int) x.getPositionY() + frames[0].height / 2;
      if (Utility.mouseX() > minWidth && Utility.mouseX() < maxWidth && Utility.mouseY() > minHeight
          && Utility.mouseY() < maxHeight) {
        x.setWalking(true);
      }
      i++;
    }
  }

  /**
   * Using two keys, A/a and S/s, the program will either add a walker that is initially not moving
   * or call all walkers to stop walking and freeze in place, respectively.
   * 
   * @param a the key inputed by the user that will determine what action will occur if the key is
   *        not A/a or S/s, then nothing will happen.
   */
  public static void keyPressed(char a) {
    char char1 = 'a';
    char char2 = 'A';
    Random randXCoord = new Random();
    Random randYCoord = new Random();
    if (a == char1 || a == char2) {
      int i = 0;
      while (walkers[i] != null) {
        i++;
      }
      if (i < walkers.length) {
        walkers[i] =
            new Walker(randXCoord.nextInt(Utility.width()), randYCoord.nextInt(Utility.height()));
      }
    }
    char1 = 's';
    char2 = 'S';
    if (a == char1 || a == char2) {
      int i = 0;
      while (walkers[i] != null) {
        walkers[i].setWalking(false);
        i++;
      }
    }
  }
}
