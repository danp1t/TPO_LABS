package com.danp1t.trigonometric_function;

public class Tan {
    public static double calculate(double x, double epsilon) {
        return Sin.calculate(x, epsilon) / Cos.calculate(x, epsilon);
    }
}
