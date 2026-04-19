package com.danp1t.utils;

import com.danp1t.FunctionInterface;
import com.danp1t.log_function.*;
import com.danp1t.trigonometric_function.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class CsvGenerator {

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java CsvGenerator <function> <start> <end> <step> [epsilon]");
            System.out.println("  function: sin, cos, tan, cot, csc, ln, log2, log3, log5, log10");
            System.out.println("  start, end, step – числовые значения");
            System.out.println("  epsilon – точность (по умолчанию 1e-9)");
            System.out.println("Example: java CsvGenerator sin 0 6.283185 0.1 1e-9");
            System.exit(1);
        }

        String funcName = args[0].toLowerCase();
        double start = Double.parseDouble(args[1]);
        double end = Double.parseDouble(args[2]);
        double step = Double.parseDouble(args[3]);
        double epsilon = args.length >= 5 ? Double.parseDouble(args[4]) : 1e-9;

        FunctionInterface function = buildFunction(funcName);
        if (function == null) {
            System.err.println("Unknown function: " + funcName);
            System.exit(1);
        }

        String fileName = funcName + "_values.csv";
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
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

            System.out.println("CSV файл успешно создан: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка записи файла: " + e.getMessage());
        }
    }

    private static FunctionInterface buildFunction(String name) {
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
            default -> null;
        };
    }
}
