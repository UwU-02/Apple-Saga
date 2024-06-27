package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Customer;
import model.ShoppingOrder;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderDetailsGui {

	private JFrame frame;
    private JTextField txtSearch;
    
    public OrderDetailsGui() {
   	 frame = new JFrame();
   	frame.getContentPane().setForeground(new Color(0, 0, 0));
    frame.setBounds(100, 100, 900, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JLabel storeName = new JLabel("APPLE SAGA STORE ");
    storeName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 24));
    storeName.setBounds(66, 35, 239, 45);
    frame.getContentPane().add(storeName);
    
    
    JButton backBttn = new JButton("BACK");
    backBttn.setFont(new Font("SansSerif", Font.PLAIN, 15));
    backBttn.setBounds(66, 90, 85, 21);
    frame.getContentPane().add(backBttn);
    backBttn.addActionListener(new ActionListener() {
   	 public void actionPerformed(ActionEvent e) {
   		 frame.dispose(); 
            //new OrderHistory();
         }
     });
    JPanel showCart = new JPanel();
    showCart.setBounds(66, 229, 722, 220);
    frame.getContentPane().add(showCart);
    
    JLabel lblOrderDetails = new JLabel("Order Details");
    lblOrderDetails.setHorizontalAlignment(SwingConstants.LEFT);
    lblOrderDetails.setFont(new Font("Serif", Font.PLAIN, 20));
    lblOrderDetails.setBounds(378, 76, 254, 45);
    frame.getContentPane().add(lblOrderDetails);
    
    
    JLabel lblOrderId = new JLabel("Order Id:");
    lblOrderId .setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
    lblOrderId .setBounds(66, 133, 135, 13);
    frame.getContentPane().add(lblOrderId);
    
    ShoppingOrder shoppingOrder = new ShoppingOrder();
    String orderIdText = String.valueOf(shoppingOrder.getOrderId());
    JLabel lblshowOrderId = new JLabel(orderIdText);
    lblshowOrderId.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
    lblshowOrderId.setBounds(152, 131, 135, 21);
    frame.getContentPane().add(lblshowOrderId);
    
    JLabel lblContactNo = new JLabel("Contact no. :");
    lblContactNo.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
    lblContactNo.setBounds(66, 162, 135, 13);
    frame.getContentPane().add(lblContactNo);
    
  /*  JLabel lblshowContactNo = new JLabel(shoppingOrder.getCustomerContact());
    lblshowContactNo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));              //get customer contact no
    lblshowContactNo.setBounds(639, 223, 135, 21);
    frame.getContentPane().add(lblshowContactNo);
    */
    JLabel lblDeliveryAddress = new JLabel("Delivery Address :");
    lblDeliveryAddress.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
    lblDeliveryAddress.setBounds(66, 190, 135, 13);
    frame.getContentPane().add(lblDeliveryAddress);
    
  /*  JLabel lblshowDeliveryAddress = new JLabel(shoppingOrder.getCustomerAddress());
    lblshowDeliveryAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));           //get customer Address
    lblshowDeliveryAddress.setBounds(639, 291, 135, 21);
    frame.getContentPane().add(lblshowDeliveryAddress);
    */
    
    JButton btnCompleteOrder = new JButton("Complete Order");
    btnCompleteOrder.setFont(new Font("Times New Roman", Font.BOLD, 15));
    btnCompleteOrder.setBounds(378, 470, 197, 43);
    frame.getContentPane().add(btnCompleteOrder);
    btnCompleteOrder.addActionListener(new ActionListener() {
   	 public void actionPerformed(ActionEvent e) {
   		 frame.dispose(); 
            new ReviewGui(null);
         }
     });
    
    JButton btnReceipt = new JButton("Print Receipt");
    btnReceipt.setFont(new Font("Times New Roman", Font.BOLD, 15));
    btnReceipt.setBounds(591, 470, 197, 43);
    frame.getContentPane().add(btnReceipt);
    btnReceipt.addActionListener(new ActionListener() {
   	 public void actionPerformed(ActionEvent e) {
   //print receipt
         }
     });
}
    }
