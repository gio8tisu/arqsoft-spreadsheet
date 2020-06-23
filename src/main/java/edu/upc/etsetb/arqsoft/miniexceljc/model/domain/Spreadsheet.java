package edu.upc.etsetb.arqsoft.miniexceljc.model.domain;

import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {
    private Map<Coordinate, Cell> cells;

    public Spreadsheet() {
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