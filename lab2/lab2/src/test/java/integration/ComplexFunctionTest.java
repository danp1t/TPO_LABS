package integration;

import com.danp1t.FunctionInterface;
import com.danp1t.log_function.*;
import com.danp1t.trigonometric_function.*;
import com.danp1t.ComplexFunction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ComplexFunctionIntegrationTest {

    private static ComplexFunction calculator;

    @BeforeAll
    static void setUp() {
        FunctionInterface realSin = new Sin();
        FunctionInterface realCos = new Cos(realSin);
        FunctionInterface realTan = new Tan(realSin, realCos);
        FunctionInterface realCot = new Cot(realSin, realCos);
        FunctionInterface realCsc = new Csc(realSin);
        FunctionInterface realLn = new Ln();
        FunctionInterface realLog2 = new Log2(realLn);
        FunctionInterface realLog3 = new Log3(realLn);
        FunctionInterface realLog5 = new Log5(realLn);
        FunctionInterface realLog10 = new Log10(realLn);

        calculator = new ComplexFunction(
                realSin, realCos, realCsc, realTan, realCot,
                realLn, realLog2, realLog3, realLog5, realLog10
        );
    }

    private final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
            "-1.1, -1798.0846347",
            "-1.5, -2946.1688125",
            "-1.0, -23116.316356",
            "0.0, NaN"
    })
    void testTrigonometricBranch(double x, double expected) {
        if (Double.isNaN(expected)) {
            assertThrows(ArithmeticException.class, () -> calculator.calculate(x, EPS));
        } else {
            double actual = calculator.calculate(x, EPS);
            assertEquals(expected, actual, 1e-3);
        }
    }

    @ParameterizedTest
    @CsvSource({
            "1.0, NaN",
            "2.0, 16.7230459859",
            "2.718281828459045, 50.3972735269667",
            "5.0, 211.6056744900294",
            "10.0, 624.6663341636205"
    })
    void testLogarithmicBranch(double x, double expected) {
            double actual = calculator.calculate(x, EPS);
            assertEquals(expected, actual, 1e-3);

    }
}
