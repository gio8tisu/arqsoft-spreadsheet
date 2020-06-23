package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands;

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
}
