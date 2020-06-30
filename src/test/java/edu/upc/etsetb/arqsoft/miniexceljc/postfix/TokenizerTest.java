package edu.upc.etsetb.arqsoft.miniexceljc.postfix;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.factories.UnkownFactoryException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author JuanCarlos
 */
public class TokenizerTest {

    @Test
    public void testCorrect() throws UnkownFactoryException, BadTokenException {
        String[] in = {
                "+12+13,2+SUMA(A27:A45", "+12+13,2+SUMA(B23:C47/",
                "+12+13,2+SUMA(/A1+B2*MEAN()B12+CA112",
                "+12 + 13,2+(SUMA(A1:B5;C7;SUMA(C8:C20))+B12)+CA112",
                "(A1+A2)+", "(A1:A2)", "()", "(A1+A2)+B1",
                "A1A2:A3", "A1:A2A3", "/A1"
        };
        SpreadsheetFactory factory = SpreadsheetFactory.getInstance("DEFAULT");
        Tokenizer tokenizer;
        tokenizer = factory.createTokenizer();
        tokenizer.setFactory(factory);
        for (String s : in) {
            tokenizer.tokenize(s);
        }
    }

    @Test
    public void testIncorrect() throws UnkownFactoryException {
        String[] in = {
                "/A", "+A",
                "+12 + 13,2+(SUMA(A1:B5;C7;SUMA(C8:C20))  ?  +B12)+CA112",
                "(A1+A2)+B",
                "A:A1", ":A1", "A1:A", "A1:"
        };
        SpreadsheetFactory factory = SpreadsheetFactory.getInstance("DEFAULT");
        Tokenizer tokenizer;
        tokenizer = factory.createTokenizer();
        tokenizer.setFactory(factory);
        for (String s : in) {
            try {
                tokenizer.tokenize(s);
                fail("Exception not thrown");
            } catch (BadTokenException ignored) {
            }
        }
    }

}
