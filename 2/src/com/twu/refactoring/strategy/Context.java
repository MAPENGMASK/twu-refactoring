package com.twu.refactoring.strategy;

import java.util.Date;

public class Context {

    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Date invokeStrategy(String dateTimeString) {
        return strategy.algorithm(dateTimeString);
    }
}
