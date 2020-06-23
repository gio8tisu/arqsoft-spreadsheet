package edu.upc.etsetb.arqsoft.miniexceljc.model.domain;

public class NumericalValue implements Value {
    private double value;

    public NumericalValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Value sum(Value v) {
        double otherValue = ((NumericalValue) v).value;
        return new NumericalValue(this.value + otherValue);
    }

    @Override
    public Value subs(Value v) {
        double otherValue = ((NumericalValue) v).value;
        return new NumericalValue(this.value - otherValue);
    }

    @Override
    public Value mult(Value v) {
        double otherValue = ((NumericalValue) v).value;
        return new NumericalValue(this.value * otherValue);
    }

    @Override
    public Value div(Value v) {
        double otherValue = ((NumericalValue) v).value;
        return new NumericalValue(this.value / otherValue);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
