package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.functions.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.NumericalValue;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Spreadsheet;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.functions.Function;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;

import java.util.ArrayList;
import java.util.List;

public class SumaFunction implements Function {
    private List<Operand> elements;

    public SumaFunction() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void addArgument(Operand op) {
        this.elements.add(op);
    }

    @Override
    public String getName() {
        return "SUMA";
    }

    @Override
    public List<Value> getValue(Spreadsheet spreadsheet) {
        double sum = 0;
        for (Operand operand: this.elements) {
            for (Value value: operand.getValue(spreadsheet)) {
                sum += ((NumericalValue) value).getNumber();
            }
        }
        List<Value> res = new ArrayList<>();
        res.add(new NumericalValue(sum));
        return res;
    }
}
