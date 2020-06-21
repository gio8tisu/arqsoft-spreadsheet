package com.arqsoft.spreadsheet.model;

public interface SpreadsheetSaver {
    void save();
    void saveAs(String filename);

    String getFilename();
}
