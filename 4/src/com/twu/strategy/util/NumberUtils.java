package com.twu.strategy.util;

public class NumberUtils {

    private NumberUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T extends Number> boolean isEven(T number) {
        if (isIntegerNumber(number)) {
            return Long.parseLong(number.toString()) % 2 == 0;
        } else {
            return Double.parseDouble(number.toString()) % 2 == 0;
        }
    }

    public static <T extends Number> boolean isOdd(T number) {
        if (isIntegerNumber(number)) {
            return Long.parseLong(number.toString()) % 2 == 1;
        } else {
            return Double.parseDouble(number.toString()) % 2 == 1;
        }
    }

    public static <T extends Number> boolean isPositive(T number) {
        if (isIntegerNumber(number)) {
            return Long.parseLong(number.toString()) >= 0;
        } else {
            return Double.parseDouble(number.toString()) >= 0;
        }
    }

    public static <T extends Number> boolean isNegative(T number) {
        if (isIntegerNumber(number)) {
            return Long.parseLong(number.toString()) < 0;
        } else {
            return Double.parseDouble(number.toString()) < 0;
        }
    }

    private static <T extends Number> boolean isIntegerNumber(T number) {
        return number instanceof Long || number instanceof Integer || number instanceof Short || number instanceof Byte;
    }
}