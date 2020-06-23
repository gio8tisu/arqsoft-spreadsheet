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
public class UnknownTokenTypeException extends Exception {

    /**
     * Creates a new instance of <code>UnkownTokenType</code> without detail
     * message.
     */
    public UnknownTokenTypeException() {
    }

    /**
     * Constructs an instance of <code>UnkownTokenType</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public UnknownTokenTypeException(String msg) {
        super(msg);
    }
}
