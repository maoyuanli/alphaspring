package com.alphasmart.alphaspring.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class TradeAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNo;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tradeAccount")
    private List<TradeOrder> tradeOrders;

    @JsonProperty("tradeaccount")
    private void unpackRawTradeAccount(Map<String, Object> account){
        this.accountNo = (String) account.get("account_no");
    }

    protected TradeAccount(){}

    public TradeAccount(Long id, String accountNo, List<TradeOrder> tradeOrders){
        this.id = id;
        this.accountNo = accountNo;
        this.tradeOrders = tradeOrders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public List<TradeOrder> getTradeOrders() {
        return tradeOrders;
    }

    public void setTradeOrders(List<TradeOrder> tradeOrders) {
        this.tradeOrders = tradeOrders;
    }
}
