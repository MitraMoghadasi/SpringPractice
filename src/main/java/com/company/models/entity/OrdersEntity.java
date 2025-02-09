package com.company.models.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String orderDate;
    private BigDecimal amountValue;
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
