package edu.upc.etsetb.arqsoft.miniexceljc.model;

import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.DivZeroException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

public class TextContent implements Content {
    private String text;

    public TextContent(String text) {
        this.text = text;
    }

    @Override
    public Double accept(FormulaVisitor v) throws NotComputableException, DivZeroException, CircularReferenceException {
        return v.visitContent(this);
    }

    @Override
    public String toString() {
        return text;
    }
}
