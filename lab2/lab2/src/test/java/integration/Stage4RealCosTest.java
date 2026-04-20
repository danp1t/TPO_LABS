package integration;

import com.danp1t.*;
import com.danp1t.log_function.Ln;
import com.danp1t.trigonometric_function.Cos;
import com.danp1t.trigonometric_function.Sin;
import org.junit.jupiter.api.BeforeAll;

import stubs.trig.TanStub;
import stubs.trig.CotStub;
import stubs.trig.CscStub;
import stubs.log.LnStub;
import stubs.log.Log2Stub;
import stubs.log.Log3Stub;
import stubs.log.Log5Stub;
import stubs.log.Log10Stub;

class Stage4RealCosTest extends AbstractComplexFunctionTest {

    private static ComplexFunction calculator;

    @BeforeAll
    static void setUp() {
        FunctionInterface sin   = new Sin();
        FunctionInterface cos   = new Cos(sin);
        FunctionInterface tan   = new TanStub();
        FunctionInterface cot   = new CotStub();
        FunctionInterface csc   = new CscStub();
        FunctionInterface ln    = new Ln();
        FunctionInterface log2  = new Log2Stub();
        FunctionInterface log3  = new Log3Stub();
        FunctionInterface log5  = new Log5Stub();
        FunctionInterface log10 = new Log10Stub();

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