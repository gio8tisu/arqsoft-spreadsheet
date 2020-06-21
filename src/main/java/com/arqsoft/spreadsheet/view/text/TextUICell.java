package com.arqsoft.spreadsheet.view.text;

import com.arqsoft.spreadsheet.model.domain.Content;
import com.arqsoft.spreadsheet.view.UICell;

public class TextUICell implements UICell {

    private Content content;
    
    public TextUICell(Content content) {
        this.content = content;
    }

    public String getValue() {
        return this.content.evaluate().toString();
    }
}
