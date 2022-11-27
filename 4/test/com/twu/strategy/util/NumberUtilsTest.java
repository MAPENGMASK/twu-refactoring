package com.twu.strategy.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    private static byte BYTE_NUMBER;
    private static short SHORT_NUMBER;
    private static int INT_NUMBER;
    private static long LONG_NUMBER;
    private static float FLOAT_NUMBER;
    private static double DOUBLE_NUMBER;

    @BeforeAll
    static void init() {
        BYTE_NUMBER = Byte.parseByte("10");
        SHORT_NUMBER = Short.parseShort("10");
        INT_NUMBER = Integer.parseInt("10");
        LONG_NUMBER = Long.parseLong("10");
        FLOAT_NUMBER = Float.parseFloat("10.1");
        DOUBLE_NUMBER = Double.parseDouble("10.1");
    }


    @Test
    void isEven() {
        // when
        boolean byteEven = NumberUtils.isEven(BYTE_NUMBER);
        boolean shortEven = NumberUtils.isEven(SHORT_NUMBER);
        boolean intEven = NumberUtils.isEven(INT_NUMBER);
        boolean longEven = NumberUtils.isEven(LONG_NUMBER);
        boolean floatEven = NumberUtils.isEven(FLOAT_NUMBER);
        boolean doubleEven = NumberUtils.isEven(DOUBLE_NUMBER);

        // then
        assertTrue(byteEven);
        assertTrue(shortEven);
        assertTrue(intEven);
        assertTrue(longEven);
        assertFalse(floatEven);
        assertFalse(doubleEven);
    }

    @Test
    void isOdd() {
        // when
        boolean byteOdd = NumberUtils.isOdd(BYTE_NUMBER);
        boolean shortOdd = NumberUtils.isOdd(SHORT_NUMBER);
        boolean intOdd = NumberUtils.isOdd(INT_NUMBER);
        boolean longOdd = NumberUtils.isOdd(LONG_NUMBER);
        boolean floatOdd = NumberUtils.isOdd(FLOAT_NUMBER);
        boolean doubleOdd = NumberUtils.isOdd(DOUBLE_NUMBER);
        // then
        assertFalse(byteOdd);
        assertFalse(shortOdd);
        assertFalse(intOdd);
        assertFalse(longOdd);
        assertFalse(floatOdd);
        assertFalse(doubleOdd);
    }

    @Test
    void isPositive() {
        // when
        boolean bytePositive = NumberUtils.isPositive(BYTE_NUMBER);
        boolean shortPositive = NumberUtils.isPositive(SHORT_NUMBER);
        boolean intPositive = NumberUtils.isPositive(INT_NUMBER);
        boolean longPositive = NumberUtils.isPositive(LONG_NUMBER);
        boolean floatPositive = NumberUtils.isPositive(FLOAT_NUMBER);
        boolean doublePositive = NumberUtils.isPositive(DOUBLE_NUMBER);
        // then
        assertTrue(bytePositive);
        assertTrue(shortPositive);
        assertTrue(intPositive);
        assertTrue(longPositive);
        assertTrue(floatPositive);
        assertTrue(doublePositive);
    }

    @Test
    void isNegative() {
        // when
        boolean byteNegative = NumberUtils.isNegative(BYTE_NUMBER);
        boolean shortNegative = NumberUtils.isNegative(SHORT_NUMBER);
        boolean intNegative = NumberUtils.isNegative(INT_NUMBER);
        boolean longNegative = NumberUtils.isNegative(LONG_NUMBER);
        boolean floatNegative = NumberUtils.isNegative(FLOAT_NUMBER);
        boolean doubleNegative = NumberUtils.isNegative(DOUBLE_NUMBER);
        // then
        assertFalse(byteNegative);
        assertFalse(shortNegative);
        assertFalse(intNegative);
        assertFalse(longNegative);
        assertFalse(floatNegative);
        assertFalse(doubleNegative);
    }
}