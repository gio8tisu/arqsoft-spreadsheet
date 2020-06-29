package edu.upc.etsetb.arqsoft.miniexceljc.visitors;

import edu.upc.etsetb.arqsoft.miniexceljc.model.*;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.MaxFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.MinFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.MeanFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.SumaFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.Operator;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.CellsRange;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.Number;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.PostFixExpression;

import java.util.Map;
import java.util.Set;

public interface FormulaVisitor {
    Map<Coordinate, Value> getPreviousValues();

    void addValues(Coordinate cc, Value v) ;

    Coordinate getStartCoordinate() ;

    Coordinate getCurrentCoordinate() ;

    void setCurrentCoordinate(Coordinate coordinate) ;

    Set<Coordinate> getSubscribers(Coordinate coordinate) ;

    Content getCellContent(Coordinate cc);

    void setCellContent(Coordinate coordinate, Content content) ;

    Value visitMax(MaxFunction maxFunction) throws CircularReferenceException, NotComputableException;

    Value visitMean(MeanFunction meanFunction) throws CircularReferenceException, NotComputableException;

    Value visitMin(MinFunction minFunction) throws CircularReferenceException, NotComputableException;

    Value visitSuma(SumaFunction sumaFunction) throws CircularReferenceException, NotComputableException;

    Value visitNumber(Number number);

    Value visitOperator(Operator operator) throws NotComputableException;

    Value visitCellsRange(CellsRange cellsRange) throws NotComputableException;

    Value visitExpression(PostFixExpression postFixExpression) throws CircularReferenceException, NotComputableException;

    Value visitTextContent(TextContent content) throws NotComputableException;

    Value visitNumericalContent(NumericalContent content);

    Value visitFormulaContent(FormulaContent content) throws NotComputableException, CircularReferenceException;

    Value visitCoordinate(Coordinate coordinate) throws CircularReferenceException, NotComputableException;
}
