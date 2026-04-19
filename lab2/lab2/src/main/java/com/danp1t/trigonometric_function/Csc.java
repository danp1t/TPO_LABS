package com.danp1t.trigonometric_function;

import com.danp1t.FunctionInterface;

public class Csc implements FunctionInterface {
    private final FunctionInterface sin;

    public Csc(FunctionInterface sin) {
        this.sin = sin;
    }

    @Override
    public double calculate(double x, double epsilon) {
        double sinVal =  sin.calculate(x, epsilon);
        if (Math.abs(sinVal) < 1e-12) throw new ArithmeticException("Синус для косеканса не может равняться нулю");
        return 1 / sinVal;
    }
}
