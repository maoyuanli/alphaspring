package com.alphasmart.alphaspring.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostRequestTestTemplate {

    @Autowired
    WebApplicationContext webApplicationContext;


    @Test
    public void testPostRequest(String postContent,int expectedStatus, List<String> expectedContentKeywords) throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/setuser";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(postContent)).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int responseStatus = response.getStatus();
        String responseContent = response.getContentAsString();
        assertEquals(expectedStatus,responseStatus);
        expectedContentKeywords.forEach(keyword->
                assertTrue(responseContent.contains(keyword))
        );
    }
}
