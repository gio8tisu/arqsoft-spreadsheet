/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.factories.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.functions.FunctionsRegister;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.BadArgumentException;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.ExpressionComponent;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operator;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.*;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.PostFixGeneratorImpl;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.SyntaxCheckerImpl;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.TokenImpl;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.impl.TokenizerImpl;

import java.util.List;

public class DefaultFactory extends SpreadsheetFactory {

    @Override
    public Token createToken(TokenType tokenType, String tokenText) throws UnknownTokenTypeException {
        if (!(tokenType instanceof TokenType)) {
            throw new UnknownTokenTypeException("The object passed as argument, whose class is \'"
                    + tokenType.getClass().getName() + "\' is an unknown token type");
        }
        return (Token) TokenImpl.getInstance((TokenType) tokenType, tokenText);
    }

    @Override
    public Tokenizer createTokenizer() {
        return (Tokenizer) TokenizerImpl.getInstance();
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
        throw new UnsupportedOperationException("createOperator() not supported yet.");
    }

    @Override
    public Operand createFunction(String funcName)
            throws BadArgumentException {
        throw new UnsupportedOperationException("createFunction() not supported yet.");
    }

    @Override
    public Operand createCellCoordinate(String cellCoord)
            throws BadArgumentException {
        throw new UnsupportedOperationException("createCellCoordinate() not supported yet.");
    }

    @Override
    public Operand createCellsRange(String cCoord1, String cCoord2)
            throws BadArgumentException {
        throw new UnsupportedOperationException("createCellsRange() not supported yet.");
    }

    @Override
    public Operand createNumber(String value) throws BadArgumentException {
        throw new UnsupportedOperationException("createNumber() not supported yet.");
    }

    @Override
    public Operand createExpression(List<ExpressionComponent> expr) {
        throw new UnsupportedOperationException("createExpression() not supported yet.");
    }

    @Override
    public FunctionsRegister createFunctionsRegister() {
        throw new UnsupportedOperationException("createFunctionsRegister() not supported yet.");
    }

}
