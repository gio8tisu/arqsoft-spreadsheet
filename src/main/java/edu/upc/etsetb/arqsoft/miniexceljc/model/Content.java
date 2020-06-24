package edu.upc.etsetb.arqsoft.miniexceljc.model;

import edu.upc.etsetb.arqsoft.miniexceljc.visitors.VisitedElement;

public abstract class Content implements VisitedElement {
    protected String content;
    protected Value value;

    public Content(String content) {
        this.content = content;
    }

    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
