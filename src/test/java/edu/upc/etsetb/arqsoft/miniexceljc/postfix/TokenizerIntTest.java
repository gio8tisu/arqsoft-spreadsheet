package edu.upc.etsetb.arqsoft.miniexceljc.postfix;

import edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.TokenizerImpl;
import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.factories.UnkownFactoryException;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.BadTokenException;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.Token;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.Tokenizer;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.TokenizerImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanCarlos
 */
public class TokenizerIntTest {

    public static void main(String[] args) {
        String[] in = {
            "/A", "+A", "+12+13,2+SUMA(A27:A45", "+12+13,2+SUMA(B23:C47/",
            "+12+13,2+SUMA(/A1+B2*MEAN()B12+CA112",
            "+12 + 13,2+(SUMA(A1:B5;C7;SUMA(C8:C20))+B12)+CA112",
            "+12 + 13,2+(SUMA(A1:B5;C7;SUMA(C8:C20))  ?  +B12)+CA112",
            "(A1:A2)", "()",
            "(A1+A2)+", "(A1+A2)+B",
            "A1A2:A3", "A:A1", ":A1", "A1:A2A3", "A1:A", "A1:"};
        for (int i = 0; i < in.length; i++) {
            List<Token> result = new ArrayList<Token>();
            System.out.println(in[i]);
            Tokenizer tokenizer = null;
            try {
                SpreadsheetFactory factory = SpreadsheetFactory.getInstance("DEFAULT");
                tokenizer = factory.createTokenizer();
                tokenizer.setFactory(factory);
                tokenizer.tokenize(in[i]);
                System.out.println(((TokenizerImpl)tokenizer).result2String());
            } catch (BadTokenException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Tokens found before the error: " + ((TokenizerImpl)tokenizer).result2String());
            } catch (UnkownFactoryException ex) {
                System.out.println("ERROR WHEN TRYING TO INSTANTIATE THE FACTORY. DETAILS: " + ex.getMessage());
                System.out.println("ENDING EXECUTION...");
                System.exit(-1);

            }
            System.out.println();
        }
    }

}
