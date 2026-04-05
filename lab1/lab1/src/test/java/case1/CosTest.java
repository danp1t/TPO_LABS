package case1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.danp1t.case1.Cos.calculate;
import static org.junit.jupiter.api.Assertions.*;

class CosTest {

    private static final double DELTA_STANDARD = 1e-5;
    private static final double DELTA_BIG = 1e-2;

    @ParameterizedTest
    @CsvFileSource(resources = "/testTable.csv", numLinesToSkip = 1)
    void testTable(double x, double expected) {
        assertEquals(expected, calculate(x), DELTA_STANDARD);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/testPeriod.csv", numLinesToSkip = 1)
    void testPeriod(double x, double period) {
        assertEquals(calculate(x), calculate(x + period), DELTA_STANDARD);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testEven.csv", numLinesToSkip = 1)
    void testEven(double x) {
        assertEquals(calculate(x), calculate(-x), DELTA_STANDARD);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testTooBig.csv", numLinesToSkip = 1)
    void testTooBig(double x, double expected) {
        assertEquals(expected, calculate(x), DELTA_STANDARD);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testTooSmall.csv", numLinesToSkip = 1)
    void testTooSmall(double x, double expected) {
        assertEquals(expected, calculate(x), DELTA_STANDARD);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testCriticalPoints.csv", numLinesToSkip = 1)
    void testCriticalPoints(double x, double expected, boolean expectException) {
        if (expectException) {
            assertThrows(ArithmeticException.class, () -> calculate(x));
        } else {
            assertEquals(expected, calculate(x), DELTA_BIG);
        }
    }
}