<%-- 
    Document   : seller_navbar
    Created on : 26-Dec-2022, 9:55:25 pm
    Author     : alpesh
--%>

<%
    String name = (String) session.getAttribute("Logged_Seller_Name");

    if (name != null) {
//     response.sendRedirect("Login.jsp");
//     return;

%>

<nav class="navbar navbar-expand-lg navbar-dark custom-nav-bg">

    <div class="container" >

        <a class="navbar-brand" href="SellerHome.jsp">E-commerce-App</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="SellerHome.jsp">Home <span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" href="sellerProfile.jsp"><%= name %></a>
                </li>

<!--                <li class="nav-item">
                    <a class="nav-link active" href="#">Pending Orders</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" href="#">History</a>
                </li>-->

            </ul>

            <ul class="navbar-nav my-2 my-lg-0">


<!--                <span>-->
                    <a href="sellerProfile.jsp"><img src="img/user-profile.svg" onclick="Logouthandle()" class="rounded mx-auto d-block" style="height: 100px; width: 30%;" alt="..."></a>
<!--                    <a href="sellerProfile.jsp"></a>-->
<!--                </span>-->
                <a href="SellerLogout.jsp"><img src="img/logout.svg" onclick="Logouthandle()" class="rounded mx-auto d-block" style="height: 100px; width: 30%;" alt="..."></a>

            </ul>

        </div>

    </div>

</nav>

<%
    }

%>