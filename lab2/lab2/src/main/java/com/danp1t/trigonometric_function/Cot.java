package com.danp1t.trigonometric_function;

public class Cot {
    public static double calculate(double x, double epsilon) {
        double sin =  Sin.calculate(x, epsilon);
        if (sin == 0) throw new ArithmeticException("Синус для котангенса не может равняться нулю");
        return Cos.calculate(x, epsilon) / sin;
    }
}
