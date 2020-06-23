package com.arqsoft.spreadsheet.view;

import com.arqsoft.spreadsheet.model.SpreadsheetFactory;
import com.arqsoft.spreadsheet.model.domain.Value;

public interface UISpreadsheet {
    public String getValueAt(int row, int col);
    public void setValueAt(int r, int col, Value value) ;
    public void setFactory(SpreadsheetFactory factory) ;
    public void resetCells();
}
