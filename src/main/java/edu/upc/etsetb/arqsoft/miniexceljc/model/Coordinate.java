package edu.upc.etsetb.arqsoft.miniexceljc.model;

import edu.upc.etsetb.arqsoft.miniexceljc.model.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.util.AlphabeticRadixConverter;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.DivZeroException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

import java.util.Objects;

public class Coordinate implements Operand {
    protected int row;
    protected String column;

    public Coordinate(int row, String column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public String getColumn() {
        return column;
    }

    public int getColumnAsNum() {
        return AlphabeticRadixConverter.fromAlphabeticRadix(column);
    }

    @Override
    public String toString() {
        return column + row;
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

    @Override
    public Double accept(FormulaVisitor v) throws NotComputableException, DivZeroException, CircularReferenceException {
        return v.visitCoordinate(this);
    }
}
