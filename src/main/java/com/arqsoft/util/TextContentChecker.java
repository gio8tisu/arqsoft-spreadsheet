package com.arqsoft.util;

import com.arqsoft.InvalidContentException;

public class TextContentChecker implements ContentChecker {
    @Override
    public String checkInput(String input) throws InvalidContentException {
        if (input.startsWith("\"") & input.endsWith("\""))
            return input.substring(1, input.length() - 1);
        else if (input.startsWith("\'") & input.endsWith("\'"))
            return input.substring(1, input.length() - 1);
        else
            throw new InvalidContentException("Quotes do not match.");
    }
}
