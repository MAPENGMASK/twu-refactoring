package com.twu.refactoring;

import com.twu.refactoring.enums.StrategyType;
import com.twu.refactoring.factory.StrategyFactory;
import com.twu.refactoring.strategy.*;

import java.util.*;

public class DateParser {
    private final String dateTimeString;

    static {
        StrategyFactory.registerStrategy(StrategyType.LESS_THAN_FIVE, new LessThanFiveStrategy());
        StrategyFactory.registerStrategy(StrategyType.LESS_THAN_EIGHT, new LessThanEightStrategy());
        StrategyFactory.registerStrategy(StrategyType.LESS_THAN_ELEVEN, new LessThanElevenStrategy());
        StrategyFactory.registerStrategy(StrategyType.LESS_THAN_FOUR_TEEN, new LessThanFourTeenStrategy());
        StrategyFactory.registerStrategy(StrategyType.GREATER_THAN_FOUR_TEEN, new GreaterThanFourTeenStrategy());
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateTimeString) {
        this.dateTimeString = dateTimeString;
    }

    public Date parse() {
        return StrategyFactory.getDate(dateTimeString);
    }
}
