package edu.upc.etsetb.arqsoft.miniexceljc.operands.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.model.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.Expression;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.ExpressionComponent;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
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
        return components;
    }

    @Override
    public Value accept(FormulaVisitor v) throws NotComputableException, CircularReferenceException {
        return v.visitExpression(this);
    }
}
