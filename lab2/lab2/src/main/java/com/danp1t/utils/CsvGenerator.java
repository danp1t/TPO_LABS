package com.danp1t.utils;

import com.danp1t.ComplexFunction;
import com.danp1t.FunctionInterface;
import com.danp1t.log_function.*;
import com.danp1t.trigonometric_function.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import java.util.Locale;

public class CsvGenerator {

    public static void main(String[] args) throws FileNotFoundException {
        String funcName = args[0].toLowerCase();
        double start = Double.parseDouble(args[1]);
        double end = Double.parseDouble(args[2]);
        double step = Double.parseDouble(args[3]);
        double epsilon = Double.parseDouble(args[4]);

        FunctionInterface function = buildFunction(funcName);

        String fileName = funcName + "_values.csv";
        PrintWriter pw = new PrintWriter(fileName);
        generateCsv(funcName, start, end, step, epsilon, function, pw);
        System.out.println("CSV файл успешно создан: " + fileName);
    }

    public static void generateCsv(String funcName, double start, double end, double step,
                                   double epsilon, FunctionInterface function, Writer writer) {
        try (PrintWriter pw = (writer instanceof PrintWriter) ? (PrintWriter) writer : new PrintWriter(writer)) {
            pw.println("X; " + funcName.toUpperCase() + "(X)");

            for (double x = start; x <= end + step / 2; x += step) {
                double y;
                try {
                    y = function.calculate(x, epsilon);
                } catch (ArithmeticException e) {
                    y = Double.NaN;
                }
                pw.printf(Locale.US, "%.5f; %.5f%n", x, y);
            }
        }
    }

    public static FunctionInterface buildFunction(String name) {
        FunctionInterface realSin = new Sin();
        FunctionInterface realCos = new Cos(realSin);
        FunctionInterface realLn = new Ln();

        return switch (name) {
            case "sin" -> realSin;
            case "cos" -> realCos;
            case "tan" -> new Tan(realSin, realCos);
            case "cot" -> new Cot(realSin, realCos);
            case "csc" -> new Csc(realSin);
            case "ln" -> realLn;
            case "log2" -> new Log2(realLn);
            case "log3" -> new Log3(realLn);
            case "log5" -> new Log5(realLn);
            case "log10" -> new Log10(realLn);
            case "666" -> new ComplexFunction(
                    realSin, realCos, new Csc(realSin),
                    new Tan(realSin, realCos), new Cot(realSin, realCos),
                    realLn, new Log2(realLn), new Log3(realLn),
                    new Log5(realLn), new Log10(realLn)
            );
            default -> null;
        };
    }
}