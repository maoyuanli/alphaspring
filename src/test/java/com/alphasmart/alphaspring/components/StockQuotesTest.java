package com.alphasmart.alphaspring.components;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StockQuotesTest {
    StockQuotes stockQuotes;

    @BeforeEach
    public void setup(){
        stockQuotes = new StockQuotes();
    }

    @Test
    void getQuote() {
    }

    @Test
    void quotesBundler() {
    }

    @Test
    void startAndEndDate() {
        List<String> expectBeginEndDate = Arrays.asList("2019-02-14","2020-02-14");
        assertEquals(expectBeginEndDate,StockQuotes.startAndEndDate(1));
    }
}