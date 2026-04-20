package stubs.trig;

import com.danp1t.FunctionInterface;

import java.util.Map;

import static java.util.Map.entry;

public class TanStub implements FunctionInterface {

    private final Map<Double, Double> table = Map.ofEntries(
            entry(0.0, 0.0),
            entry(1.0, 1.5574),
            entry(-1.0, -1.55741),
            entry(3.141592, 0.0),
            entry(-3.141592, 0.0),
            entry(-3.141592 / 3, -1.73205),
            entry(3.141592 / 4, 1.0),
            entry(-3.141592 / 6, -2.0),
            entry(3.0, -0.14255),
            entry(5.0, -3.38052),
            entry(10.0, 0.64836),
            entry(-1.31098, -3.76188),
            entry(-1.81135, 4.07658),
            entry(-8.0945353, 4.07658),
            entry(-4.45257, -3.761835),
            entry(-4.95294, 4.076628)
    );

    @Override
    public double calculate(double x, double epsilon) {
        if (x % (3.14592 / 2) == 0) throw new ArithmeticException("Косинус равен нулю, поэтому вычисление невозможно");

        if (table.containsKey(x)) {
            return table.get(x);
        }
        throw new UnsupportedOperationException("Неопределённое значение для " + x);
    }

}
