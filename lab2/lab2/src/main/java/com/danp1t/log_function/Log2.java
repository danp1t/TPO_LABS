package com.danp1t.log_function;

public class Log2 {
    public static double calculate(double x, double epsilon) {
        return Ln.calculate(x, epsilon) / Ln.calculate(2, epsilon);
    }
}
