package module.trig;

import com.danp1t.trigonometric_function.Cos;
import com.danp1t.trigonometric_function.Sin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CosTest {

    private final Cos cos = new Cos(new Sin());
    private final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1.5707963267948966, 0",
            "3.141592653589793, -1",
            "-1.5707963267948966, 0",
            "1.0471975511965976, 0.5",
            "-1.0471975511965976, 0.5",
    })
    void testBasePoints(double x, double expected) {
        assertEquals(expected, cos.calculate(x, EPS), 1e-9);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 2, 1",
            "1.5707963267948966, 4, 0",
            "3.141592653589793, 2, -1"
    })
    void testPeriodicity(double baseX, int periods, double expected) {
        double x = baseX + periods * 2 * PI;
        assertEquals(expected, cos.calculate(x, EPS), 1e-9);
    }

    @Test
    void testEpsilonNonPositive() {
        assertThrows(IllegalArgumentException.class, () -> cos.calculate(1.0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> cos.calculate(1.0, -1e-10));
    }

}