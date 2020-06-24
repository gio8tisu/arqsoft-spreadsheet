package edu.upc.etsetb.arqsoft.miniexceljc.util;

import edu.upc.etsetb.arqsoft.miniexceljc.model.Spreadsheet;

import java.io.IOException;

public interface SpreadsheetLoader {
    Spreadsheet load(String filename) throws IOException;
}
