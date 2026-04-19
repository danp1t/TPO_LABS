package module.log;

import com.danp1t.log_function.Ln;
import com.danp1t.log_function.Log10;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Log10Test {
    private final Log10 log10 = new Log10(new Ln());
    private final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "10, 1",
            "100, 2",
            "1000, 3",
            "0.1, -1"
    })
    void testLog10Values(double x, double expected) {
        assertEquals(expected, log10.calculate(x, EPS), 1e-9);
    }

    @Test
    void testInvalidX() {
        assertThrows(IllegalArgumentException.class, () -> log10.calculate(0.0, EPS));
        assertThrows(IllegalArgumentException.class, () -> log10.calculate(-1.0, EPS));
    }

    @Test
    void testInvalidEpsilon() {
        assertThrows(IllegalArgumentException.class, () -> log10.calculate(1.0, 0.0));
    }
}
