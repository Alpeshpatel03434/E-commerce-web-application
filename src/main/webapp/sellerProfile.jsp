<%-- 
    Document   : sellerProfile
    Created on : 26-Dec-2022, 10:03:50 pm
    Author     : alpesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String SellerName = (String) session.getAttribute("Logged_Seller_Name");
    String MObileNumber = (String) session.getAttribute("Logged_Seller_MobileNumber");
    String Address = (String) session.getAttribute("Logged_Seller_Address");
    String Pincode = (String) session.getAttribute("Logged_Seller_Pincode");

    String SellerLogged = (String) session.getAttribute("Logged_Seller_Email");
    if (SellerLogged == null) {
        session.setAttribute("message", "you are not login");
        response.sendRedirect("Login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title><%= SellerName %>&ncsp;Profile</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        
        <%@include file="components/seller_navbar.jsp" %>
        <%@include file="components/error_message.jsp" %>
        <%@include file="components/message.jsp" %>
        
         <div class="container">
            <div class="row mt-3">
                <div class="col-md-6 offset-md-4">
                    <div class="card">
                        <div class="card-body">
                            <div class="header text-center">
                            <h4>Seler Profile</h4>    
                            </div>
                             <form action="UserDataUpdateServlet" method="post">
                                <div class="form-group">
                                    <label for="SellerName">Seller Name</label>
                                    <input type="text" class="form-control" id="SellerName" value="<%= SellerName%>" name="Seller_Name" placeholder="Enter Name here">
                                </div>

                                <div class="form-group">
                                    <label for="SellerEmail">User Email</label>
                                    <input type="email" class="form-control" id="SellerEmail" value="<%= SellerLogged%>" name="Seller_Email" placeholder="Enter Email here">
                                </div>

                                <div class="form-group">
                                    <label for="SellerMobileNumber">User Mobile Number</label>
                                    <input type="tel" class="form-control" id="SellerMobileNumber" value="+91 <%= MObileNumber%>"  name="Seller_MobileNumber"   placeholder="Enter Mobile number here">
                                </div>

                                <div class="form-group">
                                    <label for="SellerAddress">User Address</label>
                                    <input style="height: 100px" class="form-control" value="<%= Address%>" name="Seller_Address" id="SellerAddress" placeholder="Enter Address here">
                                </div>

                                <div class="form-group">
                                    <label for="SellerPincode">User Pincode</label>
                                    <input type="text" class="form-control" id="SellerPincode" value="<%= Pincode%>" name="Seller_Pincode" placeholder="Enter Pincode here">
                                </div>

                                <div class="container text-center">
                                    <button type="submit" class="btn btn-success">Update</button>
                                    <!--                                    &nbsp;
                                                                        <button type="button" class="btn btn-warning"><a href="OrderNow.jsp">Order Now</a></button>-->
                                </div>

                            </form>
                                
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
            
    </body>
</html>
