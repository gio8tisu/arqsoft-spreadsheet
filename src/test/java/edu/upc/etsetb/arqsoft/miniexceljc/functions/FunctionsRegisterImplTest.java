package edu.upc.etsetb.arqsoft.miniexceljc.functions;

import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.FunctionsRegisterImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionsRegisterImplTest {
    @Test
    public void testExistingFunctions() {
        FunctionsRegister functionsRegister = new FunctionsRegisterImpl();
        assertTrue(functionsRegister.isRegistered("SUMA"));
        assertTrue(functionsRegister.isRegistered("MEAN"));
        assertTrue(functionsRegister.isRegistered("MIN"));
        assertTrue(functionsRegister.isRegistered("MAX"));
    }

    @Test
    public void testNonExistingFunctions() {
        FunctionsRegister functionsRegister = new FunctionsRegisterImpl();
        assertFalse(functionsRegister.isRegistered("SUM"));
        assertFalse(functionsRegister.isRegistered("PROMEDIO"));
    }

}
