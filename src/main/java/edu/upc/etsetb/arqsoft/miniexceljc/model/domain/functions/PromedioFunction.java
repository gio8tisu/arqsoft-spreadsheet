package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.functions;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.NumericalValue;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Spreadsheet;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;

import java.util.ArrayList;
import java.util.List;

public class PromedioFunction implements Function {
    private List<Operand> elements;

    public PromedioFunction() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void addArgument(Operand op) {
        this.elements.add(op);
    }

    @Override
    public String getName() {
        return "PROMEDIO";
    }

    @Override
    public List<Value> getValue(Spreadsheet spreadsheet) {
        double sum = 0;
        int numElements = 0;
        for (Operand operand: this.elements) {
            for (Value value: operand.getValue()) {
                sum += ((NumericalValue) value).getNumber();
                numElements++;
            }
        }
        List<Value> res = new ArrayList<>();
        res.add(new NumericalValue(sum / numElements));
        return res;
    }
}
