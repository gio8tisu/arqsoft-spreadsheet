package edu.upc.etsetb.arqsoft.miniexceljc.model.domain;

public class Value<T> {
    private T value;

    public Value(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

}
