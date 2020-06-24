package edu.upc.etsetb.arqsoft.miniexceljc.client;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.*;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Cell;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Content;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Coordinate;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spreadsheet;
import edu.upc.etsetb.arqsoft.miniexceljc.util.NumericalContentChecker;
import edu.upc.etsetb.arqsoft.miniexceljc.util.SpreadsheetLoader;
import edu.upc.etsetb.arqsoft.miniexceljc.util.SpreadsheetSaver;
import edu.upc.etsetb.arqsoft.miniexceljc.util.TextContentChecker;
import edu.upc.etsetb.arqsoft.miniexceljc.view.UIFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.view.UISpreadsheet;

import java.io.IOException;

public class SpreadsheetController {
    private SpreadsheetFactory factory;
    private Spreadsheet spreadsheet;
    private SpreadsheetLoader spreadsheetLoader;
    private SpreadsheetSaver spreadsheetSaver;
    protected UIFactory uiFactory;
    protected UISpreadsheet uiSpreadsheet;

    public SpreadsheetController() {}

    public void setFactory(SpreadsheetFactory factory) {
        this.factory = factory;
    }

    public void setUIFactory(UIFactory factory) {
        this.uiFactory = factory;
    }

    public void setUISpreadsheet(UISpreadsheet uiSpreadsheet) {
        this.uiSpreadsheet = uiSpreadsheet;
    }

    public void buildFrameWork(TextContentChecker textContentChecker,
                               NumericalContentChecker numericalContentChecker) {
        this.spreadsheet = this.factory.createSpreadSheet();
        this.spreadsheetLoader = this.factory.createSpreadSheetLoader(
                textContentChecker, numericalContentChecker);
        this.spreadsheetSaver = this.factory.createSpreadSheetSaver();
        this.spreadsheetSaver.setFactory(this.factory);
    }

    public void addCell(CoordinateSpec coordinateSpec, ContentSpec contentSpec) {
        Coordinate coordinate = factory.createCoordinate(coordinateSpec);
        Content content = factory.createContent(contentSpec);
        Cell cell = factory.createCell(content);
        this.spreadsheet.setCell(coordinate, cell);
        // TODO: Update view.
    }

    public void removeCell(CoordinateSpec coordinateSpec) {
        Coordinate coordinate = factory.createCoordinate(coordinateSpec);
        this.spreadsheet.unSetCell(coordinate);
        // TODO: Update view.
    }

    public void saveSpreadsheet() throws FilenameNotSetException {
        if (spreadsheetSaver.getFilename() == null)
            throw new FilenameNotSetException("Filename not associated");
        spreadsheetSaver.save(spreadsheet);
    }

    public void saveSpreadsheetAs(String filename) {
        spreadsheetSaver.saveAs(spreadsheet, filename);
    }

    public void loadSpreadsheet(String filename) throws IOException {
        this.spreadsheet = spreadsheetLoader.load(filename);
        // TODO: Update view.
    }

}
