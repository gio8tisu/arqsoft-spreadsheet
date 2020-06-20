package com.arqsoft.spreadsheet.model.domain;

import com.arqsoft.spreadsheet.model.util.Spec;

public class CoordinateSpec implements Spec {
    private int row;
    private String column;

    public CoordinateSpec(int row, String column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public String getColumn() {
        return column;
    }
}
