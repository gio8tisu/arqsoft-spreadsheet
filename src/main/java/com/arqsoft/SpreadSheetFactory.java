package com.arqsoft;

import com.arqsoft.domain.*;
import com.arqsoft.util.ContentChecker;
import com.arqsoft.util.TextContentChecker;

public class SpreadSheetFactory {
    private ContentChecker textContentChecker;
    public SpreadSheetFactory(){
        textContentChecker = new TextContentChecker();
    }

    public Content createContent(String spec) throws InvalidContentException {
        if (spec.startsWith("\"") | spec.startsWith("\'")) {
            String correctedSpec = textContentChecker.checkInput(spec);
            return new TextContent(correctedSpec);
        } else if (spec.startsWith("=")) {
            throw new UnsupportedOperationException("Cannot create formula content");
        } else {
            // Assume numerical content.
            return new NumericalContent(Float.parseFloat(spec));
        }
    }

}
