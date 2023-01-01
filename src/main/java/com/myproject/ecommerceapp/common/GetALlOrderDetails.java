/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.ecommerceapp.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alpesh
 */
public class GetALlOrderDetails {

    List<OrderData> OrderLst = new ArrayList<>();
    Connection conn = null;

    public List<OrderData> getUserAllOderHistory(int UserId) {
        try {
            List<OrderData> OrderList = new ArrayList<>();
            conn = Config.getConnection();

            if (conn != null) {

                String Query = "Select OrderId, UserId, SellerId, ProductId, ProductName, Discount, Paid, PaymentStatus, Deliver, Created_time from userOrders Where Deliver='Yes' and UserId='"+UserId+"'";

                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement(Query);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {

                    OrderData obj = new OrderData();
                    obj.setOrderId(rs.getInt("OrderId"));
                    obj.setUserId(rs.getInt("UserId"));
                    obj.setSellerId(rs.getInt("SellerId"));
                    obj.setProductId(rs.getInt("ProductId"));
                    obj.setProductName(rs.getString("ProductName"));

                    if (rs.getString("Discount").equals("") || rs.getString("Discount").equals(null)) {
                        obj.setDiscount("1");
                    } else {
                        obj.setDiscount(rs.getString("Discount"));
                    }

                    if (rs.getString("Paid").equals("") || rs.getString("Paid").equals(null)) {
                        obj.setPaid("0");
                    } else {
                        obj.setPaid(rs.getString("Paid"));
                    }

                    obj.setPaymentStatus(rs.getString("PaymentStatus"));
                    obj.setDeliver(rs.getString("Deliver"));
                    obj.setCreated_time(rs.getString("Created_time"));

                    OrderList.add(obj);
                }

                return OrderList;

            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {

        }

        return null;
    }

      public List<OrderData> getUserAllPendingOrders(int UserId) {
        try {
            List<OrderData> OrderList = new ArrayList<>();
            conn = Config.getConnection();

            if (conn != null) {

                String Query = "Select OrderId, UserId, SellerId, ProductId, ProductName, Discount, Paid, PaymentStatus, Deliver, Created_time from userOrders Where Deliver='No' and UserId='"+UserId+"'";

                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement(Query);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {

                    OrderData obj = new OrderData();
                    obj.setOrderId(rs.getInt("OrderId"));
                    obj.setUserId(rs.getInt("UserId"));
                    obj.setSellerId(rs.getInt("SellerId"));
                    obj.setProductId(rs.getInt("ProductId"));
                    obj.setProductName(rs.getString("ProductName"));

                    if (rs.getString("Discount").equals("") || rs.getString("Discount").equals(null)) {
                        obj.setDiscount("1");
                    } else {
                        obj.setDiscount(rs.getString("Discount"));
                    }

                    if (rs.getString("Paid").equals("") || rs.getString("Paid").equals(null)) {
                        obj.setPaid("0");
                    } else {
                        obj.setPaid(rs.getString("Paid"));
                    }

                    obj.setPaymentStatus(rs.getString("PaymentStatus"));
                    obj.setDeliver(rs.getString("Deliver"));
                    obj.setCreated_time(rs.getString("Created_time"));

                    OrderList.add(obj);
                }

                return OrderList;

            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {

        }

        return null;
    }
    
    
    
    public List<OrderData> getSellerOrdershistory(int SellerId) {
        try {
            List<OrderData> OrderList = new ArrayList<>();
            conn = Config.getConnection();

            if (conn != null) {

                String Query = "Select OrderId, UserId, SellerId, ProductId, ProductName, Discount, Paid, PaymentStatus, Deliver, Created_time from userOrders Where Deliver='Yes' and SellerId='"+SellerId+"'";

                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement(Query);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {

                    OrderData obj = new OrderData();
                    obj.setOrderId(rs.getInt("OrderId"));
                    obj.setUserId(rs.getInt("UserId"));
                    obj.setSellerId(rs.getInt("SellerId"));
                    obj.setProductId(rs.getInt("ProductId"));
                    obj.setProductName(rs.getString("ProductName"));

                    if (rs.getString("Discount").equals("") || rs.getString("Discount").equals(null)) {
                        obj.setDiscount("1");
                    } else {
                        obj.setDiscount(rs.getString("Discount"));
                    }

                    if (rs.getString("Paid").equals("") || rs.getString("Paid").equals(null)) {
                        obj.setPaid("0");
                    } else {
                        obj.setPaid(rs.getString("Paid"));
                    }

                    obj.setPaymentStatus(rs.getString("PaymentStatus"));
                    obj.setDeliver(rs.getString("Deliver"));
                    obj.setCreated_time(rs.getString("Created_time"));

                    OrderList.add(obj);
                }

                return OrderList;

            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {

        }

        return null;
    }
    
    
}
