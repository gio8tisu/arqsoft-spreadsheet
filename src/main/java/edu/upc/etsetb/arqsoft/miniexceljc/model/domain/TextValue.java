package edu.upc.etsetb.arqsoft.miniexceljc.model.domain;

public class TextValue implements Value {
    private String value;

    public TextValue(String value) {
        this.value = value;
    }

    public String getString() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
