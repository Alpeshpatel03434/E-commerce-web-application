<%-- 
    Document   : error_message
    Created on : 26-Dec-2022, 6:52:24 pm
    Author     : alpesh
--%>

<%
  String error_message = (String)session.getAttribute("error_message");
  
  if(error_message!=null){
  
//     out.println("<h1>"++"</h1>");
       
%>

<div class="alert alert-danger" alert-dismissible fade show" role="alert">
  <strong><%= error_message %></strong>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>

<%
      session.removeAttribute("error_message");
    }

%>