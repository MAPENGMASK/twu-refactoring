package com.twu.refactoring;

import com.twu.refactoring.strategy.*;

import java.util.*;

public class DateParser {
    private final String dateTimeString;
    private static final Map<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<>();

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
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

        Context context;

        int length = dateTimeString.length();
        if (length <= 4) {
            context = new Context(new LessThanFiveStrategy());
            return context.invokeStrategy(dateTimeString);
        } else if (length <= 7) {
            context = new Context(new LessThanEightStrategy());
            return context.invokeStrategy(dateTimeString);
        } else if (length <= 10) {
            context = new Context(new LessThanElevenStrategy());
            return context.invokeStrategy(dateTimeString);
        } else if (length <= 13) {
            context = new Context(new LessThanFourTeenStrategy());
            return context.invokeStrategy(dateTimeString);
        } else {
            context = new Context(new GreaterThanFourTeenStrategy());
            return context.invokeStrategy(dateTimeString);
        }
    }
}
