package edu.upc.etsetb.arqsoft.miniexceljc.view;

import edu.upc.etsetb.arqsoft.miniexceljc.view.text.TextUIFactory;

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
