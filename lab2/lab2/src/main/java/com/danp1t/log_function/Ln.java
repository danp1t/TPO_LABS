package com.danp1t.log_function;

public class Ln {
    public static double calculate(double x, double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Погрешность должна быть положительной");
        }

        if (x <= 0) {
            throw new IllegalArgumentException("Аргумент x должен быть больше нуля для функции ln(x)");
        }

        double y = (x - 1) / (x + 1);
        double sum = 0;
        double an = y;
        double n = 0;

        while (Math.abs(an) > epsilon / 2) {
            sum = sum + an / (2 * n + 1);
            n = n + 1;
            an = an * y*y;
        }

        return sum * 2;
    }
}
