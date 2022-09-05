package com.luxoft.jva008.module01;

import org.junit.Assert;
import org.junit.Test;

import static com.luxoft.jva008.Logger.log;

public class NumbersTutor {

    Double d = 123d;
    Integer i = 23545452;

    @Test
    public void testConvertNumbers() {
        log("=== testConvertNumbers() ===");
        covertNumbers(i);
        covertNumbers(123d);
        covertNumbers(1239879634342l);
    }

    /**
     * Conversion between numeric data types
     *
     * @param number
     */
    public void covertNumbers(Number number) {
    }

    /**
     * Conversion from String type to various numeric data types
     *
     * @param s
     */
    public void stringToNumber(String s) {
        log("=== Convert string " + s + " to Number ===");

        String message = "Exception Format: " + s;

        try {
            byte parseByte = Byte.parseByte(s);
            log("Byte: " + parseByte);
        } catch (NumberFormatException e) {
            log(message);
        }
        try {
            short parseShort = Short.parseShort(s);
            log("Short: " + parseShort);
        } catch (NumberFormatException e) {
            log(message);
        }
        try {
            int parseInt = Integer.parseInt(s);
            log("Integer: " + parseInt);
        } catch (NumberFormatException e) {
            log(message);
        }
        try {
            long parseLong = Long.parseLong(s);
            log("Long: " + parseLong);
        } catch (NumberFormatException e) {
            log(message);
        }
        try {
            float parseFloat = Float.parseFloat(s);
            log("Float: " + parseFloat);
        } catch (NumberFormatException e) {
            log(message);
        }
        try {
            double wrappedDouble = Double.parseDouble(s);
            log("Double: " + wrappedDouble);
        } catch (NumberFormatException e) {
            log(message + s);
        }
    }

    @Test
    public void testStringToNumber() {
        stringToNumber("123");
        stringToNumber("-123");
        stringToNumber("12345678987654321");
        stringToNumber("1.11f");
        stringToNumber("1.1111111111");
    }

    /**
     * Getting  NaN value for Double type
     */
    @Test
    public void testIsNaN() {
        Assert.assertTrue(Double.isNaN(Math.sqrt(-4)));
    }

    /**
     * Getting Infinite value for Double type
     */
    @Test
    public void testIsInfinite() {
        Assert.assertTrue(Double.isInfinite(Double.MAX_VALUE * 2));
    }
}
