/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.model.operands;

/**
 * You will have to create the class implements this interface; the list of 
 * methods below incllude all the methods required 
 * by the postfix generator class; it is your job to identify, design, and 
 * code any other method that your complete program may require from this
 * class.
 * 
 * @author Juan Carlos Cruellas
 */
public interface Operator extends ExpressionComponent{
        
    /**
     * Reports whether the operator is the addition (+) operator
     * 
     * @return true if the operator is the addition (+) operator, false otherwise
     */
    public boolean isAdd() ;
    
    /**
     * Reports whether the operator is the substraction (-) operator
     * 
     * @return true if the operator is the addition (-) operator, false otherwise
     */    
    public boolean isSubs() ;
    
    /**
     * Reports whether the operator is the multiplication (*) operator
     * 
     * @return true if the operator is the multiplication (*) operator, false otherwise
     */    
    public boolean isMult() ;
    
    /**
     * Reports whether the operator is the division (/) operator
     * 
     * @return true if the operator is the division (/) operator, false otherwise
     */    
    public boolean isDiv() ;

}
