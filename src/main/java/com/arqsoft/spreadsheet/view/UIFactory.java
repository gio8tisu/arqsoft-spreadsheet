package com.arqsoft.spreadsheet.view;

import com.arqsoft.spreadsheet.model.domain.Content;
import com.arqsoft.spreadsheet.view.text.TextUIFactory;

public abstract class UIFactory {

    public static UIFactory getInstance(String factoryType) throws NoConcreteFactoryException {
        if (factoryType.equalsIgnoreCase("text")) {
            return new TextUIFactory();
        } else {
            throw new NoConcreteFactoryException("Only textual view is available");
        }
    }

    public abstract UISpreadsheet createUISpreadSheet();
    public abstract UIRenderer createUIRenderer();

}
