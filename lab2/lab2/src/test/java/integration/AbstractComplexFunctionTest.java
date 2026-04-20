package integration;

import com.danp1t.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractComplexFunctionTest {

    protected static final double EPS = 1e-9;
    protected static final double DELTA = 1e-3;

    protected abstract ComplexFunction getCalculator();

    @ParameterizedTest
    @CsvSource({
            "-1.0, -23116.31635647741",
            "-1.0471973333333333, -6115.758921846995",
            "-1.0, -23116.316356",
            "-1.31098, -214.1029",
            "-1.81135, 355.32691",
            "-4.45257, 214.1029",
            "-4.95294, -355.32691",
            "-8.0945353, 355.32691",
            "0.0, NaN"
    })
    void testTrigonometricBranch(double x, double expected) {
        ComplexFunction calculator = getCalculator();
        if (Double.isNaN(expected)) {
            assertThrows(ArithmeticException.class, () -> calculator.calculate(x, EPS));
        } else {
            assertEquals(expected, calculator.calculate(x, EPS), DELTA);
        }
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, NaN",
            "3.0, 66.90261853497",
            "5.0, 211.6056744900294",
            "10.0, 624.6663341636205"
    })
    void testLogarithmicBranch(double x, double expected) {
        ComplexFunction calculator = getCalculator();
        assertEquals(expected, calculator.calculate(x, EPS), DELTA);

    }
}