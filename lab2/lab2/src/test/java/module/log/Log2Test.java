package module.log;

import com.danp1t.log_function.Ln;
import com.danp1t.log_function.Log2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Log2Test {
    private final Log2 log2 = new Log2(new Ln());
    private final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 1",
            "4, 2",
            "8, 3",
            "0.5, -1"
    })
    void testLog2Values(double x, double expected) {
        assertEquals(expected, log2.calculate(x, EPS), 1e-9);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 1",
            "3, 1.584962500721156",
            "5, 2.321928094887362",
            "10, 3.3219280948873626"
    })
    void testLog2FromTable(double x, double expected) {
        assertEquals(expected, log2.calculate(x, EPS), 1e-9);
    }

    @Test
    void testInvalidX() {
        assertThrows(IllegalArgumentException.class, () -> log2.calculate(0.0, EPS));
        assertThrows(IllegalArgumentException.class, () -> log2.calculate(-1.0, EPS));
    }

    @Test
    void testInvalidEpsilon() {
        assertThrows(IllegalArgumentException.class, () -> log2.calculate(1.0, 0.0));
    }
}
