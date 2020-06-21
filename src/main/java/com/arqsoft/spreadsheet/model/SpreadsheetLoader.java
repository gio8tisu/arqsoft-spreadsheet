package com.arqsoft.spreadsheet.model;

import com.arqsoft.spreadsheet.model.domain.Spreadsheet;

public interface SpreadsheetLoader {
    Spreadsheet load(String filename);
}
