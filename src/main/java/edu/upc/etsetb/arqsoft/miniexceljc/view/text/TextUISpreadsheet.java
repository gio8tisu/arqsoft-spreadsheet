package edu.upc.etsetb.arqsoft.miniexceljc.view.text;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.CoordinateSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Coordinate;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.util.AlphabeticRadixConverter;
import edu.upc.etsetb.arqsoft.miniexceljc.view.UISpreadsheet;

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
