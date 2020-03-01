package com.alphasmart.alphaspring.services;

import com.alphasmart.alphaspring.utils.TickersAndSources;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StockQuotesDataServiceTest {
    @Spy
    StockQuotesDataService stockQuotesDataService;

    @Test
    public void testStartAndEndDate() {
        List<String> expectBeginEndDate = Arrays.asList("2019-03-01", "2020-03-01");
        LocalDate fakeToday = LocalDate.of(2020, 3, 1);
        doReturn(fakeToday).when(stockQuotesDataService).getToday();
        assertEquals(expectBeginEndDate, stockQuotesDataService.startAndEndDate(1));
    }

    @Test
    public void testQuotesBundler() {
        String responseBody = stockQuotesDataService.quotesBundler(TickersAndSources.getTickers());

        // required by frontend
        assertTrue(responseBody.contains("quotes")
                && responseBody.contains("dataset")
                && responseBody.contains("newest_available_date")
                && responseBody.contains("data")
                && responseBody.contains("Volume"));
    }

}