package com.twu.strategy;

import com.twu.strategy.util.NumberUtils;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class NumberCruncher {

    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return countBy(NumberUtils::isEven);
    }

    public int countOdd() {
        return countBy(NumberUtils::isOdd);
    }

    public int countPositive() {
        return countBy(NumberUtils::isPositive);
    }

    public int countNegative() {
        return countBy(NumberUtils::isNegative);
    }

    public int countBy(IntPredicate judgeCondition) {
        return (int) Arrays.stream(numbers).filter(judgeCondition).count();
    }
}
