/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.postfix;

/**
 *
 * @author Juan Carlos Cruellas
 */
public class ExpressionException extends Exception {

    /**
     * Creates a new instance of <code>PostfixException</code> without detail
     * message.
     */
    public ExpressionException() {
    }

    /**
     * Constructs an instance of <code>PostfixException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExpressionException(String msg) {
        super(msg);
    }
}
