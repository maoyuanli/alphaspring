package com.alphasmart.alphaspring.components;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FeaturedStocksTest {

    @Test
    void getQuote() {
    }

    @Test
    void quotesBundler() {
    }

    @Test
    void startAndEndDate() {
        ArrayList<String> actual =  FeaturedStocks.startAndEndDate(1);
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList(new String[] {"2018-11-21", "2019-11-21"}));
        assertEquals(expected,actual);
    }
}