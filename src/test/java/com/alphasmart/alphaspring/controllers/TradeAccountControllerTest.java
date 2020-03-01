package com.alphasmart.alphaspring.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class TradeAccountControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private final String SET_ACCOUNT_URI = "/api/setaccount";
    final String SET_ACCOUNT_JSON = "{\"tradeaccount\":{\"account_no\":\"TA007\"}}";

    @Test
    public void testGetAccount() throws Exception {
        final String GET_ACCOUNT_URI = "/api/getaccount/?accountNo=TA001"; // pre-loaded with data.sql
        final List<String> EXPECTED_GET_ACCOUNT_KEYWORDS = Arrays.asList("trade_account", "account_no", "TA001");
        RequestTestTemplate.testMvcRequest(webApplicationContext, GET_ACCOUNT_URI, null, 200, EXPECTED_GET_ACCOUNT_KEYWORDS);
    }

    @Test
    public void testUnauthorizedSetAccount() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
        MvcResult mvcResult= mockMvc.perform(post(SET_ACCOUNT_URI).with(httpBasic("admin1","pass1"))
                .contentType(MediaType.APPLICATION_JSON).content(SET_ACCOUNT_JSON)
        ).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        int responseStatus = response.getStatus();
        String errorMessage = response.getErrorMessage();
        assertEquals(401, responseStatus);
        assert errorMessage != null;
        assertTrue(errorMessage.contains("Unauthorized"));
    }

    @Test
    public void testAuthorizedSetAccount() throws Exception{
        String SET_USER_JSON = "{\n" +
                "\t\"user\":\n" +
                "\t{\n" +
                "\t    \"user_name\": \"admin1\",\n" +
                "\t    \"password\":\"pass1\",\n" +
                "\t    \"email\":\"admin1@spring.com\",\n" +
                "\t    \"role\":\"ADMIN\"\n" +
                "\t}\n" +
                "}";

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();

        mockMvc.perform(post("/api/setuser").contentType(MediaType.APPLICATION_JSON).content(SET_USER_JSON))
                .andReturn();

        MvcResult mvcResult= mockMvc.perform(post(SET_ACCOUNT_URI).with(httpBasic("admin1","pass1"))
                .contentType(MediaType.APPLICATION_JSON).content(SET_ACCOUNT_JSON)
        ).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        int responseStatus = response.getStatus();
        String responseContent = response.getContentAsString();

        assertEquals(200, responseStatus);
        JSONAssert.assertEquals("{accountNo: TA007, tradeOrders: null}",responseContent,false);

    }
}
