package edu.upc.etsetb.arqsoft.miniexceljc.model.domain;

public class NumericalContent implements Content {
    private double number;

    public NumericalContent(double number) {
        this.number = number;
    }

    @Override
    public Value evaluate() {
        return new Value<>(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
