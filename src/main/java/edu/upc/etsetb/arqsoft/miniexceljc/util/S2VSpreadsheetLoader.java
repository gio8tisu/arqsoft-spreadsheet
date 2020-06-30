package edu.upc.etsetb.arqsoft.miniexceljc.util;

import edu.upc.etsetb.arqsoft.miniexceljc.client.text.InvalidInputException;
import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.ContentSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.CoordinateSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Content;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Coordinate;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spreadsheet;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.ExpressionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class S2VSpreadsheetLoader implements SpreadsheetLoader {

    private SpreadsheetFactory factory;
    private TextContentChecker textContentChecker;
    private NumericalContentChecker numericalContentChecker;
    private FormulaContentChecker formulaContentChecker;

    public S2VSpreadsheetLoader(SpreadsheetFactory factory, TextContentChecker textContentChecker,
                                NumericalContentChecker numericalContentChecker,
                                FormulaContentChecker formulaContentChecker) {
        this.factory = factory;
        this.textContentChecker = textContentChecker;
        this.numericalContentChecker = numericalContentChecker;
        this.formulaContentChecker = formulaContentChecker;
    }

    @Override
    public Spreadsheet load(String filename) throws IOException {
        File file = new File(filename);
        if (!file.canRead())
            throw new FileNotFoundException("File not found/not readable.");
        return readContent(file);
    }

    private Spreadsheet readContent(File file) throws IOException {
        Scanner in = new Scanner(new FileReader(file));
        Spreadsheet spreadsheet = factory.createSpreadSheet();
        int row = 1;
        while (in.hasNext()) {
            String line = in.nextLine();
            int column = 0;
            for (String element: line.split(";")) {
                if (element.length() > 0) {
                    try {
                        ContentSpec contentSpec = createContentSpec(element);
                        Content content = factory.createContent(contentSpec);
                        CoordinateSpec coordinateSpec = createCoordinateSpec(row, column);
                        Coordinate coordinate = factory.createCoordinate(coordinateSpec);
                        spreadsheet.setCell(coordinate, factory.createCell(content));
                    } catch (InvalidInputException | ExpressionException e) {
                        throw new IOException(e.getMessage());
                    }
                }
                column++;
            }
            row++;
        }
        return spreadsheet;
    }

    private CoordinateSpec createCoordinateSpec(int row, int column) {
        return new CoordinateSpec(row, AlphabeticRadixConverter.toAlphabeticRadix(column));
    }

    private ContentSpec createContentSpec(String text) throws InvalidInputException {
        ContentSpec contentSpec;
        if (text.startsWith("\"") | text.startsWith("'")) {
            contentSpec = textContentChecker.checkInput(text);
        } else if (text.startsWith("=")) {
            contentSpec = formulaContentChecker.checkInput(text.replace(",", ";"));
        } else {
            // Assume numerical content.
            try {
                contentSpec = numericalContentChecker.checkInput(text);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Invalid number found");
            }
        }
        return contentSpec;
    }
}
