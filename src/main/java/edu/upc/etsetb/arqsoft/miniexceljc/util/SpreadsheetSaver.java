package edu.upc.etsetb.arqsoft.miniexceljc.util;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Spreadsheet;

import java.util.logging.Logger;

public abstract class SpreadsheetSaver {

    protected String filename;
    protected SpreadsheetFactory factory;

    protected final static Logger logger = Logger.getLogger(SpreadsheetSaver.class.getName());

    public String getFilename() {
        return filename;
    }

    public void setFactory(SpreadsheetFactory factory) {
        this.factory = factory;
    }

    public abstract void save(Spreadsheet spreadsheet);

    public void saveAs(Spreadsheet spreadsheet, String filename) {
        this.filename = filename;
        save(spreadsheet);
    }
}
