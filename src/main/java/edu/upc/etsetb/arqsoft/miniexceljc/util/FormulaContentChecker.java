package edu.upc.etsetb.arqsoft.miniexceljc.util;

import edu.upc.etsetb.arqsoft.miniexceljc.client.text.InvalidInputException;
import edu.upc.etsetb.arqsoft.miniexceljc.model.CellType;
import edu.upc.etsetb.arqsoft.miniexceljc.model.ContentSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spec;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.SyntaxChecker;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.SyntaxException;

public class FormulaContentChecker implements InputChecker {
    SyntaxChecker syntaxChecker;

    public FormulaContentChecker(SyntaxChecker syntaxChecker) {
        this.syntaxChecker = syntaxChecker;
    }

    @Override
    public ContentSpec checkInput(String input) throws InvalidInputException {
        // syntaxChecker.check(input);
        return new ContentSpec(input, CellType.FORMULA);
    }
}
