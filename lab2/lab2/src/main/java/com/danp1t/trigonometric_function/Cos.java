package com.danp1t.trigonometric_function;

public class Cos {
    public static double calculate(double x, double epsilon) {
        // cos(x) = sin(PI/2 - x)
        return Sin.calculate(Math.PI / 2 - x, epsilon);
    }
}
