package edu.upc.etsetb.arqsoft.miniexceljc.visitors;

public class CircularReferenceException extends Exception {
    public CircularReferenceException(String message) {
        super(message);
    }
}
