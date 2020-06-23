package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Value;

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
