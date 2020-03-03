package com.alphasmart.alphaspring.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
public class TradeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticker;
    private String orderType;
    private String orderPrice;
    private String orderVolumn;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne
    private TradeAccount tradeAccount;

    @JsonProperty("order")
    private void unpackRawTradeOrder(Map<String, Object> order) {
        this.ticker = (String) order.get("ticker");
        this.orderType = (String) order.get("order_type");
        this.orderPrice = (String) order.get("order_price");
        this.orderVolumn = (String) order.get("order_volumn");
    }


    protected TradeOrder() {
    }

    public TradeOrder(String ticker, String orderType, String orderPrice, String orderVolumn) {
        this.ticker = ticker;
        this.orderType = orderType;
        this.orderPrice = orderPrice;
        this.orderVolumn = orderVolumn;
    }

    public Long getId() {
        return id;
    }

    public String getTicker() {
        return ticker;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public String getOrderVolumn() {
        return orderVolumn;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setOrderVolumn(String orderVolumn) {
        this.orderVolumn = orderVolumn;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public TradeAccount getTradeAccount() {
        return tradeAccount;
    }

    public void setTradeAccount(TradeAccount tradeAccount) {
        this.tradeAccount = tradeAccount;
    }

    @Override
    public String toString() {
        return "TradeOrder{" +
                "id=" + id +
                ", ticker='" + ticker + '\'' +
                ", orderType=" + orderType +
                ", orderPrice=" + orderPrice +
                ", orderVolumn=" + orderVolumn +
                ", createdDate=" + createdDate +
                '}';
    }
}
