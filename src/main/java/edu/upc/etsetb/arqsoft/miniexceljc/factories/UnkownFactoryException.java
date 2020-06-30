/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.factories;

/**
 *
 * @author Juan Carlos Cruellas
 */
public class UnkownFactoryException extends Exception {

    /**
     * Creates a new instance of <code>UnkownFactoryException</code> without
     * detail message.
     */
    public UnkownFactoryException() {
    }

    /**
     * Constructs an instance of <code>UnkownFactoryException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UnkownFactoryException(String msg) {
        super(msg);
    }
}
