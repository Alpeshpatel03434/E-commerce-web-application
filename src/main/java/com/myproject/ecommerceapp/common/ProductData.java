/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.ecommerceapp.common;

/**
 *
 * @author alpes
 */
public class ProductData {
    
    public int ProductId;
    public int SellerId;
    public String ProductCategory;
    public String ProductName;
    public String ProductImage;
    public String ProductDescription;
    public String ProductDiscount;
    public String ProductPrice;
    public int ProductQuantity;
    public String ProductCreatedDate;

    public ProductData() {
    }

    public ProductData(int ProductId, int SellerId, String ProductCategory, String ProductName, String ProductImage, String ProductDescription, String ProductDiscount, String ProductPrice, int ProductQuantity, String ProductCreatedDate) {
        this.ProductId = ProductId;
        this.SellerId = SellerId;
        this.ProductCategory = ProductCategory;
        this.ProductName = ProductName;
        this.ProductImage = ProductImage;
        this.ProductDescription = ProductDescription;
        this.ProductDiscount = ProductDiscount;
        this.ProductPrice = ProductPrice;
        this.ProductQuantity = ProductQuantity;
        this.ProductCreatedDate = ProductCreatedDate;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public int getSellerId() {
        return SellerId;
    }

    public void setSellerId(int SellerId) {
        this.SellerId = SellerId;
    }

    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String ProductCategory) {
        this.ProductCategory = ProductCategory;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductImage() {
        return ProductImage;
    }

    public void setProductImage(String ProductImage) {
        this.ProductImage = ProductImage;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String ProductDescription) {
        this.ProductDescription = ProductDescription;
    }

    public String getProductDiscount() {
        return ProductDiscount;
    }

    public void setProductDiscount(String ProductDiscount) {
        this.ProductDiscount = ProductDiscount;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(int ProductQuantity) {
        this.ProductQuantity = ProductQuantity;
    }

    public String getProductCreatedDate() {
        return ProductCreatedDate;
    }

    public void setProductCreatedDate(String ProductCreatedDate) {
        this.ProductCreatedDate = ProductCreatedDate;
    }

    @Override
    public String toString() {
        return "ProductData{" + "ProductId=" + ProductId + ", SellerId=" + SellerId + ", ProductCategory=" + ProductCategory + ", ProductName=" + ProductName + ", ProductImage=" + ProductImage + ", ProductDescription=" + ProductDescription + ", ProductDiscount=" + ProductDiscount + ", ProductPrice=" + ProductPrice + ", ProductQuantity=" + ProductQuantity + ", ProductCreatedDate=" + ProductCreatedDate + '}';
    }

    
    
}
