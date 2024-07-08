package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.ShoppingOrderController;
import model.Customer;
import model.OrderSummary;
import model.UserSession;

public class OrderHistoryGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ShoppingOrderController orderController;
    private Customer customer;
    private static String email;
    private static String password;

    public OrderHistoryGui(Connection conn, Customer customer, String email, String password) {
        this.orderController = new ShoppingOrderController();
        this.customer = customer;
        this.email = email;
        this.password = password;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 600);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setPreferredSize(new Dimension(960, 100));

        JLabel lblStoreName = new JLabel("APPLE SAGA STORE");
        lblStoreName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 24));
        lblStoreName.setBounds(71, 39, 239, 45);
        headerPanel.add(lblStoreName, BorderLayout.WEST);

        JButton buttonBack = new JButton("Back");
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProfileGui frame = new ProfileGui(email, password);
                frame.setVisible(true);
                dispose();
            }
        });
        buttonBack.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        buttonBack.setPreferredSize(new Dimension(60, 25));
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.add(buttonBack);
        headerPanel.add(backButtonPanel, BorderLayout.NORTH);

        JLabel lblOrderHistory = new JLabel("Order History");
        lblOrderHistory.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblOrderHistory.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(lblOrderHistory, BorderLayout.CENTER);

        contentPane.add(headerPanel, BorderLayout.NORTH);

        JPanel ordersPanel = new JPanel();
        ordersPanel.setLayout(new BoxLayout(ordersPanel, BoxLayout.Y_AXIS));
        
        JScrollPane scrollPane = new JScrollPane(ordersPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        contentPane.add(scrollPane, BorderLayout.CENTER);

        displayOrderHistory(ordersPanel);
    }

    private void displayOrderHistory(JPanel ordersPanel) {
        List<OrderSummary> orderSummaries = orderController.getOrderSummariesByCustomer(UserSession.getInstance().getCurrentUserId());
        System.out.println(UserSession.getInstance().getCurrentUserId());
        System.out.println("Number of orders: " + orderSummaries.size());

        if (orderSummaries.isEmpty()) {
            JLabel noOrderHistoryLabel = new JLabel("You have no order history.");
            noOrderHistoryLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
            noOrderHistoryLabel.setForeground(Color.GRAY); // Set the text color to gray

            ordersPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.weightx = 1;
            gbc.weighty = 1;
            ordersPanel.add(noOrderHistoryLabel, gbc);
        } else {
        for (OrderSummary summary : orderSummaries) {
            JPanel orderPanel = new JPanel(new BorderLayout());
            orderPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
            orderPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
            orderPanel.setPreferredSize(new Dimension(900, 120));

            JPanel detailsPanel = new JPanel(new GridLayout(3, 1, 5, 5));
            detailsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

            JLabel lblOrderId = new JLabel("Order ID : " + summary.getOrderId());
            lblOrderId.setFont(new Font("Times New Roman", Font.BOLD, 12));
            detailsPanel.add(lblOrderId);

            JLabel lblOrderTotal = new JLabel("Price : RM " + String.format("%.2f", summary.getTotalPrice()));
            lblOrderTotal.setFont(new Font("Times New Roman", Font.BOLD, 12));
            detailsPanel.add(lblOrderTotal);

            JLabel lblOrderStatus = new JLabel("Status: " + summary.getDeliveryStatus());
            lblOrderStatus.setFont(new Font("Times New Roman", Font.BOLD, 12));
            detailsPanel.add(lblOrderStatus);

            orderPanel.add(detailsPanel, BorderLayout.CENTER);

            JButton buttonDetails = new JButton("Details");
            buttonDetails.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int orderId = summary.getOrderId();
                    OrderDetailsGui frame = new OrderDetailsGui(orderId);
                    frame.setVisible(true);
                }
            });
            buttonDetails.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            buttonPanel.add(buttonDetails);
            orderPanel.add(buttonPanel, BorderLayout.EAST);

            ordersPanel.add(orderPanel);
            ordersPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        }
        ordersPanel.revalidate();
        ordersPanel.repaint();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Customer customer = new Customer();
                    String email = "example@example.com";
                    String password = "password";
                    OrderHistoryGui frame = new OrderHistoryGui(null, customer, email, password);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
