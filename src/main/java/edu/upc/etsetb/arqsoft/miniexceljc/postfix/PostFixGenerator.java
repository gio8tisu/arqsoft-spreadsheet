/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.postfix;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.ExpressionComponent;

import java.util.List;

/**
 * Interface that the postfix generator included in this module implements; 
 * this package comes with the class PostFixGeneratorImpl that implements 
 * this interface, within package edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl, 
 * and that you can use.
*
 * @author JuanCarlos
 */
public interface PostFixGenerator {

    /**
     * Sets the factory for the different expression components (operands 
     * and operators) to be generated 
     * 
     * @param factory the concrete factory
     */
    public void setFactory(SpreadsheetFactory factory);

    /**
     * Takes a string representing an expression and generates the postfix 
     * sequence of operands and operators using shunting yard algorithm after
     * creating and running a tokenizer implementing the interface  and a
     * syntax checker implementing the interface
     *
     * @param input the string representing the expression
     * @throws ExpressionException if something goes wrong
     */
    public void generateFromString(String input) throws ExpressionException;

    /**
     * Takes a list of tokens as generated by an implementation of Tokenizer 
     * interface and checked by an implementation of SyntaxChecker interface, 
     * and generates the postfix sequence of operands and operators using
     * shunting yard algorithm.
     * 
     * @param tks the list of tokens
     * @throws ExpressionException if something goes wrong
     */
    public void generateFromTokens(List<Token> tks) throws ExpressionException;
    
    /**
     * Returns the resulting list of operands and operators representing the postfix 
     * notation generated by the object using the shunting yard algorithm.
     * 
     * @return the result (list of operands and operators representing the postfix 
     * notation) generated by this object.
     */
    public List<ExpressionComponent> getResultQueue() ;
    
    /**
     * Returns a string with the result of computing the postfix notation of 
     * the expression given to the object.
     * 
     * @return a string showing the postfix notation
     */
    public String result2String() ;

}
