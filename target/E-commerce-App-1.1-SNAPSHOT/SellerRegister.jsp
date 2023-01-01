<%-- 
    Document   : SellerRegister
    Created on : 26-Dec-2022, 1:20:32 am
    Author     : alpesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>SignUp/New Seller Registration</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        
         <%@include file="components/navbar.jsp" %>

        <div class="container-fluid">
            
            <div class="row mt-5">
            <div class="col-md-6 offset-md-3">

                <div class="card">
                    <%@include file="components/message.jsp" %>
                    <div class="card-body px-4">

                        <span>
                            <img src="img/signupIcon.svg" class="rounded mx-auto d-block" style="height: 100px; width: 50%; margin-left: auto;
  margin-right: auto;" alt="...">
                        </span>
                        
                        
                        <h3 class="text-center my-3">New Seller/Sign up</h3>

                        <form action="RegisterServlet" method="post">
                            <div class="form-group">
                                <label for="userName">User Name</label>
                                <input type="text" class="form-control" id="userName" name="user_Name" placeholder="Enter Name here">
                            </div>

                            <div class="form-group">
                                <label for="userEmail">User Email</label>
                                <input type="email" class="form-control" id="userEmail" name="user_Email" placeholder="Enter Email here">
                            </div>

                            <div class="form-group">
                                <label for="userMobileNumber">User Mobile Number</label>
                                <input type="tel" class="form-control" id="userMobileNumber"  name="user_MobileNumber"   placeholder="Enter Mobile number here">
                            </div>

                            <div class="form-group">
                                <label for="userPassword">User Password</label>
                                <input type="password" class="form-control" id="userPassword" name="user_Password" placeholder="Enter Password here">
                            </div>

                            <div class="form-group">
                                <label for="userAddress">User Address</label>
                                <textarea style="height: 100px" class="form-control" name="user_Address" id="userAddress" placeholder="Enter Address here"></textarea>
                            </div>

                            <div class="form-group">
                                <label for="userPincode">User Pincode</label>
                                <input type="text" class="form-control" id="userPincode" name="user_Pincode" placeholder="Enter Pincode here">
                            </div>

                            <div class="container text-center">
                                <button type="submit" class="btn btn-success">SignUp</button>
                                &nbsp;
                                <button type="reset" class="btn btn-warning">Reset</button>
                            </div>

                        </form>

                        <div class="padding-top: 10px; container text-center">
                            <p style="color:red; font-size:100%;">Have an Account Already? <a href="Login.jsp">Login</a></p>
                        </div>


                    </div>
                </div>

            </div>
        </div>
            
        </div>

        
    </body>
</html>
