package com.twu.refactoring.util;

public class DateTimeStringParseUtils {

    private DateTimeStringParseUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static int parseMinute(String dateTimeString) {
        int minute;
        if (dateTimeString.charAt(11) == 'Z')
            return 0;
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

    public static int parseHour(String dateTimeString) {
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

    public static int parseDayOfMonth(String dateTimeString) {
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

    public static int parseMonth(String dateTimeString) {
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

    public static int parseYear(String dateTimeString) {
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
