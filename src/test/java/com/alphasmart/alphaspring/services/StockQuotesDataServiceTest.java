package com.alphasmart.alphaspring.services;

import com.alphasmart.alphaspring.utils.TickersAndSources;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StockQuotesDataServiceTest {

    @Autowired
    StockQuotesDataService stockQuotesDataService;

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