package edu.upc.etsetb.arqsoft.miniexceljc.model.operands;

import edu.upc.etsetb.arqsoft.miniexceljc.postfix.SyntaxException;

/**
 *
 * @author Juan Carlos Cruellas
 */
public class BadArgumentException extends SyntaxException {

    /**
     * Creates a new instance of <code>BadArgumentException</code> without
     * detail message.
     */
    public BadArgumentException() {
    }

    /**
     * Constructs an instance of <code>BadArgumentException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BadArgumentException(String msg) {
        super(msg);
    }
}
