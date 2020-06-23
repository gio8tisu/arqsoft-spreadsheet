/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.postfix;

/**
 * Interface that any class managing tokens shall have to implement for being 
 * used by the tokenizer, the syntax checker, and the postfix generator included 
 * in the present module; this package comes with the class TokenImpl, within 
 * the package edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl, which implements 
 * this interface, and that you can use
 * 
 * @author Juan Carlos Cruellas
 */
public interface Token {
    
    /**
     * Returns the type of the object
     * 
     * @return the type of the token as an object of a class / or enumerated type
     * value that is implementation-dependent, and that implements the 
     * interface TokenType
     */
    public TokenType getType() ;
    
    /**
     * Returns the text of the token
     * 
     * @return the text of the token
     */
    public String getText() ;
    
    /**
     * Indicates whether the token is a closing round bracket ')'
     * 
     * @return true if the token is a closing round bracket ')', false otherwise
     */
    public boolean isClosingB() ;
    
    /**
     * Indicates whether the token is an operator
     * 
     * @return true if the token is an operator, false otherwise
     */
    public boolean isOperator() ;
    
    /**
     * Indicates whether the token is a function name
     * 
     * @return true if the token is a function name, false otherwise
     */
    public boolean isFunction() ;
    
    /**
     * Indicates whether the token is a semicolon
     * 
     * @return true if the token is a semicolon, false otherwise
     */
    public boolean isSemicolon() ;
    
    /**
     * Indicates whether the token is a reference to a cell (A21, for example)
     * 
     * @return true if the token is a reference to a cell, false otherwise
     */
    public boolean isCell() ;
    
    /**
     * Indicates whether the token is a range of cells (A1:C21, for instance)
     * 
     * @return true if the token is a range of cells, false otherwise
     */
    public boolean isRange() ;    
    
    /**
     * Indicates whether the token is an opening round bracket '('
     * 
     * @return true if the token is an opening round bracket, false otherwise
     */
    public boolean isOpeningB() ;    
    
    /**
     * Indicates whether the token is a number
     * 
     * @return true if the token is a number, false otherwise
     */
    public boolean isNumber() ;
}
