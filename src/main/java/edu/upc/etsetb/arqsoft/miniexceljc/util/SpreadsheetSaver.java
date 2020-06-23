package edu.upc.etsetb.arqsoft.miniexceljc.util;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Spreadsheet;

import java.util.logging.Logger;

public abstract class SpreadsheetSaver {

    protected String filename;
    protected Spreadsheet spreadsheet;
    protected SpreadsheetFactory factory;

    protected final static Logger logger = Logger.getLogger(SpreadsheetSaver.class.getName());

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Spreadsheet getSpreadsheet() {
        return spreadsheet;
    }

    public void setSpreadsheet(Spreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public void setFactory(SpreadsheetFactory factory) {
        this.factory = factory;
    }

    public abstract void save();
    public abstract void saveAs(String filename);
}
