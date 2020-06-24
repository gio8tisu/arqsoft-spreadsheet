package edu.upc.etsetb.arqsoft.miniexceljc.model;

import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.Number;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

public class NumericalContent extends Content {
    private Number number;

    public NumericalContent(String number) {
        super(number);
        this.number = new Number(number);
    }

    @Override
    public Value accept(FormulaVisitor v) throws NotComputableException, CircularReferenceException {
        return v.visitNumericalContent(this);
    }

    public Number getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
