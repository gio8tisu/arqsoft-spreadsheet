package edu.upc.etsetb.arqsoft.miniexceljc.visitors;

import edu.upc.etsetb.arqsoft.miniexceljc.model.Content;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Coordinate;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.model.functions.impl.MaxFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.model.functions.impl.MinFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.model.functions.impl.PromedioFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.model.functions.impl.SumaFunction;
import edu.upc.etsetb.arqsoft.miniexceljc.model.operands.Operator;
import edu.upc.etsetb.arqsoft.miniexceljc.model.operands.impl.CellsRange;
import edu.upc.etsetb.arqsoft.miniexceljc.model.operands.impl.Number;
import edu.upc.etsetb.arqsoft.miniexceljc.model.operands.impl.PostFixExpression;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface FormulaVisitor {
    Map getValues() ;

    void addValues(Coordinate cc, Value v) ;

    Coordinate getStartCoordinate() ;

    Coordinate getCurrentCoordinate() ;

    void setCurrentCoordinate(Coordinate coordinate) ;

    Set<Coordinate> getSubscribers(Coordinate coordinate) ;

    Content getCellContent(Coordinate cc) throws EmptyCellException ;

    void setCellContent(Coordinate coordinate, Content content) ;

    Double visitMax(MaxFunction maxFunction);

    Double visitPromedio(PromedioFunction promedioFunction);

    Double visitMin(MinFunction minFunction);

    Double visitSum(SumaFunction sumaFunction);

    Double visitNumber(Number number);

    Double visitOperator(Operator operator);

    Double visitCellsRange(CellsRange cellsRange);

    Double visitExpression(PostFixExpression postFixExpression);

    Double visitContent(Content content);

    Double visitCoordinate(Coordinate coordinate);
}
