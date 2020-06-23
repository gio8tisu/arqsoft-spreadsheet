package edu.upc.etsetb.arqsoft.miniexceljc.util;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.CellType;
import edu.upc.etsetb.arqsoft.miniexceljc.model.ContentSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spec;

public class NumericalContentChecker implements InputChecker {
    @Override
    public Spec checkInput(String input) {
        return new ContentSpec(input, CellType.NUMERICAL);
    }
}
