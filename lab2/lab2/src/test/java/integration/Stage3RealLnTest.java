package integration;

import com.danp1t.ComplexFunction;
import com.danp1t.FunctionInterface;
import com.danp1t.log_function.Ln;
import com.danp1t.trigonometric_function.Sin;
import integration.AbstractComplexFunctionTest;
import org.junit.jupiter.api.BeforeAll;
import stubs.log.*;
import stubs.trig.CosStub;
import stubs.trig.CotStub;
import stubs.trig.CscStub;
import stubs.trig.TanStub;

class Stage3RealLnTest extends AbstractComplexFunctionTest {

    private static ComplexFunction calculator;

    @BeforeAll
    static void setUp() {
        FunctionInterface realSin = new Sin();
        FunctionInterface cos     = new CosStub();
        FunctionInterface tan     = new TanStub();
        FunctionInterface cot     = new CotStub();
        FunctionInterface csc     = new CscStub();
        FunctionInterface ln      = new Ln();
        FunctionInterface log2    = new Log2Stub();
        FunctionInterface log3    = new Log3Stub();
        FunctionInterface log5    = new Log5Stub();
        FunctionInterface log10   = new Log10Stub();

        calculator = new ComplexFunction(
                realSin, cos, csc, tan, cot,
                ln, log2, log3, log5, log10
        );
    }

    @Override
    protected ComplexFunction getCalculator() {
        return calculator;
    }
}