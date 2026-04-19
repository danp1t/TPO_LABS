package com.danp1t.log_function;

import com.danp1t.FunctionInterface;

public class Log3 implements FunctionInterface {
    private final FunctionInterface ln;

    public Log3(FunctionInterface ln) {
        this.ln = ln;
    }

    @Override
    public double calculate(double x, double epsilon) {
        return ln.calculate(x, epsilon) / ln.calculate(3, epsilon);
    }
}
