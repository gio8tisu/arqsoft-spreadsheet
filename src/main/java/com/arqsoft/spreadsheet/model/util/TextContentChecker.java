package com.arqsoft.spreadsheet.model.util;

import com.arqsoft.spreadsheet.model.InvalidInputException;
import com.arqsoft.spreadsheet.model.domain.ContentSpec;

public class TextContentChecker implements InputChecker {
    @Override
    public Spec checkInput(String input) throws InvalidInputException {
        if (input.startsWith("\"") & input.endsWith("\"") ||
                input.startsWith("'") & input.endsWith("'"))
            return new ContentSpec(input.substring(1, input.length() - 1));
        else throw new InvalidInputException("Quotes do not match.");
    }
}
