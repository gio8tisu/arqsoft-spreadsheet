package edu.upc.etsetb.arqsoft.miniexceljc.functions.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.functions.FunctionsRegister;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FunctionsRegisterImpl implements FunctionsRegister {
    private static Set<String> functionNames = new HashSet<>(Arrays.asList("SUMA", "MEAN", "MIN", "MAX"));

    public static FunctionsRegister getInstance(){
        return new FunctionsRegisterImpl();
    }

    public FunctionsRegisterImpl() {
    }

    @Override
    public boolean isRegistered(String funcName) {
        return functionNames.contains(funcName.toUpperCase());
    }
}
