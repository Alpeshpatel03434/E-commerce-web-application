<%-- 
    Document   : SellerHome
    Created on : 26-Dec-2022, 9:35:36 pm
    Author     : alpesh
--%>

<%@page import="java.util.Map"%>
<%@page import="com.myproject.ecommerceapp.common.GetAllProductDetails"%>
<%@page import="com.myproject.ecommerceapp.common.ProductData"%>
<%@page import="com.myproject.ecommerceapp.common.SellerData"%>
<%@page import="com.myproject.ecommerceapp.common.GetAllUserSellerData"%>
<%@page import="com.myproject.ecommerceapp.common.UserData"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String SellerLogged = (String) session.getAttribute("Logged_Seller_Email");
    if (SellerLogged == null) {
        session.setAttribute("message", "you are not login");
        response.sendRedirect("Login.jsp");
        return;
    }
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seller-Home</title>
        <%@include file="components/common_css_js.jsp" %>
    </head>
    <body>
        <%@include file="components/seller_navbar.jsp" %>

        <%@include file="components/message.jsp" %>
        <%@include file="components/error_message.jsp" %>

        <%
            GetAllUserSellerData obj = new GetAllUserSellerData();
            List<UserData> lst = obj.getAllUsersdata();
            int userlstSize = 0;
            if(lst!=null){
            userlstSize = lst.size();
        }
            
            
            GetAllProductDetails obj2 = new GetAllProductDetails();
            Map<String, List<ProductData>> map = obj2.getCategoryWiseProducts();
            int categTotal = map.size();

        %>


        <div class="container seller-home" style="padding-top: 20px">

            <!--             1st row-->
            <div class="row">
                <!--                 FirstColumn-->
                <div class="col-md-4">
                    <div class="card" style="border: 1px solid green;">
                        <!--                        <div class="card-body text-center">-->
                        <div class="card">
                            <div class="card-body text-center">

                                <div class="container">
                                    <img style="max-width: 140px" src="img/customers.png" class="img-fluid rounded-circle" alt="customers_icon"/>

                                </div>

                                <h3><%= userlstSize %></h3>
                                <h3 class="text-success">Buyers</h3>

                            </div> 
                        </div>
                        <!--                           </div> -->
                    </div>  
                </div>


                <!--                 SecoundColumn-->
                <div class="col-md-4">

                    <div class="card" style="border: 1px solid green;">
                        <div class="card">

                            <div class="card-body text-center">

                                <div class="container">
                                    <img style="max-width: 140px" src="img/categories.png" class="img-fluid rounded-circle" alt="customers_icon"/>

                                </div>

                                <h3><%= categTotal %></h3>
                                <h3 class="text-success">Categories</h3>

                            </div> 
                        </div>
                    </div>
                </div>


                <!--                 ThirdColumn-->
                <div class="col-md-4">

                    <div class="card" style="border: 1px solid green;">
                        <div class="card">
                            <div class="card-body text-center">

                                <div class="container">
                                    <img style="max-width: 140px" src="img/product.png" class="img-fluid rounded-circle" alt="customers_icon"/>
                                </div>

                                <h3>4331</h3>
                                <h3 class="text-success">Products</h3>

                            </div> 
                        </div>
                    </div>
                </div>

            </div>



            <!--             2nd Row-->
<!--            <div class="row mt-3">
                <div class="col-md-6">

                    <div class="card" style="border: 1px solid green;">
                        <div class="card">
                            <div class="card-body text-center">

                                <div class="container">
                                    <img style="max-width: 140px" src="img/addcategories.jpg" class="img-fluid rounded-circle" alt="customers_icon"/>
                                </div>

                                <p>Click here to add new Category</p>
                                <h3 class="text-success">Add Category</h3>

                            </div> 
                        </div>
                    </div>
                </div>   -->

                <div class="col-md-4 offset-md-4">

                    <div class="card" style="border: 1px solid green;">
                        <div class="card" data-toggle="modal" data-target="#add-product">
                            <div class="card-body text-center">

                                <div class="container">
                                    <img style="max-width: 140px" src="img/addcategories.jpg" class="img-fluid rounded-circle" alt="customers_icon"/>
                                </div>

                                <p>Click here to add new Category</p>
                                <h3 class="text-success">Add Product</h3>

                            </div> 
                        </div>
                    </div>
                </div> 
            </div>

        </div>


        <!--        Strt Category Model
   
        <!-- Modal -->
        <div class="modal fade" id="add-product" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header custom-nav-bg text-white">
                        <h5 class="modal-title" id="exampleModalLabel">Fill Product Details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body container-fluid">

                        <form action="AddNewProductServlet" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="productCategories">Select type of product category</label>
                                <select name="productCategories" id="productCategories" class="form-control btn-info">
                                    <option>Mobiles and Tablets</option>
                                    <option>Books</option>
                                    <option>Clothing</option>
                                    <option>Earphones and Headphones</option>
                                    <option>Laptop and Desktop</option>
                                    <option>Other</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="productName">Enter Product Name</label>
                                <input type="text" class="form-control" id="productName" name="productName" placeholder="Enter Product Name here">
                            </div>

                            <div class="form-group">
                                <label for="productImage">Upload Product Image</label>
                                <input type="file" class="form-control" id="productImage"  name="productImage">
                            </div>

                            <div class="form-group">
                                <label for="productDesc">Product Description</label>
                                <textarea style="height: 100px" class="form-control" id="productDesc" name="productDesc" placeholder="Enter Product Description here"></textarea>
                            </div>

                            <div class="form-group">
                                <label for="productdisc">Selling Discount(If you want)</label>
                                <input type="number" class="form-control" name="productdisc" id="productdisc" placeholder="Enter Discount here (ex. 20, 22.23)">
                            </div>

                            <div class="form-group">
                                <label for="productPrice">Price</label>
                                <input type="number" class="form-control" id="productPrice" name="productPrice" placeholder="Enter Product Price here">
                            </div>

                            <div class="form-group">
                                <label for="productQuantity">Available Number of Product</label>
                                <input type="number" class="form-control" id="productQuantity" name="productQuantity" placeholder="Enter Product Quantity here">
                            </div>

                            <div class="form-group text-center">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="Submit" class="btn btn-outline-success">Add Product</button>
                            </div>
                        </form>

                    </div>
                    <div class="modal-footer">

                    </div>
                </div>
            </div>
        </div>

        <!--            End Category Model-->
        
    </body>
</html>
