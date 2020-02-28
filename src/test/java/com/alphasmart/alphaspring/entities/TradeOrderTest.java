package com.alphasmart.alphaspring.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TradeOrderTest {

    private final String LIMITED_ORDER = "{\n" +
            "\t\"order\":\n" +
            "\t{\n" +
            "\t    \"ticker\": \"Mao Technology\",\n" +
            "\t    \"order_type\": \"Limited Buy\",\n" +
            "\t    \"order_price\": \"2210.0\",\n" +
            "\t    \"order_volumn\": \"855000\"\n" +
            "\t}\n" +
            "}";

    private final String MARKET_ORDER = "{\n" +
            "\t\"order\":\n" +
            "\t{\n" +
            "\t    \"ticker\": \"Mao Technology\",\n" +
            "\t    \"order_type\": \"Market Buy\",\n" +
            "\t    \"order_price\": null,\n" +
            "\t    \"order_volumn\": \"855000\"\n" +
            "\t}\n" +
            "}";


    @Test
    void testUnpackingLimitedOrder() throws IOException {
        TradeOrder tradeOrder = new ObjectMapper()
                .readerFor(TradeOrder.class)
                .readValue(LIMITED_ORDER);

        assertEquals("Mao Technology",tradeOrder.getTicker());
        assertEquals("Limited Buy",tradeOrder.getOrderType());
        assertEquals("2210.0",tradeOrder.getOrderPrice());
        assertEquals("855000", tradeOrder.getOrderVolumn());
    }

    @Test
    void testUnpackingMarketOrder() throws IOException {
        TradeOrder tradeOrder = new ObjectMapper()
                .readerFor(TradeOrder.class)
                .readValue(MARKET_ORDER);

        assertEquals("Mao Technology",tradeOrder.getTicker());
        assertEquals("Market Buy",tradeOrder.getOrderType());
        assertNull(tradeOrder.getOrderPrice());
        assertEquals("855000", tradeOrder.getOrderVolumn());
    }
}