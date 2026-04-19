package module.log;

import com.danp1t.log_function.Ln;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LnTest {
    private final Ln ln = new Ln();
    private final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2.718281828459045, 1",
            "2, 0.6931471805599453",
            "3, 1.0986122886681098",
            "5, 1.6094379124341003",
            "10, 2.302585092994046"
    })
    void testStandardValues(double x, double expected) {
        assertEquals(expected, ln.calculate(x, EPS), 1e-9);
    }

    @Test
    void testEpsilonNonPositive() {
        assertThrows(IllegalArgumentException.class, () -> ln.calculate(1.0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> ln.calculate(1.0, -1e-10));
    }

    @Test
    void testXNonPositive() {
        assertThrows(IllegalArgumentException.class, () -> ln.calculate(0.0, EPS));
        assertThrows(IllegalArgumentException.class, () -> ln.calculate(-1.0, EPS));
    }
}
