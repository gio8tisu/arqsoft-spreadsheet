package com.arqsoft.spreadsheet.client.text.util;

import com.arqsoft.spreadsheet.client.text.InvalidInputException;
import com.arqsoft.spreadsheet.model.CoordinateSpec;
import com.arqsoft.spreadsheet.model.Spec;

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
