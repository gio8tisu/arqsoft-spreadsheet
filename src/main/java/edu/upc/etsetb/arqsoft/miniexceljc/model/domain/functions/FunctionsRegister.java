/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.functions;

/**
 * The class implementing this interface shall record the names of the functions 
 * already implemented, so that while processing an expression the program may 
 * identify the usage of a non-implemented function and raise an error; it is 
 * your job to decide whether other methods (including constructor) shall 
 * be needed for completing your program.
 *
 * @author Juan Carlos Cruellas
 */
public interface FunctionsRegister{

/**
 * Reports whether a certain function name is registered as a function 
 * implemented in the program.
 * 
 * @param funcName the name of the function
 * @return true if the name is registered, false otherwise
 */    
    public boolean isRegistered(String funcName) ;
}
