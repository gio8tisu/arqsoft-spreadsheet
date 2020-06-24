package edu.upc.etsetb.arqsoft.miniexceljc.operands.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.operands.Operator;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.DivZeroException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

public class DivOperator implements Operator {
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
        return false;
    }

    @Override
    public boolean isDiv() {
        return true;
    }

    @Override
    public Double accept(FormulaVisitor v) throws NotComputableException, DivZeroException, CircularReferenceException {
        return v.visitOperator(this);
    }
}
