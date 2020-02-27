package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.entities.TradeAccount;
import com.alphasmart.alphaspring.services.TradeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TradeAccountController {
    @Autowired
    TradeAccountService tradeAccountService;

    @PostMapping("api/setaccount")
    public TradeAccount newTradeAccount(@RequestBody TradeAccount tradeAccount) {
        return tradeAccountService.save(tradeAccount);
    }

    @GetMapping("api/getaccount")
    public String findByAccountNo(@RequestParam String accountNo) {
        Optional<TradeAccount> tradeAccount =
                tradeAccountService.findTradeAccountByAccountNo(accountNo);

        return String.format("{ \"trade_account\": { \"account_no\":\"%s\"}"
                , tradeAccount.get().getAccountNo());

    }
}
