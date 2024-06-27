package com.apple.controller;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.apple.model.Customer;

public class CustomerController extends Controller{


    public void connectToDatabase() 
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/penpalsoop", "root", "");
        } catch (ClassNotFoundException | SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public Customer getCustomerDetailbyUsernamePassword(String username, String password) {
        Customer customer = null;
        try {
            String sql = "SELECT customerId, customerName, customerEmail, customerContact, customerAddress, customerPassword FROM CUSTOMER WHERE customerEmail = ? AND customerPassword = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setCustomerId(rs.getInt("customerId"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setCustomerEmail(rs.getString("customerEmail"));
                customer.setCustomerContact(rs.getString("customerContact"));
                customer.setCustomerAddress(rs.getString("customerAddress"));
                customer.setCustomerPassword(rs.getString("customerPassword"));
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return customer;
    }

    public void updateCustomerDetail(Customer customer) {
        try {
            String sql = "UPDATE CUSTOMER SET customerName = ?, customerEmail = ?, customerContact = ?, customerAddress = ?, customerPassword = ? WHERE customerId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerEmail());
            ps.setString(3, customer.getCustomerContact());
            ps.setString(4, customer.getCustomerAddress());
            ps.setString(5, customer.getCustomerPassword());
            ps.setInt(6, customer.getCustomerId());
            ps.executeUpdate();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public void addCustomer(Customer customer) {
        try {
            String sql = "INSERT INTO CUSTOMER (customerName, customerEmail, customerContact, customerAddress, customerPassword) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerEmail());
            ps.setString(3, customer.getCustomerContact());
            ps.setString(4, customer.getCustomerAddress());
            ps.setString(5, customer.getCustomerPassword());
            ps.executeUpdate();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public boolean checkUserbyEmail(String email) {
        boolean result = false;
        try {
            String sql = "SELECT * FROM CUSTOMER WHERE customerEmail = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return result;
    }

    public boolean checkUserbyUsername(String username) {
        boolean result = false;
        try {
            String sql = "SELECT * FROM CUSTOMER WHERE customerName = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return result;
    }

    public boolean checkUserbyPhoneNumber(String phoneNumber) {
        boolean result = false;
        try {
            String sql = "SELECT * FROM CUSTOMER WHERE customerContact = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, phoneNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = true;
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return result;
    }
}
