package com.arqsoft.spreadsheet.model;

import com.arqsoft.spreadsheet.model.domain.*;

public class SpreadSheetFactory {
    public SpreadSheetFactory(){}

    public Content createContent(ContentSpec spec) {
        if (spec.getType() == CellType.TEXT) {
            return new TextContent(spec.getContent());
        } else if (spec.getType() == CellType.FORMULA) {
            throw new UnsupportedOperationException("Cannot create formula content");
        } else if (spec.getType() == CellType.NUMERICAL) {
            // Assume numerical content.
            return new NumericalContent(Float.parseFloat(spec.getContent()));
        }
        return null;  // TODO: throw exception.
    }

    public SpreadSheet createSpreadSheet() {
        return new SpreadSheet();
    }

    public Coordinate createCoordinate(CoordinateSpec spec){
        return new Coordinate(spec.getRow(), spec.getColumn());
    }

    public Cell createCell(Content content) {
        return new Cell(content);
    }
}
