/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.postfix;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;

import java.util.List;

/**
 * Interface that any class analyzing the syntax correction of the sequence of
 * tokens generated by the tokenizer, shall have to implement for using the
 * postfix generator included in this module; this package comes with the class
 * SyntaxCheckerImpl that implements this interface, within package
 * edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl, and that you can use.
 *
 * @author Juan Carlos Cruellas
 */
public interface SyntaxChecker {

    /**
     * Sets the concrete factory for creating the concrete tokens of each
     * implementation
     *
     * @param factory the concrete factory
     */
    public void setFactory(SpreadsheetFactory factory);

    /**
     * Returns the list of tokens after checking their correctness
     * 
     * @return the list of tokens
     */
    public List<Token> getTokens();

    /**
     * Method that creates an object that implements the interface 
     * makes it to break the string in a sequence of tokens, and checks that
     * the sequence is correct.
     * 
     * @param input the string containing the tokens
     * @throws SyntaxException if it finds any syntax error
     */
    public void check(String input) throws SyntaxException;

    String result2String();
}
