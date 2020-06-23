package com.arqsoft.spreadsheet.view.text;

import com.arqsoft.spreadsheet.model.CoordinateSpec;
import com.arqsoft.spreadsheet.model.SpreadsheetFactory;
import com.arqsoft.spreadsheet.model.domain.Coordinate;
import com.arqsoft.spreadsheet.model.domain.Value;
import com.arqsoft.spreadsheet.util.AlphabeticRadixConverter;
import com.arqsoft.spreadsheet.view.UIFactory;
import com.arqsoft.spreadsheet.view.UISpreadsheet;

import java.util.HashMap;
import java.util.Map;

public class TextUISpreadsheet implements UISpreadsheet {
    
    private SpreadsheetFactory spreadsheetFactory;
    private Map<Coordinate,String> cells;

    public TextUISpreadsheet() {
        this.cells = new HashMap<>();
    }
    
    @Override
    public String getValueAt(int row, int col) {
        String c = AlphabeticRadixConverter.toAlphabeticRadix(col);
        CoordinateSpec spec = new CoordinateSpec(row,c);
        Coordinate coordinate = spreadsheetFactory.createCoordinate(spec);
        if (this.cells.containsKey(coordinate))
            return this.cells.get(coordinate);
        return "  ";
    }

    @Override
    public void setValueAt(int r, int col, Value value) {
        String c = AlphabeticRadixConverter.toAlphabeticRadix(col);
        CoordinateSpec spec = new CoordinateSpec(r,c);
        Coordinate coordinate = spreadsheetFactory.createCoordinate(spec);
        this.cells.put(coordinate, value.toString());
    }

    @Override
    public void setFactory(SpreadsheetFactory factory) {
        this.spreadsheetFactory = factory;
    }

    @Override
    public void resetCells() {
        this.cells = new HashMap<>();
    }

}
