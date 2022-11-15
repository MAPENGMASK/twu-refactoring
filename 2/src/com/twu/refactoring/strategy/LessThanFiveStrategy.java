package com.twu.refactoring.strategy;

import com.twu.refactoring.util.DateTimeStringParseUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LessThanFiveStrategy implements Strategy {
    @Override
    public Date algorithm(String dateTimeString) {
        int year = DateTimeStringParseUtils.parseYear(dateTimeString);
        int month = 0;
        int dayOfMonth = 0;
        int hour = 0;
        int minute = 0;

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
