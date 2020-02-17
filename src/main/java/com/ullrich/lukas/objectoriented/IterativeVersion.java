package com.ullrich.lukas.objectoriented;

import com.ullrich.lukas.util.TreasureHuntUtilities;

import java.util.ArrayList;
import java.util.List;

/**
 * A class providing an iterative, object oriented solution for the treasure hunt problem
 */
public class IterativeVersion {

  public static void main(String[] args) {

    String map = "34 21 32 41 25" + '\n' + "14 42 43 14 31" + '\n' + "54 45 52 42 23" + '\n' + "33 15 51 31 35" + '\n' + "21 52 33 13 23";
    int[][] inputMap = TreasureHuntUtilities.getInputMapFromSTDIN(map);

    System.out.println(hunt(inputMap, new Clue(11)));
    System.out.println("===");
    System.out.println(hunt(inputMap, new Clue(55)));
    System.out.println("===");
    System.out.println(hunt(inputMap, new Clue(15)));
  }

  /**
   * Iterative method to hunt for the treasure in a NxM matrix received via the inputMap parameter.
   * The treasure is the position in the matrix where the row/column of the entry (clue) are identical with the values it points to
   * @param inputMap a NxM matrix in the form of an array, containing coordinates (clues) that detail a row/column combination to the next clue
   * @param clue The first clue Object (starting position for the hunt)
   * @return if there is a treasure, the history of the clue-path to it is returned, if there is none, "NO TREASURE" is returned
   */
  public static String hunt(int[][] inputMap, Clue clue){

    //create a list of the history and add the first clue
    List<Clue> history = new ArrayList<>();
    history.add(clue);

    Clue currentClue = clue;
    Clue nextClue = new Clue(inputMap[currentClue.getRowHint()-1][currentClue.getColumnHint()-1]);

    //while the treasure is not yet found
    while (currentClue.getNumber() != nextClue.getNumber()){
      currentClue = nextClue;
      nextClue = new Clue(inputMap[currentClue.getRowHint()-1][currentClue.getColumnHint()-1]);

      //if there is a dead end (a clue to a position in the array we've already been to)
      if (history.contains(currentClue)){
        return "NO TREASURE";
      }
      else {
        history.add(currentClue);
      }
    }

    //add all clues from the history to a string and return it
    StringBuilder resultString = new StringBuilder();
    for (Clue historyClue : history) {
        resultString.append(historyClue.getRowHint());
        resultString.append(" ");
        resultString.append(historyClue.getColumnHint());
        resultString.append("\n");
    }
    return resultString.toString().trim();
  }
}
