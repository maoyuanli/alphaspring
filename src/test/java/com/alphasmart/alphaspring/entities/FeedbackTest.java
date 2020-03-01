package com.alphasmart.alphaspring.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeedbackTest {

    private final String SOURCE_JSON = "{" +
            "\"feedback\": " +
            "{" +
            "\"name\": \"John Snow\"," +
            "\"email\": \"jsnow@postman.com\"," +
            "\"phone\": \"1212333\"," +
            "\"comment\": \"from postman test\"" +
            "}" +
            "}";

    @Test
    public void testUnpacking() throws IOException {
        Feedback feedback = new ObjectMapper().readerFor(Feedback.class).readValue(SOURCE_JSON);
        assertEquals("John Snow",feedback.getName());
        assertEquals("jsnow@postman.com",feedback.getEmail());
        assertEquals("1212333",feedback.getPhone());
        assertEquals("from postman test",feedback.getComment());
    }
}