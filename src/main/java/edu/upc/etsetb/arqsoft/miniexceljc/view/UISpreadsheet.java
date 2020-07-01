package edu.upc.etsetb.arqsoft.miniexceljc.view;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Coordinate;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Value;

public interface UISpreadsheet {
    String getValueAt(int row, int col);
    void setValueAt(Coordinate coordinate, Value value) ;
    void setFactory(SpreadsheetFactory factory) ;
    void resetCells();
    void setCell(Coordinate coordinate, String value);
}
