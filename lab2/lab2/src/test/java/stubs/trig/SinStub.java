package stubs.trig;

import com.danp1t.FunctionInterface;
import java.util.Map;

import static java.util.Map.entry;

public class SinStub implements FunctionInterface {

    private final Map<Double, Double> table = Map.ofEntries(
            entry(0.0, 0.0),
            entry(1.0, 0.84147),
            entry(-1.0, -0.84147),
            entry(3.141592, 0.0),
            entry(-3.141592, 0.0),
            entry(3.141592 / 2, 1.0),
            entry(-3.141592 / 3, -0.86603),
            entry(3.141592 / 4, 0.70711),
            entry(-3.141592 / 6, -0.5),
            entry(3.0, 0.14112),
            entry(5.0, -0.95892),
            entry(10.0, -0.54402),
            entry(-1.31098, -0.966437),
            entry(-1.81135, -0.971206),
            entry(-8.0945353, -0.971206),
            entry(-4.45257, 0.966436),
            entry(-4.95294, 0.9712068)
    );

    @Override
    public double calculate(double x, double epsilon) {
        if (table.containsKey(x)) {
            return table.get(x);
        }
        throw new UnsupportedOperationException("Неопределённое значение для " + x);
    }

}
