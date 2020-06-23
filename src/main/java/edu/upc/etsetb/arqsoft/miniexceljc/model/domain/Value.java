package edu.upc.etsetb.arqsoft.miniexceljc.model.domain;

public interface Value {

    String toString();

    Value sum(Value v);
    Value subs(Value v);
    Value mult(Value v);
    Value div(Value v);
}
