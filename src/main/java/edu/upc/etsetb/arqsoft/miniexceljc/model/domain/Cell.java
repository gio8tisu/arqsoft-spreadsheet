package edu.upc.etsetb.arqsoft.miniexceljc.model.domain;

public class Cell {
    private Content content;

    public Cell(Content content) {
        this.content = content;
    }

    public Value getValue() {
        return content.evaluate();
    }

    public Content getContent() {
        return content;
    }

}
