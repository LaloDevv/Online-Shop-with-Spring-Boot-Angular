package com.example.storeangular.DTOs;

import com.example.storeangular.entities.ShoppingCart;

import java.math.BigDecimal;

public class ShoppingCartDTO {
    private String productName;
    private String image;
    private BigDecimal price;
    private int quantity;
    private int userID;
    private int productID;
    public ShoppingCartDTO(){}

    public ShoppingCartDTO(ShoppingCart cart){
        this.productName = cart.getProduct().getName();
        this.price = cart.getProduct().getPrice();
        this.image = cart.getProduct().getImage();
        this.quantity = cart.getQuantity();
        this.productID = cart.getProduct().getId();
        this.userID = cart.getUser().getId();
    }

    // Getters and setters


    public int getUserID() {
        return userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

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
