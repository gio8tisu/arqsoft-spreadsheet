package edu.upc.etsetb.arqsoft.miniexceljc.util;

import edu.upc.etsetb.arqsoft.miniexceljc.client.text.InvalidInputException;
import edu.upc.etsetb.arqsoft.miniexceljc.model.ContentSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.CoordinateSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spec;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.BadArgumentException;

public class CoordinateChecker implements InputChecker {
    @Override
    public CoordinateSpec checkInput(String input) throws InvalidInputException {
        if (!input.matches("^[a-z|A-Z]*[1-9][0-9]*$")){
            throw new InvalidInputException("'" + input + "' is an invalid cell coordinate.");
        }
        String column = input.replaceAll("[0-9]*$", "").toUpperCase();
        int row = Integer.parseInt(input.replaceAll("^[a-z|A-Z]*", ""));

        return new CoordinateSpec(row, column);
    }
}
