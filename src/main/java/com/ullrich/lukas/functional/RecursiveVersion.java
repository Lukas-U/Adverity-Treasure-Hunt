package com.ullrich.lukas.functional;

import com.ullrich.lukas.util.TreasureHuntUtilities;

/**
 * A class providing a recursive, functional solution for the treasure hunt problem
 */
public class RecursiveVersion {

  private static StringBuilder history = new StringBuilder();


  public static void main(String[] args) {

    String map = "34 21 32 41 25" + '\n' + "14 42 43 14 31" + '\n' + "54 45 52 42 23" + '\n' + "33 15 51 31 35" + '\n' + "21 52 33 13 23";
    int[][] inputMap = TreasureHuntUtilities.getInputMapFromSTDIN(map);

    System.out.println(hunt(inputMap, 11));
    System.out.println("===");
    System.out.println(hunt(inputMap, 55));
    System.out.println("===");
    System.out.println(hunt(inputMap, 15));
  }

  /**
   * Recursive method to hunt for the treasure in a NxM matrix received via the inputMap parameter.
   * The treasure is the position in the matrix where the row/column of the entry (clue) are identical with the values it points to
   * @param inputMap a NxM matrix in the form of an array, containing coordinates (clues) that detail a row/column combination to the next clue
   * @param Clue The first clue (starting position for the hunt)
   * @return if there is a treasure, the history of the clue-path to it is returned, if there is none, "NO TREASURE" is returned
   */
  public static String hunt(int[][] inputMap, int Clue){

    //get the digits (location) of the current clue
    int currentClueRow = TreasureHuntUtilities.getClueForRow(Clue);
    int currentClueColumn = TreasureHuntUtilities.getClueForColumn(Clue);
    //and save them to the history
    history.append(currentClueRow);
    history.append(" ");
    history.append(currentClueColumn);
    history.append("\n");

    //get the information (value, where it points to) from the current clue
    int currentClueInfo = inputMap[currentClueRow-1][currentClueColumn-1];

    //and use that information to locate the next clue's location in the array
    int nextClueRow = TreasureHuntUtilities.getClueForRow(currentClueInfo);
    int nextClueColumn = TreasureHuntUtilities.getClueForColumn(currentClueInfo);

    //if the treasure is found, return the history
    //we can check for that by comparing the current-values (location in the array) with the next-values (the location the clue points to) -
    //if they are the same the Treasure is found!
    if(currentClueRow == nextClueRow && currentClueColumn == nextClueColumn){
      String result = history.toString().trim();
      //reset the history for the next call of the method
      history = new StringBuilder();
      return result;
    }

    //if there is a dead end (a clue to a position in the array we've already been to)
    if (history.toString().contains(nextClueRow + " " + nextClueColumn)){
      //reset the history for the next call of the method
      history = new StringBuilder();
      return "NO TREASURE";
    }

    //save the next clues digits (location) to the history (done after the check if it is found so that it only gets appended if the result has not yet been reached)
    history.append(nextClueRow);
    history.append(" ");
    history.append(nextClueColumn);
    history.append("\n");
    int nextClue = inputMap[nextClueRow-1][nextClueColumn-1];
    //continue recursion
    return hunt(inputMap, nextClue);

  }
}
