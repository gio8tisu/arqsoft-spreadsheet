package edu.upc.etsetb.arqsoft.miniexceljc.postfix;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.factories.UnkownFactoryException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author JuanCarlos
 */
public class SyntaxCheckerTest {

    @Test
    public void testCorrect() throws UnkownFactoryException, SyntaxException {
        String[] in = {
                "13,2",
                "+SUMA(MAX(MIN(A1;A2;A4:A6);B1:B7);C3)",
                "+12 + 13,2+(SUMA(A1:B5;C7;SUMA(C8:C20)) +B12)+CA112",
                "(A1:A2)",
        };
        SpreadsheetFactory factory = SpreadsheetFactory.getInstance("DEFAULT");
        SyntaxChecker parser = factory.createSyntaxChecker();
        parser.setFactory(factory);
        for (String input : in) {
            parser.check(input);
        }
    }

    @Test
    public void testIncorrect() throws UnkownFactoryException {
        String[] in = {
                "/A1",
                "*A1",
                ")A1",
                ":A1",
                ";A1",
                ",A1",
                "+A",
                "+12+13,2+SUMA(A27:A45",
                "+12+13,2+SUMA(B23:C47/",
                "+12+13,2+SUMA(/A1+B2*MAX()B12+CA112",
                "+12 + 13,2+(SUMA(A1:B5;C7;SUMA(C8:C20))  ?  +B12)+CA112",
                "()",
                "(A1+A2)+",
                "(A1+A2)+B",
                "A1A2:A3",
                "A:A1",
                ":A1",
                "A1:A2A3",
                "A1:A",
                "A1:"
        };
        SpreadsheetFactory factory = SpreadsheetFactory.getInstance("DEFAULT");
        SyntaxChecker parser = factory.createSyntaxChecker();
        parser.setFactory(factory);
        for (String input : in) {
            try {
                parser.check(input);
                fail("Exception not thrown" + input);
            } catch (SyntaxException ignore) {
            }
        }
    }

}
