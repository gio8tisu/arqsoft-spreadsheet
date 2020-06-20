package com.arqsoft.domain;

public class NumericalContent implements Content {
    private double number;

    public NumericalContent(double number) {
        this.number = number;
    }

    @Override
    public Value evaluate() {
        return new Value<>(number);
    }

}
