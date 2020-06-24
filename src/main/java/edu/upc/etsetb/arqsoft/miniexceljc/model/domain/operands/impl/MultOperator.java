package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.NumericalValue;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operator;

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
    public Value operate(Operand op1, Operand op2) {
        NumericalValue value1 = (NumericalValue) op1.getValue();
        NumericalValue value2 = (NumericalValue) op2.getValue();
        return new NumericalValue(value1.getNumber() * value2.getNumber());
    }
}
