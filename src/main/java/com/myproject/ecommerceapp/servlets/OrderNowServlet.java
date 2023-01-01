/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.myproject.ecommerceapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alpesh
 */
public class OrderNowServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String TypeOfPage = request.getParameter("CheckoutPage");
            HttpSession httpSession = request.getSession();

            if (TypeOfPage.equals("Checkout")) {

                String user_PaymentMode = request.getParameter("user_PaymentMode");
                if (user_PaymentMode.equals("Online")) {
                    response.sendRedirect("OrderNow.jsp");

                    // out.println("TypeOfPayment : "+request.getParameter("itemsdata"));
                } else {

                    httpSession.setAttribute("message", "Order has been Created!");

                    out.println("TypeOfPayment : " + request.getParameter("itemsdata"));
                    response.sendRedirect("Home.jsp");
                }
                // String TypeOfPayment2 = request.getParameter("user_PaymentMode2");
                // out.println("TypeOfPayment : "+TypeOfPage);

            } else if (TypeOfPage.equals("OrderNowPage")) {

                // Oneline Payment
                out.println("TypeOfPayment : " + request.getParameter("itemsdata"));
                response.sendRedirect("Home.jsp");

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
        processRequest(request, response);
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
        processRequest(request, response);
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
