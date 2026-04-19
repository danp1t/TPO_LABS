package com.danp1t.trigonometric_function;

import com.danp1t.FunctionInterface;

public class Cos implements FunctionInterface {
    private final FunctionInterface sin;

    public Cos(FunctionInterface sin) {
        this.sin = sin;
    }

    @Override
    public double calculate(double x, double epsilon) {
        // cos(x) = sin(PI/2 - x)
        return sin.calculate(Math.PI / 2 - x, epsilon);
    }
}
