package com.arqsoft.spreadsheet.view.text;

import com.arqsoft.spreadsheet.view.UICell;
import com.arqsoft.spreadsheet.view.UIFactory;
import com.arqsoft.spreadsheet.view.UISpreadSheet;

public class TextUIFactory extends UIFactory {
    @Override
    public UISpreadSheet createUISpreadSheet() {
        return new TextUISpreadSheet();
    }

    @Override
    public UICell createUICell() {
        return new TextUICell();
    }
}
