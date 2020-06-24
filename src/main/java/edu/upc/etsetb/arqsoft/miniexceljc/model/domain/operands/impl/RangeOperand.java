package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.*;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.util.AlphabeticRadixConverter;

import java.util.ArrayList;
import java.util.List;

public class RangeOperand implements Operand {

    private Coordinate start;
    private Coordinate end;

    public RangeOperand(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
    }

    private List<SpreadSheetCoordinate> fillCoordinates(Coordinate start, Coordinate end, Spreadsheet spreadsheet) {
        int startCol = start.getColumnAsNum();
        int startRow = start.getRow();
        int endCol = end.getColumnAsNum();
        int endRow = end.getRow();

        List<SpreadSheetCoordinate> coordinates = new ArrayList<>();
        for (int j = startRow; j <= endRow; j++) {
            for (int i = startCol; i <= endCol; i++) {
                coordinates.add(new SpreadSheetCoordinate(j,
                        AlphabeticRadixConverter.toAlphabeticRadix(i), spreadsheet));
            }
        }
        return coordinates;
    }

    @Override
    public List<Value> getValue(Spreadsheet spreadsheet) {
        List<SpreadSheetCoordinate> coordinates = fillCoordinates(start, end, spreadsheet);
        List<Value> res = new ArrayList<>();
        for (SpreadSheetCoordinate c: coordinates) {
            Cell cell = spreadsheet.getCell(c);
            res.add(cell.getValue());
        }
        return res;
    }
}
