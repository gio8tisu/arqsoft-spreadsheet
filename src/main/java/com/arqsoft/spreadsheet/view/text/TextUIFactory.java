package com.arqsoft.spreadsheet.view.text;

import com.arqsoft.spreadsheet.model.domain.Content;
import com.arqsoft.spreadsheet.view.UICell;
import com.arqsoft.spreadsheet.view.UIFactory;
import com.arqsoft.spreadsheet.view.UISpreadsheet;

public class TextUIFactory extends UIFactory {
    @Override
    public UISpreadsheet createUISpreadSheet() {
        return new TextUISpreadsheet();
    }

    @Override
    public UICell createUICell(Content content) {
        return new TextUICell(content);
    }
}
