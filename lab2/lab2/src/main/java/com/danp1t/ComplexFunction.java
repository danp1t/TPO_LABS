package com.danp1t;

public class ComplexFunction implements FunctionInterface {
    private final FunctionInterface sin, cos, csc, tan, cot;
    private final FunctionInterface ln, log2, log3, log5, log10;

    public ComplexFunction(
            FunctionInterface sin, FunctionInterface cos, FunctionInterface csc,
            FunctionInterface tan, FunctionInterface cot,
            FunctionInterface ln, FunctionInterface log2, FunctionInterface log3,
            FunctionInterface log5, FunctionInterface log10) {
        this.sin = sin;
        this.cos = cos;
        this.csc = csc;
        this.tan = tan;
        this.cot = cot;
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    @Override
    public double calculate(double x, double epsilon) {
        if (x <= 0) {
            return calculateTrigonometric(x, epsilon);
        } else {
            return calculateLogarithmic(x, epsilon);
        }
    }

    private double calculateTrigonometric(double x, double epsilon) {
        double s = sin.calculate(x, epsilon);
        double c = cos.calculate(x, epsilon);
        double cscVal = csc.calculate(x, epsilon);
        double t = tan.calculate(x, epsilon);
        double cotVal = cot.calculate(x, epsilon);

        double step1 = s - c;
        double step2 = step1 - cscVal;
        double step3 = step2 * cscVal;
        double step4 = step3 / cscVal;
        double step5 = step4 + c;
        double step6 = step5 / (Math.pow(cscVal, 3) + cscVal);
        double step7 = Math.pow(step6, 2);
        double step8 = Math.pow(step7, 2);
        double step9 = step8 - cscVal*cscVal;
        double step10 = step9 * step9 * step9;
        double step11 = step10 * step10 * step10;
        double firstPart = step11 * step11 * step11;

        double sin3 = s * s * s;
        double tanMinusCot = t - cotVal;
        double innerDiv = tanMinusCot / s;
        double stepA = sin3 - innerDiv;
        double stepB = stepA + c;
        double stepC = stepB * stepB;
        double stepD = stepC + t * t * t;
        double secondPart = s * stepD;

        return firstPart * secondPart;
    }

    private double calculateLogarithmic(double x, double epsilon) {
        double lnVal = ln.calculate(x, epsilon);
        double log2Val = log2.calculate(x, epsilon);
        double log3Val = log3.calculate(x, epsilon);
        double log5Val = log5.calculate(x, epsilon);
        double log10Val = log10.calculate(x, epsilon);

        // Выражение: ((((log3^2)^3) / (log10 + log5)) / log3) + ((log2 * (log2 / (ln - log10)))^3)
        double log3Pow2 = log3Val*log3Val;
        double log3Pow6 = log3Pow2 * log3Pow2 * log3Pow2;
        double denominator1 = log10Val + log5Val;
        double step1 = log3Pow6 / denominator1;
        double firstPart = step1 / log3Val;

        double lnMinusLog10 = lnVal - log10Val;
        double inner = log2Val / lnMinusLog10;
        double product = log2Val * inner;
        double secondPart = product * product * product;

        return firstPart + secondPart;
    }
}

