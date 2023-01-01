/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.ecommerceapp.common;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author alpesh
 */
public class TagHandlerClass extends TagSupport{

    @Override
    public int doStartTag() throws JspException {
        
        try{
            
            JspWriter out = pageContext.getOut();
             HttpSession httpSession =  pageContext.getSession();
             
             String name = (String)httpSession.getAttribute("Logged_Seller_Name");
             
             out.println(name);
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return SKIP_BODY; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}
