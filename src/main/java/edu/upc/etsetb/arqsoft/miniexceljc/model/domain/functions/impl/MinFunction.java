package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.functions.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.NumericalValue;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Spreadsheet;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.functions.Function;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;

import java.util.ArrayList;
import java.util.List;

public class MinFunction implements Function {
    private List<Operand> elements;

    public MinFunction() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void addArgument(Operand op) {
        this.elements.add(op);
    }

    @Override
    public String getName() {
        return "MIN";
    }

    @Override
    public List<Value> getValue(Spreadsheet spreadsheet) {
        double min = Double.POSITIVE_INFINITY;
        for (Operand operand: this.elements) {
            for (Value value: operand.getValue(spreadsheet)) {
                double candidate = ((NumericalValue) value).getNumber();
                if (min > candidate)
                    min = candidate;
            }
        }
        List<Value> res = new ArrayList<>();
        res.add(new NumericalValue(min));
        return res;
    }
}
