package edu.upc.etsetb.arqsoft.miniexceljc.view;

public interface UIRenderer {
    void render(UISpreadsheet spreadsheet);
    void moveView(int rowIncrement, int columnIncrement);
    int getRowOffset();
    int getColumnOffset();
}
