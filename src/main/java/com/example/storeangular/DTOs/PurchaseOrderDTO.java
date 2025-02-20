package com.example.storeangular.DTOs;

import com.example.storeangular.entities.PurchaseOrder;

import java.math.BigDecimal;
import java.time.Instant;


public class PurchaseOrderDTO {
    private Integer id;
    private Integer user_id;
    private Instant order_date;
    private BigDecimal total_price;

    public PurchaseOrderDTO(){}

    public PurchaseOrderDTO(PurchaseOrder po){
        this.id = po.getId();
        this.user_id = po.getUser().getId();
        this.order_date = po.getOrderDate();
        this.total_price = po.getTotalPrice();
    }

    // Getters setters

    public Integer getId() {
        return id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Instant getOrder_date() {
        return order_date;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setOrder_date(Instant order_date) {
        this.order_date = order_date;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }
}
