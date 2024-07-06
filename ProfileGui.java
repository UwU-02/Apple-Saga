package com.apple.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.apple.controller.ShoppingCartController;
import com.apple.controller.CustomerController;
import com.apple.model.CartItem;
import com.apple.model.Customer;
import com.apple.model.Product;
import com.apple.model.ShoppingCart;
import com.apple.model.UserSession;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ProfileGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileGui frame = new ProfileGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProfileGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APPLE SAGA STORE ");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblNewLabel.setBounds(34, 31, 185, 22);
		contentPane.add(lblNewLabel);
		
		JButton buttonLogout = new JButton("Logout");
		buttonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginPageGui frame = new LoginPageGui();
				frame.setVisible(true);
			}
		});
		buttonLogout.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonLogout.setBounds(34, 57, 101, 34);
		contentPane.add(buttonLogout);
		
		JLabel lblNewLabel_1 = new JLabel("Profile");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1.setBounds(414, 31, 135, 39);
		contentPane.add(lblNewLabel_1);
		
		JButton buttonOrder = new JButton("Order History ");
		buttonOrder.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		buttonOrder.setBounds(224, 316, 498, 61);
		contentPane.add(buttonOrder);
		
		JButton buttonShopping = new JButton("Shopping Cart");
		buttonShopping.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		buttonShopping.setBounds(225, 407, 497, 61);
		contentPane.add(buttonShopping);

		buttonShopping.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dispose();
		        ShoppingCartController cartController = new ShoppingCartController();
		        try {
					cartController.connectToDatabase();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
		        int customerId = getCurrentCustomerId(); 
		        
		        ShoppingCart cart = cartController.getShoppingCartDetailbyCustomerId(customerId);
		        List<Product> products = new ArrayList<>();
		        
		        if (cart != null && cart.getCartItems() != null) {
		            for (CartItem item : cart.getCartItems()) {
		                products.add(item.getCartItemProduct());
		            }
		        }
		        
		        com.apple.view.ShoppingCart frame = new com.apple.view.ShoppingCart(products);
		        frame.setVisible(true);
		    }
		});
		JLabel lblNewLabel_2 = new JLabel("Username ");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(432, 250, 79, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(" Email");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(442, 272, 57, 34);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\This PC\\Downloads\\profile.jpg"));
		lblNewLabel_3.setBounds(373, 80, 195, 171);
		contentPane.add(lblNewLabel_3);
	}

	private int getCurrentCustomerId() {
	    return UserSession.getInstance().getCurrentUserId();
	}
	
}