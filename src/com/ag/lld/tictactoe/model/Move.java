package com.ag.lld.tictactoe.model;

public class Move {
    private Grid gridSnap;

    private int row;
    private int column;

    public Move(Grid gridSnap, int row, int column){
        this.gridSnap = gridSnap;
        this.row = row;
        this.column = column;
    }

    public Move(int row, int column){
        this.row = row;
        this.column = column;
    }

    public Grid getGridSnap() {
        return gridSnap;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
