package edu.upc.etsetb.arqsoft.miniexceljc.model;

import edu.upc.etsetb.arqsoft.miniexceljc.operands.Expression;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.*;

public class FormulaContent extends Content implements Subscriber {
    Expression expression;

    public FormulaContent(String content) {
        super(content);
    }

    @Override
    public Value accept(FormulaVisitor v) throws NotComputableException, CircularReferenceException {
        return v.visitFormulaContent(this);
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void update(FormulaVisitor v) throws NotComputableException, CircularReferenceException {
        v.addValues(v.getCurrentCoordinate(), this.value);
        this.setValue(null);
        this.setValue(this.accept(v));
        v.setCellContent(v.getCurrentCoordinate(), this);
        for (Coordinate subscribers: v.getSubscribers(v.getCurrentCoordinate())) {
            v.setCurrentCoordinate(subscribers);
            if (v.getCellContent(subscribers) instanceof FormulaContent) {
                FormulaContent content = (FormulaContent) v.getCellContent(subscribers);
                if (content == null)
                    continue;
                v.addValues(v.getCurrentCoordinate(), content.getValue());
                content.setValue(null);
                content.update(v);
                v.setCellContent(subscribers, content);
            }
        }
    }
}
