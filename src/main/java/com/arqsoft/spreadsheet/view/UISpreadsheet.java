package com.arqsoft.spreadsheet.view;

public interface UISpreadsheet {
    public UICell getCell(int r, int col);
    public void setCell(UICell c, int r, int col) ;
    public void setFactory(UIFactory factory) ;
}
