package com.arqsoft.spreadsheet.model;

import com.arqsoft.spreadsheet.model.domain.*;

public class SpreadsheetFactory {
    public SpreadsheetFactory(){}

    public Content createContent(ContentSpec spec) {
        if (spec.getType() == CellType.TEXT) {
            return new TextContent(spec.getContent());
        } else if (spec.getType() == CellType.FORMULA) {
            throw new UnsupportedOperationException("Cannot create formula content");
        } else if (spec.getType() == CellType.NUMERICAL) {
            // Assume numerical content.
            return new NumericalContent(Float.parseFloat(spec.getContent()));
        }
        throw new UnsupportedOperationException("Unknown cell type");
    }

    public Spreadsheet createSpreadSheet() {
        return new Spreadsheet();
    }

    public Coordinate createCoordinate(CoordinateSpec spec){
        return new Coordinate(spec.getRow(), spec.getColumn());
    }

    public Cell createCell(Content content) {
        return new Cell(content);
    }

    public SpreadsheetLoader createSpreadSheetLoader() {
        return new S2VSpreadsheetLoader();
    }

    public SpreadsheetSaver createSpreadSheetSaver() {
        return new S2VSpreadsheetSaver();
    }
}
