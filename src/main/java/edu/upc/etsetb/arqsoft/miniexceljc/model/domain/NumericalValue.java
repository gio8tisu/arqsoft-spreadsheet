package edu.upc.etsetb.arqsoft.miniexceljc.model.domain;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;

import java.util.ArrayList;
import java.util.List;

public class NumericalValue implements Value, Operand {
    private double value;

    public NumericalValue(double value) {
        this.value = value;
    }

    public List<Value> getValue(Spreadsheet spreadsheet) {
        List<Value> res = new ArrayList<>();
        res.add(this);
        return res;
    }

    public double getNumber() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
