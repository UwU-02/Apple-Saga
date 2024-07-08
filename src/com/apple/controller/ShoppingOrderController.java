package controller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.ShoppingOrder;
import model.CartItem;
import model.Customer;
import model.OrderSummary;
import model.Product;

public class ShoppingOrderController extends Controller {
    public ShoppingOrderController() {
        connectToDatabase();
    }

    public void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/applesaga", "root", "");
            System.out.println("Database connected!");
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

    public List<OrderSummary> getOrderSummariesByCustomer(int customerId) {
        List<OrderSummary> orderSummaries = new ArrayList<>();
        try {
            String query = "SELECT " +
                           "so.orderId, " +
                           "SUM(p.productPrice * ol.productQuantity) AS totalPrice, " +
                           "d.deliveryStatus " +
                           "FROM " +
                           "SHOPPING_ORDER so " +
                           "JOIN ORDER_LIST ol ON so.orderId = ol.orderId " +
                           "JOIN PRODUCT p ON ol.productId = p.productId " +
                           "JOIN DELIVERY d ON so.orderId = d.orderId " +
                           "WHERE " +
                           "so.customerId = ? " +
                           "GROUP BY " +
                           "so.orderId, d.deliveryStatus";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                double totalPrice = rs.getDouble("totalPrice");
                String deliveryStatus = rs.getString("deliveryStatus");
                
                orderSummaries.add(new OrderSummary(orderId, totalPrice, deliveryStatus));
                System.out.println("Order ID: " + orderId + ", Total Price: " + totalPrice + ", Delivery Status: " + deliveryStatus);
            }
            
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderSummaries;
    }
    
    public ShoppingOrder getCompleteOrderDetails(int orderId) {
        ShoppingOrder order = new ShoppingOrder();
        order.setOrderId(orderId);
        
        try {
            // Fetch order details
            String orderQuery = "SELECT so.orderId, c.customerName, c.customerAddress, c.customerContact, d.deliveryStatus " +
                                "FROM SHOPPING_ORDER so " +
                                "JOIN CUSTOMER c ON so.customerId = c.customerId " +
                                "JOIN DELIVERY d ON so.orderId = d.orderId " +
                                "WHERE so.orderId = ?";
            PreparedStatement orderPs = conn.prepareStatement(orderQuery);
            orderPs.setInt(1, orderId);
            ResultSet orderRs = orderPs.executeQuery();
            
            if (orderRs.next()) {
                Customer customer = new Customer();
                customer.setCustomerName(orderRs.getString("customerName"));
                customer.setCustomerAddress(orderRs.getString("customerAddress"));
                customer.setCustomerContact(orderRs.getString("customerContact"));
                order.setOrderCustomer(customer);
                
                // Convert String status to boolean
                String status = orderRs.getString("deliveryStatus");
                boolean isDelivered = "DELIVERED".equalsIgnoreCase(status);
                order.setDeliveryStatus(isDelivered);
            }
            
            // Fetch order items
            String itemsQuery = "SELECT p.productId, p.productName, p.productPrice, p.imageURL, ol.productQuantity " +
                                "FROM ORDER_LIST ol " +
                                "JOIN PRODUCT p ON ol.productId = p.productId " +
                                "WHERE ol.orderId = ?";
            PreparedStatement itemsPs = conn.prepareStatement(itemsQuery);
            itemsPs.setInt(1, orderId);
            ResultSet itemsRs = itemsPs.executeQuery();
            
            List<CartItem> cartItems = new ArrayList<>();
            double total = 0.0;
            while (itemsRs.next()) {
                Product product = new Product();
                product.setProductId(itemsRs.getInt("productId"));
                product.setProductName(itemsRs.getString("productName"));
                product.setProductPrice(itemsRs.getDouble("productPrice"));
                product.setProductImageURL(itemsRs.getString("imageURL"));
                
                CartItem cartItem = new CartItem();
                cartItem.setCartItemProduct(product);
                cartItem.setCartItemQuantity(itemsRs.getInt("productQuantity"));
                
                cartItems.add(cartItem);
                
                // Calculate total
                total += product.getProductPrice() * cartItem.getCartItemQuantity();
            }
            order.setCartItems(cartItems);
            order.setOrderTotal(total);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return order;
    }
}
