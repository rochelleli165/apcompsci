//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P01 Vending Machine
// Course:   CS 300 Fall 2022
//
// Author:   Rochelle Li
// Email:    rli484@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Chris Shu
// Partner Email:   cshu23@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;

// Javadoc style class header comes here
public class VendingMachineTester {

  // TODO complete the implementation of the following tester methods and add their javadoc style
  // method headers

  // Checks the correctness of getIndexNextItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetIndexNextItem() {
    // Test scenarios normal and edge cases
    // Recall that the VendingMachine.getNextItem method gets the next item to be dispensed given
    // its description without removing it.

    // 1. Next item to be dispensed is NOT found: the expected output is -1
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did not return "
                + "-1 when no match found.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 2. Next item to be dispensed is at index 0
    {
      String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at index 0.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 3. Next item to be dispensed is at the end of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at the end of the array");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 4. Next item to be dispensed is at the middle of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains matches with the provided "
                + "item description with different expiration dates.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    return true; // No bug detected
  }

  // Checks the correctness of containsItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testContainsItem() {
    // Define at least two test scenarios: (1) successful search returning true and (2) unsuccessful
    // search returning false.
    //Defines items
    String[][] items =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
    int itemsCount = 3;
    // 1. if the method does not recognize each description argument in vending machine
    for(int i = 0; i < itemsCount; i++)
    {
      if(!VendingMachine.containsItem(items[i][0], items, itemsCount))
      {
        return false;
      }
    }
    // Check that the method did not make change to the contents of the array items passed as
    // input
    String[][] originalItems =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
    if (!Arrays.deepEquals(items, originalItems)) {
      System.out.println(
              "testContainsItem-scenario 1. Problem detected: Your containsItem did make "
                      + "changes to the content of the array passed as input.");
      return false;
    }
    // 2. Successful search
    return true; // default return statement to let this incomplete code compiles with no errors.
                  // Feel free to change it.
  }

  // Checks the correctness of getItemAtIndex defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetItemAtIndex() {
    // Define at least two test scenarios: (1) the provided index is out of the range
    // 0..itemsCount-1, (2) the provided index is in bounds [0..itemsCount-1].
    // For each test scenario, ensure that the method returned the exact expected string output
    // without making any changes to the contents of the array.
    String[][] items =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
    int itemsCount = 3;
    // 1. Index argument is not valid,
    if(!VendingMachine.getItemAtIndex(-1, items, itemsCount).equals("ERROR INVALID INDEX") ||
            !VendingMachine.getItemAtIndex(4, items, itemsCount).equals("ERROR INVALID INDEX"))
    {
      return false;
    }
    // Check that the method did not make change to the contents of the array items passed as
    // input
    String[][] originalItems =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
    if (!Arrays.deepEquals(items, originalItems)) {
      System.out.println(
              "testGetItemAtIndex-scenario 1. Problem detected: Your getItemAtIndex did make "
                      + "changes to the content of the array passed as input.");
      return false;
    }
    //2. The provided index is in bounds but doesn't return the right value
    if(!VendingMachine.getItemAtIndex(0, items, itemsCount).equals("Water"))
    {
      return false;
    }
    //if everything goes right, return true
    return true;
  }

  // Checks the correctness of getItemOccurrences defined in the VendingMachine class.
  public static boolean testGetItemsOccurrences() {
    // Define at least two test scenarios: (1) no match found so that the method returns zero,
    // (2) the items array contains multiple occurrences of the provided item description.
    String[][] items =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "4"}, null, null, null};
    int itemsCount = 4;
    // 1. if the vending machine doesn't detect any matches to the snack and doesn't return zero
    if(VendingMachine.getItemOccurrences("Apple", items, itemsCount) != 0)
    {
      return false;
    }
    // 2. There is a match, but the number of occurrences don't match
    if(VendingMachine.getItemOccurrences("Water", items, itemsCount) != 2)
    {
      return false;
    }
    // For each test scenario, ensure that the method returned the expected output without making
    // any changes to the contents of the array.
    String[][] originalItems =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "4"}, null, null, null};
    if (!Arrays.deepEquals(items, originalItems))
    {
      System.out.println(
              "testGetItemsOccurences-scenario 1. Problem detected: Your getItemsOccurrences did make "
                      + "changes to the content of the array passed as input.");
      return false;
    }
    //everything works out fine
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of addItem defined in the VendingMachine class.
  public static boolean testAddItem() {
    // Define at least three test scenarios: (1) adding a new item to an empty vending machine whose
    // size is zero (provided itemsCount == 0), (2) adding a new item to a non-empty non-full
    // vending machine, and (3) adding a new item to a full vending machine where the provided
    // itemsCount equals the length of the provided items array.
    String[][] firstItems =
            new String[][] {null, null, null, null, null, null};
    int itemsCount = 0;
    // 1. The addition to an empty list does not work
    if(VendingMachine.addItem("Water", "1", firstItems, itemsCount) != 1)
    {
      return false;
    }
    if(firstItems[0] != null && !Arrays.equals(firstItems[0], new String[] {"Water", "1"}))
    {
      return false;
    }
    // 2. The addition to a not empty, not full vending machine doesn't work
    String[][] secondItems =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
    itemsCount = 3;
    if (VendingMachine.addItem("Water", "1", secondItems, itemsCount) != 4)
    {
      return false;
    }
    if(secondItems[3] != null && !Arrays.equals(secondItems[3], new String[] {"Water", "1"}))
    {
      return false;
    }
    // 3. The addition ot a full vending machine doesn't work
    String[][] thirdItems =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}};
    itemsCount = 3;
    if (VendingMachine.addItem("Water", "1", secondItems, itemsCount) != 3)
    {
      return false;
    }
    String[][] copyThirdItems =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}};
    if (!Arrays.deepEquals(thirdItems, copyThirdItems)) {
      System.out.println(
              "testaddItem-scenario 3. Problem detected: Your addItem did make "
                      + "changes to the content of the array passed as input.");
      return false;
    }

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.
    //everything works!
    return true;
  }

  // Checks the correctness of removeNextItem defined in the VendingMachine class.

  /**
   * This checks the removeNextItem in the Vending Machine.java class
   * @return true is the method works in all scenarios, false if otherwise
   */
  public static boolean testRemoveNextItem() {
    // Define at least four test scenarios: (1) trying to remove a non-existing item from a vending
    // machine (the vending machine can be empty or not), (2) the next item to be removed matching
    // the provided description is at index 0 of the array, (3) the next item to be removed is at
    // index itemsCount of the array (at the end of the array), and (4) the next item to be removed
    // is at a middle index of the provided items array.
    //1. removing non-existent item from vending machine
    String[][] items =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
    int itemsCount = 3;
    if(VendingMachine.removeNextItem("Apple", items, itemsCount) != 3)
    {
      return false;
    }
    // Check that the method did not make change to the contents of the array items passed as
    // input
    String[][] originalItems =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
    if (!Arrays.deepEquals(items, originalItems)) {
      System.out.println(
              "testRemoveNextItem-scenario 1. Problem detected: Your removeNextItem did make "
                      + "changes to the content of the array passed as input.");
      return false;
    }
    //2. removing the item at index zero
    //restarting array
    originalItems =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
    if (VendingMachine.removeNextItem("Water", items, itemsCount) != 2) {
      System.out.println(
              "testremoveNextItem-scenario 2. Problem detected: Your removeNextItem did make "
                      + "changes to the content of the array passed as input.");
      return false;
    }
    if(!Arrays.deepEquals(items, new String[][]{{"Chocolate", "10"}, {"Juice", "20"}, null, null, null, null}))
    {
      return false;
    }
    //3. removing the item at the last index of itemsCount
    originalItems =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
    if (VendingMachine.removeNextItem("Juice", items, itemsCount) != 2) {
      System.out.println(
              "testremoveNextItem-scenario 3. Problem detected: Your removeNextItem did make "
                      + "changes to the content of the array passed as input.");
      return false;
    }
    if(!Arrays.deepEquals(items, new String[][]{{"Water", "15"}, {"Chocolate", "10"}, null, null, null, null}))
    {
      return false;
    }
    //4. removing the item at the middle index of items
    originalItems =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
    if (VendingMachine.removeNextItem("Chocolate", items, itemsCount) != 2) {
      System.out.println(
              "testremoveNextItem-scenario 4. Problem detected: Your removeNextItem did make "
                      + "changes to the content of the array passed as input.");
      return false;
    }
    if(!Arrays.deepEquals(items, new String[][]{{"Water", "15"}, {"Juice", "20"}, null, null, null, null}))
    {
      return false;
    }
    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.
    //everything works!
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of getItemsSummary defined in the VendingMachine class.
  public static boolean testGetItemsSummary() {
    // Define at least three scenarios: (1) the vending machine is empty, (2) the vending machine
    // contains non duplicate items (no multiple items with the same description), (3) the vending
    // machine contains multiple items with the same description at various index locations.
    //1. if the vending machine is empty
    String[][] firstItems =
            new String[][] {null, null, null, null, null, null};
    int itemsCount = 0;
    if(!VendingMachine.getItemsSummary(firstItems, itemsCount).equals(""))
    {
      return false;
    }
    //2. The vending machine has non duplicate items
    String[][] secondItems =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
    itemsCount = 3;
    String answer = "Water (1)\n Chocolate (1)\n Juice (1)\n";
    if(!VendingMachine.getItemsSummary(secondItems, itemsCount).equals(answer)){
      return false;
    }
    //3. The vending machine has duplicate items
    String[][] thirdItems =
            new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "9"}, null, null};
    itemsCount = 4;
    String secondAnswer = "Water (2)\n Chocolate (1)\n Juice (1)\n";
    if(!VendingMachine.getItemsSummary(secondItems, itemsCount).equals(secondAnswer)){
      return false;
    }
    //everything works alright!
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // This method returns false if any of the tester methods defined in this class fails, and true
  // if no bug detected.
  public static boolean runAllTests() {
    return testAddItem() && testContainsItem() && testGetIndexNextItem() && testGetItemAtIndex()
            && testGetItemsSummary() && testGetItemsOccurrences() && testRemoveNextItem();
  }

  // main method to call the tester methods defined in this class
  public static void main(String[] args) {
    System.out.println("testGetIndexNextItem(): " + testGetIndexNextItem());
    System.out.println("testContainsItem(): " + testContainsItem());
    System.out.println("testGetItemAtIndex(): " + testGetItemAtIndex());
    System.out.println("testGetItemsOccurances(): " + testGetItemsOccurrences());
    System.out.println("testAddItem(): " + testAddItem());
    System.out.println("testRemoveNextItem(): " + testRemoveNextItem());
    System.out.println("testGetItemsSummary(): " + testGetItemsSummary());
    System.out.println("runAllTests(): " + runAllTests());
  }

}
