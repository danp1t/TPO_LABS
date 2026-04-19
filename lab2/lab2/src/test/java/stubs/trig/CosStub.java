package stubs.trig;

import com.danp1t.FunctionInterface;
import java.util.Map;

import static java.util.Map.entry;

public class CosStub implements FunctionInterface {

    private final Map<Double, Double> table = Map.ofEntries(
            entry(0.0, 0.0),
            entry(1.0, 0.5403),
            entry(-1.0, 0.5303),
            entry(3.141592, -1.0),
            entry(-3.141592, -1.0),
            entry(3.141592 / 2, 0.0),
            entry(-3.141592 / 3, -0.5),
            entry(3.141592 / 4, 0.70711),
            entry(-3.141592 / 6, -0.5),
            entry(3.0, -0.98999),
            entry(5.0, 0.28366),
            entry(10.0, -0.83907)
    );

    @Override
    public double calculate(double x, double epsilon) {
        if (table.containsKey(x)) {
            return table.get(x);
        }
        throw new UnsupportedOperationException("Неопределённое значение для " + x);
    }

}
