package com.ullrich.lukas.objectoriented;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClueTest {

    private Clue clue34;
    private Clue clue55_1;
    private Clue clue55_2;

    @BeforeEach
    public void beforeEach() {
        clue34 = new Clue(34);
        clue55_1 = new Clue(55);
        clue55_2 = new Clue(55);

    }

    @Test
    public void test_equals_sameObject_ExpectTrue() {
        Assertions.assertEquals(clue34, clue34);
    }

    @Test
    public void test_equals_sameValues_ExpectTrue() {
        Assertions.assertEquals(clue55_2, clue55_1);
    }

    @Test
    public void test_equals_differentObjects_ExpectFalse() {
        Assertions.assertNotEquals(clue34, clue55_1);
    }

    @Test
    public void testClueConstructor_ExpectCorrectObjectPopulation(){
        Clue testClue = new Clue (24);
        Assertions.assertEquals(testClue.getRowHint(), 2);
        Assertions.assertEquals(testClue.getColumnHint(), 4);
    }

}
