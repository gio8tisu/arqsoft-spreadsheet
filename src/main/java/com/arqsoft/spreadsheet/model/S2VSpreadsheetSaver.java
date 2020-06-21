package com.arqsoft.spreadsheet.model;

import com.arqsoft.spreadsheet.model.domain.Spreadsheet;

public class S2VSpreadsheetSaver implements SpreadsheetSaver {
    private String filename;
    private Spreadsheet spreadSheet;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Spreadsheet getSpreadSheet() {
        return spreadSheet;
    }

    public void setSpreadSheet(Spreadsheet spreadSheet) {
        this.spreadSheet = spreadSheet;
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("S2V save is not implemented yet.");
    }

    @Override
    public void saveAs(String filename) {
        this.filename = filename;
        this.save();
    }

}
