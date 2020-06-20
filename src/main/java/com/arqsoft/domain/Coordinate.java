package com.arqsoft.domain;

public class Coordinate {
    private int row;
    private String column;

    public Coordinate(int row, String column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public String getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return row + column;
    }
}
