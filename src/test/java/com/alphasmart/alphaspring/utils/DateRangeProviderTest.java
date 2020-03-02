package com.alphasmart.alphaspring.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
class DateRangeProviderTest {

    @Spy
    DateRangeProvider dateRangeProvider;

    @Test
    public void testStartAndEndDate() {
        List<String> expectBeginEndDate = Arrays.asList("2019-03-01", "2020-03-01");
        LocalDate fakeToday = LocalDate.of(2020, 3, 1);
        doReturn(fakeToday).when(dateRangeProvider).getToday();
        assertEquals(expectBeginEndDate, dateRangeProvider.startAndEndDate(1));
    }

}