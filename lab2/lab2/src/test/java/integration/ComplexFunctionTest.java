package integration;

import com.danp1t.FunctionInterface;
import com.danp1t.log_function.*;
import com.danp1t.trigonometric_function.*;
import com.danp1t.ComplexFunction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stubs.log.*;
import stubs.trig.*;

import static org.junit.jupiter.api.Assertions.*;

class ComplexFunctionIntegrationTest {

    private static ComplexFunction calculator;

    @BeforeAll
    static void setUp() {
        FunctionInterface realSin = new SinStub();
        FunctionInterface realCos = new CosStub();
        FunctionInterface realTan = new TanStub();
        FunctionInterface realCot = new CotStub();
        FunctionInterface realCsc = new CscStub();
        FunctionInterface realLn = new LnStub();
        FunctionInterface realLog2 = new Log2Stub();
        FunctionInterface realLog3 = new Log3Stub();
        FunctionInterface realLog5 = new Log5Stub();
        FunctionInterface realLog10 = new Log10Stub();

        calculator = new ComplexFunction(
                realSin, realCos, realCsc, realTan, realCot,
                realLn, realLog2, realLog3, realLog5, realLog10
        );
    }

    private final double EPS = 1e-9;

    @ParameterizedTest
    @CsvSource({
            "-1.0, -23116.31635647741",
            "-1.0471973333333333, -6115.758921846995",
            "-1.0, -23116.316356",
            "0.0, NaN"
    })
    void testTrigonometricBranch(double x, double expected) {
        System.out.println(3.141592 / 3);
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
            "3.0, 66.90261853497",
            "5.0, 211.6056744900294",
            "10.0, 624.6663341636205"
    })
    void testLogarithmicBranch(double x, double expected) {
            double actual = calculator.calculate(x, EPS);
            assertEquals(expected, actual, 1e-3);

    }
}
