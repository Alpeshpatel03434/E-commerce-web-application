<%-- 
    Document   : index.jsp
    Created on : 25-Dec-2022, 12:45:57 am
    Author     : alpesh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="com.myproject.ecommerceapp.common.ProductData"%>
<%@page import="java.util.List"%>
<%@page import="com.myproject.ecommerceapp.common.GetAllProductDetails"%>
<%@page import="com.myproject.ecommerceapp.common.LoginUserData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String userLogged1 = (String) session.getAttribute("Logged_User_Email");
    String userLogged2 = (String) session.getAttribute("Logged_Seller_Email");
    if (userLogged1 != null && userLogged2 == null || userLogged1 == null && userLogged2 != null){
        return;
    }
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home - E-commerce App</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        <%@include file="components/navbar.jsp" %>
        <%@include file="components/error_message.jsp" %>
        <%@include file="components/message.jsp" %>


        <div class="row mt-3" id="main-index-home">

            <input type="radio" checked name="main-index-home-radio" style="display: none">
            <%               
                String SelectedCategory = request.getParameter("Category");

                GetAllProductDetails obj = new GetAllProductDetails();
//                List<ProductData> list = obj.getAllProduct();

                Map<String, List<ProductData>> product_map = obj.getCategoryWiseProducts();
                Set<String> CategorySet = product_map.keySet();
                List<ProductData> list;
                if (product_map.containsKey(SelectedCategory)) {
                    list = product_map.get(SelectedCategory);
                } else if (SelectedCategory == ("All")) {
                    list = obj.getAllProduct();
                } else {
                    list = obj.getAllProduct();
                }
//                for(Map.Entry<String, List<ProductData>> map : product_map.entrySet()){
//                    
//                } 

            %>

            <!-- Show Categories-->
            <div class="col-md-2 mx-2">
                <div class="list-group mt-4">

                    <a href="Home.jsp?Category=All" class="list-group-item list-group-item-action active text-center">
                        All Products
                    </a> 
                    <%                    for (String key : CategorySet) {
                    %>

                    <a href="Home.jsp?Category=<%= key%>" class="list-group-item list-group-item-action"><%= key%></a>

                    <%  }
                    %>

                </div>

                <div class="list-group mt-4">



                </div>
            </div>

            <!-- Show Products-->
            <div class="col-md-9 mr-2">



                <div class="row mt-4">
                    <div class="col-md-12">
                        <div class="card-columns">

                            <!--                        Products-->
                            <%
                                for (ProductData p : list) {
                            %>

                            <!--                            <form action="AddCartServlet" method="post">-->

                            <div class="card product-card" style="max-height: 100%; max-width: 100%;">

                                <div class="container text-center mt-2">
                                    <img src="img/products/<%= p.getProductImage()%>" class="card-img-top m-2" style="max-height: 200px; max-width: 100%; width: auto; " alt="img/products/main-logo.png"/>
                                </div>


                                <div class="card-body">

                                    <h5 class="card-title"><%= p.getProductName()%></h5>
                                    <p class="card-text" style="font-size: 14px">
                                        <%= GetAllProductDetails.get10Words(p.getProductDescription())%>
                                    </p>
                                    <h6><span> Discount of <%= p.getProductDiscount()%>% Off </span></h6>
                                    <p class="card-tex" style="font-size: 14px; color: red;">Available Total Quantity <%= p.getProductQuantity()%></p>
                                </div>



                                <%
                                    int price = Integer.parseInt(p.getProductPrice());
                                    int discount = Integer.parseInt(p.getProductDiscount());
                                    int FinalPrice = price + (price * discount) / 100;


                                %>
                                <div class="card-footer">
                                    <button onclick="addTOCart(<%= p.getSellerId()%>, <%= p.getProductId()%>, `<%= p.getProductName()%>`, <%= p.getProductPrice()%>)"  class="btn custom-nav-bg text-white text-center">Add to Cart</button>
                                    <button class="btn btn-outline-success text-center">Only ₹ <%= FinalPrice%>/-</button>
                                </div>



                            </div>
                            <!--                            </form>-->




                            <%
//  out.println(p.ProductName + "</br>");
                                }
                            %>

                        </div>
                    </div>
                </div>

            </div>
        </div>


        <div id="snackbar">Some text some message..</div>
        <%@include file="components/common_modal.jsp" %>

    </body>
</html>
