package case1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.danp1t.case1.Cos.calculate;
import static com.danp1t.case1.Cos.PI;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CosTest {
    double delta = 1e-5;
    double deltaForBigNumber = 1e-2;

    @Test
    public void testTable() {
        assertEquals(1, calculate(0.0), delta);
        assertEquals(0.86603, calculate(PI/6), delta);
        assertEquals(0.70711, calculate(PI / 4), delta);
        assertEquals(0.5, calculate(PI / 3), delta);
        assertEquals(0, calculate(PI / 2), delta);
        assertEquals(-0.5, calculate(2*PI / 3), delta);
        assertEquals(-0.70711, calculate(3*PI / 4), delta);
        assertEquals(-0.86603, calculate(5*PI / 6), delta);
        assertEquals(-1, calculate(PI), delta);
        assertEquals(-0.86603, calculate(7*PI / 6), delta);
        assertEquals(-0.70711, calculate(5*PI / 4), delta);
        assertEquals(-0.5, calculate(4*PI / 3), delta);
        assertEquals(0, calculate(3*PI / 2), delta);
        assertEquals(0.5, calculate(5*PI / 3), delta);
        assertEquals(0.70711, calculate(7*PI / 4), delta);
        assertEquals(0.86603, calculate(11*PI / 6), delta);
        assertEquals(1, calculate(2*PI), delta);
    }

    @Test
    //cos(x) = cos(x + 2*pi)
    public void testPeriod() {
        assertEquals(calculate(2*PI), calculate(0.0), delta);
        assertEquals(calculate(PI/6 + 2*PI), calculate(PI / 6), delta);
        assertEquals(calculate(PI/4 - 2*PI), calculate(PI / 4), delta);
        assertEquals(calculate(PI/3 + 10*PI), calculate(PI / 3), delta);
        assertEquals(calculate(PI/2 - 20*PI), calculate(PI / 2), delta);
    }

    @Test
    // cos(x) = cos(-x)
    public void testEven() {
        assertEquals(calculate(-0.0), calculate(0.0), delta);
        assertEquals(calculate(-PI/6), calculate(PI/6), delta);
        assertEquals(calculate(-PI / 4), calculate(PI / 4), delta);
        assertEquals(calculate(-PI / 3), calculate(PI / 3), delta);
        assertEquals(calculate(-PI / 2), calculate(PI / 2), delta);
    }

    @Test
    public void testTooBig() {
        assertEquals(-0.86603, calculate(19*PI/6), delta);
        assertEquals(0.5, calculate(37*PI/3), delta);
        assertEquals(-0.70711, calculate(85*PI/4), delta);
        assertEquals(1, calculate(30000*PI/2), delta);
        assertEquals(-0.5, calculate(37040*PI/3), delta);
        assertEquals(0.70711, calculate(214103*PI/4), delta);
        assertEquals(0.86603, calculate(416603*PI/6), delta);
        assertEquals(1, calculate(857238*PI), delta);
    }

    @Test
    public void testTooSmall() {
        assertEquals(-0.86603, calculate(-19*PI/6), delta);
        assertEquals(0.5, calculate(-37*PI/3), delta);
        assertEquals(-0.70711, calculate(-85*PI/4), delta);
        assertEquals(1, calculate(-30000*PI/2), delta);
        assertEquals(-0.5, calculate(-37040*PI/3), delta);
        assertEquals(0.70711, calculate(-214103*PI/4), delta);
        assertEquals(0.86603, calculate(-416603*PI/6), delta);
        assertEquals(1, calculate(-857238*PI), delta);
    }

    @Test
    public void testCriticalPoint() {
        assertEquals(1, calculate(Math.pow(10, 200)*PI), deltaForBigNumber);
        assertEquals(1, calculate(-Math.pow(10, 200)*PI), deltaForBigNumber);
        assertEquals(1, calculate(Math.pow(10, 308)), deltaForBigNumber);
        assertEquals(1, calculate(-Math.pow(10, 308)), deltaForBigNumber);
        assertThrows(ArithmeticException.class, () -> calculate(Math.pow(10, 309)*PI));
        assertThrows(ArithmeticException.class, () -> calculate(-Math.pow(10, 309)*PI));
        assertEquals(0, calculate(PI / 2), delta);
        assertEquals(1, calculate(0.0), delta);
        assertEquals(1, calculate(Math.pow(10, -326)), delta);
        assertEquals(1, calculate(-Math.pow(10, -326)), delta);

    }



}