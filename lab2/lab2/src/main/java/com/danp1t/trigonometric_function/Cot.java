package com.danp1t.trigonometric_function;

public class Cot {
    public static double calculate(double x, double epsilon) {
        return Cos.calculate(x, epsilon) / Sin.calculate(x, epsilon);
    }
}
