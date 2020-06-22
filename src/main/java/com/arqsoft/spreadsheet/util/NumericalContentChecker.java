package com.arqsoft.spreadsheet.util;

import com.arqsoft.spreadsheet.model.domain.CellType;
import com.arqsoft.spreadsheet.model.ContentSpec;
import com.arqsoft.spreadsheet.model.Spec;

public class NumericalContentChecker implements InputChecker {
    @Override
    public Spec checkInput(String input) {
        return new ContentSpec(input, CellType.NUMERICAL);
    }
}
