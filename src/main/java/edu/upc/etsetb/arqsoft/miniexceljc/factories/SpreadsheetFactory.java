/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.factories;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.impl.DefaultFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.*;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.*;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.functions.FunctionsRegister;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.BadArgumentException;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.ExpressionComponent;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operator;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.*;
import edu.upc.etsetb.arqsoft.miniexceljc.util.*;

import java.util.List;

/**
 * <p><b>IMPORTANT NOTE: THE USAGE OF THE CLASESS PRESENT WITHIN THIS MODULE IS COMPLETELY OPTIONAL.</b></p>
 * <p>The abstract factory class of the Abstract Factory Design Pattern; if 
 * you do not want to use the default factory delivered in this package, you will
 * have to modify the method getInstance for allowing to return YOUR concrete
 * factory and SUPPRESSING the return of DefaultFactory; when you do that, you
 * will have to remove the import of the DefaultFactory; the list of methods 
 * present in this class is the set of factory methods used by the classes that 
 * generate a postfix notation from an arithmetic expression passed in a string; 
 * it is your job to decide whether other factory methods are required by the rest 
 * of the program.</p>
 * 
 * <p><b>IMPORTANT WARNING 1:</b> Using these classes will have a penalty in the
 * final mark of the program, as detailed below:</p>
 * <ul>
 * <li>Using createToken(),
 * {@link edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.TokenImpl},
 * createTokenizer() and
 * {@link edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.TokenizerImpl} shall
 * substract 0,15 points to the final mark.</li></p
 <p></p>
 * <li>Using createSyntaxChecker(), and
 * {@link edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.SyntaxCheckerImpl}
 * shall substract 0,30 points to the final mark.</li>
 <p></p>
 * <li>Using createPostFixGenerator(), and
 * {@link edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.PostFixGeneratorImpl}
 * shall substract 0,55 points to the final mark.</li>
 * </ul>
* <p></p>
 
 * * <b>IMPORTANT WARNING 2:</b> In the Test packages of the maven project 
 * you will find some programs that run 
 * {@link edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.TokenizerImpl},
 * {@link edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.SyntaxCheckerImpl}, and  
 * {@link edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.PostFixGeneratorImpl}.
 * <b>You can run TokenizerIntTest and SyntaxChecerIntTesting without
 * adding anything to the code; however, PostFixGeneratorIntTesting shall require that 
 * you implement all the classes and methods listed in the documentation of 
 *
 *
 * @author Juan Carlos Cruellas
 */
public abstract class SpreadsheetFactory {
    
    /**
     * Static method for creating and returning a concrete factory implemented by a 
     * subclass of SpreadsheetFactory.
     * 
     * @param which string identifying the concrete factory to create. 
     * @return the concrete factory; note that if you do not modify the code of 
     * this method, and you pass the string "DEFAULT" as argument, it will 
     * create and return an instance of the partially implemented default factory 
     * You are free of building your own concrete factory for creating any object
     * that your program requires
     * @throws UnkownFactoryException in case the argument does not properly 
     * identify any concrete factory.
     */
    public static SpreadsheetFactory getInstance(String which) throws UnkownFactoryException {
        if (which.toUpperCase().equals("DEFAULT")) {
            return new DefaultFactory();
        } else {
            throw new UnkownFactoryException("Unknown factory code \'" + which + "\'.");
        }
    }

    /**
     * Factory method for creating a new Token object.
     *
     * @param tokenType an object identifying the type of the token. The
     * specific object shall be implementation-dependent, and its
     * class/enumerated type shall be declared as implementing the TokenType
     * interface
     *
     * @param tokenText the text of the token
     *
     * @return the Token object. Its specific class will depend on the
     * implementation
     *
     * @throws UnknownTokenTypeException if the object passed as first argument
     * does not correspond to any token as per implementation
     */
    public abstract Token createToken(TokenType tokenType, String tokenText)
            throws UnknownTokenTypeException;

    /**
     * Factory method for creating a new Tokenizer
     *
     * @return the Tokenizer object
     */
    public abstract Tokenizer createTokenizer();

    /**
     * Factory method for creating a new SyntaxChecker
     *
     * @return the SyntaxChecker object
     */
    public abstract SyntaxChecker createSyntaxChecker();
    
    /**
     * Factory method for creating the object FunctionsRegister
     * 
     * @return the FunctionsRegister object
     */
    public abstract FunctionsRegister createFunctionsRegister() ;

    /**
     * Factory method for creating a new PostFixGenerator
     *
     * @return the PostFixGenerator object
     */
    public abstract PostFixGenerator createPostFixGenerator();

    /**
     * Factory method for creating a new Operator.
     *
     * @param opText the operator text ("+", "/", "*", "-"
     * @return the created operator object
     */
    public abstract Operator createOperator(String opText) throws BadArgumentException;
    
    /**
     * Creates the object of one of the subclasses of Function corresponding to
     * the name passed as argument to the method.
     *
     * @param funcName the function name
     * @return the Function object
     * @throws BadArgumentException if there is a problem for creating the
     * object corresponding to the specific function
     */
    public abstract Operand createFunction(String funcName)
            throws BadArgumentException;

    /**
     * Creates a Cell coordinate object, whose value is the String passed as 
     * argument to the method, "A12" for instance.
     * 
     * @param cellCoord the coordinate of the cell
     * @return the object of class CellCoordinate
     * 
     * @throws BadArgumentException if the String is not a correct cell coordinate
     */
    public abstract Operand createCellCoordinate(String cellCoord) throws BadArgumentException;

    /**
     * Creates a Range object.
     * 
     * @param range a string representing the range
     * @return the Range object created
     * 
     * @throws BadArgumentException if the string passed as argument does not 
     * correspond to any cells range.
     */
    /**
     * Creates a Range object.
     * @param cCoord1 the cell coordinate of the first limit of the range
     * @param cCoord2 the cell coordinate of the second limit of the range
     * @return the Range object created
     * @throws BadArgumentException if some of the strings passed as argument does not 
     * correspond to a cell coordinate.
     */
    public abstract Operand createCellsRange(String cCoord1, String cCoord2) throws BadArgumentException;

    /**
     * Creates a number operand whose value is the numeric value represented by the 
     * string passed as argument
     * 
     * @param value the textual representation of the value of the number
     * @return the object number
     * 
     * @throws BadArgumentException if the string passed does not represent any 
     * number
     */
    public abstract Operand createNumber(String value) throws BadArgumentException ;
    
    /**
     * Creates an expression of operands and operators (expression components).
     * 
     * @param expr the list of operands and operators (expression components) that
     * represent the expression.
     * 
     * @return the expression object 
     */
    public abstract Operand createExpression(List<ExpressionComponent> expr)  ;

    public Content createContent(ContentSpec spec) {
        if (spec.getType() == CellType.TEXT) {
            return new TextContent(spec.getContent());
        } else if (spec.getType() == CellType.FORMULA) {
            throw new UnsupportedOperationException("Cannot create formula content");
        } else if (spec.getType() == CellType.NUMERICAL) {
            // Assume numerical content.
            return new NumericalContent(Float.parseFloat(spec.getContent()));
        }
        throw new UnsupportedOperationException("Unknown cell type");
    }

    public Spreadsheet createSpreadSheet() {
        return new Spreadsheet();
    }

    public Coordinate createCoordinate(CoordinateSpec spec){
        return new Coordinate(spec.getRow(), spec.getColumn());
    }

    public SpreadSheetCoordinate createSpreadsheetCoordinate(CoordinateSpec spec, Spreadsheet spreadsheet){
        return new SpreadSheetCoordinate(spec.getRow(), spec.getColumn(), spreadsheet);
    }

    public Cell createCell(Content content) {
        return new Cell(content);
    }

    public SpreadsheetLoader createSpreadSheetLoader(TextContentChecker textContentChecker,
                                                     NumericalContentChecker numericalContentChecker) {
        return new S2VSpreadsheetLoader(this, textContentChecker, numericalContentChecker);
    }

    public SpreadsheetSaver createSpreadSheetSaver() {
        return new S2VSpreadsheetSaver();
    }
}
