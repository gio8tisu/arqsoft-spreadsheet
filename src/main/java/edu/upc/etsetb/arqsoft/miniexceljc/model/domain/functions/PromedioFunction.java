package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.functions;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.NumericalValue;
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
    public NumericalValue getValue() {
        double result = 0;
        for (Operand o: this.elements) {
            result += ((NumericalValue) o.getValue()).getValue();
        }
        return new NumericalValue(result / this.elements.size());
    }
}
