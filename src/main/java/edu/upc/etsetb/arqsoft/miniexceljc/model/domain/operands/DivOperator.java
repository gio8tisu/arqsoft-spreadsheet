package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands;

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
}
