package com.ullrich.lukas.util;

import java.util.Arrays;

/**
 * Class providing methods to simplify working with two-dimensional int arrays and the clue integers
 */
public class TreasureHuntUtilities {


    /**
     * Method to return the integer of the second digit of the clue (which is a two digit integer). *
     * The result equals the next cue's column.
     * @param completeClue the two digit cue int
     * @return the one digit column int
     */
    public static int getClueForColumn(int completeClue) {
        return completeClue%10;
    }

    /**
     * Method to return the integer of the first digit of the clue (which is a two digit integer).
     * The result equals the next cue's row.
     * @param completeClue the two digit cue int
     * @return the one digit row int
     */
    public static int getClueForRow(int completeClue){
        return completeClue/10;
    }


    /**
     * Method to read an inputMap from STDIN
     * (CURRENTLY FAKING THE MAP TO SAVE TIME AT MANUAL TESTING)
     * @return a two-dimensional Array
     */
    //TODO replace String with input from STDIN
    public static int[][] getInputMapFromSTDIN(String input){

        //get the inputstring's rows and size, create input array
        String[] inputrows = input.split("\n");
        int size = inputrows.length;
        int[][] inputMap = new int [size][];

        //go through all the rows of the inputrows array, put the clues into an array and put the array into the inputMap array
        for(int rowNumber = 0; rowNumber < size; rowNumber++){
            String[] clueStrings = inputrows[rowNumber].split(" ");
            int[] clues = Arrays.stream(clueStrings).mapToInt(Integer::parseInt).toArray();
            inputMap[rowNumber] = clues;
        }
        return inputMap;
    }

}
