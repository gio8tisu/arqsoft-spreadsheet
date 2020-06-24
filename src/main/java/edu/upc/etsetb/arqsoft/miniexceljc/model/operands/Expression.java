/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.model.operands;
import java.util.List;

/**
 * Interface for arithmetic expression; the methods listed are the methods 
 * required by the class that generates the postfix notation; it is your job decide whether 
 * other methods (apart from constructor(s)), shall be needed by the code of 
 * the rest of your program.
 *
 * @author Juan Carlos Cruellas
 */
public interface Expression extends Operand{
    
    /**
     * Returns a list of the components of the expressions (operands and operators)
     * 
     * @return the list of the components of the expression
     */
    public List<ExpressionComponent> getComponents() ;
    
}
