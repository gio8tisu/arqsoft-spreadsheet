package com.arqsoft.spreadsheet.client;

import com.arqsoft.spreadsheet.model.ContentSpec;
import com.arqsoft.spreadsheet.model.CoordinateSpec;
import com.arqsoft.spreadsheet.model.SpreadsheetFactory;
import com.arqsoft.spreadsheet.model.domain.*;

public class SpreadsheetController {
    private SpreadsheetFactory factory;
    private Spreadsheet spreadSheet;

    public SpreadsheetController() {
        this.factory = new SpreadsheetFactory();
    }

    public void buildFrameWork() {
        this.spreadSheet = this.factory.createSpreadSheet();
    }

    public void addCell(CoordinateSpec coordinateSpec, ContentSpec contentSpec) {
        Coordinate coordinate = factory.createCoordinate(coordinateSpec);
        Content content = factory.createContent(contentSpec);
        this.spreadSheet.setCell(coordinate, factory.createCell(content));
    }
}
