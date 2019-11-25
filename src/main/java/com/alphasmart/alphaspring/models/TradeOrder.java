package com.alphasmart.alphaspring.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TradeOrder {

    @Id
    @GeneratedValue
    private Integer id;
    private String ticker;
    private String companyName;
    private String orderType;
    private Double orderPrice;
    private Integer orderVolumn;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    protected TradeOrder() {
    }

    public TradeOrder(String ticker, String companyName, String orderType, Double orderPrice, Integer orderVolumn) {
        this.ticker = ticker;
        this.companyName = companyName;
        this.orderType = orderType;
        this.orderPrice = orderPrice;
        this.orderVolumn = orderVolumn;
    }

    public Integer getId() {
        return id;
    }

    public String getTicker() {
        return ticker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getOrderType() {
        return orderType;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public Integer getOrderVolumn() {
        return orderVolumn;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return "TradeOrder{" +
                "id=" + id +
                ", ticker='" + ticker + '\'' +
                ", companyName='" + companyName + '\'' +
                ", orderType=" + orderType +
                ", orderPrice=" + orderPrice +
                ", orderVolumn=" + orderVolumn +
                ", createdDate=" + createdDate +
                '}';
    }
}
