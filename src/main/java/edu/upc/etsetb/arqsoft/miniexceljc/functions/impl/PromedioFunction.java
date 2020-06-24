package edu.upc.etsetb.arqsoft.miniexceljc.functions.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.functions.Function;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.DivZeroException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PromedioFunction implements Function {
    private List<Operand> elements;

    public PromedioFunction() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void addArgument(Operand op) {
        this.elements.add(op);
    }

    @Override
    public String getName() {
        return "MEAN";
    }

    @Override
    public List<Operand> getElements() {
        return this.elements;
    }

    @Override
    public Double accept(FormulaVisitor v) throws NotComputableException, DivZeroException, CircularReferenceException {
        return v.visitPromedio(this);
    }

    @Override
    public String toString() {
        Iterator<Operand> it = this.elements.iterator();
        StringBuilder s = new StringBuilder(this.getName());
        s.append(" ( ");
        while (it.hasNext()) {
            s.append(it.next());
            if (it.hasNext()){
                s.append(" ; ");
            }
        }
        s.append(" )");

        return s.toString();
    }

//    @Override
//    public List<Value> getValue(Spreadsheet spreadsheet) {
//        double sum = 0;
//        int numElements = 0;
//        for (Operand operand: this.elements) {
//            for (Value value: operand.getValue(spreadsheet)) {
//                sum += ((NumericalValue) value).getNumber();
//                numElements++;
//            }
//        }
//        List<Value> res = new ArrayList<>();
//        res.add(new NumericalValue(sum / numElements));
//        return res;
//    }

}
