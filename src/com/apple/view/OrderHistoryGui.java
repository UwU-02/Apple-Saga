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

import com.apple.controller.CustomerController;
import com.apple.controller.ShoppingOrderController;
import database.MyDatabase;
import com.apple.model.Customer;
import com.apple.model.ShoppingOrder;

public class OrderHistoryGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ShoppingOrderController orderController;
    private Customer customer;
    private static String email;
    private static String password;

    public OrderHistoryGui(Connection conn, Customer customer,String email, String password) {
        this.orderController = new ShoppingOrderController();
        this.customer = customer;
        this.email=email;
        this.password=password;
        
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
        List<ShoppingOrder> orders = orderController.getOrdersByCustomer(customer.getCustomerId());
        int yPosition = 145;
        for (ShoppingOrder order : orders) {
            JLabel lblOrderId = new JLabel("Order ID : " + order.getOrderId());
            lblOrderId.setFont(new Font("Times New Roman", Font.BOLD, 12));
            lblOrderId.setBounds(96, yPosition, 608, 27);
            contentPane.add(lblOrderId);

            JLabel lblOrderTotal = new JLabel("Price : " + order.getOrderTotal());
            lblOrderTotal.setFont(new Font("Times New Roman", Font.BOLD, 12));
            lblOrderTotal.setBounds(96, yPosition + 37, 608, 27);
            contentPane.add(lblOrderTotal);

            JLabel lblOrderStatus = new JLabel("Status: " + (order.isDeliveryStatus() ? "Delivered" : "Pending"));
            lblOrderStatus.setFont(new Font("Times New Roman", Font.BOLD, 12));
            lblOrderStatus.setBounds(96, yPosition + 74, 608, 27);
            contentPane.add(lblOrderStatus);

            JButton buttonDetails = new JButton("Details");
            buttonDetails.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implement action for viewing order details
                    // Example: new OrderDetailsGui(order).setVisible(true);
                }
            });
            buttonDetails.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            buttonDetails.setBounds(760, yPosition + 37, 103, 34);
            contentPane.add(buttonDetails);

            yPosition += 111; // Adjust position for the next order
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Establish database connection
                    Connection conn = MyDatabase.doConnection();

                    // Fetch customer data as needed (example)
                    Customer customer = new Customer();

                   
					// Initialize and display OrderHistoryGui
                    OrderHistoryGui frame = new OrderHistoryGui(conn, customer,email,password);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
