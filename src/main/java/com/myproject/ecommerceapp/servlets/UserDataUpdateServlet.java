/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.myproject.ecommerceapp.servlets;

import com.myproject.ecommerceapp.common.Config;
import com.myproject.ecommerceapp.common.LoginUserData;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class UserDataUpdateServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            HttpSession httpSession = request.getSession();

            String PageType = request.getParameter("UserProfilePage");

            int UserID = (int) httpSession.getAttribute(LoginUserData.UserId);
            String userName = request.getParameter("user_Name");
            String userEmail = request.getParameter("user_Email");
            String userMobileNumber = request.getParameter("user_MobileNumber");
            String userAddress = request.getParameter("user_Address");
            String userPincode = request.getParameter("user_Pincode");

            try {

                Connection conn = Config.getConnection();
                if (conn != null) {

                    String query = "UPDATE `user` SET `Name` = ?, `Email`=?, `MobileNumber`=?, `Address`=?, `Pincode`=? WHERE `UserId` = ?";

                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setString(1, userName);
                    ps.setString(2, userEmail);
                    ps.setString(3, userMobileNumber);
                    ps.setString(4, userAddress);
                    ps.setString(5, userPincode);
                    ps.setInt(6, UserID);

                    int QueryRun = ps.executeUpdate();

                    if (QueryRun > 0) {
                        httpSession.setAttribute("message", "Profile Update SuccesssFully !!");

                        httpSession.setAttribute(LoginUserData.UserName, userName);
                        httpSession.setAttribute(LoginUserData.UserEmail, userEmail);
                        httpSession.setAttribute(LoginUserData.UserMobileNumber, userMobileNumber.substring(4, 14));
                        httpSession.setAttribute(LoginUserData.UserAddress, userAddress);
                        httpSession.setAttribute(LoginUserData.UserPincode, userPincode);

                    } else {
                        httpSession.setAttribute("message", "Try Again!! Update UnSuccesssFully");
                    }
                    conn.close();

                    if (PageType.equals("UserProfilePage")) {
                        response.sendRedirect("userProfile.jsp");
                    } else {
                        response.sendRedirect("Checkout.jsp");
                    }

                } else {
                    out.println("<h1>Not Connected</h1>");
                }

            } catch (SQLException se) {
                se.printStackTrace();
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
            Logger.getLogger(UserDataUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserDataUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
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
