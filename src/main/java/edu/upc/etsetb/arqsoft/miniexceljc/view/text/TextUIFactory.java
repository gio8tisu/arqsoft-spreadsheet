package edu.upc.etsetb.arqsoft.miniexceljc.view.text;

import edu.upc.etsetb.arqsoft.miniexceljc.view.UIFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.view.UIRenderer;
import edu.upc.etsetb.arqsoft.miniexceljc.view.UISpreadsheet;

public class TextUIFactory extends UIFactory {
    @Override
    public UISpreadsheet createUISpreadSheet() {
        return new TextUISpreadsheet();
    }

    @Override
    public UIRenderer createUIRenderer() {
        return new TextUIRenderer();
    }
}
