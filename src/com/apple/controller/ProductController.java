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
    public Product getProductDetailsbyId(int productId)
    {
        Product product = new Product();
        try
        {
            String sql = "SELECT * FROM product WHERE productId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("name"));
                product.setProductPrice(rs.getDouble("price"));
                product.setProductStockQuantity(rs.getInt("stockQuantity"));
                product.setProductColor(rs.getString("productColor"));
                product.setProductImageURL(rs.getString("imageURL"));
                product.setProductCategory(new ProductCategoryController().getProductCategoryById(rs.getInt("categoryId_fk")));
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
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("name"));
                product.setProductPrice(rs.getDouble("price"));
                product.setProductStockQuantity(rs.getInt("stockQuantity"));
                product.setProductColor(rs.getString("productColor"));
                product.setProductImageURL(rs.getString("imageURL"));
                product.setProductCategory(new ProductCategoryController().getProductCategoryById(rs.getInt("categoryId_fk")));
               
                products.add(product);
            }
        } catch (SQLException err)
        {
            System.out.println(err.getMessage());
        }
        return products;
    }
    
    //get products by category
    public List<Product> getAllProductByCategory(String categoryName)
    {
    	List<Product> products = new ArrayList<>();
    	try {
    		//
    		String sql = "SELECT p.* FROM product p JOIN product_category pc ON p.categoryId_fk = pc.categoryId WHERE pc.categoryName = ?";
        	PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, categoryName);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Product product = new Product();
                product.setProductId(rs.getInt("p.productId"));
                product.setProductName(rs.getString("p.productName"));
                product.setProductPrice(rs.getDouble("p.productPrice"));
                product.setProductStockQuantity(rs.getInt("p.stockQuantity"));
                product.setProductColor(rs.getString("p.productColor"));
                product.setProductImageURL(rs.getString("p.imageURL"));
                product.setProductCategory(new ProductCategoryController().getProductCategoryById(rs.getInt("p.category_id_fk")));
                
                products.add(product);
            }
    	}catch (SQLException err)
    	{
            System.out.println(err.getMessage());
        }
        return products;
    	
        
    }
    
  //get stock quantity
    public int getProductStockQuantity(int productId)
    {
        int stockQuantity = 0;
        try
        {
            String sql = "SELECT stockQuantity FROM product WHERE productId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productId);
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
