package com.arqsoft.spreadsheet.util;

import com.arqsoft.spreadsheet.client.text.InvalidInputException;
import com.arqsoft.spreadsheet.model.Spec;

public interface InputChecker {
    Spec checkInput(String input) throws InvalidInputException;
}
