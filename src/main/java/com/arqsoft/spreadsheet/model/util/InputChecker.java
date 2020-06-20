package com.arqsoft.spreadsheet.model.util;

import com.arqsoft.spreadsheet.model.InvalidInputException;

public interface InputChecker {
    Spec checkInput(String input) throws InvalidInputException;
}
