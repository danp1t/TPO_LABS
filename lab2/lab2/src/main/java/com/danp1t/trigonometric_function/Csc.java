package com.danp1t.trigonometric_function;

public class Csc {
    public static double calculate(double x, double epsilon) {
        return 1 / Sin.calculate(x, epsilon);
    }
}
