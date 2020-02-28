package com.alphasmart.alphaspring.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
class TradeOrderControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private final String SET_ORDER_URI = "/api/setorder";

    private final String ORDER_JSON = "{\n" +
            "\t\"order\":\n" +
            "\t{\n" +
            "\t    \"ticker\": \"Mao Technology\",\n" +
            "\t    \"order_type\": \"Market\",\n" +
            "\t    \"order_price\": \"2210.0\",\n" +
            "\t    \"order_volumn\": \"855000\"\n" +
            "\t}\n" +
            "}";

    private final List<String> EXPECTED_RESPONSE_KEYWORDS = Arrays.asList("Mao", "Market", "2210.0", "855000");

    @Test
    void testSetOrder() throws Exception {
        RequestTestTemplate.testMvcRequest(webApplicationContext, SET_ORDER_URI, ORDER_JSON, 200, EXPECTED_RESPONSE_KEYWORDS);
    }

}