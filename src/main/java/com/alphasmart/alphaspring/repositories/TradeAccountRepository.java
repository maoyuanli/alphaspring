package com.alphasmart.alphaspring.repositories;

import com.alphasmart.alphaspring.entities.TradeAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TradeAccountRepository extends CrudRepository<TradeAccount, Long> {
    Optional<TradeAccount> findTradeAccountByAccountNo(String accountNo);
}
