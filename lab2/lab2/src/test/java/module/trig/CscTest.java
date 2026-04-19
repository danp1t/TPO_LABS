package module.trig;

import com.danp1t.trigonometric_function.Csc;
import com.danp1t.trigonometric_function.Sin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CscTest {
    private final Csc csc = new Csc(new Sin());
    private final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
            "1.5707963267948966, 1",   // π/2 → csc=1
            "0.5235987755982988, 2",   // π/6 → csc=2
            "-1.5707963267948966, -1"
    })
    void testBasePoints(double x, double expected) {
        assertEquals(expected, csc.calculate(x, EPS), 1e-9);
    }

    @ParameterizedTest
    @CsvSource({
            "1.5707963267948966, 2, 1",
            "0.5235987755982988, 4, 2"
    })
    void testPeriodicity(double baseX, int periods, double expected) {
        double x = baseX + periods * 2 * PI;
        assertEquals(expected, csc.calculate(x, EPS), 1e-9);
    }

    @Test
    void testSingularities() {
        assertThrows(ArithmeticException.class, () -> csc.calculate(0.0, EPS));
        assertThrows(ArithmeticException.class, () -> csc.calculate(PI, EPS));
        assertThrows(ArithmeticException.class, () -> csc.calculate(2*PI, EPS));
    }
}
