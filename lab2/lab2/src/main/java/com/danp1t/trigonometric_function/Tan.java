package com.danp1t.trigonometric_function;

import com.danp1t.FunctionInterface;

public class Tan implements FunctionInterface {
    private final FunctionInterface sin;
    private final FunctionInterface cos;

    public Tan(FunctionInterface sin, FunctionInterface cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double calculate(double x, double epsilon) {
        double cosVal =  cos.calculate(x, epsilon);
        if (Math.abs(cosVal) < 1e-12) throw new ArithmeticException("Косинус для тангенса не может равняться нулю");
        return sin.calculate(x, epsilon) / cosVal;
    }
}
