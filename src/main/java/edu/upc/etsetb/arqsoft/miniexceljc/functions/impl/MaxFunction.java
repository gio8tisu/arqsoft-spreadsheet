package edu.upc.etsetb.arqsoft.miniexceljc.functions.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.functions.Function;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaxFunction implements Function {
    private List<Operand> elements;

    public MaxFunction() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void addArgument(Operand op) {
        this.elements.add(op);
    }

    @Override
    public String getName() {
        return "MAX";
    }

    @Override
    public List<Operand> getElements() {
        return this.elements;
    }

    @Override
    public Value accept(FormulaVisitor v) throws NotComputableException, CircularReferenceException {
        return v.visitMax(this);
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

}
