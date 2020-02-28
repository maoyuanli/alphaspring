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
class FeedbackControllerTest {
    @Autowired
    WebApplicationContext webApplicationContext;

    private final String FEEDBACK_URI = "/api/feedback";

    private final String FEEDBACK_JSON = "{\n" +
            "\t\"feedback\": \n" +
            "\t\t{\n" +
            "            \"name\": \"John Snow\",\n" +
            "            \"email\": \"jsnow@postman.com\",\n" +
            "            \"phone\": \"1212333\",\n" +
            "            \"comment\": \"from postman test\"\n" +
            "        }\n" +
            "}";


    private final List<String> EXPECTED_RESPONSE_KEYWORDS = Arrays.asList("created", "successfully", "Snow", "jsnow@postman.com", "1212333", "postman");

    @Test
    void testPostFeedback() throws Exception {
        RequestTestTemplate.testMvcRequest(webApplicationContext, FEEDBACK_URI, FEEDBACK_JSON, 200, EXPECTED_RESPONSE_KEYWORDS);
    }

}