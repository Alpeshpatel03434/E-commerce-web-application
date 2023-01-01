<%-- 
    Document   : SellerLogout
    Created on : 27-Dec-2022, 2:25:47 pm
    Author     : alpesh
--%>

<%
    session.setAttribute("Logged_Seller_SellerId", null);
    session.setAttribute("Logged_Seller_Name", null);
    session.setAttribute("Logged_Seller_SellerImage", null);
    session.setAttribute("Logged_Seller_Email", null);
    session.setAttribute("Logged_Seller_MobileNumber", null);
    session.setAttribute("Logged_Seller_Password", null);
    session.setAttribute("Logged_Seller_Address", null);
    session.setAttribute("Logged_Seller_Pincode", null);
    session.setAttribute("Logged_Seller_AccountStatus", null);
    session.setAttribute("Logged_Seller_CreatedDate", null);

    session.setAttribute("message", "Logout SuccessFully!!");
    response.sendRedirect("Login.jsp");

%>