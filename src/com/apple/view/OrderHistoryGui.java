package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.CustomerController;
import controller.ShoppingOrderController;
import database.MyDatabase;
import model.Customer;
import model.OrderSummary;
import model.ShoppingOrder;
import model.UserSession;

public class OrderHistoryGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ShoppingOrderController orderController;
    private Customer customer;
    private static String email;
    private static String password;

    public OrderHistoryGui(Connection conn, Customer customer, String email, String password) {
        this.orderController = new ShoppingOrderController(); // Ensure connection is initialized inside the controller
        this.customer = customer;
        this.email = email;
        this.password = password;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblStoreName = new JLabel("APPLE SAGA STORE");
        lblStoreName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
        lblStoreName.setBounds(29, 34, 185, 22);
        contentPane.add(lblStoreName);

        JButton buttonBack = new JButton("Back");
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProfileGui frame = new ProfileGui(email, password);
                frame.setVisible(true);
                dispose(); // Close current frame
            }
        });
        buttonBack.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        buttonBack.setBounds(29, 66, 85, 34);
        contentPane.add(buttonBack);

        JLabel lblOrderHistory = new JLabel("Order History");
        lblOrderHistory.setFont(new Font("Tahoma", Font.BOLD, 32));
        lblOrderHistory.setBounds(388, 34, 226, 39);
        contentPane.add(lblOrderHistory);

        displayOrderHistory();
    }

    private void displayOrderHistory() {
        List<OrderSummary> orderSummaries = orderController.getOrderSummariesByCustomer(UserSession.getInstance().getCurrentUserId());
        int yPosition = 145;
        System.out.println(UserSession.getInstance().getCurrentUserId());
        System.out.println("Number of orders: " + orderSummaries.size());
        for (OrderSummary summary : orderSummaries) {
            JLabel lblOrderId = new JLabel("Order ID : " + summary.getOrderId());
            lblOrderId.setFont(new Font("Times New Roman", Font.BOLD, 12));
            lblOrderId.setBounds(96, yPosition, 608, 27);
            contentPane.add(lblOrderId);

            JLabel lblOrderTotal = new JLabel("Price : " + String.valueOf(summary.getTotalPrice())); // Ensure total price is a string
            lblOrderTotal.setFont(new Font("Times New Roman", Font.BOLD, 12));
            lblOrderTotal.setBounds(96, yPosition + 37, 608, 27);
            contentPane.add(lblOrderTotal);

            JLabel lblOrderStatus = new JLabel("Status: " + summary.getDeliveryStatus());
            lblOrderStatus.setFont(new Font("Times New Roman", Font.BOLD, 12));
            lblOrderStatus.setBounds(96, yPosition + 74, 608, 27);
            contentPane.add(lblOrderStatus);

            JButton buttonDetails = new JButton("Details");
            buttonDetails.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int orderId = summary.getOrderId(); // Get the order ID from the summary
                    OrderDetailsGui frame = new OrderDetailsGui(orderId);
                    frame.setVisible(true);
                }
            });
            buttonDetails.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            buttonDetails.setBounds(760, yPosition + 37, 103, 34);
            contentPane.add(buttonDetails);

            yPosition += 111; // Adjust position for the next order
        }
        contentPane.revalidate();
        contentPane.repaint();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Customer customer = new Customer(); // You need to fetch actual customer data
                    String email = "example@example.com";
                    String password = "password";
                    OrderHistoryGui frame = new OrderHistoryGui(null, customer, email, password); // Pass connection and customer
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
