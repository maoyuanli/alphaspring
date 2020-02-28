package com.alphasmart.alphaspring.utils;

import com.alphasmart.alphaspring.services.StockQuotesDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StockQuotesDataServiceTest {
    StockQuotesDataService stockQuotesDataService;
    private static final Logger logger = LogManager.getLogger(StockQuotesDataServiceTest.class);

    @BeforeEach
    public void setup(){
        stockQuotesDataService = spy(new StockQuotesDataService());
    }

    @Test
    void testStartAndEndDate() {
        List<String> expectBeginEndDate = Arrays.asList("2019-03-01","2020-03-01");
        LocalDate fakeToday = LocalDate.of(2020,3,1);
        doReturn(fakeToday).when(stockQuotesDataService).getToday();
        assertEquals(expectBeginEndDate, stockQuotesDataService.startAndEndDate(1));
    }

    @Test
    void testQuotesBundler(){
        logger.info(stockQuotesDataService.quotesBundler(TickersAndSources.getTickers()));
    }

}