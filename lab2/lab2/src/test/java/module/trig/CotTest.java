package module.trig;

import com.danp1t.trigonometric_function.Cos;
import com.danp1t.trigonometric_function.Cot;
import com.danp1t.trigonometric_function.Sin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CotTest {
    private final Cot cot = new Cot(new Sin(), new Cos(new Sin()));
    private final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
            "0.7853981633974483, 1",
            "1.5707963267948966, 0",
            "0.5235987755982988, 1.7320508075688772"
    })
    void testBasePoints(double x, double expected) {
        assertEquals(expected, cot.calculate(x, EPS), 1e-9);
    }

    @ParameterizedTest
    @CsvSource({
            "0.7853981633974483, 1, 1",
            "1.5707963267948966, 2, 0"
    })
    void testPeriodicity(double baseX, int periods, double expected) {
        double x = baseX + periods * PI;
        assertEquals(expected, cot.calculate(x, EPS), 1e-9);
    }

    @Test
    void testSingularities() {
        assertThrows(ArithmeticException.class, () -> cot.calculate(0.0, EPS));
        assertThrows(ArithmeticException.class, () -> cot.calculate(PI, EPS));
    }
}
