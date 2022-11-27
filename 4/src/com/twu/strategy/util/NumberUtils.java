package com.twu.strategy.util;

public class NumberUtils {

    private NumberUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 == 1;
    }

    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }
}