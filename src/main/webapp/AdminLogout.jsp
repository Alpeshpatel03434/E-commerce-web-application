<%-- 
    Document   : AdminLogout
    Created on : 01-Jan-2023, 3:40:25 pm
    Author     : alpesh
--%>

<%
    session.setAttribute("Admin", "");
    response.sendRedirect("Login.jsp");

%>
