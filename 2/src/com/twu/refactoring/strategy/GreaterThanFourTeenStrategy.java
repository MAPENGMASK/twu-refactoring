package com.twu.refactoring.strategy;

import com.twu.refactoring.util.DateTimeStringParseUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class GreaterThanFourTeenStrategy implements Strategy {
    @Override
    public Date algorithm(String dateTimeString) {
        int year = DateTimeStringParseUtils.parseYear(dateTimeString);
        int month = DateTimeStringParseUtils.parseMonth(dateTimeString);
        int dayOfMonth = DateTimeStringParseUtils.parseDayOfMonth(dateTimeString);
        int hour = DateTimeStringParseUtils.parseHour(dateTimeString);
        int minute = DateTimeStringParseUtils.parseMinute(dateTimeString);

        return buildDate(year, month, dayOfMonth, hour, minute);
    }

    private Date buildDate(int year, int month, int dayOfMonth, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, dayOfMonth, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
