package com.arqsoft.domain;

public class Cell {
    private Content content;

    public Cell(Content content) {
        this.content = content;
    }

    public Value getValue() {
        return content.evaluate();
    }

    @Override
    public String toString() {
        return "Cell{" + content.evaluate() + '}';
    }
}
