package com.ullrich.lukas.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreasureHuntUtilitiesTest {

    @Test
    public void test_GetClueForRow_with_TwoDigitNumber_ExpectCorrectDigit() {
        Assertions.assertEquals(2, TreasureHuntUtilities.getClueForRow(24));
    }

    @Test
    public void test_GetClueForRow_with_OneDigitNumber_ExpectZero() {
        Assertions.assertEquals(0, TreasureHuntUtilities.getClueForRow(5));
    }

    @Test
    public void test_GetClueForColumn_with_TwoDigitNumber_ExpectCorrectDigit() {
        Assertions.assertEquals(4, TreasureHuntUtilities.getClueForColumn(24));
    }

    @Test
    public void test_GetClueForColumn_with_OneDigitNumber_ExpectCorrectDigit() {
        Assertions.assertEquals(4, TreasureHuntUtilities.getClueForColumn(4));
    }

    //getInputMapFromSTDIN not tested because not final version
    //TODO: implement getInputMapFromSTDIN tests (maybe map with strings and integers, and normal case)
}
