<%-- 
    Document   : userProfile
    Created on : 26-Dec-2022, 10:02:58 pm
    Author     : alpesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= UserName %>&ncsp;Profile</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        <%@include file="components/user_navbar.jsp" %>
        <%@include file="components/error_message.jsp" %>
        <%@include file="components/message.jsp" %>

        
        <div class="container">
            <div class="row mt-3">
                <div class="col-md-6 offset-md-4">
                    <div class="card">
                        <div class="card-body">
                            
                            <div class="header text-center">
                            <h4>User Profile</h4>    
                            </div>
                            
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
        
    </body>
    
    
        <div id="snackbar">Some text some message..</div>
        <%@include file="components/common_modal.jsp" %>

</html>
