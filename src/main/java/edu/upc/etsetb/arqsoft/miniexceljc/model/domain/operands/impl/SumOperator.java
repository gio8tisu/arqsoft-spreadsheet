package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operator;

public class SumOperator implements Operator {
    @Override
    public boolean isAdd() {
        return true;
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
        return false;
    }

    @Override
    public Value operate(Operand op1, Operand op2) {
        return null;
    }
}
