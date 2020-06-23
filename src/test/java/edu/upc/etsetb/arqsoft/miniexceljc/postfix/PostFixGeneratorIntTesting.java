package edu.upc.etsetb.arqsoft.miniexceljc.postfix;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;

public class PostFixGeneratorIntTesting {

    public static void main(String[] args) {
        String[] in = {
            
            "A1+A2*A3",
            
            "A1-A2*(A4-A5)*B6",
            
            "A1*(A2*(A3+A4)+A5)",
           
            "A1-A2*(A4-(A5*V4)-V6)*B6",  
             
            "SUMA(13+A8;SUM(A1:A2;A3;A5*(A4-A3));B5/(B6-B5*(A27-A32)))",
            "SUMA(SUM(A1:A2;A3;A5*(A4-A3));13+A8;B5/(B6-B5*(A27-A32)))",
            "SUMA(A1;A2)",
            "SUMA(SUMA(A1:A2;A3);13+A8)",
            "SUMA(SUMA(A1:A2;A3;A5*(A4-A3));(13+A8);B5/(B6-B5*(A27-A32)))",
            "A3+SUMA(MEAN(B5:B30);C1:C20)*(D2*(D4-D5))",
            "SUMA(MEAN(MIN(A1;A2;A4:A6);B1:B7);C3)",
            "A3+A5*B4-((B7*C7)/(A4-D6))+(B16*C17-C12)"
        };
        for (String input : in) {
            try {
                SpreadsheetFactory factory = SpreadsheetFactory.getInstance("DEFAULT");
                PostFixGenerator gen =  factory.createPostFixGenerator();
                gen.setFactory(factory);
                System.out.println("\n\n" + input);
                gen.generateFromString(input);
                System.out.println("Postfix generation OK. Result generated: " + gen.result2String());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Error while trying to generate the postfix expression. Details follow. " + ex.getMessage());
                continue;
            }
        }
    }

}
