package edu.upc.etsetb.arqsoft.miniexceljc.view;

import edu.upc.etsetb.arqsoft.miniexceljc.model.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Value;

public interface UISpreadsheet {
    public String getValueAt(int row, int col);
    public void setValueAt(int r, int col, Value value) ;
    public void setFactory(SpreadsheetFactory factory) ;
    public void resetCells();
}
