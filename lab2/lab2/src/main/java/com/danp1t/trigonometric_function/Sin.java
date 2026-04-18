package com.danp1t.trigonometric_function;

public class Sin {
    public static double calculate(double x, double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Погрешность должна быть положительной");
        }

        x = prepareArg(x);

        double sum = 0;
        double an = x;
        int n = 0;

        //a_n = a_(n-1) * x^2 / ((2n)(2n+1))
        while (Math.abs(an) >= epsilon) {
            sum += an;
            n += 1;
            an = -an * x * x / (2*n * (2*n + 1));
        }
        return sum;
    }

    private static double prepareArg(double x) {
        if (x < 0) {
            x = -x;
            x = x % (2 * Math.PI);
            return -x;
        }
        return x % (2 * Math.PI);
    }
}
