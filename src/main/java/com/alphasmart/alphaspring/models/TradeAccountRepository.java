package com.alphasmart.alphaspring.models;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TradeAccountRepository extends CrudRepository <TradeAccount, Long>{
    Optional<TradeAccount> findTradeAccountByAccountNo(String accountNo);
}
