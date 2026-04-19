package com.danp1t.trigonometric_function;

public class Tan {
    public static double calculate(double x, double epsilon) {
        double cos =  Cos.calculate(x, epsilon);
        if (cos == 0) throw new ArithmeticException("Косинус для тангенса не может равняться нулю");
        return Sin.calculate(x, epsilon) / cos;
    }
}
