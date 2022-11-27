package com.twu.strategy;

import java.util.Arrays;

public class NumberCruncher {

    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return (int) Arrays.stream(numbers).filter(NumberCruncher::isEven).count();
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public int countOdd() {
        return (int) Arrays.stream(numbers).filter(NumberCruncher::isOdd).count();
    }

    private static boolean isOdd(int number) {
        return number % 2 == 1;
    }

    public int countPositive() {
        return (int) Arrays.stream(numbers).filter(NumberCruncher::isPositive).count();
    }

    private static boolean isPositive(int number) {
        return number >= 0;
    }

    public int countNegative() {
        return (int) Arrays.stream(numbers).filter(NumberCruncher::isNegative).count();
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }
}
