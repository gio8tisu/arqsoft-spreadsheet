package edu.upc.etsetb.arqsoft.miniexceljc.client;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.*;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Cell;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Content;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Coordinate;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spreadsheet;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.ExpressionException;
import edu.upc.etsetb.arqsoft.miniexceljc.util.*;
import edu.upc.etsetb.arqsoft.miniexceljc.view.UIFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.view.UISpreadsheet;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.EmptyCellException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

import java.io.IOException;
import java.util.Map;

public class SpreadsheetController {
    private SpreadsheetFactory factory;
    private Spreadsheet spreadsheet;
    private SpreadsheetLoader spreadsheetLoader;
    private SpreadsheetSaver spreadsheetSaver;
    protected UIFactory uiFactory;
    protected UISpreadsheet uiSpreadsheet;
    private String filename;

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

    public void buildFrameWork(TextContentChecker textContentChecker,
                               NumericalContentChecker numericalContentChecker,
                               FormulaContentChecker formulaContentChecker) {
        this.spreadsheet = this.factory.createSpreadSheet();
        this.spreadsheetLoader = this.factory.createSpreadSheetLoader(
                textContentChecker, numericalContentChecker, formulaContentChecker);
        this.spreadsheetSaver = this.factory.createSpreadSheetSaver();
        this.spreadsheetSaver.setFactory(this.factory);
    }

    public void addCell(CoordinateSpec coordinateSpec, ContentSpec contentSpec) throws CircularReferenceException, NotComputableException, ExpressionException {
        Coordinate coordinate = factory.createCoordinate(coordinateSpec);
        Content content = factory.createContent(contentSpec);

        FormulaVisitor visitor = this.factory.createFormulaVisitor(spreadsheet, coordinate);
        putCellInSpreadsheet(coordinate, content, visitor);

        updateSpreadsheet(coordinate, visitor);
        updateUISpreadsheet();
    }

    private void updateSpreadsheet(Coordinate coordinate, FormulaVisitor visitor) throws NotComputableException, CircularReferenceException {
        try {
            // Update subscribers.
            for (Coordinate subsCoordinate: spreadsheet.getSubscribers(coordinate)) {
                Content subsCont = spreadsheet.getCell(subsCoordinate).getContent();
                if (subsCont instanceof FormulaContent) {
                    visitor.setCurrentCoordinate(subsCoordinate);
                    ((FormulaContent) subsCont).update(visitor);
                }
            }
        } catch (CircularReferenceException e) {
            // Restore.
            for (Coordinate c: visitor.getPreviousValues().keySet()) {
                Content content = spreadsheet.getCell(c).getContent();
                content.setValue(visitor.getPreviousValues().get(c));
                spreadsheet.setCell(c, factory.createCell(content));
            }
            spreadsheet.unSetCell(coordinate);
            spreadsheet.removeSubscriber(coordinate);
            throw e;
        }
    }

    private void updateUISpreadsheet() {
        uiSpreadsheet.resetCells();
        for (Coordinate coordinate: spreadsheet.getCells().keySet()) {
            Value value = spreadsheet.getCellValue(coordinate);
            uiSpreadsheet.setValueAt(coordinate, value);
        }
    }

    private void putCellInSpreadsheet(Coordinate coordinate, Content content, FormulaVisitor visitor) throws NotComputableException, CircularReferenceException {
        spreadsheet.removeSubscriber(coordinate);
        content.setValue(content.accept(visitor));
        Cell cell = factory.createCell(content);
        spreadsheet.setCell(coordinate, cell);
    }

    public void removeCell(CoordinateSpec coordinateSpec) throws CircularReferenceException, NotComputableException, EmptyCellException {
        Coordinate coordinate = factory.createCoordinate(coordinateSpec);
        if (this.spreadsheet.getCells().containsKey(coordinate)) {
            FormulaVisitor visitor = this.factory.createFormulaVisitor(spreadsheet, coordinate);
            this.spreadsheet.unSetCell(coordinate);
            updateSpreadsheet(coordinate, visitor);
            updateUISpreadsheet();
        } else {
            throw new EmptyCellException("Cell is already empty in given coordinate");
        }
    }

    public void saveSpreadsheet() throws FilenameNotSetException {
        if (this.filename == null)
            throw new FilenameNotSetException("Filename not associated");
        spreadsheetSaver.save(spreadsheet, filename);
    }

    public void saveSpreadsheetAs(String filename) {
        this.filename = filename;
        spreadsheetSaver.save(spreadsheet, filename);
    }

    public void loadSpreadsheet(String filename) throws IOException, CircularReferenceException, NotComputableException {
        this.spreadsheet = spreadsheetLoader.load(filename);
        for (Map.Entry<Coordinate, Cell> entry: this.spreadsheet.getCells().entrySet()) {
            FormulaVisitor visitor = this.factory.createFormulaVisitor(this.spreadsheet, entry.getKey());
            Content content = entry.getValue().getContent();
            content.setValue(content.accept(visitor));
        }
        updateUISpreadsheet();
    }

    public void showCellContent(CoordinateSpec coordinateSpec) throws EmptyCellException {
        Coordinate coordinate = factory.createCoordinate(coordinateSpec);
        if (this.spreadsheet.getCells().containsKey(coordinate)) {
            String content = this.spreadsheet.getCell(coordinate).getContent().getContent();
            this.uiSpreadsheet.setCell(coordinate, content);
        } else {
            throw new EmptyCellException("No content in given coordinate");
        }

    public void newSpreadsheet() {
        this.spreadsheet = this.factory.createSpreadSheet();
        this.filename = null;
        uiSpreadsheet.resetCells();
    }
}
