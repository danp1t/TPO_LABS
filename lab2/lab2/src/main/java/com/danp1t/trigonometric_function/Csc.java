package com.danp1t.trigonometric_function;

public class Csc {
    public static double calculate(double x, double epsilon) {
        double sin =  Sin.calculate(x, epsilon);
        if (sin == 0) throw new ArithmeticException("Синус для косеканса не может равняться нулю");
        return 1 / sin;
    }
}
