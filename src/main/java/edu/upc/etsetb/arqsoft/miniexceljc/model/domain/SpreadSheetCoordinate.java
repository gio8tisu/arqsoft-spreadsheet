package edu.upc.etsetb.arqsoft.miniexceljc.model.domain;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpreadSheetCoordinate extends Coordinate implements Operand {
    private final Spreadsheet spreadsheet;

    public SpreadSheetCoordinate(int row, String column, Spreadsheet spreadsheet) {
        super(row, column);
        this.spreadsheet = spreadsheet;
    }

    @Override
    public List<Value> getValue(Spreadsheet spreadsheet) {
        List<Value> res = new ArrayList<Value>();
        res.add(this.spreadsheet.getCell(this).getValue());
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row &&
                Objects.equals(column, that.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
