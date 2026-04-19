package module.trig;

import com.danp1t.trigonometric_function.Cos;
import com.danp1t.trigonometric_function.Sin;
import com.danp1t.trigonometric_function.Tan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TanTest {
    private final Tan tan = new Tan(new Sin(), new Cos(new Sin()));
    private final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "0.7853981633974483, 1",
            "-0.7853981633974483, -1",
            "1.0471975511965976, 1.7320508075688772"
    })
    void testBasePoints(double x, double expected) {
        assertEquals(expected, tan.calculate(x, EPS), 1e-9);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1, 0",
            "0.7853981633974483, 2, 1",
            "-0.7853981633974483, 3, -1"
    })
    void testPeriodicity(double baseX, int periods, double expected) {
        double x = baseX + periods * PI;
        assertEquals(expected, tan.calculate(x, EPS), 1e-9);
    }

    @Test
    void testSingularity() {
        assertThrows(ArithmeticException.class, () -> tan.calculate(PI/2, EPS));
    }
}
