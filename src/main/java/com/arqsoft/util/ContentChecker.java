package com.arqsoft.util;

import com.arqsoft.InvalidContentException;

public interface ContentChecker {
    String checkInput(String input) throws InvalidContentException;
}
