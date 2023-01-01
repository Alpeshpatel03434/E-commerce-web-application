/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.ecommerceapp.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alpes
 */
public class GetAllProductDetails {
    
    List<ProductData> productLst = new ArrayList<>();
    Connection conn = null;
    
    public List<ProductData> getAllProduct() {
        
        try{
             List<ProductData> ProductList = new ArrayList<>();
            conn = Config.getConnection();
            
            if(conn!=null){
                
               String Query = "Select ProductId, SellerId, Productcategory, ProductName, ProductImage, ProductDesc, Discount, ProductPrice, Quantity, Created_time from products";
                
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(Query);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
 
                ProductData obj = new ProductData();
                obj.setProductId(rs.getInt("ProductId"));
                obj.setSellerId(rs.getInt("SellerId"));
                obj.setProductCategory(rs.getString("Productcategory"));
                obj.setProductName(rs.getString("ProductName"));
                obj.setProductImage(rs.getString("ProductImage"));
                obj.setProductDescription(rs.getString("ProductDesc"));
                if(rs.getString("Discount").equals("") || rs.getString("Discount").equals(null)){
                    obj.setProductDiscount("1");
                } else {
                    obj.setProductDiscount(rs.getString("Discount"));
                }
//                obj.setProductDiscount(rs.getString("Discount"));
                if(rs.getString("ProductPrice").equals("") || rs.getString("ProductPrice").equals(null)){
                    obj.setProductPrice("0");
                } else {
                    obj.setProductPrice(rs.getString("ProductPrice"));
                }
//                obj.setProductPrice(rs.getString("ProductPrice"));
                obj.setProductQuantity(rs.getInt("Quantity"));
                obj.setProductCreatedDate(rs.getString("Created_time"));
                ProductList.add(obj);
                
                
            } 
                
            
            return ProductList;
            
            } else{
                System.out.println("Connection Failed");
            }
            
        } catch(Exception e){
            
        }
        
        
        return null;
    }
    
    public Map<String, List<ProductData>> getCategoryWiseProducts() {
        
        try{
             List<ProductData> ProductList = (new GetAllProductDetails().getAllProduct());
           
             Map<String, List<ProductData>> product_map = new HashMap<>();
             
             for(ProductData p : ProductList){
              
                 if(product_map.containsKey(p.ProductCategory)){
                     List<ProductData> data =  product_map.get(p.ProductCategory);
                     data.add(p);
                     product_map.put(p.ProductCategory, data);
                 } else {
                     List<ProductData> data = new ArrayList<ProductData>();
                     data.add(p);
                     product_map.put(p.ProductCategory, data);
                 }
             } 
             
            return product_map;
            
        } catch(Exception e){
            
        }
        
        
        return null;
    }
    
    
    
    
    // helper Method
    public static String get10Words(String description){
        String str[] = description.split(" ");
        String ansDesc = "";
        if(str.length>10){
            
            for(int i=0; i<10; i++){
                ansDesc+=str[i]+" ";
            }
            
            return (ansDesc+"...");
        } else {
            return description;
        }
        
    }
    
    
}
