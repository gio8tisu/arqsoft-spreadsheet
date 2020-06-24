/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.factories.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Coordinate;
import edu.upc.etsetb.arqsoft.miniexceljc.model.CoordinateSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.Spreadsheet;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.*;
import edu.upc.etsetb.arqsoft.miniexceljc.functions.impl.*;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.*;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.*;
import edu.upc.etsetb.arqsoft.miniexceljc.operands.impl.Number;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.*;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.PostFixGeneratorImpl;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.SyntaxCheckerImpl;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.TokenImpl;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.TokenizerImpl;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.impl.FormulaVisitorImpl;

import java.util.List;

public class DefaultFactory extends SpreadsheetFactory {

    @Override
    public Token createToken(TokenType tokenType, String tokenText) throws UnknownTokenTypeException {
        if (!(tokenType instanceof TokenType)) {
            throw new UnknownTokenTypeException("The object passed as argument, whose class is \'"
                    + tokenType.getClass().getName() + "\' is an unknown token type");
        }
        return TokenImpl.getInstance(tokenType, tokenText);
    }

    @Override
    public Tokenizer createTokenizer() {
        return TokenizerImpl.getInstance();
    }

    @Override
    public SyntaxChecker createSyntaxChecker() {
        return SyntaxCheckerImpl.getInstance();
    }

    @Override
    public PostFixGenerator createPostFixGenerator() {
        return PostFixGeneratorImpl.getInstance();
    }

    @Override
    public Operator createOperator(String opText) throws BadArgumentException {
        switch (opText) {
            case "+":
                return new AddOperator();
            case "-":
                return new SubsOperator();
            case "*":
                return new MultOperator();
            case "/":
                return new DivOperator();
        }
        throw new BadArgumentException("Unknown operator.");
    }

    @Override
    public Operand createFunction(String funcName) throws BadArgumentException {
        switch (funcName) {
            case "SUMA":
                return new SumaFunction();
            case "MIN":
                return new MinFunction();
            case "MAX":
                return new MaxFunction();
            case "PROMEDIO":
                return new PromedioFunction();
        }
        throw new BadArgumentException("Unknown function.");
    }

    @Override
    public Operand createCellsRange(CoordinateSpec cCoord1, CoordinateSpec cCoord2) throws BadArgumentException {
        return new CellsRange(createCoordinate(cCoord1), createCoordinate(cCoord2));
    }

    @Override
    public Operand createNumber(String value) throws BadArgumentException {
        return new Number(value);
    }

    @Override
    public Operand createExpression(List<ExpressionComponent> expr) {
        return new PostFixExpression(expr);
    }

    @Override
    public FormulaVisitor createFormulaVisitor(Spreadsheet spreadsheet, Coordinate startCoordinate) {
        return new FormulaVisitorImpl(spreadsheet, startCoordinate);
    }

    @Override
    public FunctionsRegister createFunctionsRegister() {
        return new FunctionsRegisterImpl();
    }

}
