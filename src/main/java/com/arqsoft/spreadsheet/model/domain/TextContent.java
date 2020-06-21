package com.arqsoft.spreadsheet.model.domain;

public class TextContent implements Content {
    private String text;

    public TextContent(String text) {
        this.text = text;
    }

    @Override
    public Value evaluate() {
        return new Value<>(text.substring(1, text.length() - 1));
    }

}
