package com.arqsoft.spreadsheet.client;

import com.arqsoft.spreadsheet.model.*;
import com.arqsoft.spreadsheet.model.domain.*;

public class SpreadsheetController {
    private final SpreadsheetFactory factory;
    private Spreadsheet spreadSheet;
    private SpreadsheetLoader spreadsheetLoader;
    private SpreadsheetSaver spreadsheetSaver;

    public SpreadsheetController() {
        this.factory = new SpreadsheetFactory();
    }

    public void buildFrameWork() {
        this.spreadSheet = this.factory.createSpreadSheet();
        this.spreadsheetLoader = this.factory.createSpreadSheetLoader();
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

    public void loadSpreadsheet(String filename) {
        this.spreadSheet = spreadsheetLoader.load(filename);
    }

}
