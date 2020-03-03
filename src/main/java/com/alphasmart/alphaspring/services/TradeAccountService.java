package com.alphasmart.alphaspring.services;

import com.alphasmart.alphaspring.entities.TradeAccount;
import com.alphasmart.alphaspring.repositories.TradeAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TradeAccountService {

    private TradeAccountRepository tradeAccountRepository;

    @Autowired
    public TradeAccountService(TradeAccountRepository tradeAccountRepository) {
        this.tradeAccountRepository = tradeAccountRepository;
    }

    public TradeAccount save(TradeAccount tradeAccount) {
        return tradeAccountRepository.save(tradeAccount);
    }

    public Optional<TradeAccount> findTradeAccountByAccountNo(String accountNo) {
        return tradeAccountRepository.findTradeAccountByAccountNo(accountNo);
    }
}
