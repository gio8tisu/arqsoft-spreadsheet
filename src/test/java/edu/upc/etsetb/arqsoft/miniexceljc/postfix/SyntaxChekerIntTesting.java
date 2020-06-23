package edu.upc.etsetb.arqsoft.miniexceljc.postfix;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.factories.UnkownFactoryException;

/**
 *
 * @author JuanCarlos
 */
public class SyntaxChekerIntTesting {

    public static void main(String[] args) {
        String[] in = {
            "13,2",
            "/A1",
            "*A1",
            ")A1",
            ":A1",
            ";A1",
            ",A1",
            "+SUMA(MAX(MIN(A1;A2;A4:A6);B1:B7);C3)",
            "+A",
            "+12+13,2+SUMA(A27:A45",
            "+12+13,2+SUMA(B23:C47/",
            "+12+13,2+SUMA(/A1+B2*MAX()B12+CA112",
            "+12 + 13,2+(SUMA(A1:B5;C7;SUMA(C8:C20)) +B12)+CA112",
            "+12 + 13,2+(SUMA(A1:B5;C7;SUMA(C8:C20))  ?  +B12)+CA112",
            "(A1:A2)",
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
        for (String input : in) {
            try {
                SpreadsheetFactory factory = SpreadsheetFactory.getInstance("DEFAULT");
                SyntaxChecker parser = factory.createSyntaxChecker();
                System.out.println("\n\n" + input);
                parser.setFactory(factory);
                parser.check(input);
                System.out.println("Checking OK. Tokens found: " + parser.result2String());
            } catch (SyntaxException ex) {
                System.out.println("An error has occurred while parsing. Details follow. " + ex.getMessage());
            } catch (UnkownFactoryException ex) {
                System.out.println("ERROR WHEN TRYING TO INSTANTIATE THE FACTORY. DETAILS: " + ex.getMessage());
                System.out.println("ENDING EXECUTION...");
                System.exit(-1);

            }

        }
    }

}
