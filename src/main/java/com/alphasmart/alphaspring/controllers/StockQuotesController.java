package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.services.StockQuotesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class StockQuotesController {

    @Autowired
    StockQuotesDataService stockQuotesDataService;

    @GetMapping("api/quote")
    public String featuredStocksQuote() {
        return stockQuotesDataService.getQuote();
    }


}
