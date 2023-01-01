<%-- 
    Document   : Checkout
    Created on : 31-Dec-2022, 12:03:37 am
    Author     : alpesh
--%>

<%
    String UserName = (String) session.getAttribute("Logged_User_Name");
    String MObileNumber = (String) session.getAttribute("Logged_User_MobileNumber");
    String Address = (String) session.getAttribute("Logged_User_Address");
    String Pincode = (String) session.getAttribute("Logged_User_Pincode");

    String userLogged = (String) session.getAttribute("Logged_User_Email");
    if (userLogged == null) {
        session.setAttribute("message", "you are not login");
        response.sendRedirect("Login.jsp");
        return;
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        <%@include file="components/user_navbar.jsp" %>
        <%@include file="components/error_message.jsp" %>
        <%@include file="components/message.jsp" %>

        <div class="container">
            <div class="row mt-5">
                <div class="col-md-6">
                    <!--Cart-->

                    <div class="card">
                        <h3 class="text-center mb-4 mt-2">Selected Items</h3>
                        <div class="card-body">
                            <div class="cart-body">

                            </div>
                        </div>
                        <div class="card-footer">
                            <form action="OrderNowServlet" method="post">

                                   
                                <label class="mx-4 mt-2" style="font-weight: bold; font-size: 22; color: blue" for="flexRadioDefault1">Please Select Payment Mode</label>
                                    <div style="display: flex; align-content: center;">
                                         
                                    <div class="text-center mt-2 mx-2 payment-option-selction" style="height:12%; width: 80px" id="div-user_PaymentMode1">
                                    <input class="form-check-input" type="radio" onchange="PaymentOptionSelect()" style="display: none" value="COD" name="user_PaymentMode" id="user_PaymentMode1">
                                    <label class="form-check-label" for="user_PaymentMode1">
                                        Cash On Delivery
                                    </label>
                                </div>
                                    
                                <div class="text-center mt-2 mx-2 payment-option-selction" style="height:12%; width: 140px" onchange="PaymentOptionSelect()" id="div-user_PaymentMode2">
                                    <input class="form-check-input" type="radio" value="Online" style="display: none" name="user_PaymentMode" id="user_PaymentMode2">
                                    <label class="form-check-label" for="user_PaymentMode2">
                                        Online Payment Gateway
                                    </label>
                                </div>
                                    </div>
                                    <input type="text" value="Checkout" style="display: none" name="CheckoutPage">

<!--                                    <input type="text" value="${Items}" style="display: none" name="itemsdata">-->
                                    
                                <div class="container text-center mt-3">
                                    <button type="Submit" onchange="handleOrderNow()" class="btn btn-primary">Order Now</button>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">

                    <div class="cart">
                        <div class="card-body">

                            <h3>Your Details for Order</h3>
                            <form action="UserDataUpdateServlet" method="post">
                                <div class="form-group">
                                    <label for="userName">User Name</label>
                                    <input type="text" class="form-control" id="userName" value="<%= UserName%>" name="user_Name" placeholder="Enter Name here">
                                </div>

                                <div class="form-group">
                                    <label for="userEmail">User Email</label>
                                    <input type="email" class="form-control" id="userEmail" value="<%= userLogged%>" name="user_Email" placeholder="Enter Email here">
                                </div>

                                <div class="form-group">
                                    <label for="userMobileNumber">User Mobile Number</label>
                                    <input type="tel" class="form-control" id="userMobileNumber" value="+91 <%= MObileNumber%>"  name="user_MobileNumber"   placeholder="Enter Mobile number here">
                                </div>

                                <div class="form-group">
                                    <label for="userAddress">User Address</label>
                                    <input style="height: 100px" class="form-control" value="<%= Address%>" name="user_Address" id="userAddress" placeholder="Enter Address here">
                                </div>

                                <div class="form-group">
                                    <label for="userPincode">User Pincode</label>
                                    <input type="text" class="form-control" id="userPincode" value="<%= Pincode%>" name="user_Pincode" placeholder="Enter Pincode here">
                                </div>
                                
                                 <input type="text" value="UserProfilePage" name="UserProfilePage" style="display: none;">

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


        <div id="snackbar">Some text some message..</div>
        <%@include file="components/common_modal.jsp" %>

    </body>
</html>
