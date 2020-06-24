package edu.upc.etsetb.arqsoft.miniexceljc.model.functions.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.NumericalValue;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spreadsheet;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.model.functions.Function;
import edu.upc.etsetb.arqsoft.miniexceljc.model.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.DivZeroException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

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
    public List<Operand> getElements() {
        return this.elements;
    }

    @Override
    public Double accept(FormulaVisitor v) throws NotComputableException, DivZeroException, CircularReferenceException {
        return v.visitMin(this);
    }

//    @Override
//    public List<Value> getValue(Spreadsheet spreadsheet) {
//        double min = Double.POSITIVE_INFINITY;
//        for (Operand operand: this.elements) {
//            for (Value value: operand.getValue(spreadsheet)) {
//                double candidate = ((NumericalValue) value).getNumber();
//                if (min > candidate)
//                    min = candidate;
//            }
//        }
//        List<Value> res = new ArrayList<>();
//        res.add(new NumericalValue(min));
//        return res;
//    }

}
