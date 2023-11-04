package com.jumbo.trus.util;

import java.time.LocalDate;

public class CalendarDateTranslator {

    public CalendarDateTranslator() {
    }

    public String getCalendarDay(LocalDate date) {
        return addZeroToCalendarNumber(date.getDayOfMonth()) + "." + addZeroToCalendarNumber(date.getMonthValue()) +  ". " + date.getYear();
    }

    private String addZeroToCalendarNumber(int dayOrMonth) {
        if (dayOrMonth < 10) {
            return "0"+ dayOrMonth;
        }
        return String.valueOf(dayOrMonth);
    }

    public LocalDate getInitPlayerDate() {
        return LocalDate.of(LocalDate.now().getYear(), 1,1);
    }
}
