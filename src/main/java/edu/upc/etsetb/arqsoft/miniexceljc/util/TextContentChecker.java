package edu.upc.etsetb.arqsoft.miniexceljc.util;

import edu.upc.etsetb.arqsoft.miniexceljc.client.text.InvalidInputException;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.CellType;
import edu.upc.etsetb.arqsoft.miniexceljc.model.ContentSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spec;

public class TextContentChecker implements InputChecker {
    @Override
    public Spec checkInput(String input) throws InvalidInputException {
        if (input.startsWith("\"") & input.endsWith("\"") ||
                input.startsWith("'") & input.endsWith("'"))
            return new ContentSpec(input, CellType.TEXT);
        else throw new InvalidInputException("Quotes do not match.");
    }
}
