package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Customer;
import model.ShoppingOrder;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderDetailsGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtSearch;

    public OrderDetailsGui(int orderId) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        getContentPane().setForeground(new Color(0, 0, 0));
        getContentPane().setLayout(null);

        JLabel storeName = new JLabel("APPLE SAGA STORE ");
        storeName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 24));
        storeName.setBounds(66, 35, 239, 45);
        getContentPane().add(storeName);

        JButton backBttn = new JButton("BACK");
        backBttn.setFont(new Font("SansSerif", Font.PLAIN, 15));
        backBttn.setBounds(66, 90, 85, 21);
        getContentPane().add(backBttn);
        backBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                // new OrderHistory(); // Uncomment and implement this to go back to order history
            }
        });

        JPanel showCart = new JPanel();
        showCart.setBounds(66, 229, 722, 220);
        getContentPane().add(showCart);

        JLabel lblOrderDetails = new JLabel("Order Details");
        lblOrderDetails.setHorizontalAlignment(SwingConstants.LEFT);
        lblOrderDetails.setFont(new Font("Serif", Font.PLAIN, 20));
        lblOrderDetails.setBounds(378, 76, 254, 45);
        getContentPane().add(lblOrderDetails);

        JLabel lblOrderId = new JLabel("Order Id : ");
        lblOrderId.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
        lblOrderId.setBounds(66, 133, 135, 13);
        getContentPane().add(lblOrderId);

        JLabel lblshowOrderId = new JLabel(String.valueOf(orderId));
        lblshowOrderId.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
        lblshowOrderId.setBounds(155, 131, 135, 21);
        getContentPane().add(lblshowOrderId);

        // Fetch order details based on the provided order ID
        ShoppingOrder shoppingOrder = getOrderDetails(orderId);

        if (shoppingOrder != null) {
            Customer customer = shoppingOrder.getOrderCustomer();
            if (customer != null) {
                JLabel lblContactNo = new JLabel("Contact no. : ");
                lblContactNo.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
                lblContactNo.setBounds(66, 162, 135, 13);
                getContentPane().add(lblContactNo);

                JLabel lblshowContactNo = new JLabel(customer.getCustomerContact());
                lblshowContactNo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
                lblshowContactNo.setBounds(155, 160, 135, 21);
                getContentPane().add(lblshowContactNo);

                JLabel lblDeliveryAddress = new JLabel("Delivery Address : ");
                lblDeliveryAddress.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
                lblDeliveryAddress.setBounds(66, 190, 120, 13);
                getContentPane().add(lblDeliveryAddress);

                JTextArea txtDeliveryAddress = new JTextArea(customer.getCustomerAddress());
                txtDeliveryAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
                txtDeliveryAddress.setEditable(false); // Make it non-editable
                txtDeliveryAddress.setLineWrap(true); // Enable line wrapping
                txtDeliveryAddress.setWrapStyleWord(true); // Wrap at word boundaries

                JScrollPane scrollPane = new JScrollPane(txtDeliveryAddress);
                scrollPane.setBounds(186, 190, 200, 50); // Adjust the bounds to be to the right of the label
                getContentPane().add(scrollPane);
            }
        }

        JButton btnCompleteOrder = new JButton("Complete Order");
        btnCompleteOrder.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnCompleteOrder.setBounds(378, 470, 197, 43);
        getContentPane().add(btnCompleteOrder);
        btnCompleteOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                // new ReviewGui(null); // Uncomment and implement this to proceed to review
            }
        });

        JButton btnReceipt = new JButton("Print Receipt");
        btnReceipt.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnReceipt.setBounds(591, 470, 197, 43);
        getContentPane().add(btnReceipt);
        btnReceipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Print receipt logic here
            }
        });

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
