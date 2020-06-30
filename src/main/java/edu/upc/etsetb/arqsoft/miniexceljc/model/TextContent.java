package edu.upc.etsetb.arqsoft.miniexceljc.model;

import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

public class TextContent extends Content {
    private String text;

    public TextContent(String content) {
        super(content);
        this.text = content;
    }

    @Override
    public Value accept(FormulaVisitor v) throws NotComputableException, CircularReferenceException {
        return v.visitTextContent(this);
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
