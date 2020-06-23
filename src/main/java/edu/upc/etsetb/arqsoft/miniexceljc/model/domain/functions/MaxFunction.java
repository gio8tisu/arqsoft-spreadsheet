package edu.upc.etsetb.arqsoft.miniexceljc.model.domain.functions;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.NumericalValue;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Value;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.operands.Operand;

import java.util.ArrayList;
import java.util.List;

public class MaxFunction implements Function {
    private List<Operand> elements;

    public MaxFunction() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void addArgument(Operand op) {
        this.elements.add(op);
    }

    @Override
    public String getName() {
        return "MAX";
    }

    @Override
    public Value getValue() {
        double max = ((NumericalValue) this.elements.get(0).getValue()).getValue();
        for (Operand o: this.elements.subList(1, elements.size())) {
            double candidate = ((NumericalValue) o.getValue()).getValue();
            if (max < candidate)
                max = candidate;
        }
        return new NumericalValue(max);
    }
}
