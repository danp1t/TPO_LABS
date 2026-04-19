package stubs.log;

import com.danp1t.FunctionInterface;
import java.util.Map;

import static java.util.Map.entry;

public class LnStub implements FunctionInterface {

    private final Map<Double, Double> table = Map.ofEntries(
            entry(1.0, 0.0),
            entry(3.141592, 1.14473),
            entry(3.141592 / 2, 0.45158),
            entry(3.141592 / 4, -0.25156),
            entry(3.0, 1.09861),
            entry(5.0, 1.60944),
            entry(10.0, 2.30259)
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
