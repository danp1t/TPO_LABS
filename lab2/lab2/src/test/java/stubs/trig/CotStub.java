package stubs.trig;

import com.danp1t.FunctionInterface;
import java.util.Map;

import static java.util.Map.entry;

public class CotStub implements FunctionInterface {

    private final Map<Double, Double> table = Map.ofEntries(
            entry(1.0, 0.64209),
            entry(-1.0, -0.64209),
            entry(3.141592 / 2, 0.0),
            entry(-3.141592 / 3, -0.57735),
            entry(3.141592 / 4, 1.0),
            entry(-3.141592 / 6, 0.86603),
            entry(3.0, -7.01525),
            entry(5.0, -0.29581),
            entry(10.0, 1.54235)
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
