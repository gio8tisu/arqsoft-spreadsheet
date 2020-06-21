package com.arqsoft.spreadsheet.model.domain;

import com.arqsoft.spreadsheet.util.AlphabeticRadixConverter;

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

    public int getColumnAsNum() {
        return AlphabeticRadixConverter.fromAlphabeticRadix(column);
    }

    @Override
    public String toString() {
        return column + row;
    }
}
