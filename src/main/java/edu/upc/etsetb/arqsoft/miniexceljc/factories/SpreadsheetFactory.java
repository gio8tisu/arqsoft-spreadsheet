/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.factories;

import edu.upc.etsetb.arqsoft.miniexceljc.client.Client;
import edu.upc.etsetb.arqsoft.miniexceljc.factories.impl.DefaultFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.*;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.FunctionsRegister;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.*;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.Number;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.PostFixExpression;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.*;
import edu.upc.etsetb.arqsoft.miniexceljc.util.*;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;

import java.text.Normalizer;
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

    protected PostFixGenerator postFixGenerator;

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
            throw new UnkownFactoryException("Unknown factory code '" + which + "'.");
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

    public Operand createCellsRange(String cCoord1, String cCoord2) throws BadArgumentException {
        String col1 = cCoord1.substring(0, 1);
        int row1 = Integer.parseInt(cCoord1.substring(1));
        CoordinateSpec spec1 = new CoordinateSpec(row1, col1);
        String col2 = cCoord2.substring(0, 1);
        int row2 = Integer.parseInt(cCoord2.substring(1));
        CoordinateSpec spec2 = new CoordinateSpec(row2, col2);

        return createCellsRange(spec1, spec2);
    }

    public abstract Operand createCellsRange(CoordinateSpec cCoord1, CoordinateSpec cCoord2) throws BadArgumentException;

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

    public Content createContent(ContentSpec spec) throws ExpressionException {
        Content content;
        switch (spec.getType()) {
            case TEXT:
                content = new TextContent(spec.getContent());
                break;
            case FORMULA:
                postFixGenerator.generateFromString(spec.getContent().substring(1));
                Expression expr = (Expression) this.createExpression(postFixGenerator.getResultQueue());
                content = new FormulaContent(spec.getContent());
                ((FormulaContent) content).setExpression(expr);
                break;
            case NUMERICAL:
                content = new NumericalContent(spec.getContent());
                break;
            default:
                throw new UnsupportedOperationException("Unknown cell type");
        }
        return content;
    }

    abstract public FormulaVisitor createFormulaVisitor(Spreadsheet spreadsheet, Coordinate startCoordinate);

    public abstract Client createClient();

    public Spreadsheet createSpreadSheet() {
        return new Spreadsheet();
    }

    public Operand createCellCoordinate(String c) {
        String col = c.substring(0, 1);
        int row = Integer.parseInt(c.substring(1));
        CoordinateSpec spec = new CoordinateSpec(row, col);
        return createCoordinate(spec);
    }

    public Coordinate createCoordinate(CoordinateSpec spec){
        return new Coordinate(spec.getRow(), spec.getColumn());
    }

    public Cell createCell(Content content) {
        return new Cell(content);
    }

    abstract public SpreadsheetSaver createSpreadSheetSaver();

    abstract public SpreadsheetLoader createSpreadSheetLoader(
            TextContentChecker textContentChecker, NumericalContentChecker numericalContentChecker);

    abstract public InputChecker createTextContentChecker();

    abstract public InputChecker createNumericalContentChecker();

    abstract public InputChecker createFormulaContentChecker();

    abstract public InputChecker createCoordinateChecker();
}
