package com.apple.controller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.apple.model.Product;

public class ProductController extends Controller {

	@Override
	public void connectToDatabase() {
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/applesaga", "root", "");
        } catch (ClassNotFoundException | SQLException err)
        {
            System.out.println(err.getMessage());
        }
	}

	// get 1 product by id
    public Product getProductDetailsbyId(String productId)
    {
        Product product = new Product();
        try
        {
            String sql = "SELECT * FROM product WHERE productId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                product.setProductId(rs.getString("productId"));
                product.setProductName(rs.getString("name"));
                product.setProductPrice(rs.getDouble("price"));
                product.setProductQuantity(rs.getInt("productQuantity"));
                product.setProductCategory(new ProductCategoryController().getProductCategoryById(rs.getString("categoryId_fk")));
            }
        } catch (SQLException err)
        {
            System.out.println(err.getMessage());
        }
        return product;
    }
	
    // get all product details
    public List<Product> getAllProduct()
    {
        List<Product> products = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Product product = new Product();
                product.setProductId(rs.getString("productId"));
                product.setProductName(rs.getString("name"));
                product.setProductPrice(rs.getDouble("price"));
                product.setProductQuantity(rs.getInt("productQuantity"));
                product.setProductCategory(new ProductCategoryController().getProductCategoryById(rs.getString("categoryId_fk")));
               
                products.add(product);
            }
        } catch (SQLException err)
        {
            System.out.println(err.getMessage());
        }
        return products;
    }
    
  //get stock quantity
    public int getProductStockQuantity(String productId)
    {
        int stockQuantity = 0;
        try
        {
            String sql = "SELECT stockQuantity FROM product WHERE productId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                stockQuantity = rs.getInt("stockQuantity");
            }
        } catch (SQLException err)
        {
            System.out.println(err.getMessage());
        }
        return stockQuantity;
    }
    
}
