package edu.upc.etsetb.arqsoft.miniexceljc.operands.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.NumericalValue;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;

public class Number implements Operand {
    Value value;

    public Number(String value) {
        this.value = new NumericalValue(Double.parseDouble(value));
    }

    public Value getValue() {
        return value;
    }

    @Override
    public Value accept(FormulaVisitor v) {
        return v.visitNumber(this);
    }
}
