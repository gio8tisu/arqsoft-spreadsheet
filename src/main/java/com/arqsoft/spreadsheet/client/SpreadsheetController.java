package com.arqsoft.spreadsheet.client;

import com.arqsoft.spreadsheet.model.*;
import com.arqsoft.spreadsheet.model.domain.*;

public class SpreadsheetController {
    private SpreadsheetFactory factory;
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

    public void loadSpreadsheet() throws FilenameNotSetException {
        if (spreadsheetLoader.getFilename() == null)
            throw new FilenameNotSetException("Filename not associated");
        this.spreadSheet = spreadsheetLoader.load();
    }

}
