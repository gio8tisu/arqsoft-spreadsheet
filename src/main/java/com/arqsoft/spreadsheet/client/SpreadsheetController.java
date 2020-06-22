package com.arqsoft.spreadsheet.client;

import com.arqsoft.spreadsheet.model.*;
import com.arqsoft.spreadsheet.model.domain.*;
import com.arqsoft.spreadsheet.util.NumericalContentChecker;
import com.arqsoft.spreadsheet.util.TextContentChecker;

import java.io.IOException;

public class SpreadsheetController {
    private final SpreadsheetFactory factory;
    private Spreadsheet spreadSheet;
    private SpreadsheetLoader spreadsheetLoader;
    private SpreadsheetSaver spreadsheetSaver;

    public SpreadsheetController() {
        this.factory = new SpreadsheetFactory();
    }

    public void buildFrameWork(TextContentChecker textContentChecker,
                               NumericalContentChecker numericalContentChecker) {
        this.spreadSheet = this.factory.createSpreadSheet();
        this.spreadsheetLoader = this.factory.createSpreadSheetLoader(
                textContentChecker, numericalContentChecker);
        this.spreadsheetSaver = this.factory.createSpreadSheetSaver();
        this.spreadsheetSaver.setFactory(this.factory);
        this.spreadsheetSaver.setSpreadsheet(this.spreadSheet);
    }

    public void addCell(CoordinateSpec coordinateSpec, ContentSpec contentSpec) {
        Coordinate coordinate = factory.createCoordinate(coordinateSpec);
        Content content = factory.createContent(contentSpec);
        this.spreadSheet.setCell(coordinate, factory.createCell(content));
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
        this.spreadSheet = spreadsheetLoader.load(filename);
    }

}
