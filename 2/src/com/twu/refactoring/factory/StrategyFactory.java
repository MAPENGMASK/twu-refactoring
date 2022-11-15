package com.twu.refactoring.factory;

import com.twu.refactoring.enums.StrategyType;
import com.twu.refactoring.strategy.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {

    private StrategyFactory() {
        throw new IllegalStateException("Utility class");
    }

    private static final Map<StrategyType, Strategy> STRATEGY_MAP = new HashMap<>();

    public static void registerStrategy(StrategyType type, Strategy strategy) {
        STRATEGY_MAP.put(type, strategy);
    }

    public static Date getDate(String dateTimeString) {
        int length = dateTimeString.length();

        if (length <= 4) {
            return STRATEGY_MAP.get(StrategyType.LESS_THAN_FIVE).algorithm(dateTimeString);
        } else if (length <= 7) {
            return STRATEGY_MAP.get(StrategyType.LESS_THAN_EIGHT).algorithm(dateTimeString);
        } else if (length <= 10) {
            return STRATEGY_MAP.get(StrategyType.LESS_THAN_ELEVEN).algorithm(dateTimeString);
        } else if (length <= 13) {
            return STRATEGY_MAP.get(StrategyType.LESS_THAN_FOUR_TEEN).algorithm(dateTimeString);
        } else {
            return STRATEGY_MAP.get(StrategyType.GREATER_THAN_FOUR_TEEN).algorithm(dateTimeString);
        }
    }
}
