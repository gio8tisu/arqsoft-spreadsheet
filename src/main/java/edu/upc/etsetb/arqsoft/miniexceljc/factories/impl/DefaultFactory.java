package edu.upc.etsetb.arqsoft.miniexceljc.factories.impl;

import edu.upc.etsetb.arqsoft.miniexceljc.client.Client;
import edu.upc.etsetb.arqsoft.miniexceljc.client.text.TextClient;
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
import edu.upc.etsetb.arqsoft.miniexceljc.util.*;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.FormulaVisitor;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.impl.PostFixFormulaVisitor;

import java.util.List;

public class DefaultFactory extends SpreadsheetFactory {
    public DefaultFactory() {
        this.postFixGenerator = this.createPostFixGenerator();
        postFixGenerator.setFactory(this);
        this.coordinateChecker = this.createCoordinateChecker();
    }

    @Override
    public Token createToken(TokenType tokenType, String tokenText) throws UnknownTokenTypeException {
        if (tokenType == null) {
            throw new UnknownTokenTypeException("The object passed as argument, is an unknown token type");
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
    public Operator createOperator(String operator) throws BadArgumentException {
        switch (operator) {
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
    public Operand createFunction(String function) throws BadArgumentException {
        switch (function) {
            case "SUMA":
                return new SumaFunction();
            case "MIN":
                return new MinFunction();
            case "MAX":
                return new MaxFunction();
            case "MEAN":
                return new MeanFunction();
        }
        throw new BadArgumentException("Unknown function.");
    }

    @Override
    public Operand createCellsRange(CoordinateSpec cCoord1, CoordinateSpec cCoord2) {
        return new CellsRange(createCoordinate(cCoord1), createCoordinate(cCoord2));
    }

    @Override
    public Operand createNumber(String value) {
        return new Number(value);
    }

    @Override
    public Operand createExpression(List<ExpressionComponent> expr) {
        return new PostFixExpression(expr);
    }

    @Override
    public FormulaVisitor createFormulaVisitor(Spreadsheet spreadsheet, Coordinate startCoordinate) {
        return new PostFixFormulaVisitor(spreadsheet, startCoordinate);
    }

    @Override
    public Client createClient() {
        return new TextClient();
    }

    public SpreadsheetSaver createSpreadSheetSaver() {
        return new S2VSpreadsheetSaver();
    }

    public SpreadsheetLoader createSpreadSheetLoader(TextContentChecker textContentChecker,
                                                     NumericalContentChecker numericalContentChecker, FormulaContentChecker formulaContentChecker) {
        return new S2VSpreadsheetLoader(this, textContentChecker, numericalContentChecker, formulaContentChecker);
    }

    @Override
    public FunctionsRegister createFunctionsRegister() {
        return new FunctionsRegisterImpl();
    }

    public TextContentChecker createTextContentChecker() {
        return new TextContentChecker();
    }

    public NumericalContentChecker createNumericalContentChecker() {
        return new NumericalContentChecker();
    }

    public FormulaContentChecker createFormulaContentChecker() {
        return new FormulaContentChecker();
    }

    public CoordinateChecker createCoordinateChecker() {
        return new CoordinateChecker();
    }
}
