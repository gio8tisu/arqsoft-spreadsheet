package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.functions;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.NumericalValue;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;

import java.util.ArrayList;
import java.util.List;

public class MinFunction implements Function {
    private List<Operand> elements;

    public MinFunction() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void addArgument(Operand op) {
        this.elements.add(op);
    }

    @Override
    public String getName() {
        return "MIN";
    }

    @Override
    public Value getValue() {
        double min = ((NumericalValue) this.elements.get(0).getValue()).getValue();
        for (Operand o: this.elements.subList(1, elements.size())) {
            double candidate = ((NumericalValue) o.getValue()).getValue();
            if (min > candidate)
                min = candidate;
        }
        return new NumericalValue(min);
    }
}
