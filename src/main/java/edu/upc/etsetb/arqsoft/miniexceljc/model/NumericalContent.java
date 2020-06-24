package edu.upc.etsetb.arqsoft.miniexceljc.model;

import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.Number;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.DivZeroException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

public class NumericalContent implements Content {
    private Number number;

    public NumericalContent(Number number) {
        this.number = number;
    }

    @Override
    public Double accept(FormulaVisitor v) throws NotComputableException, DivZeroException, CircularReferenceException {
        return v.visitContent(this);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
