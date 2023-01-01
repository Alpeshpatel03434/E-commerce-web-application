/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.myproject.ecommerceapp.servlets;

import com.myproject.ecommerceapp.common.Config;
import com.myproject.ecommerceapp.entites.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alpesh
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String successMessage = "SuccessFully Registred";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String userName = request.getParameter("user_Name");
            String userEmail = request.getParameter("user_Email");
            String userMobileNumber = request.getParameter("user_MobileNumber");
            String userPassword = request.getParameter("user_Password");
            String userAddress = request.getParameter("user_Address");
            String userPincode = request.getParameter("user_Pincode");
            String userAccountStatus = "Accepted";

            Class.forName("org.mariadb.jdbc.Driver");
            //Connection conn = null;

            try {
//                conn = DriverManager.getConnection(
//                        "jdbc:mariadb://localhost:3306/ecommercewebapp", "root", ""
//                );

                Connection conn = Config.getConnection();
                if (conn != null) {

                    String query = "INSERT INTO `user` (`Name`, `Email`, `MobileNumber`, `Password`, `Address`, `Pincode`, `Account_Status`) VALUES\n"
                            + "(?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setString(1, userName);
                    ps.setString(2, userEmail);
                    ps.setString(3, userMobileNumber);
                    ps.setString(4, userPassword);
                    ps.setString(5, userAddress);
                    ps.setString(6, userPincode);
                    ps.setString(7, userAccountStatus);
                    
                    int QueryRun = ps.executeUpdate();
                    
                    HttpSession httpSession = request.getSession();
                    
                    if(QueryRun>0){
                        httpSession.setAttribute("message", "Registration SuccesssFully !!");
                    } else {
                        httpSession.setAttribute("message", "Try Again!! Registration UnSuccesssFully");
                    }
                    conn.close();
                    response.sendRedirect("Register.jsp");

                } else {
                    out.println("<h1>Not Connected</h1>");
                }

            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
