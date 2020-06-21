package com.arqsoft.spreadsheet.view;

import com.arqsoft.spreadsheet.model.SpreadsheetFactory;

public interface UISpreadsheet {
    public UICell getCell(int r, int col);
    public void setCell(UICell c, int r, int col) ;
    public void setUIFactory(UIFactory factory) ;
    public void setFactory(SpreadsheetFactory factory) ;
}
