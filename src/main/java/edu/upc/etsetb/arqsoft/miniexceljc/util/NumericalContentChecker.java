package edu.upc.etsetb.arqsoft.miniexceljc.util;

import edu.upc.etsetb.arqsoft.miniexceljc.model.CellType;
import edu.upc.etsetb.arqsoft.miniexceljc.model.ContentSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spec;

public class NumericalContentChecker implements InputChecker {
    @Override
    public ContentSpec checkInput(String input) {
        return new ContentSpec(input, CellType.NUMERICAL);
    }
}
