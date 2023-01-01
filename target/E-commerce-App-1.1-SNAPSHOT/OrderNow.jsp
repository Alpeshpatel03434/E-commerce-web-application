<%-- 
    Document   : OrderNow
    Created on : 31-Dec-2022, 4:07:12 pm
    Author     : alpesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
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
        <title>Order Now</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        <%@include file="components/user_navbar.jsp" %>
        <%@include file="components/error_message.jsp" %>
        <%@include file="components/message.jsp" %>


        <div class="container">
            <div class="row mt-4">
                <div class="col-6 offset-md-3">
                    <div class="card">
                        <div class="card-body">

                            <form action="OrderNowServlet" method="post">

                                <div class="form-group">
                                    <label for="cardType">Card Type</label>
                                    <div class="input-group">
                                        <span>
                                            <table role="presentation" class="cardType">
                                                <tbody class="cardType"><tr>
                                                        <td>
                                                            <input type="radio" name="cardType" value="Visa" id="Visa" aria-errormessage="Please select card type" required value="Visa"><label for="visa"> Visa</label></td>
                                                        <td>
                                                            <input type="radio" name="cardType" value="Mastercard" id="Mastercard" aria-errormessage="Please select card type" required value="Mastercard"><label for="mastercard"> Mastercard</label></td>
                                                        <td>
                                                            <input type="radio" name="cardType" value="American Express" id="Americanexpress" aria-errormessage="Please select card type" required value="American Express"><label for="americanexpress"> American Express</label></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </span>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="cardName">Cardholder Name</label>
                                    <div class="input-group elementParent">
                                        <span class="input-group-addon mx-1"><i class="fa fa-user"></i></span> <input id="paymentPage:paymentForm:cardName" class="cardName" type="text" name="cardName" required placeholder="Name On Card">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="cardNumber">Card Number</label>
                                    <div class="input-group elementParent">
                                        <span class="input-group-addon mx-1"><i class="fa fa-credit-card"></i></span> <input id="cardNumber" class="cardNumber" type="text" name="cardNumber" onchange="handleCardNumber()" required autocomplete="cc-number" placeholder="Card Number">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="cardExpiry">Expiry Date</label>
                                    <div class="input-group elementParent">
                                        <input id="paymentPage:paymentForm:cardExpiry" required class="cardExpiryDate" type="text" name="cardExpiry" onchange={
                                               handleCardExpiryDate} autocomplete="cc-exp" placeholder="MM / YY">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <button class="btn btn-success btn-lg btn-block" type="Submit" id="btn-confirm-forPayment-details" onclick="ConfirmButtonhandle()">Confirm</button>
                                </div>

                                 <input type="text" value="OrderNowPage" style="display: none" name="CheckoutPage">
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
