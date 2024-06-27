package view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;



import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Color;
import model.Customer;

public class CheckoutGui {
	private JFrame frame;
    private JTextField txtSearch;
    private static String paymentMethod;
    
    public CheckoutGui() {
	 frame = new JFrame();
	 frame.getContentPane().setForeground(new Color(0, 0, 0));
     frame.setBounds(100, 100, 900, 600);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.getContentPane().setLayout(null);
     
     JLabel storeName = new JLabel("APPLE SAGA STORE ");
     storeName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 24));
     storeName.setBounds(66, 35, 239, 45);
     frame.getContentPane().add(storeName);
     
     JLabel lblCheckout = new JLabel("CHECKOUT");
     lblCheckout.setHorizontalAlignment(SwingConstants.LEFT);
     lblCheckout.setFont(new Font("Serif", Font.PLAIN, 20));
     lblCheckout.setBounds(378, 76, 254, 45);
     frame.getContentPane().add(lblCheckout);
     
     JButton btnPay = new JButton("Pay");
     btnPay.setFont(new Font("Times New Roman", Font.BOLD, 15));
     btnPay.setBounds(720, 487, 117, 43);
     frame.getContentPane().add(btnPay);
     btnPay.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent e) {
    		 frame.dispose(); 
             new ReviewGui(null);
          }
      });
     
     JButton backBttn = new JButton("BACK");
     backBttn.setFont(new Font("SansSerif", Font.PLAIN, 15));
     backBttn.setBounds(66, 90, 85, 21);
     frame.getContentPane().add(backBttn);
     backBttn.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent e) {
    		 frame.dispose(); 
             new ShoppingCart(null);
          }
      });
     
     JPanel showCart = new JPanel();
     showCart.setBounds(62, 132, 457, 208);
     frame.getContentPane().add(showCart);
     
     JLabel lblLabelReceiverName = new JLabel("ReceiverName");
     lblLabelReceiverName.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
     lblLabelReceiverName.setBounds(639, 132, 135, 13);
     frame.getContentPane().add(lblLabelReceiverName);
     
     Customer customer = new Customer();
     JLabel lblshowReceiverName = new JLabel(customer.getCustomerName());
     lblshowReceiverName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
     lblshowReceiverName.setBounds(639, 159, 135, 21);
     frame.getContentPane().add(lblshowReceiverName);
     
     JLabel lblContactNo = new JLabel("Contact no.");
     lblContactNo.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
     lblContactNo.setBounds(639, 196, 135, 13);
     frame.getContentPane().add(lblContactNo);
     
     JLabel lblshowContactNo = new JLabel(customer.getCustomerContact());
     lblshowContactNo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
     lblshowContactNo.setBounds(639, 223, 135, 21);
     frame.getContentPane().add(lblshowContactNo);
     
     JLabel lblDeliveryAddress = new JLabel("Delivery Address");
     lblDeliveryAddress.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
     lblDeliveryAddress.setBounds(639, 264, 135, 13);
     frame.getContentPane().add(lblDeliveryAddress);
     
     JLabel lblshowDeliveryAddress = new JLabel(customer.getCustomerAddress());
     lblshowDeliveryAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
     lblshowDeliveryAddress.setBounds(639, 291, 135, 21);
     frame.getContentPane().add(lblshowDeliveryAddress);
     
     JLabel lblNewLabel = new JLabel("Select your payment method: ");
     lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
     lblNewLabel.setBounds(66, 350, 198, 21);
     frame.getContentPane().add(lblNewLabel);
     
     JRadioButton rdbtnCreditDebitCard = new JRadioButton("Credit / Debit Card");
     rdbtnCreditDebitCard.setFont(new Font("Tahoma", Font.PLAIN, 15));
     rdbtnCreditDebitCard.setBounds(66, 391, 163, 21);
     frame.getContentPane().add(rdbtnCreditDebitCard);
     
     JRadioButton rdbtnOnlineBanking = new JRadioButton("Online Banking");
     rdbtnOnlineBanking.setFont(new Font("Tahoma", Font.PLAIN, 15));
     rdbtnOnlineBanking.setBounds(66, 432, 163, 21);
     frame.getContentPane().add(rdbtnOnlineBanking);
     
     JRadioButton rdbtnEwallet = new JRadioButton("E-Wallet");
     rdbtnEwallet.setFont(new Font("Tahoma", Font.PLAIN, 15));
     rdbtnEwallet.setBounds(66, 473, 163, 21);
     frame.getContentPane().add(rdbtnEwallet);
     
     ButtonGroup paymentGroup = new ButtonGroup();
     paymentGroup.add(rdbtnCreditDebitCard);
     paymentGroup.add(rdbtnOnlineBanking);
     paymentGroup.add(rdbtnEwallet);

     rdbtnCreditDebitCard.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             paymentMethod = "Credit/Debit Card";
             // controller.setPaymentMethod("Credit/Debit Card");
         }
     });

     rdbtnOnlineBanking.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             paymentMethod = "Online Banking";
             // controller.setPaymentMethod("Online Banking");
         }
     });

     rdbtnEwallet.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             paymentMethod = "E-Wallet";
             // controller.setPaymentMethod("E-wallet");
         }
     });

     frame.setVisible(true);
     
    }
    public static void main(String[] args) {
     
        new CheckoutGui();
    }
}