<%-- 
    Document   : UserLogout
    Created on : 01-Jan-2023, 11:10:37 am
    Author     : alpesh
--%>

<%
    session.setAttribute("Logged_User_UserId", null);
    session.setAttribute("Logged_User_Name", null);
    session.setAttribute("Logged_User_UserImage", null);
    session.setAttribute("Logged_User_Email", null);
    session.setAttribute("Logged_User_MobileNumber", null);
    session.setAttribute("Logged_User_Password", null);
    session.setAttribute("Logged_User_Address", null);
    session.setAttribute("Logged_User_Pincode", null);
    session.setAttribute("Logged_User_AccountStatus", null);
    session.setAttribute("Logged_User_CreatedDate", null);

    session.setAttribute("message", "Logout SuccessFully!!");
    response.sendRedirect("Login.jsp");

%>
