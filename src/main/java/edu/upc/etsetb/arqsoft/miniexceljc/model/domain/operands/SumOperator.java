package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands;

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
}
