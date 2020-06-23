package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands;

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
}
