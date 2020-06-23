package edu.upc.etsetb.arqsoft.miniexceljc.model;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Spreadsheet;

import java.io.IOException;

public interface SpreadsheetLoader {
    Spreadsheet load(String filename) throws IOException;
}
