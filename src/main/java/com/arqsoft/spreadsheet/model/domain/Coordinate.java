package com.arqsoft.spreadsheet.model.domain;

import java.util.Objects;

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
        return column + row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row &&
                Objects.equals(column, that.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
