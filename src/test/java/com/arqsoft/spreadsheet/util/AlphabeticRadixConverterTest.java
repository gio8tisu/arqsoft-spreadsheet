package com.arqsoft.spreadsheet.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlphabeticRadixConverterTest {
    @Test
    void testToAlphabeticRadix() {
        assertEquals("A", AlphabeticRadixConverter.toAlphabeticRadix(0));
        assertEquals("B", AlphabeticRadixConverter.toAlphabeticRadix(1));
        assertEquals("AA", AlphabeticRadixConverter.toAlphabeticRadix(27));
        assertEquals("AB", AlphabeticRadixConverter.toAlphabeticRadix(28));
    }

    @Test
    void testFromAlphabeticRadix() {
        assertEquals(1, AlphabeticRadixConverter.fromAlphabeticRadix("A"));
        assertEquals(2, AlphabeticRadixConverter.fromAlphabeticRadix("B"));
        assertEquals(27, AlphabeticRadixConverter.fromAlphabeticRadix("AA"));
        assertEquals(28, AlphabeticRadixConverter.fromAlphabeticRadix("AB"));
    }

}
