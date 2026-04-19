package com.danp1t.trigonometric_function;

import com.danp1t.FunctionInterface;

public class Cot implements FunctionInterface {
    private final FunctionInterface sin;
    private final FunctionInterface cos;

    public Cot(FunctionInterface sin, FunctionInterface cos) {
        this.sin = sin;
        this.cos = cos;
    }

    @Override
    public double calculate(double x, double epsilon) {

        double sinVal =  sin.calculate(x, epsilon);
        if (Math.abs(sinVal) < 1e-12) throw new ArithmeticException("Синус для котангенса не может равняться нулю");
        return cos.calculate(x, epsilon) / sinVal;
    }
}
