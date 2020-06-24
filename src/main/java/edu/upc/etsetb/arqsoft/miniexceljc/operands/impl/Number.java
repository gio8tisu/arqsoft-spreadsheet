package edu.upc.etsetb.arqsoft.miniexceljc.operands.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.DivZeroException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

public class Number implements Operand {
    double value;

    public Number(String value) {
        this.value = Double.parseDouble(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Double accept(FormulaVisitor v) throws NotComputableException, DivZeroException, CircularReferenceException {
        return v.visitNumber(this);
    }
}
