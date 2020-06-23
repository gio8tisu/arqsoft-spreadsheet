package edu.upc.etsetb.arqsoft.miniexceljc.util;

import edu.upc.etsetb.arqsoft.miniexceljc.client.text.InvalidInputException;
import edu.upc.etsetb.arqsoft.miniexceljc.model.CoordinateSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spec;

public class CoordinateChecker implements InputChecker {
    @Override
    public Spec checkInput(String input) throws InvalidInputException {
        String[] inputParts = input.split(" ");
        if (inputParts.length != 2) {
            throw new InvalidInputException("Coordinate has to have 2 parts separated by a space");
        }
        // Check row part.
        try {
            int row = Integer.parseInt(inputParts[1]);
            // Check column part.
            inputParts[0] = inputParts[0].toUpperCase();
            return new CoordinateSpec(row, inputParts[0]);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid row number");
        }
    }
}
