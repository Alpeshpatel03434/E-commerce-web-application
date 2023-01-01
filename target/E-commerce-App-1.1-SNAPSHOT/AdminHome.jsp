<%-- 
    Document   : AdminHome
    Created on : 01-Jan-2023, 1:35:52 pm
    Author     : alpesh
--%>

<%@page import="com.myproject.ecommerceapp.common.SellerData"%>
<%@page import="com.myproject.ecommerceapp.common.UserData"%>
<%@page import="java.util.List"%>
<%@page import="com.myproject.ecommerceapp.common.GetAllUserSellerData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin-Home</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>
        <%@include file="components/error_message.jsp" %>
        <%@include file="components/message.jsp" %>

        <div class="container">

            <div class="row mt-3">
                <div class="md-6">
                    <div class="card">
                        <div class="card-body">

                            <div class="card-title text-center">
                                <h3>Users & Seller Management</h3>
                            </div>
                            <%                               
                                String UserType1 = (String) session.getAttribute("Admin");
//
//                                if (UserType != null) {
                                    GetAllUserSellerData obj = new GetAllUserSellerData();
                                    List<UserData> lst = obj.getAllUsersdata();

                                    if (UserType1.equalsIgnoreCase("User")) {
                            %>
                            
                            <table class='table'>
                                <thead class='thread-light'>
                                    <tr>
                                        <th>UserId</th>
                                        <th>UserName</th> 
                                        <th>Email</th> 
                                        <th>Mobile number</th> 
                                        <th>Address</th> 
                                        <th>Pincode</th>
                                        <th>Account Status</th>
                                        <th>Created Time</th>
                                        <th>Action1</th>
                                        <th>Action2</th>
                                    </tr>
                                </thead>
                               <%
                                   for (UserData u : lst) {
                               %>
                               
                               <tr>
                                   <td><%= u.getUserId() %></td>
                                    <td><%= u.getUserName()%></td>
                                    <td><%= u.getUserEmail()%></td>
                                    <td><%= u.getUserMobileNumber()%></td>
                                    <td><%= u.getUserAddress()%></td>
                                    <td><%= u.getUserPincode()%></td>
                                    <td><%= u.getUserAccountStatus()%></td>
                                    <td><%= u.getCreatedTime()%></td>
                                   <%
                                        if (u.getUserAccountStatus().equalsIgnoreCase("Accepted")) {
                                    %>
                                    <td><button onclick='' class="btn btn-danger btn-sm">Deactivate</button></td>
                                    <%
                                    } else {
                                    %>
                                    <td><button onclick='' disabled=true class="btn btn-danger btn-sm">Deactivate</button></td>
                                    <%
                                        } %>
                                        
                                        <%
                                         if (u.getUserAccountStatus().equalsIgnoreCase("Cancelled")) {
                                    %>
                                    <td><button onclick='' class="btn btn-success btn-sm">Active</button></td>
                                    <%
                                    } else {
                                    %>
                                    <td><button onclick='' disabled=true class="btn btn-success btn-sm">Active</button></td>
                                    <%
                                        }
                                    %>

                                        
                                </tr>

                               
                               <% } 
                               %>
                                <tr><td colspan='7' class='text-right font-weight-bold m-5'> Toal Users : <%= lst.size() %> </td></tr>
                            </table>
                            
                            <%
                                }
                            %>
                            
                            
                             <%                               
                                String UserType2 = (String) session.getAttribute("Admin");
//
//                                if (UserType != null) {
                                    List<SellerData> lst2 = obj.getAllSellerdata();

                                    if (UserType2.equalsIgnoreCase("Seller")) {
                            %>
                            
                            <table class='table'>
                                <thead class='thread-light'>
                                    <tr>
                                        <th>SellerId</th>>
                                        <th>Seller Name</th> 
                                        <th>Email</th> 
                                        <th>Mobile number</th> 
                                        <th>Address</th> 
                                        <th>Pincode</th>
                                        <th>Account Status</th>
                                        <th>Created Time</th>
                                        <th>Action1</th>
                                        <th>Action2</th>
                                    </tr>
                                </thead>
                               <%
                                   for (SellerData s : lst2) {
                               %>
                               
                               <tr>
                                   <td><%= s.getSellerId() %></td>>
                                    <td><%= s.getSellerName() %></td>
                                    <td><%= s.getSellerEmail() %></td>
                                    <td><%= s.getSellerMobileNumber() %></td>
                                    <td><%= s.getSellerAddress() %></td>
                                    <td><%= s.getSellerPincode() %></td>
                                    <td><%= s.getSellerAccountStatus() %></td>
                                    <td><%= s.getCreatedTime() %></td>
                                   <%
                                        if (s.getSellerAccountStatus().equalsIgnoreCase("Accepted")) {
                                    %>
                                    <td><button onclick='' class="btn btn-danger btn-sm">Deactivate</button></td>
                                    <%
                                    } else {
                                    %>
                                    <td><button onclick='' disabled=true class="btn btn-danger btn-sm">Deactivate</button></td>
                                    <%
                                        } %>
                                        
                                        <%
                                         if (s.getSellerAccountStatus().equalsIgnoreCase("Cancelled")) {
                                    %>
                                    <td><button onclick='' class="btn btn-success btn-sm">Active</button></td>
                                    <%
                                    } else {
                                    %>
                                    <td><button onclick='' disabled=true class="btn btn-success btn-sm">Active</button></td>
                                    <%
                                        }
                                    %>

                                        
                                </tr>

                               
                               <% } 
                               %>
                                <tr><td colspan='7' class='text-right font-weight-bold m-5'> Toal Users : <%= lst2.size() %> </td></tr>
                            </table>
                            
                            <%
                                }
                            %>
                            

                        </div>
                    </div>
                </div> 

            </div>

        </div>

    </body>
</html>

