package com.arqsoft;

import com.arqsoft.domain.*;

public class SpreadSheetFactory {
    public SpreadSheetFactory(){}

    public Content createContent(String spec) throws InvalidContentException {
        if (spec.startsWith("\"") | spec.startsWith("\'")) {
            if (spec.startsWith("\"") & spec.endsWith("\""))
                return new TextContent(spec.substring(1, spec.length() - 1));
            else if (spec.startsWith("\'") & spec.endsWith("\'"))
                return new TextContent(spec.substring(1, spec.length() - 1));
            else
                throw new InvalidContentException("Quotes do not match.");
        } else if (spec.startsWith("=")) {
            throw new UnsupportedOperationException("Cannot create formula content");
        } else {
            // Assume numerical content.
            return new NumericalContent(Float.parseFloat(spec));
        }
    }

}
