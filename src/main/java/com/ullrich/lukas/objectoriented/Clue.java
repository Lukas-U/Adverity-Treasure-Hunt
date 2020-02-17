package com.ullrich.lukas.objectoriented;

import com.ullrich.lukas.util.TreasureHuntUtilities;

/**
 * A class to access the clues' information as an object
 */
public class Clue {

    private int rowHint;
    private int columnHint;

    public Clue(int clue){
        this.rowHint = TreasureHuntUtilities.getClueForRow(clue);
        this.columnHint = TreasureHuntUtilities.getClueForColumn(clue);
    }

    public int getRowHint() {
        return rowHint;
    }

    public int getColumnHint() {
        return columnHint;
    }

    public int getNumber(){
        return Integer.parseInt("" + rowHint + columnHint);
    }

    //had to override equals so that in the iterative version we can check the list if there is another clue with the same values
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Clue)) {
            return false;
        }
        Clue clue = (Clue) o;
        return getRowHint() == clue.getRowHint() &&
                getColumnHint() == clue.getColumnHint();
    }
}
