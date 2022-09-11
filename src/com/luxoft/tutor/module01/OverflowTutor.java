package com.luxoft.tutor.module01;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static com.luxoft.tutor.Logger.log;

public class OverflowTutor {

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    /**
     * Multiply 2 numbers, excite ArithmeticException in case of overflow
     */
    public Integer multiply(int a, int b) {

        long max = Math.max(a, b);

        if ((0 >= b || b <= max / a) && (0 <= b || b >= max / a)) {

            return Math.toIntExact(max);
        }

        throw new ArithmeticException("Integer overflow: " + max);

    }

    @Test(expected = ArithmeticException.class)
    public void testOverflow() {
        int i1 = 34524235;
        int i2 = 23423423;
        int overflowed = i1 * i2;
        log("i1*i2=" + overflowed);
        this.multiply(i1, i2);
    }

    @Test
    public void testSum() {
        Double d = Double.POSITIVE_INFINITY * 10;
        log("doubleMultiply=" + d);
    }
}