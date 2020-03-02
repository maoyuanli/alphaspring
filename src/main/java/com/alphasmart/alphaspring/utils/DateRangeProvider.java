package com.alphasmart.alphaspring.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class DateRangeProvider {

    public List<String> startAndEndDate(long yearAgo) {
        List<String> dateRangePair = new ArrayList<>();
        LocalDate today = getToday();
        String strToday = today.format(DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate oneYrAgo = today.minusYears(yearAgo);
        String strOneYrAgo = oneYrAgo.format(DateTimeFormatter.ISO_LOCAL_DATE);
        dateRangePair.add(strOneYrAgo);
        dateRangePair.add(strToday);
        return dateRangePair;
    }

    public LocalDate getToday() {
        return LocalDate.now();
    }
}
