package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CartItem;
import model.Customer;
import model.ShoppingCart;

public class CheckoutGui extends JFrame {
    private String email;
    private String password;
    private ShoppingCart shoppingCart;
    private Customer customer;
    private double total;
    private String paymentMethod;
    
    public CheckoutGui(String email, String password, ShoppingCart shoppingCart, Customer customer, double total) {
        this.email = email;
        this.password = password;
        this.shoppingCart = shoppingCart;
        this.customer = customer;
        this.total = total;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        // Main Content Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Customer Details Panel
        JPanel customerDetailsPanel = createCustomerDetailsPanel();
        mainPanel.add(customerDetailsPanel, BorderLayout.NORTH);

        // Cart Items Panel
        JScrollPane cartItemsPanel = createCartItemsPanel();
        mainPanel.add(cartItemsPanel, BorderLayout.CENTER);
        
        // Total Price and Payment Panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel totalPricePanel = createTotalPricePanel();
        bottomPanel.add(totalPricePanel, BorderLayout.NORTH);
        JPanel paymentPanel = createPaymentPanel();
        bottomPanel.add(paymentPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Button Panel
        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel storeName = new JLabel("APPLE SAGA STORE ");
        storeName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 24));
        headerPanel.add(storeName, BorderLayout.WEST);

        JButton backBttn = new JButton("BACK");
        backBttn.setFont(new Font("SansSerif", Font.PLAIN, 15));
        backBttn.addActionListener(e -> {
            dispose();
            new ShoppingCartGui(email, password, shoppingCart, customer);
        });
        headerPanel.add(backBttn, BorderLayout.EAST);

        return headerPanel;
    }

    private JPanel createCustomerDetailsPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 5));
        panel.setBorder(BorderFactory.createTitledBorder("CUSTOMER DETAILS"));
        
        if (customer != null) {
            panel.add(new JLabel("Name:"));
            panel.add(new JLabel(customer.getCustomerName()));
            panel.add(new JLabel("Contact:"));
            panel.add(new JLabel(customer.getCustomerContact()));
            panel.add(new JLabel("Address:"));
            panel.add(new JLabel(customer.getCustomerAddress()));
        } else {
            panel.add(new JLabel("Customer details not available"));
        }
        
        return panel;
    }

    private JScrollPane createCartItemsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("CART ITEMS"));
        
        if (shoppingCart != null && !shoppingCart.getCartItems().isEmpty()) {
            for (CartItem item : shoppingCart.getCartItems()) {
                JPanel productPanel = new JPanel(new BorderLayout());
                JLabel productName = new JLabel(item.getCartItemProduct().getProductName());
                productName.setFont(new Font("Tahoma", Font.BOLD, 14));
                productPanel.add(productName, BorderLayout.NORTH);
                    
                JLabel productPriceLabel = new JLabel("Per Unit Price: RM " + String.format("%.2f", item.getCartItemProduct().getProductPrice()));
                productPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
                productPriceLabel.setForeground(Color.LIGHT_GRAY);
                productPanel.add(productPriceLabel, BorderLayout.CENTER);
                    
                // Panel for quantity and subtotal
                JPanel quantitySubtotalPanel = new JPanel(new GridLayout(1, 2, 10, 5));
                JLabel quantityLabel = new JLabel("Qty: " + item.getCartItemQuantity());
                quantityLabel.setHorizontalAlignment(SwingConstants.RIGHT); // Right align quantity
                quantitySubtotalPanel.add(quantityLabel);
                
                double productPrice = item.getCartItemProduct().getProductPrice();
                int quantity = item.getCartItemQuantity();
                double subtotal = productPrice * quantity;
                JLabel subtotalLabel = new JLabel("Subtotal: RM " + String.format("%.2f", subtotal));
                subtotalLabel.setHorizontalAlignment(SwingConstants.RIGHT); // Right align subtotal
                quantitySubtotalPanel.add(subtotalLabel);
                
                productPanel.add(quantitySubtotalPanel, BorderLayout.SOUTH);
                
                panel.add(productPanel);
                panel.add(Box.createVerticalStrut(10)); // Add some spacing between items
            }
        } else {
            panel.add(new JLabel("No items in cart"));
        }
        
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(400, 300)); // Set the preferred size of the scroll pane
        return scrollPane;
    }


    private JPanel createTotalPricePanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel totalPriceLabel = new JLabel("Total Price: RM " + String.format("%.2f", total));
        totalPriceLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(totalPriceLabel);
        return panel;
    }

    private JPanel createPaymentPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblNewLabel = new JLabel("Select your payment method: ");
        lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblNewLabel, gbc);

        JRadioButton rdbtnCreditDebitCard = new JRadioButton("Credit / Debit Card");
        rdbtnCreditDebitCard.setFont(new Font("Tahoma", Font.PLAIN, 15));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(rdbtnCreditDebitCard, gbc);

        JRadioButton rdbtnOnlineBanking = new JRadioButton("Online Banking");
        rdbtnOnlineBanking.setFont(new Font("Tahoma", Font.PLAIN, 15));
        gbc.gridy = 2;
        panel.add(rdbtnOnlineBanking, gbc);

        JRadioButton rdbtnEwallet = new JRadioButton("E-Wallet");
        rdbtnEwallet.setFont(new Font("Tahoma", Font.PLAIN, 15));
        gbc.gridy = 3;
        panel.add(rdbtnEwallet, gbc);

        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(rdbtnCreditDebitCard);
        paymentGroup.add(rdbtnOnlineBanking);
        paymentGroup.add(rdbtnEwallet);

        rdbtnCreditDebitCard.addActionListener(e -> paymentMethod = "Credit/Debit Card");
        rdbtnOnlineBanking.addActionListener(e -> paymentMethod = "Online Banking");
        rdbtnEwallet.addActionListener(e -> paymentMethod = "E-Wallet");

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnPay = new JButton("Pay");
        btnPay.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnPay.addActionListener(e -> {
            if (paymentMethod == null) {
                JOptionPane.showMessageDialog(this, "Please select a payment method!");
            } else {
                JOptionPane.showMessageDialog(this, "Payment processed successfully via " + paymentMethod + "!");
                dispose();
                // Redirect to order confirmation or review page
            }
        });
        panel.add(btnPay);
        return panel;
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Customer customer = new Customer("John Doe", "0123456789", "123 Example St", "example@email.com", "password");
        double total = 100.00; // Example total
        new CheckoutGui("example@email.com", "password", shoppingCart, customer, total);
    }
}
