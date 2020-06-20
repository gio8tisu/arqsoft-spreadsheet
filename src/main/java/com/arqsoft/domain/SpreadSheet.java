package com.arqsoft.domain;

import java.util.HashMap;
import java.util.Map;

public class SpreadSheet {
    private Map<Coordinate, Cell> cells;

    public SpreadSheet() {
        this.cells = new HashMap<>();
    }

    public Map<Coordinate, Cell> getCells() {
        return cells;
    }

    public void setCell(Coordinate coordinate, Cell cell) {
        cells.put(coordinate, cell);
    }

    public Cell getCell(Coordinate coordinate) {
        return cells.get(coordinate);
    }
}
