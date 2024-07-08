package view;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ShoppingOrderController;
import model.CartItem;
import model.Customer;
import model.ShoppingOrder;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class OrderDetailsGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private ShoppingOrderController orderController;
    
    public OrderDetailsGui(int orderId) {
        orderController = new ShoppingOrderController();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel storeName = new JLabel("APPLE SAGA STORE");
        storeName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 24));
        headerPanel.add(storeName, BorderLayout.WEST);

        JButton backBttn = new JButton("BACK");
        backBttn.setFont(new Font("SansSerif", Font.PLAIN, 15));
        backBttn.addActionListener(e -> dispose());
        headerPanel.add(backBttn, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);

        // Main Content Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Fetch order details
        ShoppingOrder shoppingOrder = orderController.getCompleteOrderDetails(orderId);

        // Order Details Panel
        JPanel orderDetailsPanel = new JPanel(new GridLayout(0, 2, 10, 5));
        orderDetailsPanel.setBorder(BorderFactory.createTitledBorder("Order Details"));
        orderDetailsPanel.add(new JLabel("Order ID:"));
        orderDetailsPanel.add(new JLabel(String.valueOf(shoppingOrder.getOrderId())));
        orderDetailsPanel.add(new JLabel("Customer Name:"));
        orderDetailsPanel.add(new JLabel(shoppingOrder.getOrderCustomer().getCustomerName()));
        orderDetailsPanel.add(new JLabel("Contact No:"));
        orderDetailsPanel.add(new JLabel(shoppingOrder.getOrderCustomer().getCustomerContact()));
        orderDetailsPanel.add(new JLabel("Delivery Address:"));
        orderDetailsPanel.add(new JLabel(shoppingOrder.getOrderCustomer().getCustomerAddress()));
        orderDetailsPanel.add(new JLabel("Delivery Status:"));
        orderDetailsPanel.add(new JLabel(shoppingOrder.isDeliveryStatus() ? "DELIVERED" : "IN-DELIVERY"));
        mainPanel.add(orderDetailsPanel, BorderLayout.NORTH);

        // Order Items Panel
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        itemsPanel.setBorder(BorderFactory.createTitledBorder("Order Items"));
        
        for (CartItem item : shoppingOrder.getCartItems()) {
            JPanel itemPanel = new JPanel(new BorderLayout(10, 5));
            itemPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            
            // Load and display product image
            String imageUrl = "/com/apple/resources/product_images/" + item.getCartItemProduct().getProductImageURL();
            URL url = getClass().getResource(imageUrl);
            
            if (url == null) {
                String filePath = System.getProperty("user.dir") + "/src" + imageUrl;
                File file = new File(filePath);
                try {
                    url = file.toURI().toURL();
                } catch (MalformedURLException e) {
                    System.err.println("Error converting file path to URL: " + e.getMessage());
                }
            }

            ImageIcon imageIcon;
            try {
                BufferedImage image = ImageIO.read(url);
                Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(scaledImage);
            } catch (Exception e) {
                System.err.println("Error loading image: " + e.getMessage());
                imageIcon = new ImageIcon("path/to/placeholder.png");
            }
            
            JLabel imageLabel = new JLabel(imageIcon);
            itemPanel.add(imageLabel, BorderLayout.WEST);
            
            JPanel itemDetailsPanel = new JPanel(new GridLayout(0, 1));
            itemDetailsPanel.add(new JLabel("Name: " + item.getCartItemProduct().getProductName()));
            itemDetailsPanel.add(new JLabel("Price: RM " + item.getCartItemProduct().getProductPrice()));
            itemDetailsPanel.add(new JLabel("Quantity: " + item.getCartItemQuantity()));
            itemPanel.add(itemDetailsPanel, BorderLayout.CENTER);
            
            itemsPanel.add(itemPanel);
            itemsPanel.add(Box.createVerticalStrut(10));
        }

        // Wrap itemsPanel in a JScrollPane
        JScrollPane itemsScrollPane = new JScrollPane(itemsPanel);
        itemsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        itemsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(itemsScrollPane, BorderLayout.CENTER);

        // Total Price Panel
        JPanel totalPricePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel totalPriceLabel = new JLabel("Total Price: RM " + String.format("%.2f", shoppingOrder.getOrderTotal()));
        totalPriceLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        totalPricePanel.add(totalPriceLabel);
        mainPanel.add(totalPricePanel, BorderLayout.SOUTH);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnCompleteOrder = new JButton("Complete Order");
        btnCompleteOrder.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnCompleteOrder.addActionListener(e -> {
            dispose();
            // new ReviewGui(null); // Uncomment and implement this to proceed to review
        });
        buttonPanel.add(btnCompleteOrder);

        JButton btnReceipt = new JButton("Print Receipt");
        btnReceipt.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnReceipt.addActionListener(e -> {
            // Print receipt logic here
        });
        buttonPanel.add(btnReceipt);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private ShoppingOrder getOrderDetails(int orderId) {
        // Fetch the order details based on the order ID.
        // This method should return a ShoppingOrder object with the details of the order.
        // For now, this is a placeholder and should be replaced with actual database fetching logic.
        ShoppingOrder shoppingOrder = new ShoppingOrder();
        shoppingOrder.setOrderId(orderId);
        Customer customer = new Customer("Example Name", "0123456789", "123, Example Street, City", "email@example.com", "password");
        shoppingOrder.setOrderCustomer(customer);
        return shoppingOrder;
    }

    public static void main(String[] args) {
        new OrderDetailsGui(1); // For testing purpose, provide a valid order ID
    }
}
