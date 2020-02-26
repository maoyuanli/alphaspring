package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.models.TradeAccount;
import com.alphasmart.alphaspring.models.TradeAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TradeAccountController {
    @Autowired
    TradeAccountRepository tradeAccountRepository;

    @PostMapping("api/setaccount")
    public TradeAccount newTradeAccount(@RequestBody TradeAccount tradeAccount) {
        return tradeAccountRepository.save(tradeAccount);
    }

    @GetMapping("api/getaccount")
    public String findByAccountNo(@RequestParam String accountNo) {
        Optional<TradeAccount> tradeAccount =
                tradeAccountRepository.findTradeAccountByAccountNo(accountNo);

        return String.format("{ \"trade_account\": { \"account_no\":\"%s\"}"
                , tradeAccount.get().getAccountNo());

    }
}
