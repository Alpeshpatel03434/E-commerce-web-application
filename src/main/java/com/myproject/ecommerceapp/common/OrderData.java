/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.ecommerceapp.common;

/**
 *
 * @author alpesh
 */

public class OrderData {
    
    public int OrderId;
    public int UserId;
    public int SellerId;
    public int ProductId; 
    public String ProductName;
    public String Discount;
    public String Paid;
    public String PaymentStatus;
    public String Deliver;
    public String Created_time;

    public OrderData() {
    }

    public OrderData(int OrderId, int UserId, int SellerId, int ProductId, String ProductName, String Discount, String Paid, String PaymentStatus, String Deliver, String Created_time) {
        this.OrderId = OrderId;
        this.UserId = UserId;
        this.SellerId = SellerId;
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.Discount = Discount;
        this.Paid = Paid;
        this.PaymentStatus = PaymentStatus;
        this.Deliver = Deliver;
        this.Created_time = Created_time;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getSellerId() {
        return SellerId;
    }

    public void setSellerId(int SellerId) {
        this.SellerId = SellerId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String Discount) {
        this.Discount = Discount;
    }

    public String getPaid() {
        return Paid;
    }

    public void setPaid(String Paid) {
        this.Paid = Paid;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String PaymentStatus) {
        this.PaymentStatus = PaymentStatus;
    }

    public String getDeliver() {
        return Deliver;
    }

    public void setDeliver(String Deliver) {
        this.Deliver = Deliver;
    }

    public String getCreated_time() {
        return Created_time;
    }

    public void setCreated_time(String Created_time) {
        this.Created_time = Created_time;
    }

    @Override
    public String toString() {
        return "OrderData{" + "OrderId=" + OrderId + ", UserId=" + UserId + ", SellerId=" + SellerId + ", ProductId=" + ProductId + ", ProductName=" + ProductName + ", Discount=" + Discount + ", Paid=" + Paid + ", PaymentStatus=" + PaymentStatus + ", Deliver=" + Deliver + ", Created_time=" + Created_time + '}';
    }

    
    
}
