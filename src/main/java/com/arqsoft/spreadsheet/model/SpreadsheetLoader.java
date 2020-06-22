package com.arqsoft.spreadsheet.model;

import com.arqsoft.spreadsheet.model.domain.Spreadsheet;

import java.io.IOException;

public interface SpreadsheetLoader {
    Spreadsheet load(String filename) throws IOException;
}
