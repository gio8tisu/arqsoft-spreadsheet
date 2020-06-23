package edu.upc.etsetb.arqsoft.miniexceljc.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlphabeticRadixConverterTest {
    @Test
    public void testToAlphabeticRadix() {
        assertEquals("A", AlphabeticRadixConverter.toAlphabeticRadix(0));
        assertEquals("Z", AlphabeticRadixConverter.toAlphabeticRadix(25));
        assertEquals("BA", AlphabeticRadixConverter.toAlphabeticRadix(26));
        assertEquals("BB", AlphabeticRadixConverter.toAlphabeticRadix(27));
        assertEquals("CA", AlphabeticRadixConverter.toAlphabeticRadix(52));
    }

    @Test
    public void testFromAlphabeticRadix() {
        assertEquals(0, AlphabeticRadixConverter.fromAlphabeticRadix("A"));
        assertEquals(25, AlphabeticRadixConverter.fromAlphabeticRadix("Z"));
        assertEquals(26, AlphabeticRadixConverter.fromAlphabeticRadix("BA"));
        assertEquals(27, AlphabeticRadixConverter.fromAlphabeticRadix("BB"));
        assertEquals(52, AlphabeticRadixConverter.fromAlphabeticRadix("CA"));
    }
}
