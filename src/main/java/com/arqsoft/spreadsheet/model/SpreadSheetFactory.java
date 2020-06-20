package com.arqsoft.spreadsheet.model;

import com.arqsoft.domain.*;
import com.arqsoft.model.domain.*;
import com.arqsoft.spreadsheet.model.util.CoordinateChecker;
import com.arqsoft.spreadsheet.model.util.InputChecker;
import com.arqsoft.spreadsheet.model.util.TextContentChecker;
import com.arqsoft.spreadsheet.model.domain.*;

public class SpreadSheetFactory {
    private InputChecker textContentChecker;
    private CoordinateChecker coordinateChecker;
    public SpreadSheetFactory(){
        textContentChecker = new TextContentChecker();
        coordinateChecker = new CoordinateChecker();
    }

    public Content createContent(String spec) throws InvalidInputException {
        if (spec.startsWith("\"") | spec.startsWith("\'")) {
            ContentSpec correctedSpec = (ContentSpec) textContentChecker.checkInput(spec);
            return new TextContent(correctedSpec.getContent());
        } else if (spec.startsWith("=")) {
            throw new UnsupportedOperationException("Cannot create formula content");
        } else {
            // Assume numerical content.
            return new NumericalContent(Float.parseFloat(spec));
        }
    }

    public SpreadSheet createSpreadSheet() {
        return new SpreadSheet();
    }

    public Coordinate createCoordinate(String spec) throws InvalidInputException {
        CoordinateSpec correctedSpec = (CoordinateSpec) coordinateChecker.checkInput(spec);
        return new Coordinate(correctedSpec.getRow(), correctedSpec.getColumn());
    }

    public Cell createCell(Content content) {
        return new Cell(content);
    }
}
