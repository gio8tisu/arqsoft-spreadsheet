/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.functions;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;

/**
 *
 * <b>VERY IMPORTANT:</b> This interface includes the set of methods that are invoked by the PostfixGenerator 
 * implementation that is given; function objects will need to incorporate other 
 * methods for properly running the spreadsheet program, and it is your job to 
 * identify, design, and code them.
 * 
 * @author Juan Carlos Cruellas
 */
public interface Function extends Operand {
    
    public void addArgument(Operand op) ;

    public String getName() ;

}
