package com.twu.strategy;

import com.twu.strategy.util.NumberUtils;

import java.util.Arrays;

public class NumberCruncher {

    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return (int) Arrays.stream(numbers).filter(NumberUtils::isEven).count();
    }

    public int countOdd() {
        return (int) Arrays.stream(numbers).filter(NumberUtils::isOdd).count();
    }

    public int countPositive() {
        return (int) Arrays.stream(numbers).filter(NumberUtils::isPositive).count();
    }

    public int countNegative() {
        return (int) Arrays.stream(numbers).filter(NumberUtils::isNegative).count();
    }

}
