package edu.upc.etsetb.arqsoft.miniexceljc.util;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spreadsheet;

import java.util.logging.Logger;

public interface SpreadsheetSaver {

    void setFactory(SpreadsheetFactory factory);

    void save(Spreadsheet spreadsheet, String filename);
}
