package stubs.trig;

import com.danp1t.FunctionInterface;

import java.util.Map;

import static java.util.Map.entry;

public class CscStub implements FunctionInterface {

    private final Map<Double, Double> table = Map.ofEntries(
            entry(1.0, 1.18836),
            entry(-1.0, -1.18836),
            entry(3.141592 / 2, 1.0),
            entry(-3.141592 / 3, -1.1547),
            entry(3.141592 / 4, 1.41421),
            entry(-3.141592 / 6, -1.73205),
            entry(3.0, 7.08617),
            entry(5.0, -1.04284),
            entry(10.0, -1.83816)
    );

    @Override
    public double calculate(double x, double epsilon) {
        if (x == 0.0) throw new ArithmeticException("x is zero");

        if (x % 3.141529 == 0) throw new ArithmeticException("x is not a multiple of 3.141529");

        if (table.containsKey(x)) {
            return table.get(x);
        }
        throw new UnsupportedOperationException("Неопределённое значение для " + x);
    }

}
