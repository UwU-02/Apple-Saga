package com.apple.controller;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import com.apple.model.ShoppingOrder;
import com.apple.model.CartItem;
import com.apple.model.Product;

public class ShoppingOrderController  extends Controller {
    public void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/penpalsoop", "root", "");
        } catch (ClassNotFoundException | SQLException err) {
            System.out.println(err.getMessage());
        }
    }
    
    public int insertOrder(int customerId) {
        try {
            String query = "INSERT INTO SHOPPING_ORDER (customerId) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customerId);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return 0;   
    }
    
    public void insertOrderDetail(int orderId, int productId, int productQuantity) {
        try {
            String query = "INSERT INTO ORDER_LIST (productId, orderId, productQuantity) VALUES (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, orderId);
            ps.setInt(3, productQuantity);
            ps.executeUpdate();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
    
    public List<CartItem> getAllItembyOrderId(int orderId) {
        List<CartItem> cartItems = new ArrayList<CartItem>();
        try {
            String query = "SELECT p.productId, p.productName, p.productPrice, p.productColour, p.imageURL, oi.productQuantity "
                         + "FROM ORDER_LIST oi JOIN PRODUCT p ON (oi.productId = p.productId) WHERE oi.orderId = ?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CartItem cartItem = new CartItem();
                Product product = new Product();
                product.setProductId(rs.getInt("p.productId"));
                product.setProductName(rs.getString("p.productName"));
                product.setProductPrice(rs.getDouble("p.productPrice"));
                product.setProductColor(rs.getString("p.productColour"));
                product.setProductImageURL(rs.getString("p.imageURL"));
                cartItem.setCartItemProduct(product);
                cartItem.setCartItemQuantity(rs.getInt("oi.productQuantity"));
                cartItems.add(cartItem);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return cartItems;
    }

}
