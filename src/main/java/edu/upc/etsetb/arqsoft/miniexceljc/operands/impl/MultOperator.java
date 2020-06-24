package edu.upc.etsetb.arqsoft.miniexceljc.operands.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.operands.Operator;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.DivZeroException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

public class MultOperator implements Operator {
    @Override
    public boolean isAdd() {
        return false;
    }

    @Override
    public boolean isSubs() {
        return false;
    }

    @Override
    public boolean isMult() {
        return true;
    }

    @Override
    public boolean isDiv() {
        return false;
    }

    @Override
    public Double accept(FormulaVisitor v) throws NotComputableException, DivZeroException, CircularReferenceException {
        return v.visitOperator(this);
    }
}
