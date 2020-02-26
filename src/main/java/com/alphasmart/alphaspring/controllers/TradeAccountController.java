package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.models.TradeAccount;
import com.alphasmart.alphaspring.models.TradeAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeAccountController {
    @Autowired
    TradeAccountRepository tradeAccountRepository;

    @PostMapping("api/setaccount")
    public TradeAccount newTradeAccount(@RequestBody TradeAccount tradeAccount){
        return tradeAccountRepository.save(tradeAccount);
    }
}
