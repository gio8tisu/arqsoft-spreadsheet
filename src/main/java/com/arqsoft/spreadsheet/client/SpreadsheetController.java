package com.arqsoft.spreadsheet.client;

import com.arqsoft.spreadsheet.model.*;
import com.arqsoft.spreadsheet.model.domain.*;
import com.arqsoft.spreadsheet.util.NumericalContentChecker;
import com.arqsoft.spreadsheet.util.TextContentChecker;
import com.arqsoft.spreadsheet.view.UIFactory;
import com.arqsoft.spreadsheet.view.UISpreadsheet;

import java.io.IOException;
import java.util.Map;

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
        this.spreadsheetSaver.setSpreadsheet(this.spreadsheet);
    }

    public void addCell(CoordinateSpec coordinateSpec, ContentSpec contentSpec) {
        Coordinate coordinate = factory.createCoordinate(coordinateSpec);
        Content content = factory.createContent(contentSpec);
        Cell cell = factory.createCell(content);
        this.spreadsheet.setCell(coordinate, cell);
        this.uiSpreadsheet.setValueAt(coordinate.getRow(), coordinate.getColumnAsNum(), cell.getValue());
    }

    public void saveSpreadsheet() throws FilenameNotSetException {
        if (spreadsheetSaver.getFilename() == null)
            throw new FilenameNotSetException("Filename not associated");
        spreadsheetSaver.save();
    }

    public void saveSpreadsheetAs(String filename) {
        spreadsheetSaver.saveAs(filename);
    }

    public void loadSpreadsheet(String filename) throws IOException {
        this.spreadsheet = spreadsheetLoader.load(filename);
        refreshUISpreadsheet();
    }

    private void refreshUISpreadsheet() {
        this.uiSpreadsheet.resetCells();
        for (Map.Entry<Coordinate, Cell> entry : this.spreadsheet.getCells().entrySet()) {
            Coordinate coordinate = entry.getKey();
            Cell cell = entry.getValue();
            this.uiSpreadsheet.setValueAt(coordinate.getRow(), coordinate.getColumnAsNum(), cell.getValue());
        }
    }

}
