package com.twu.refactoring;

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
        int year = 0;
        int month = 0;
        int dayOfMonth = 0;
        int hour = 0;
        int minute = 0;

        int length = dateTimeString.length();
        if (length <= 4) {
            year = getYear();
        } else if (length <= 7) {
            year = getYear();
            month = getMonth();
        } else if (length <= 10) {
            year = getYear();
            month = getMonth();
            dayOfMonth = getDayOfMonth();
        } else if (length == 11) {
            year = getYear();
            month = getMonth();
            if (dateTimeString.substring(11, 12).equals("Z")) {
                hour = 0;
                minute = 0;
            }
        } else if (length <= 13) {
            year = getYear();
            month = getMonth();
            dayOfMonth = getDayOfMonth();
            hour = getHour();
        } else {
            year = getYear();
            month = getMonth();
            dayOfMonth = getDayOfMonth();
            hour = getHour();
            minute = getMinute();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(KNOWN_TIME_ZONES.get("UTC"));
        calendar.set(year, month - 1, dayOfMonth, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private int getMinute() {
        int minute;
        try {
            String minuteString = dateTimeString.substring(14, 16);
            minute = Integer.parseInt(minuteString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Minute string is less than 2 characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Minute is not an integer");
        }
        if (minute < 0 || minute > 59)
            throw new IllegalArgumentException("Minute cannot be less than 0 or more than 59");
        return minute;
    }

    private int getHour() {
        int hour;
        try {
            String hourString = dateTimeString.substring(11, 13);
            hour = Integer.parseInt(hourString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Hour string is less than 2 characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Hour is not an integer");
        }
        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("Hour cannot be less than 0 or more than 23");
        return hour;
    }

    private int getDayOfMonth() {
        int dayOfMonth;
        try {
            String dateString = dateTimeString.substring(8, 10);
            dayOfMonth = Integer.parseInt(dateString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Date string is less than 2 characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Date is not an integer");
        }
        if (dayOfMonth < 1 || dayOfMonth > 31)
            throw new IllegalArgumentException("Date cannot be less than 1 or more than 31");
        return dayOfMonth;
    }

    private int getMonth() {
        int month;
        try {
            String monthString = dateTimeString.substring(5, 7);
            month = Integer.parseInt(monthString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Month string is less than 2 characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Month is not an integer");
        }
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Month cannot be less than 1 or more than 12");
        return month;
    }

    private int getYear() {
        int year;
        try {
            String yearString = dateTimeString.substring(0, 4);
            year = Integer.parseInt(yearString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Year string is less than 4 characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Year is not an integer");
        }
        if (year < 2000 || year > 2012)
            throw new IllegalArgumentException("Year cannot be less than 2000 or more than 2012");
        return year;
    }
}
