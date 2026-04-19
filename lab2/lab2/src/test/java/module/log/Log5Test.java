package module.log;

import com.danp1t.log_function.Ln;

import com.danp1t.log_function.Log5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Log5Test {
    private final Log5 log5 = new Log5(new Ln());
    private final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "5, 1",
            "25, 2",
            "125, 3",
            "0.2, -1"
    })
    void testLog5Values(double x, double expected) {
        assertEquals(expected, log5.calculate(x, EPS), 1e-9);
    }

    @Test
    void testInvalidX() {
        assertThrows(IllegalArgumentException.class, () -> log5.calculate(0.0, EPS));
        assertThrows(IllegalArgumentException.class, () -> log5.calculate(-1.0, EPS));
    }

    @Test
    void testInvalidEpsilon() {
        assertThrows(IllegalArgumentException.class, () -> log5.calculate(1.0, 0.0));
    }
}
