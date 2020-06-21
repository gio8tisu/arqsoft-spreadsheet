package com.arqsoft.spreadsheet.view.text;

import com.arqsoft.spreadsheet.model.CoordinateSpec;
import com.arqsoft.spreadsheet.model.SpreadsheetFactory;
import com.arqsoft.spreadsheet.model.domain.Coordinate;
import com.arqsoft.spreadsheet.util.AlphabeticRadixConverter;
import com.arqsoft.spreadsheet.view.UICell;
import com.arqsoft.spreadsheet.view.UIFactory;
import com.arqsoft.spreadsheet.view.UISpreadsheet;
import java.util.HashMap;
import java.util.Map;

public class TextUISpreadsheet implements UISpreadsheet {
    
    private UIFactory uiFactory;
    private SpreadsheetFactory spreadsheetFactory;
    private Map<Coordinate,UICell> cells;

    public TextUISpreadsheet() {
        this.cells = new HashMap<>();
    }
    
    @Override
    public UICell getCell(int r, int col) {
        String c = this.convertColtoString(col);
        CoordinateSpec spec = new CoordinateSpec(r,c);
        Coordinate coordinate = spreadsheetFactory.createCoordinate(spec);
        return this.cells.get(coordinate);
    }

    @Override
    public void setCell(UICell cell, int r, int col) {
        String c = this.convertColtoString(col);
        CoordinateSpec spec = new CoordinateSpec(r,c);
        Coordinate coordinate = spreadsheetFactory.createCoordinate(spec);
        this.cells.put(coordinate, cell);
    }

    @Override
    public void setFactory(UIFactory factory) {
        this.uiFactory = factory;
    }
    
    private String convertColtoString(int col){
        return AlphabeticRadixConverter.toAlphabeticRadix(col);
    }

}
