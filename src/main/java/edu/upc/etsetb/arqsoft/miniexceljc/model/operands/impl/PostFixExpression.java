package edu.upc.etsetb.arqsoft.miniexceljc.model.operands.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.operands.Expression;
import edu.upc.etsetb.arqsoft.miniexceljc.model.operands.ExpressionComponent;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.DivZeroException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

import java.util.List;

public class PostFixExpression implements Expression {
    List<ExpressionComponent> components;

    public PostFixExpression(List<ExpressionComponent> components) {
        this.components = components;
    }

    @Override
    public List<ExpressionComponent> getComponents() {
        return null;
    }

    @Override
    public Double accept(FormulaVisitor v) throws NotComputableException, DivZeroException, CircularReferenceException {
        return v.visitExpression(this);
    }
}
