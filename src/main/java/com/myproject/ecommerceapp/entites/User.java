/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.ecommerceapp.entites;

/**
 *
 * @author alpesh
 */

public class User {

    private int userId;
    private String userName;
    private String userImage;
    private String userEmail;
    private String userMobileNumber;
    private String userPassword;
    private String userAddress;
    private String userPincode;
    private String userAccountStatus;

    public User(int userId, String userName, String userImage, String userEmail, String userMobileNumber, String userPassword, String userAddress, String userPincode, String userAccountStatus) {
        this.userId = userId;
        this.userName = userName;
        this.userImage = userImage;
        this.userEmail = userEmail;
        this.userMobileNumber = userMobileNumber;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userPincode = userPincode;
        this.userAccountStatus = userAccountStatus;
    }

    public User(String userName, String userImage, String userEmail, String userMobileNumber, String userPassword, String userAddress, String userPincode, String userAccountStatus) {
        this.userName = userName;
        this.userImage = userImage;
        this.userEmail = userEmail;
        this.userMobileNumber = userMobileNumber;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userPincode = userPincode;
        this.userAccountStatus = userAccountStatus;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPincode() {
        return userPincode;
    }

    public void setUserPincode(String userPincode) {
        this.userPincode = userPincode;
    }

    public String getUserAccountStatus() {
        return userAccountStatus;
    }

    public void setUserAccountStatus(String userAccountStatus) {
        this.userAccountStatus = userAccountStatus;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", userImage=" + userImage + ", userEmail=" + userEmail + ", userMobileNumber=" + userMobileNumber + ", userPassword=" + userPassword + ", userAddress=" + userAddress + ", userPincode=" + userPincode + ", userAccountStatus=" + userAccountStatus + '}';
    }
    
    
    
}
