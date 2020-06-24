/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.operands;

/**
 * Empty interface for grouping all the classes whose objects may be an 
 * operand (a number, a cell coordinate, a function, etc), under the same umbrella; 
 * in this way, whenever an operand may appear in your code, you can use this interface instead 
 * any of the different types of operands
 * 
 * @author Juan Carlos Cruellas
 */
public interface Operand extends ExpressionComponent{
}
