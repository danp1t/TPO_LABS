package module.trig;

import com.danp1t.trigonometric_function.Sin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.PI;

class SinTest {

    private final Sin sin = new Sin();
    private final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
            "0.0,               0.0",
            "1.57079632679,     1.0",
            "-1.57079632679,   -1.0",
            "3.14159265359,     0.0",
            "-3.14159265359,    0.0",
            "-0.52359877559,   -0.5",
            "6.28318530718,     0.0"
    })
    void testBasePoints(double x, double expected) {
        assertEquals(expected, sin.calculate(x, EPS), 1e-5);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0,       4, 0.0",
            "1.5708,    6, 1.0",
            "-1.5708,   10, -1.0",
            "3.1416,    12, 0.0",
            "-3.1416,   14, 0.0",
            "-0.5236,   18, -0.5"
    })
    void testPeriod(double baseX, int periods, double expected) {
        double x = baseX + periods * PI;
        assertEquals(expected, sin.calculate(x, EPS), 1e-5);
    }

    @Test
    void testSinLargeArgument() {
        assertEquals(0.0, sin.calculate(100 * PI, EPS), 1e-5);
    }

    @Test
    void testEpsilonNonPositive() {
        assertThrows(IllegalArgumentException.class, () -> sin.calculate(1.0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> sin.calculate(1.0, -1e-10));
    }
}