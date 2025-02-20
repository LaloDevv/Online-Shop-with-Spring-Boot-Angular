package com.example.storeangular.DTOs;

import com.example.storeangular.entities.PurchaseOrderDetail;

import java.math.BigDecimal;

public class PurchaseOrderDetailsDTO {
    private Integer id;
    private Integer purchase_order_id;
    private Integer product_id;
    private Integer quantity;
    private BigDecimal price;


    public PurchaseOrderDetailsDTO(){}

    public PurchaseOrderDetailsDTO(PurchaseOrderDetail poDetail){
        this.id = poDetail.getId();
        this.purchase_order_id = poDetail.getPurchaseOrder().getId();
        this.product_id = poDetail.getProduct().getId();
        this.quantity = poDetail.getQuantity();
        this.price = poDetail.getPrice();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPurchase_order_id(Integer purchase_order_id) {
        this.purchase_order_id = purchase_order_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPurchase_order_id() {
        return purchase_order_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
