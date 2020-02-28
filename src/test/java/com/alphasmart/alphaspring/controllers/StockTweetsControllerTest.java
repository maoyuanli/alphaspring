package com.alphasmart.alphaspring.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class StockTweetsControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private final String QUOTE_URI = "/api/tweet";

    private final List<String> EXPECTED_RESPONSE_KEYWORDS = Arrays.asList("tweets", "profileImageUrlHttps", "profileImageUrlHttps", "screenName", "text"); // required by frontend

    @Test
    void testStockTweetsControllerResponse() throws Exception {
        RequestTestTemplate.testMvcRequest(webApplicationContext, QUOTE_URI, null, 200, EXPECTED_RESPONSE_KEYWORDS);

    }

}