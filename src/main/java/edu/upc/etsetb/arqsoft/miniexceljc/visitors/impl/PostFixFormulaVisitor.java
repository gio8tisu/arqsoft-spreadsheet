package edu.upc.etsetb.arqsoft.miniexceljc.visitors.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.*;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.MaxFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.MinFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.MeanFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.SumaFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.ExpressionComponent;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.Operator;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.CellsRange;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.Number;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.PostFixExpression;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.*;

import java.util.*;

public class PostFixFormulaVisitor implements FormulaVisitor {

    Spreadsheet spreadsheet;
    Coordinate startCoordinate;
    Coordinate currentCoordinate;
    Map<Coordinate, Value> previousValues;

    public PostFixFormulaVisitor(Spreadsheet spreadsheet, Coordinate startCoordinate) {
        this.spreadsheet = spreadsheet;
        this.startCoordinate = startCoordinate;
        this.previousValues = new HashMap<>();
    }

    @Override
    public Map<Coordinate, Value> getPreviousValues() {
        return previousValues;
    }

    @Override
    public void addValues(Coordinate cc, Value v) {
        if (!this.previousValues.containsKey(cc)) {
            this.previousValues.put(cc, v);
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
    public Content getCellContent(Coordinate coordinate) {
        return this.spreadsheet.getCell(coordinate).getContent();
    }

    @Override
    public void setCellContent(Coordinate coordinate, Content content) {
        this.spreadsheet.getCell(coordinate).setContent(content);
    }

    @Override
    public Value visitNumericalContent(NumericalContent content) {
        return content.getNumber().accept(this);
    }

    @Override
    public Value visitFormulaContent(FormulaContent content) throws NotComputableException, CircularReferenceException {
        Value value = content.getValue();
        if (value == null) {
            return content.getExpression().accept(this);
        }
        return value;
    }

    @Override
    public Value visitMax(MaxFunction maxFunction) throws CircularReferenceException, NotComputableException {
        double max = Double.NEGATIVE_INFINITY;
        for (Operand operand: maxFunction.getElements()) {
            if (!(operand instanceof CellsRange)) {
                NumericalValue value = (NumericalValue) operand.accept(this);
                double candidate = value.getNumber();
                if (max < candidate)
                    max = candidate;
            } else {
                for (Coordinate coordinate: ((CellsRange) operand).getCoordinates()) {
                    NumericalValue value = (NumericalValue) coordinate.accept(this);
                    double candidate = value.getNumber();
                    if (max < candidate)
                        max = candidate;
                }
            }
        }
        return new NumericalValue(max);
    }

    @Override
    public Value visitMean(MeanFunction meanFunction) throws CircularReferenceException, NotComputableException {
        double sum = 0;
        int numElements = 0;
        for (Operand operand: meanFunction.getElements()) {
            if (!(operand instanceof CellsRange)) {
                NumericalValue value = (NumericalValue) operand.accept(this);
                sum += value.getNumber();
                numElements++;
            } else {
                for (Coordinate coordinate: ((CellsRange) operand).getCoordinates()) {
                    NumericalValue value = (NumericalValue) coordinate.accept(this);
                    sum += value.getNumber();
                    numElements++;
                }
            }
        }
        return new NumericalValue(sum / numElements);
    }

    @Override
    public Value visitMin(MinFunction minFunction) throws CircularReferenceException, NotComputableException {
        double min = Double.POSITIVE_INFINITY;
        for (Operand operand: minFunction.getElements()) {
            if (!(operand instanceof CellsRange)) {
                NumericalValue value = (NumericalValue) operand.accept(this);
                double candidate = value.getNumber();
                if (min > candidate)
                    min = candidate;
            } else {
                for (Coordinate coordinate: ((CellsRange) operand).getCoordinates()) {
                    NumericalValue value = (NumericalValue) coordinate.accept(this);
                    double candidate = value.getNumber();
                    if (min > candidate)
                        min = candidate;
                }
            }
        }
        return new NumericalValue(min);
    }

    @Override
    public Value visitSuma(SumaFunction sumaFunction) throws CircularReferenceException, NotComputableException {
        double sum = 0;
        for (Operand operand: sumaFunction.getElements()) {
            if (!(operand instanceof CellsRange)) {
                NumericalValue value = (NumericalValue) operand.accept(this);
                sum += value.getNumber();
            } else {
                for (Coordinate coordinate: ((CellsRange) operand).getCoordinates()) {
                    NumericalValue value = (NumericalValue) coordinate.accept(this);
                    sum += value.getNumber();
                }
            }
        }
        return new NumericalValue(sum);
    }

    @Override
    public Value visitNumber(Number number) {
        return number.getValue();
    }

    @Override
    public Value visitOperator(Operator operator) throws NotComputableException {
        throw new NotComputableException();
    }

    @Override
    public Value visitCellsRange(CellsRange cellsRange) throws NotComputableException {
        throw new NotComputableException();
    }

    @Override
    public Value visitExpression(PostFixExpression postFixExpression) throws CircularReferenceException, NotComputableException {
        Stack<Value> stack=new Stack<>();
        for (ExpressionComponent component : postFixExpression.getComponents()) {
            if (!(component instanceof Operator)) {
                stack.push(component.accept(this));
            } else {
                Value lastValue = stack.pop();
                Value previousValue = stack.pop();
                if (((Operator) component).isAdd()) {
                    double result = ((NumericalValue) previousValue).getNumber() + ((NumericalValue) lastValue).getNumber();
                    stack.push(new NumericalValue(result));
                } else if (((Operator) component).isSubs()) {
                    double result = ((NumericalValue) previousValue).getNumber() - ((NumericalValue) lastValue).getNumber();
                    stack.push(new NumericalValue(result));
                } else if (((Operator) component).isMult()) {
                    double result = ((NumericalValue) previousValue).getNumber() * ((NumericalValue) lastValue).getNumber();
                    stack.push(new NumericalValue(result));
                } else if (((Operator) component).isDiv()) {
                    double result = ((NumericalValue) previousValue).getNumber() / ((NumericalValue) lastValue).getNumber();
                    stack.push(new NumericalValue(result));
                }
            }
        }
        return stack.pop();
    }

    @Override
    public Value visitTextContent(TextContent content) {
        String text = content.getText();
        return new TextValue(text.substring(1, text.length() - 1));
    }

    @Override
    public Value visitCoordinate(Coordinate coordinate) throws CircularReferenceException, NotComputableException {
        try {
            if (this.currentCoordinate == this.startCoordinate) {
                throw new CircularReferenceException("Circular reference in" + coordinate.toString());
            }
            if (!this.currentCoordinate.equals(coordinate)) {
                this.spreadsheet.addSubscriber(this.currentCoordinate, coordinate);
            }
        } catch (NullPointerException ex) {
            if (!this.startCoordinate.equals(coordinate)) {
                this.spreadsheet.addSubscriber(this.startCoordinate, coordinate);
            }
        }

        return this.spreadsheet.getCell(coordinate).getContent().accept(this);
    }
}
