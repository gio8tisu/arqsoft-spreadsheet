package edu.upc.etsetb.arqsoft.miniexceljc.subscribers;

import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.DivZeroException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

public interface Subscriber {
    void update(FormulaVisitor v) throws NotComputableException, DivZeroException, CircularReferenceException;
}
