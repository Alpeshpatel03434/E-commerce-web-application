/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.ecommerceapp.entites;

import javax.persistence.Entity;

/**
 *
 * @author alpes
 */

@Entity
public class Product {
    
    private int productId;
    private int sellerId;
    private String Productcategory;
    private String productName;
    private String productImage;
    private String productDesc;
    private float productDiscount;
    private String productPrice;
    private int productQuantity;

    public Product(int productId, int sellerId, String Productcategory, String productName, String productImage, String productDesc, float productDiscount, String productPrice, int productQuantity) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.Productcategory = Productcategory;
        this.productName = productName;
        this.productImage = productImage;
        this.productDesc = productDesc;
        this.productDiscount = productDiscount;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public Product(int sellerId, String Productcategory, String productName, String productImage, String productDesc, float productDiscount, String productPrice, int productQuantity) {
        this.sellerId = sellerId;
        this.Productcategory = Productcategory;
        this.productName = productName;
        this.productImage = productImage;
        this.productDesc = productDesc;
        this.productDiscount = productDiscount;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getProductcategory() {
        return Productcategory;
    }

    public void setProductcategory(String Productcategory) {
        this.Productcategory = Productcategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public float getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(float productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", sellerId=" + sellerId + ", Productcategory=" + Productcategory + ", productName=" + productName + ", productImage=" + productImage + ", productDesc=" + productDesc + ", productDiscount=" + productDiscount + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + '}';
    }

    
    
}
