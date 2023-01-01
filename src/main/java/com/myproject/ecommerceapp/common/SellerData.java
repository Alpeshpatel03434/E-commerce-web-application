/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.ecommerceapp.common;

/**
 *
 * @author alpesh
 */
public class SellerData {
    
    public int sellerId;
    public String sellerName;
    public String sellerImage;
    public String sellerEmail;
    public String sellerMobileNumber;
    public String sellerPassword;
    public String sellerAddress;
    public String sellerPincode;
    public String sellerAccountStatus;
    public String CreatedTime;

    public SellerData() {
    }

    public SellerData(int sellerId, String sellerName, String sellerImage, String sellerEmail, String sellerMobileNumber, String sellerPassword, String sellerAddress, String sellerPincode, String sellerAccountStatus, String CreatedTime) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerImage = sellerImage;
        this.sellerEmail = sellerEmail;
        this.sellerMobileNumber = sellerMobileNumber;
        this.sellerPassword = sellerPassword;
        this.sellerAddress = sellerAddress;
        this.sellerPincode = sellerPincode;
        this.sellerAccountStatus = sellerAccountStatus;
        this.CreatedTime = CreatedTime;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerImage() {
        return sellerImage;
    }

    public void setSellerImage(String sellerImage) {
        this.sellerImage = sellerImage;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getSellerMobileNumber() {
        return sellerMobileNumber;
    }

    public void setSellerMobileNumber(String sellerMobileNumber) {
        this.sellerMobileNumber = sellerMobileNumber;
    }

    public String getSellerPassword() {
        return sellerPassword;
    }

    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public String getSellerPincode() {
        return sellerPincode;
    }

    public void setSellerPincode(String sellerPincode) {
        this.sellerPincode = sellerPincode;
    }

    public String getSellerAccountStatus() {
        return sellerAccountStatus;
    }

    public void setSellerAccountStatus(String sellerAccountStatus) {
        this.sellerAccountStatus = sellerAccountStatus;
    }

    public String getCreatedTime() {
        return CreatedTime;
    }

    public void setCreatedTime(String CreatedTime) {
        this.CreatedTime = CreatedTime;
    }

    @Override
    public String toString() {
        return "SellerData{" + "sellerId=" + sellerId + ", sellerName=" + sellerName + ", sellerImage=" + sellerImage + ", sellerEmail=" + sellerEmail + ", sellerMobileNumber=" + sellerMobileNumber + ", sellerPassword=" + sellerPassword + ", sellerAddress=" + sellerAddress + ", sellerPincode=" + sellerPincode + ", sellerAccountStatus=" + sellerAccountStatus + ", CreatedTime=" + CreatedTime + '}';
    }
    
    
}
