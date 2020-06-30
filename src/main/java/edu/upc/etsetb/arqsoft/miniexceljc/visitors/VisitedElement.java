package edu.upc.etsetb.arqsoft.miniexceljc.visitors;

import edu.upc.etsetb.arqsoft.miniexceljc.model.Value;

public interface VisitedElement {
    public Value accept(FormulaVisitor v) throws NotComputableException, CircularReferenceException ;
}
