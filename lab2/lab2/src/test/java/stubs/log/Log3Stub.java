package stubs.log;

import com.danp1t.FunctionInterface;

import java.util.Map;
import static java.util.Map.entry;

public class Log3Stub implements FunctionInterface {

    private final Map<Double, Double> table = Map.ofEntries(
            entry(1.0, 0.0),
            entry(3.141592, 1.0412),
            entry(3.141592 / 2, 0.41105),
            entry(3.141592 / 4, -0.21988),
            entry(3.0, 1.0),
            entry(5.0, 1.46497),
            entry(10.0, 2.0959)
    );

    @Override
    public double calculate(double x, double epsilon) {
        if (x <= 0) throw new ArithmeticException("Аргумент для вычисления логарифма должен быть больше 0");

        if (table.containsKey(x)) {
            return table.get(x);
        }
        throw new UnsupportedOperationException("Неопределённое значение для " + x);
    }

}
