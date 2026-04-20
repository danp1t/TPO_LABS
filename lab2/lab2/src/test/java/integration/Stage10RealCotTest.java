package integration;

import com.danp1t.*;
import com.danp1t.log_function.Ln;
import com.danp1t.log_function.Log10;
import com.danp1t.log_function.Log2;
import com.danp1t.log_function.Log3;
import com.danp1t.trigonometric_function.*;
import org.junit.jupiter.api.BeforeAll;

import stubs.trig.CotStub;
import stubs.log.Log2Stub;
import stubs.log.Log5Stub;
import stubs.log.Log10Stub;

class Stage10RealCotTest extends AbstractComplexFunctionTest {

    private static ComplexFunction calculator;

    @BeforeAll
    static void setUp() {
        FunctionInterface sin   = new Sin();
        FunctionInterface cos   = new Cos(sin);
        FunctionInterface tan   = new Tan(sin, cos);
        FunctionInterface cot   = new Cot(sin, cos);
        FunctionInterface csc   = new Csc(sin);
        FunctionInterface ln    = new Ln();
        FunctionInterface log2  = new Log2(ln);
        FunctionInterface log3  = new Log3(ln);
        FunctionInterface log5  = new Log5Stub();
        FunctionInterface log10 = new Log10(ln);

        calculator = new ComplexFunction(
                sin, cos, csc, tan, cot,
                ln, log2, log3, log5, log10
        );
    }

    @Override
    protected ComplexFunction getCalculator() {
        return calculator;
    }
}