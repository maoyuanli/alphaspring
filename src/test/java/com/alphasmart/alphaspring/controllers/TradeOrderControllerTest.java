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

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
class TradeOrderControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private final String ORDER_JSON="{\n" +
            "\t\"order\":\n" +
            "\t{\n" +
            "\t    \"ticker\": \"Mao Technology\",\n" +
            "\t    \"order_type\": \"Market\",\n" +
            "\t    \"order_price\": \"2210.0\",\n" +
            "\t    \"order_volumn\": \"855000\"\n" +
            "\t}\n" +
            "}";

    @Test
    void testSetOrder() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/setorder";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(ORDER_JSON)).andReturn();
        int responseStatus = mvcResult.getResponse().getStatus();
        String responseContent = mvcResult.getResponse().getContentAsString();
        assertEquals(200,responseStatus);
        assertTrue(responseContent.contains("Mao"));
    }

}