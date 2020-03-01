package com.alphasmart.alphaspring.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class FeedbackControllerTest {
    @Autowired
    WebApplicationContext webApplicationContext;

    private final String FEEDBACK_URI = "/api/feedback";

    private final String FEEDBACK_JSON = "{" +
            "\"feedback\":" +
            "{" +
            "\"name\": \"John Snow\"," +
            "\"email\": \"jsnow@postman.com\"," +
            "\"phone\": \"1212333\"," +
            "\"comment\": \"from postman test\"" +
            "}" +
            "}";


    private final String EXPECTED_RESPONSE_STRICT_JSON =
            "{success: \"Feedback created successfully: John Snow | jsnow@postman.com | 1212333 | from postman test\"}";

    @Test
    public void testPostFeedback() throws Exception {
        RequestTestTemplate.testMvcRequest(webApplicationContext, FEEDBACK_URI, FEEDBACK_JSON,
                200, EXPECTED_RESPONSE_STRICT_JSON, true);
    }

}