package com.example.storeangular.DTOs;

import com.example.storeangular.entities.ShoppingCart;

import java.math.BigDecimal;

public class ShoppingCartDTO {
    private String productName;
    private String image;
    private BigDecimal price;
    private int quantity;

    ShoppingCartDTO(ShoppingCart cart){
        this.productName = cart.getProduct().getName();
        this.price = cart.getProduct().getPrice();
        this.image = cart.getProduct().getImage();
        this.quantity = cart.getQuantity();
    }

    // Getters and setters

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
