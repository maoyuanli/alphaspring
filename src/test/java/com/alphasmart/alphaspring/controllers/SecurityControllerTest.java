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
class SecurityControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private final String SET_USER_JSON = "{\n" +
            "\t\"user\":\n" +
            "\t{\n" +
            "\t    \"user_name\": \"admin1\",\n" +
            "\t    \"password\":\"pass1\",\n" +
            "\t    \"email\":\"admin1@spring.com\",\n" +
            "\t    \"role\":\"ADMIN\"\n" +
            "\t}\n" +
            "}";

    @Test
    void testSetUserAccount() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/setuser";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(SET_USER_JSON)).andReturn();
        int responseStatus = mvcResult.getResponse().getStatus();
        String responseContent = mvcResult.getResponse().getContentAsString();
        assertEquals(200, responseStatus);
        assertTrue(responseContent.contains("id")
                &&  responseContent.contains("userName")
                &&  responseContent.contains("email")
                &&  responseContent.contains("role")
                &&  responseContent.contains("password"));
    }

}