package com.arqsoft.util;

import com.arqsoft.InvalidInputException;

public interface InputChecker {
    Spec checkInput(String input) throws InvalidInputException;
}
