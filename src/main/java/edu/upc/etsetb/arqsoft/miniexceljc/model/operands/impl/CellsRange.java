package edu.upc.etsetb.arqsoft.miniexceljc.model.operands.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.*;
import edu.upc.etsetb.arqsoft.miniexceljc.model.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.util.AlphabeticRadixConverter;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.DivZeroException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

import java.util.HashSet;
import java.util.Set;

public class CellsRange implements Operand {

    private Coordinate start;
    private Coordinate end;
    private Set<Coordinate> coordinates;

    public CellsRange(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
        this.coordinates = computeCoordinatesSet(start, end);
    }

    private Set<Coordinate> computeCoordinatesSet(Coordinate start, Coordinate end) {
        int startCol = start.getColumnAsNum();
        int startRow = start.getRow();
        int endCol = end.getColumnAsNum();
        int endRow = end.getRow();

        Set<Coordinate> coordinates = new HashSet<>();
        for (int j = startRow; j <= endRow; j++) {
            for (int i = startCol; i <= endCol; i++) {
                coordinates.add(new Coordinate(j, AlphabeticRadixConverter.toAlphabeticRadix(i)));
            }
        }
        return coordinates;
    }

    public Set<Coordinate> getCoordinates() {
        return coordinates;
    }

    @Override
    public Double accept(FormulaVisitor v) throws NotComputableException, DivZeroException, CircularReferenceException {
        return v.visitCellsRange(this);
    }

//    @Override
//    public List<Value> getValue(Spreadsheet spreadsheet) {
//        List<SpreadSheetCoordinate> coordinates = fillCoordinates(start, end, spreadsheet);
//        List<Value> res = new ArrayList<>();
//        for (SpreadSheetCoordinate c: coordinates) {
//            Cell cell = spreadsheet.getCell(c);
//            res.add(cell.getValue());
//        }
//        return res;
//    }

}
