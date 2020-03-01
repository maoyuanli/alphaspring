package com.alphasmart.alphaspring.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class TradeOrderControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private final String SET_ORDER_URI = "/api/setorder";

    private final String ORDER_JSON = "{" +
            "\"order\":" +
            "{" +
            "\"ticker\": \"Mao Technology\"," +
            "\"order_type\": \"Market\"," +
            "\"order_price\": \"2210.0\"," +
            "\"order_volumn\": \"855000\"" +
            "}" +
            "}";

    private final String EXPECTED_RESPONSE_LOOSE_JSON =
            "{ticker: \"Mao Technology\"," +
                    "orderType: Market," +
                    "orderPrice: \"2210.0\"," +
                    "orderVolumn: \"855000\"," +
                    "tradeAccount: null}";

    @Test
    public void testSetOrder() throws Exception {
        RequestTestTemplate.testMvcRequest(webApplicationContext, SET_ORDER_URI, ORDER_JSON,
                200, EXPECTED_RESPONSE_LOOSE_JSON,false);
    }

}