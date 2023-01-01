/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.myproject.ecommerceapp.servlets;

import com.myproject.ecommerceapp.common.Config;
import com.myproject.ecommerceapp.common.LoginSellerData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author alpes
 */
@MultipartConfig
public class AddNewProductServlet extends HttpServlet {

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

            String ProductCategory = request.getParameter("productCategories");
            String ProductName = request.getParameter("productName");
            // String ProductImage = request.getParameter("productImage");
            Part proimg = request.getPart("productImage");
            String ProductImage = proimg.getSubmittedFileName();

            String ProductDescription = request.getParameter("productDesc");
            String ProductDiscount = request.getParameter("productdisc");
            String ProductPrice = request.getParameter("productPrice");
            String ProductQantity = request.getParameter("productQuantity");

            Connection conn = null;
            try {
                conn = Config.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddNewProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            HttpSession httpSession = request.getSession();
//            httpSession.setAttribute("message", ProductPrice+" SuccesssFully !!");
//            response.sendRedirect("SellerHome.jsp");
            if (conn != null) {

                String query = "INSERT INTO `products` (`SellerId`, `Productcategory`, `ProductName`, `ProductImage`, `ProductDesc`, `Discount`, `ProductPrice`, `Quantity`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, (int) httpSession.getAttribute(LoginSellerData.SellerId));
                ps.setString(2, ProductCategory);
                ps.setString(3, ProductName);
                ps.setString(4, ProductImage);
                ps.setString(5, ProductDescription);
                ps.setString(6, ProductDiscount);
                ps.setString(7, ProductPrice);
                if (ProductQantity.equals("") || ProductQantity.equals(null)) {
                    ps.setInt(8, 0);
                } else {
                    ps.setInt(8, Integer.parseInt(ProductQantity));
                }

                int QueryRun = ps.executeUpdate();
                if (QueryRun > 0) {
                    //  String pathUploadImage = request.getRealPath("img");
                    //  out.println(pathUploadImage);
//                    httpSession.setAttribute("message", "Product add SuccesssFully !!"+ProductImage);
                    // Pic upload

//                    find real path of upload photo
                    String pathUploadImage = request.getRealPath("img") + File.separator + "products" + File.separator + ProductImage;
                    FileOutputStream fouts = new FileOutputStream(pathUploadImage);
                    InputStream inputs = proimg.getInputStream();

                    byte[] data = new byte[inputs.available()];

                    inputs.read(data);
//                    writting data
                    fouts.write(data);
                    fouts.close();

                    httpSession.setAttribute("message", "Product add SuccesssFully !!");

                } else {
                    httpSession.setAttribute("error_message", ProductImage + "<- Please try Again!! Unable to add Product ->" + ProductCategory);
                }
                conn.close();
                response.sendRedirect("SellerHome.jsp");

            } else {
                httpSession.setAttribute("message", "Connection Falied");
                out.println("<h1>Not Connected</h1>");
                response.sendRedirect("SellerHome.jsp");
            }

        } catch (SQLException se) {
            se.printStackTrace();
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
