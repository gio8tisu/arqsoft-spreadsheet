package com.arqsoft.spreadsheet.model;

import com.arqsoft.spreadsheet.model.domain.Spreadsheet;

public class S2VSpreadsheetLoader implements SpreadsheetLoader {
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public Spreadsheet load() {
        throw new UnsupportedOperationException("S2V load is not implemented yet.");
    }
}
