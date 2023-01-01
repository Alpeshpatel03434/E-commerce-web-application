/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.myproject.ecommerceapp.servlets;

import com.myproject.ecommerceapp.common.Config;
import com.myproject.ecommerceapp.common.LoginSellerData;
import com.myproject.ecommerceapp.common.LoginUserData;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alpes
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String UserName = request.getParameter("login_UserName");
            String Password = request.getParameter("login_UserPasswd");

            Connection conn = Config.getConnection();

            String UserType = "Seller";
            String sty = request.getParameter("utype");

            if (conn != null) {

                if (sty.equalsIgnoreCase("User")) {

                    String query = "Select UserId, Name, UserImage, Email, MobileNumber, Password, Address, Pincode, Account_Status, Created_time from user Where (Email='" + UserName + "' OR  MobileNumber='" + UserName + "') And Password= '" + Password + "' And Account_Status= 'Accepted' ";

                    PreparedStatement pstmt = null;
                    pstmt = conn.prepareStatement(query);
                    ResultSet rs = pstmt.executeQuery();
                    //out.println("<h1> RS - " + rs + " </h1>");
                    HttpSession httpSession = request.getSession();

                    int row = 0;
                    while (rs.next()) {
                        row++;
                        int id = rs.getInt("UserId");
                        httpSession.setAttribute(LoginUserData.UserId, rs.getInt("UserId"));
                        httpSession.setAttribute(LoginUserData.UserName, rs.getString("Name"));
                        httpSession.setAttribute(LoginUserData.UserImage, rs.getString("UserImage"));
                        httpSession.setAttribute(LoginUserData.UserEmail, rs.getString("Email"));
                        httpSession.setAttribute(LoginUserData.UserMobileNumber, rs.getString("MobileNumber"));
                        httpSession.setAttribute(LoginUserData.UserPassword, rs.getString("Password"));
                        httpSession.setAttribute(LoginUserData.UserAddress, rs.getString("Address"));
                        httpSession.setAttribute(LoginUserData.UserPincode, rs.getString("Pincode"));
                        httpSession.setAttribute(LoginUserData.UserAccountStatus, rs.getString("Account_Status"));
                        httpSession.setAttribute(LoginUserData.UserCreatedDate, rs.getString("Created_time"));

                        // String a = (String)httpSession.getAttribute(LoginUserData.UserPassword);
                        httpSession.setAttribute("message", "User SuccessFully Login");
                    }

                    if (row == 0) {
                        // String s = request.getParameter("user");
                        //    httpSession.setAttribute("error_message", " Not valid User");

                        if (UserName.equalsIgnoreCase("Admin@gmail.com") || UserName.equalsIgnoreCase("Admin") && Password.equalsIgnoreCase("admin")) {

                            httpSession.setAttribute("Admin", "User"); 
                            httpSession.setAttribute("message", "Admin SuccessFully Login");
                            response.sendRedirect("AdminHome.jsp");
                        } else {
                            httpSession.setAttribute("error_message", "Not valid User");
                            response.sendRedirect("Login.jsp");
                        }

                    } else {
                        response.sendRedirect("Home.jsp");
                    }

                } else if (sty.equalsIgnoreCase("Seller")) {

                    String query = "Select SellerId, Name, SellerImage, Email, MobileNumber, Password, Address, Pincode, Account_Status, Created_time from seller Where (Email='" + UserName + "' OR  MobileNumber='" + UserName + "') And Password= '" + Password + "' And Account_Status= 'Accepted' ";
                    PreparedStatement pstmt = null;
                    pstmt = conn.prepareStatement(query);
                    ResultSet rs = pstmt.executeQuery();
                    //out.println("<h1> RS - " + rs + " </h1>");
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("message", "Seller User SuccessFully Login");

                    int row = 0;
                    while (rs.next()) {
                        row++;
                        int id = rs.getInt("SellerId");
                        httpSession.setAttribute(LoginSellerData.SellerId, rs.getInt("SellerId"));
                        httpSession.setAttribute(LoginSellerData.SellerName, rs.getString("Name"));
                        httpSession.setAttribute(LoginSellerData.SellerImage, rs.getString("SellerImage"));
                        httpSession.setAttribute(LoginSellerData.SellerEmail, rs.getString("Email"));
                        httpSession.setAttribute(LoginSellerData.SellerMobileNumber, rs.getString("MobileNumber"));
                        httpSession.setAttribute(LoginSellerData.SellerPassword, rs.getString("Password"));
                        httpSession.setAttribute(LoginSellerData.SellerAddress, rs.getString("Address"));
                        httpSession.setAttribute(LoginSellerData.SellerPincode, rs.getString("Pincode"));
                        httpSession.setAttribute(LoginSellerData.SellerAccountStatus, rs.getString("Account_Status"));
                        httpSession.setAttribute(LoginSellerData.SellerCreatedDate, rs.getString("Created_time"));

                        // String a = (String)httpSession.getAttribute(LoginUserData.UserPassword);
                        httpSession.setAttribute("message", "Seller SuccessFully Login");
                    }

                    if (row == 0) {
                        //  String s = request.getParameter("user");

                        if (UserName.equalsIgnoreCase("Admin@gmail.com") || UserName.equalsIgnoreCase("Admin") && Password.equalsIgnoreCase("admin")) {

                             httpSession.setAttribute("Admin", "Seller");
                            httpSession.setAttribute("message", "Admin SuccessFully Login");
                            response.sendRedirect("AdminHome.jsp");
                        } else {
                            httpSession.setAttribute("error_message", "Not valid User");
                            response.sendRedirect("Login.jsp");
                        }

                    } else {
                        response.sendRedirect("SellerHome.jsp");
                    }

                }

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
