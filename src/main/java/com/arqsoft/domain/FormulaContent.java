package com.arqsoft.domain;

public class FormulaContent implements Content {
    @Override
    public Value evaluate() {
        throw new UnsupportedOperationException("Cannot evaluate formula content");
    }
}
