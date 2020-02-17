package com.ullrich.lukas.functional;

import com.ullrich.lukas.util.TreasureHuntUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecursiveVersionTest {

    private int[][] inputMapTreasureAt43;
    private String inputMapTreasureAt43History = "1 1\n5 5\n1 5\n2 1\n4 4\n3 2\n1 3\n2 5\n4 3";

    private int[][] inputMapNOTREASURE;


    @BeforeEach
    public void beforeEach() {
        String treasureAt43 =
                "55 14 25 52 21" + "\n" +
                "44 31 11 53 43" + "\n" +
                "24 13 45 12 34" + "\n" +
                "42 22 43 32 41" + "\n" +
                "51 23 33 54 15";
        inputMapTreasureAt43 = TreasureHuntUtilities.getInputMapFromSTDIN(treasureAt43);

        String NOTREASURE =
                "12 11 11 13 43" + "\n" +
                "22 23 21 24 31" + "\n" +
                "24 13 45 55 34" + "\n" +
                "25 22 43 32 41" + "\n" +
                "51 23 33 54 41";
        inputMapNOTREASURE = TreasureHuntUtilities.getInputMapFromSTDIN(NOTREASURE);
    }

    @Test
    public void test_recursiveHunt_with_TreasureAt43_ExpectCorrectHistory(){
        String resultHistory = RecursiveVersion.hunt(inputMapTreasureAt43, 11);
        Assertions.assertEquals(inputMapTreasureAt43History, resultHistory);
    }

    @Test
    public void test_recursiveHunt_with_NOTREASURE_ExpectNOTREASURE(){
        Assertions.assertEquals("NO TREASURE", RecursiveVersion.hunt(inputMapNOTREASURE, 11));
    }

}
