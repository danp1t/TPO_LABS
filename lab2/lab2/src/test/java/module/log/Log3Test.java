package module.log;

import com.danp1t.log_function.Ln;
import com.danp1t.log_function.Log3;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Log3Test {
    private final Log3 log3 = new Log3(new Ln());
    private final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "3, 1",
            "9, 2",
            "27, 3",
            "0.3333333333333333, -1"
    })
    void testLog3Values(double x, double expected) {
        assertEquals(expected, log3.calculate(x, EPS), 1e-9);
    }

    @Test
    void testInvalidX() {
        assertThrows(IllegalArgumentException.class, () -> log3.calculate(0.0, EPS));
        assertThrows(IllegalArgumentException.class, () -> log3.calculate(-1.0, EPS));
    }

    @Test
    void testInvalidEpsilon() {
        assertThrows(IllegalArgumentException.class, () -> log3.calculate(1.0, 0.0));
    }
}
