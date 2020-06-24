package edu.upc.etsetb.arqsoft.miniexceljc.model.operands.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.operands.Operator;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.DivZeroException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

public class SubsOperator implements Operator {
    @Override
    public boolean isAdd() {
        return false;
    }

    @Override
    public boolean isSubs() {
        return true;
    }

    @Override
    public boolean isMult() {
        return false;
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
