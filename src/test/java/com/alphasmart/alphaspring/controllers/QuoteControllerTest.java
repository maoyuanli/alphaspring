package com.alphasmart.alphaspring.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuoteControllerTest {

    @org.junit.jupiter.api.Test
    void getQuote() {
    }

    @org.junit.jupiter.api.Test
    void quotesBundler() {
    }

    @org.junit.jupiter.api.Test
    void startAndEndDate() {
        ArrayList<String> actual =  QuoteController.startAndEndDate(1);
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList(new String[] {"2018-11-20", "2019-11-20"}));
        assertEquals(expected,actual);
    }
}