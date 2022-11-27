package com.twu.strategy;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        int count = 0;
        for (int number : numbers) {
            if (isEven(number)) count++;
        }
        return count;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public int countOdd() {
        int count = 0;
        for (int number : numbers) {
            if (isOdd(number)) count++;
        }
        return count;
    }

    private static boolean isOdd(int number) {
        return number % 2 == 1;
    }

    public int countPositive() {
        int count = 0;
        for (int number : numbers) {
            if (isPositive(number)) count++;
        }
        return count;
    }

    private static boolean isPositive(int number) {
        return number >= 0;
    }

    public int countNegative() {
        int count = 0;
        for (int number : numbers) {
            if (isNegative(number)) count++;
        }
        return count;
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }
}
