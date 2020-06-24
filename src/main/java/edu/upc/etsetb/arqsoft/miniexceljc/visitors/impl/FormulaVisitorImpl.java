package edu.upc.etsetb.arqsoft.miniexceljc.visitors.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.Content;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Coordinate;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spreadsheet;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.MaxFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.MinFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.PromedioFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.SumaFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.Operator;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.CellsRange;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.Number;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.PostFixExpression;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.EmptyCellException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FormulaVisitorImpl implements FormulaVisitor {
    Spreadsheet spreadsheet;
    Coordinate startCoordinate;
    Coordinate currentCoordinate;
    Map<Coordinate, Value> values;

    public FormulaVisitorImpl(Spreadsheet spreadsheet, Coordinate startCoordinate) {
        this.spreadsheet = spreadsheet;
        this.startCoordinate = startCoordinate;
        this.values = new HashMap<>();
    }

    @Override
    public Map getValues() {
        return values;
    }

    @Override
    public void addValues(Coordinate cc, Value v) {
        if (!this.values.containsKey(cc)) {
            this.values.put(cc, v);
        }
    }

    @Override
    public Coordinate getStartCoordinate() {
        return startCoordinate;
    }

    @Override
    public Coordinate getCurrentCoordinate() {
        return currentCoordinate;
    }

    @Override
    public void setCurrentCoordinate(Coordinate coordinate) {
        this.currentCoordinate = coordinate;
    }

    @Override
    public Set<Coordinate> getSubscribers(Coordinate coordinate) {
        return this.spreadsheet.getSubscribers(coordinate);
    }

    @Override
    public Content getCellContent(Coordinate cc) throws EmptyCellException {
        return null;
    }

    @Override
    public void setCellContent(Coordinate coordinate, Content content) {

    }

    @Override
    public Double visitMax(MaxFunction maxFunction) {
        return null;
    }

    @Override
    public Double visitPromedio(PromedioFunction promedioFunction) {
        return null;
    }

    @Override
    public Double visitMin(MinFunction minFunction) {
        return null;
    }

    @Override
    public Double visitSum(SumaFunction sumaFunction) {
        return null;
    }

    @Override
    public Double visitNumber(Number number) {
        return null;
    }

    @Override
    public Double visitOperator(Operator operator) {
        return null;
    }

    @Override
    public Double visitCellsRange(CellsRange cellsRange) {
        return null;
    }

    @Override
    public Double visitExpression(PostFixExpression postFixExpression) {
        return null;
    }

    @Override
    public Double visitContent(Content content) {
        return null;
    }

    @Override
    public Double visitCoordinate(Coordinate coordinate) {
        return null;
    }
}
