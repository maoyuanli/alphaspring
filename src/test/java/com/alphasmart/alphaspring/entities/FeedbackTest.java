package com.alphasmart.alphaspring.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeedbackTest {

    private final String SOURCE_JSON = "{\n" +
            "\t\"feedback\": \n" +
            "\t\t{\n" +
            "            \"name\": \"John Snow\",\n" +
            "            \"email\": \"jsnow@postman.com\",\n" +
            "            \"phone\": \"1212333\",\n" +
            "            \"comment\": \"from postman test\"\n" +
            "        }\n" +
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