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
public class GetAllUserSellerData {

    List<UserData> userLst = new ArrayList<>();
    List<SellerData> sellerLst = new ArrayList<>();
   // Connection conn = null;

    public List<UserData> getAllUsersdata() {
        try {
            List<UserData> UserList = new ArrayList<>();
            Connection conn = null;
            conn = Config.getConnection();

            if (conn != null) {

                String Query = "Select UserId, Name, UserImage, Email, MobileNumber, Password, Address, Pincode, Account_Status, Created_time from `user`";

                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement(Query);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    UserData obj = new UserData();
                    obj.setUserId(rs.getInt("UserId"));
                    obj.setUserName(rs.getString("Name"));
                    obj.setUserImage(rs.getString("UserImage"));
                    obj.setUserEmail(rs.getString("Email"));
                    obj.setUserMobileNumber(rs.getString("MobileNumber"));
                    obj.setUserPassword(rs.getString("Password"));
                    obj.setUserAddress(rs.getString("Address"));
                    obj.setUserPincode(rs.getString("Pincode"));
                    obj.setUserAccountStatus(rs.getString("Account_Status"));
                    obj.setCreatedTime(rs.getString("Created_time"));

                    UserList.add(obj);
                }

                return UserList;

            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {

        }

        return null;
    }

    
    public List<SellerData> getAllSellerdata() {
        try {
            List<SellerData> SellerList = new ArrayList<>();
            Connection conn = null;
            conn = Config.getConnection();

            if (conn != null) {

                String Query = "Select sellerId, Name, SellerImage, Email, MobileNumber, Password, Address, Pincode, Account_Status, Created_time from seller";

                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement(Query);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {

                    SellerData obj = new SellerData();
                    obj.setSellerId(rs.getInt("sellerId"));
                    obj.setSellerName(rs.getString("Name"));
                    obj.setSellerImage(rs.getString("SellerImage"));
                    obj.setSellerEmail(rs.getString("Email"));
                    obj.setSellerMobileNumber(rs.getString("MobileNumber"));
                    obj.setSellerPassword(rs.getString("Password"));
                    obj.setSellerAddress(rs.getString("Address"));
                    obj.setSellerPincode(rs.getString("Pincode"));
                    obj.setSellerAccountStatus(rs.getString("Account_Status"));
                    obj.setCreatedTime(rs.getString("Created_time"));

                    SellerList.add(obj);
                }

                return SellerList;

            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {

        }

        return null;
    }

}
