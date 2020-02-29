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
class SecurityControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private final String SETUSER_URI = "/api/setuser";

    private final String SET_USER_JSON = "{\n" +
            "\t\"user\":\n" +
            "\t{\n" +
            "\t    \"user_name\": \"admin1\",\n" +
            "\t    \"password\":\"pass1\",\n" +
            "\t    \"email\":\"admin1@spring.com\",\n" +
            "\t    \"role\":\"ADMIN\"\n" +
            "\t}\n" +
            "}";

    private final List<String> EXPECTED_RESPONSE_KEYWORDS = Arrays.asList("id", "userName", "email", "role", "password");

    @Test
    public void testSetUserAccount() throws Exception {
        RequestTestTemplate.testMvcRequest(webApplicationContext, SETUSER_URI, SET_USER_JSON, 200, EXPECTED_RESPONSE_KEYWORDS);
    }

}