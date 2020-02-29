package com.alphasmart.alphaspring.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StockTweetsControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private final String QUOTE_URI = "/api/tweet";

    private final List<String> EXPECTED_RESPONSE_KEYWORDS = Arrays.asList("tweets", "profileImageUrlHttps", "profileImageUrlHttps", "screenName", "text"); // required by frontend

    @Test
    public void testStockTweetsControllerResponse() throws Exception {
        RequestTestTemplate.testMvcRequest(webApplicationContext, QUOTE_URI, null, 200, EXPECTED_RESPONSE_KEYWORDS);

    }

}