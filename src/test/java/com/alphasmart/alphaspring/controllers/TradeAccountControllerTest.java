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
class TradeAccountControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private final String GET_ACCOUNT_URI = "/api/getaccount/?accountNo=TA001"; // pre-loaded with data.sql

    private final List<String> EXPECTED_GET_RESPONSE_KEYWORDS = Arrays.asList("trade_account", "account_no","TA001");

    @Test
    void testGetAccount() throws Exception {
        RequestTestTemplate.testMvcRequest(webApplicationContext,GET_ACCOUNT_URI,null,200,EXPECTED_GET_RESPONSE_KEYWORDS);
    }
}
