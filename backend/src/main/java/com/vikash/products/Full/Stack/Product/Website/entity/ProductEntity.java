package com.vikash.products.Full.Stack.Product.Website.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_table")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    private String productName;

    private Long productPrice;

    public ProductEntity() {
    }

    public ProductEntity(Long productID, String productName, Long productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }
}
