package com.arqsoft.spreadsheet.client;

import com.arqsoft.spreadsheet.model.*;
import com.arqsoft.spreadsheet.model.domain.*;
import com.arqsoft.spreadsheet.util.AlphabeticRadixConverter;
import com.arqsoft.spreadsheet.view.UICell;
import com.arqsoft.spreadsheet.view.UIFactory;
import com.arqsoft.spreadsheet.view.UIRenderer;
import com.arqsoft.spreadsheet.view.UISpreadsheet;

public class SpreadsheetController {
    private SpreadsheetFactory factory;
    private Spreadsheet spreadSheet;
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

    public void buildFrameWork() {
        this.spreadSheet = this.factory.createSpreadSheet();
        this.spreadsheetLoader = this.factory.createSpreadSheetLoader();
        this.spreadsheetSaver = this.factory.createSpreadSheetSaver();
    }

    public void addCell(CoordinateSpec coordinateSpec, ContentSpec contentSpec) {
        Coordinate coordinate = factory.createCoordinate(coordinateSpec);
        Content content = factory.createContent(contentSpec);
        this.spreadSheet.setCell(coordinate, factory.createCell(content));
        UICell uiCell = uiFactory.createUICell(content);
        this.uiSpreadsheet.setCell(uiCell, coordinate.getRow(), coordinate.getColumnAsNum());
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
