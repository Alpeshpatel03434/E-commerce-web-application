<%-- 
    Document   : Login
    Created on : 26-Dec-2022, 11:23:23 am
    Author     : alpesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>

        <%@include file="components/navbar.jsp" %>

        <div class="container">
            <div class="row">
                <div class="col-md-4 offset-md-4">

                    <div class="card mt-3" style="border: 1px solid greenyellow;">
                        <div class="card mt-3" style="border: 1px solid #673AB7;">
                            <%@include file="components/message.jsp" %>
                            <%@include file="components/error_message.jsp" %>
                            <div class="header custom-nav-bg text-white text-center pt-2">
                                <h4>Login here</h4>
                            </div>
                            <div class="card-body">

                                <br></br>
                                <form action="LoginServlet" method="post">

                                    <div class="form-group">
                                        <select name="utype">
                                            <option>User</option>
                                            <option>Seller</option>
                                        </select>

                                        <input type="radio" class="btn-check" name="user" id="success-outlined" autocomplete="off" checked>
                                        <label class="btn btn-outline-success" for="success-outlined">User</label>

                                        <input type="radio" class="btn-check" name="seller" id="danger-outlined" autocomplete="off">
                                        <label class="btn btn-outline-danger" for="danger-outlined">Seller</label>

                                    </div>

                                    <div class="form-group">
                                        <label for="loginUserId">Enter Email/Mobile number</label>
                                        <input type="text" class="form-control" id="loginUserId" name="login_UserName" placeholder="Enter Email/Mobile number here">
                                    </div>

                                    <div class="form-group">
                                        <label for="loginUserPasswd">Enter Password</label>
                                        <input type="password" class="form-control" id="loginUserPasswd" name="login_UserPasswd" placeholder="Enter Password here">
                                    </div>


                                    <!-- 2 column grid layout for inline styling -->
                                    <div class="row mb-4">
                                        <div class="col d-flex justify-content-center">
                                            <!-- Checkbox -->
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
                                                <label class="form-check-label" for="form2Example31"> Remember me </label>
                                            </div>
                                        </div>

                                        <div class="col">
                                            <!-- Simple link -->
                                            <a href="ForgotPassword.jsp">Forgot password?</a>
                                        </div>
                                    </div>

                                    <div class="container text-center">
                                        <button type="submit" onclick="Logout()" class="btn btn-primary btn-block mb-4">Sign In</button>
                                        <p class="small fw-bold mt-2 pt-1 mb-0" style="font-size:16px">Don't have an account? <a href="Register.jsp"
                                                                                                                                 class="link-danger">Register</a></p>
                                    </div>


                                </form>


                            </div>
                            <div class="card-footer">

                                <p class="small fw-bold mt-2 pt-1 mb-0" style="font-size:16px">Seller Account?? <a href="SellerRegister.jsp"
                                                                                                                                 class="link-danger">Create Account</a></p>
                                
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>



    </body>
</html>
