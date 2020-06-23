package edu.upc.etsetb.arqsoft.miniexceljc.view;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Value;

public interface UISpreadsheet {
    String getValueAt(int row, int col);
    void setValueAt(int r, int col, Value value) ;
    void setFactory(SpreadsheetFactory factory) ;
    void resetCells();
}
