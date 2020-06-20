package com.arqsoft;

import com.arqsoft.domain.*;
import com.arqsoft.util.CoordinateChecker;
import com.arqsoft.util.InputChecker;
import com.arqsoft.util.Spec;
import com.arqsoft.util.TextContentChecker;

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
