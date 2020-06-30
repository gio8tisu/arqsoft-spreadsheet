package edu.upc.etsetb.arqsoft.miniexceljc.model;

public class NumericalValue implements Value {
    private double value;

    public NumericalValue(double value) {
        this.value = value;
    }

    public double getNumber() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
