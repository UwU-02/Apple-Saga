package com.apple.controller;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.apple.model.*;

public class ShoppingCartController extends Controller{

    public void connectToDatabase() throws SQLException
    {
    	conn.setAutoCommit(false);
    	try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/applesaga", "root", "");
        } catch (ClassNotFoundException | SQLException err)
        {
            System.out.println(err.getMessage());
        }
    	conn.commit();
    }

    public ShoppingCart getShoppingCartDetailbyCustomerId(int customerId)
    {
    	
        ShoppingCart shoppingCart = new ShoppingCart();
        try{
            String query = "SELECT * FROM cart WHERE customerId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                shoppingCart.setCartId(resultSet.getInt("id"));
            } else if (!resultSet.next())
            {
                String query2 = "INSERT INTO cart (customerId) VALUES (?)";
                PreparedStatement preparedStatement2 = conn.prepareStatement(query2);
                preparedStatement2.setInt(1, customerId);
                preparedStatement2.executeUpdate();
                String query3 = "SELECT * FROM cart WHERE customerId = ?";
                PreparedStatement preparedStatement3 = conn.prepareStatement(query3);
                preparedStatement3.setInt(1, customerId);
                ResultSet resultSet2 = preparedStatement3.executeQuery();
                if (resultSet2.next())
                {
                    shoppingCart.setCartId(resultSet2.getInt("id"));
                }
            }
            shoppingCart.setCartItems(getAllCartItembyCartId(shoppingCart.getCartId()));
        } catch (SQLException err)
        {
            System.out.println(err.getMessage());
        }
        return shoppingCart;
    }

    public List<CartItem> getAllCartItembyCartId(int cartId)
    {
        List<CartItem> cartItems = new ArrayList<CartItem>();
        try{
            String query = "SELECT productId, quantity FROM cart_item WHERE cart_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, cartId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                CartItem cartItem = new CartItem();
                cartItem.setCartItemQuantity(resultSet.getInt("quantity"));
                cartItem.setCartItemProduct(new ProductController().getProductDetailsbyId(resultSet.getInt("productId")));
                cartItems.add(cartItem);
            }
        } catch (SQLException err)
        {
            System.out.println(err.getMessage());
        }
        return cartItems;
    }

    public void addItemToCart(int cartId, int productId)
    {
        try{
            String query = "SELECT * FROM cart_item WHERE cartId = ? AND productId = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, cartId);
            preparedStatement.setInt(2, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                String query2 = "UPDATE cart_item SET quantity = quantity+1 WHERE cartId = ? AND productId = ?";
                PreparedStatement preparedStatement2 = conn.prepareStatement(query2);
                preparedStatement2.setInt(1, cartId);
                preparedStatement2.setInt(2, productId);
                preparedStatement2.executeUpdate();
            } else if (!resultSet.next())
            {
                String query3 = "INSERT INTO cart_item (cartId_fk, productId_fk, quantity) VALUES (?, ?, 1)";
                PreparedStatement preparedStatement3 = conn.prepareStatement(query3);
                preparedStatement3.setInt(1, cartId);
                preparedStatement3.setInt(2, productId);
                preparedStatement3.executeUpdate();
            }
        } catch (SQLException err)
        {
            System.out.println(err.getMessage());
        }
    }

    public void removeItemFromCart(int cartId, int productId)
    {
        try{
            String query = "DELETE FROM cart_item WHERE cartId_fk = ? AND productId_fk = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, cartId);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException err)
        {
            System.out.println(err.getMessage());
        }
    }
}