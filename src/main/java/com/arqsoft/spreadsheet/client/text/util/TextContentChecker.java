package com.arqsoft.spreadsheet.client.text.util;

import com.arqsoft.spreadsheet.client.text.InvalidInputException;
import com.arqsoft.spreadsheet.model.domain.CellType;
import com.arqsoft.spreadsheet.model.ContentSpec;
import com.arqsoft.spreadsheet.model.Spec;

public class TextContentChecker implements InputChecker {
    @Override
    public Spec checkInput(String input) throws InvalidInputException {
        if (input.startsWith("\"") & input.endsWith("\"") ||
                input.startsWith("'") & input.endsWith("'"))
            return new ContentSpec(input.substring(1, input.length() - 1), CellType.TEXT);
        else throw new InvalidInputException("Quotes do not match.");
    }
}
