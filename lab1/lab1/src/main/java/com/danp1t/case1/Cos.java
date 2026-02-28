package com.danp1t.case1;

public class Cos {
    public static final double PI = 3.1415926535;

    public static Double calculate(Double x) {
        if (x.isInfinite()) {
            throw new ArithmeticException("The number is infinite");
        }

        if (x < 0) {
            x = -x;
        }

        if (x > 2*PI) {
            x = x % (2*PI);
        }

        var factorials = new Double[129];
        factorials[0] = 1.0;

        for (int i = 1; i <= 128; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        var y = 0.0;
        for (int n = 0; n < 64; n++) {
            y += Math.pow(-1, n) * Math.pow(x, 2*n) / factorials[2*n];
        }
        return y;
    }
}
