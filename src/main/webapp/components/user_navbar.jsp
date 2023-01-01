<%-- 
    Document   : user_navbar
    Created on : 26-Dec-2022, 7:41:58 pm
    Author     : alpesh
--%>

<%
    String userName = (String) session.getAttribute("Logged_User_Name");
    if (userName != null) {

%>

<nav class="navbar navbar-expand-lg navbar-dark custom-nav-bg">

    <div class="container" style="min-height: 30px;">

        <a class="navbar-brand" href="index.jsp">E-commerce-App</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="Home.jsp">Home <span class="sr-only">(current)</span></a>
                </li>

                <!--                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Product Categories
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="#">Action</a>
                                        <a class="dropdown-item" href="#">Another action</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#">Something else here</a>
                                    </div>
                                </li>-->


                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="userProfile.jsp"><%= userName%></a>
                </li>

                <!--                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="#">Oder</a>
                                </li>-->

                <!--                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="#">history</a>
                                </li>-->


            </ul>



            <ul class="navbar-nav my-2 my-lg-0">

                <li class="nav-item active justify-content-center">
                    <a class="nav-link" href="#" data-toggle="modal" data-target="#cart">
                        <i class="fa fa-cart-plus" style="color: white; font-size: 30px;"></i><span class="card-items" style="font-size: 22px; margin-top: -6">(0)</span></a>
                </li>


                <a href="userProfile.jsp"><img src="img/user-profile.svg" class="rounded mx-auto d-block" style="height: 50px; width: 70%;" alt="..."></a>


                <a href="UserLogout.jsp"><img src="img/logout.svg" class="rounded mx-auto d-block" style="height: 50px; width: 70%;" alt="..."></a>

            </ul>

        </div>

    </div>

</nav>

<%
    }

%>