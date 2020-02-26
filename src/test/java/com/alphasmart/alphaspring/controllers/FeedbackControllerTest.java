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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
class FeedbackControllerTest {
    @Autowired
    WebApplicationContext webApplicationContext;

    private final String FEEDBACK_JSON = "{\n" +
            "\t\"feedback\": \n" +
            "\t\t{\n" +
            "            \"name\": \"John Snow\",\n" +
            "            \"email\": \"jsnow@postman.com\",\n" +
            "            \"phone\": \"1212333\",\n" +
            "            \"comment\": \"from postman test\"\n" +
            "        }\n" +
            "}";

    private final String EXPECTED_FEEDBACK_RESPONSE = "{ \"success\": \"Feedback created successfully: John Snow | jsnow@postman.com | 1212333 | from postman test\"}";

    @Test
    void testPostFeedback() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/feedback";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(FEEDBACK_JSON)).andReturn();
        int responseStatus = mvcResult.getResponse().getStatus();
        String responseContent = mvcResult.getResponse().getContentAsString();
        assertEquals(200,responseStatus);
        assertEquals(EXPECTED_FEEDBACK_RESPONSE,responseContent);
        assertTrue(responseContent.contains("postman"));

    }

}