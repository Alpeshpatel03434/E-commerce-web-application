/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.ecommerceapp.common;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author alpesh
 */
public class Config {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ecommercewebapp";
    private static final String db_username = "root";
    private static final String db_Password = " ";

    public static Connection getConnection() throws ClassNotFoundException {
         Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = null;

            try {
                conn = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/ecommercewebapp", "root", ""
                );

            } catch (Exception e) {
                e.printStackTrace();
            }
            
            return conn;
    }

}
