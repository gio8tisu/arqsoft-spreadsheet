package edu.upc.etsetb.arqsoft.miniexceljc.model.domain;

public class TextValue implements Value {
    private String value;

    public TextValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Value sum(Value v) {
        String otherValue = ((TextValue) v).value;
        return new TextValue(otherValue);
    }

    @Override
    public Value subs(Value v) {
        throw new UnsupportedOperationException("Cant subtract text");
    }

    @Override
    public Value mult(Value v) {
        throw new UnsupportedOperationException("Cant multiply text");
    }

    @Override
    public Value div(Value v) {
        throw new UnsupportedOperationException("Cant divide text");
    }

    @Override
    public String toString() {
        return this.value;
    }
}
