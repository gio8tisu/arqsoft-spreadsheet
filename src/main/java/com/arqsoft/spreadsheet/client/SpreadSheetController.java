package com.arqsoft.spreadsheet.client;

import com.arqsoft.spreadsheet.model.ContentSpec;
import com.arqsoft.spreadsheet.model.CoordinateSpec;
import com.arqsoft.spreadsheet.model.SpreadSheetFactory;
import com.arqsoft.spreadsheet.model.domain.*;

import java.util.ArrayList;
import java.util.List;

public class SpreadSheetController {
    private SpreadSheetFactory factory;
    private List<SpreadSheet> spreadSheetList;

    public SpreadSheetController() {
        this.factory = new SpreadSheetFactory();
    }

    public void buildFrameWork() {
        this.spreadSheetList = new ArrayList<>();
        this.spreadSheetList.add(this.factory.createSpreadSheet());
    }

    public void addCell(CoordinateSpec coordinateSpec, ContentSpec contentSpec) {
        Coordinate coordinate = factory.createCoordinate(coordinateSpec);
        Content content = factory.createContent(contentSpec);
        this.spreadSheetList.get(0).setCell(coordinate, factory.createCell(content));
    }
}
