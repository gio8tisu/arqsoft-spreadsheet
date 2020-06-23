/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.postfix;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;

import java.util.List;

/**
 * Interface that any class breaking the input string in a sequence of tokens 
 * (as enummerated in ), shall have to implement for using the syntax
 * checker and the postfix generator included in this module; this package comes
 * with the class TokenizerImpl that implements this interface, within package 
 * edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl, and that you can use
 * 
 * @author Juan Carlos Cruellas
 */
public interface Tokenizer {
    
    /**
     * Sets the concrete factory for creating the concrete tokens of each 
     * implementation
     * 
     * @param factory the concrete factory
     */
    public void setFactory(SpreadsheetFactory factory) ;
    
    /**
     * Method that analizes the input String str and gets all the tokens that 
     * are present in it.
     * 
     * @param str the string containing the tokens
     * 
     * @throws BadTokenException if some non allowed character is present or some 
     * error happesn during the analysis of the string
     */
    public void tokenize(String str) throws BadTokenException ;
    
    /**
     * Method for returning an ordered list of found tokens in the input String.
     * 
     * @return the ordered list of tokens in the order they appeared in the 
     * input String
     */
    public List<Token> getResult() ;
    
}
