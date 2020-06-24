package edu.upc.etsetb.arqsoft.miniexceljc.visitors;

public interface VisitedElement {
    public Double accept(FormulaVisitor v) throws NotComputableException, DivZeroException, CircularReferenceException ;
}
