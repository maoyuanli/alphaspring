package com.alphasmart.alphaspring.components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StockQuotesTest {
    StockQuotes stockQuotes;
    private static final Logger logger = LogManager.getLogger(StockQuotesTest.class);

    @BeforeEach
    public void setup(){
        stockQuotes = spy(new StockQuotes());
    }

    @Test
    void testStartAndEndDate() {
        List<String> expectBeginEndDate = Arrays.asList("2019-03-01","2020-03-01");
        LocalDate fakeToday = LocalDate.of(2020,3,1);
        doReturn(fakeToday).when(stockQuotes).getToday();
        assertEquals(expectBeginEndDate,stockQuotes.startAndEndDate(1));
    }

    @Test
    void testQuotesBundler(){
        logger.info(stockQuotes.quotesBundler(TickersAndSources.getTickers()));
    }

}