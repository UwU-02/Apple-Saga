package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.CustomerController;
import controller.ProductController;
import model.Customer;
import model.Product;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ProfileGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel showCustName;
	private JLabel showCustEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileGui frame = new ProfileGui("customerEmail", "customerPassword");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void updateCustomerDetails(String email, String password) {
	    CustomerController customerController = new CustomerController();
	    Customer customer = customerController.getCustomerDetailbyUsernamePassword(email, password);

	    if (customer != null) {
	        showCustName.setText("USERNAME: " + customer.getCustomerName());
	        showCustEmail.setText("EMAIL: " + customer.getCustomerEmail());
	    }
	}

	/**
	 * Create the frame.
	 */
	public ProfileGui(String email, String password) {
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
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1.setBounds(402, 31, 135, 39);
		contentPane.add(lblNewLabel_1);
		
		JButton buttonOrder = new JButton("Order History ");
		buttonOrder.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		buttonOrder.setBounds(224, 367, 498, 39);
		contentPane.add(buttonOrder);
		
		JButton buttonShopping = new JButton("Shopping Cart");
		buttonShopping.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
		buttonShopping.setBounds(225, 416, 497, 39);
		contentPane.add(buttonShopping);
		
		showCustName = new JLabel("Username ");
		showCustName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		showCustName.setBounds(373, 238, 195, 34);
		contentPane.add(showCustName);
		
		showCustEmail = new JLabel(" Email");
		showCustEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		showCustEmail.setBounds(373, 272, 250, 34);
		contentPane.add(showCustEmail);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
        try {
            Image image = ImageIO.read(new File("C:\\Users\\Manni\\Documents\\UNIVERSITY STUDY\\Y2S2 sub\\OOP SANUSI\\PROJECT APPLE\\photos\\profile.png"));
            Image scaledImage = image.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
            lblNewLabel_3.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lblNewLabel_3.setPreferredSize(new Dimension(128, 128));
        lblNewLabel_3.setBounds(402, 90, 128, 128);
        contentPane.add(lblNewLabel_3);
        
        JButton btnShopping = new JButton("Shop Products");
        btnShopping.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductController controller = new ProductController();
                List<Product> products = controller.getAllProduct();
                new ProductGui(products, null, ProfileGui.this, email, password); // Pass the email and password
                setVisible(false); 
            }
        });
        btnShopping.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
        btnShopping.setBounds(224, 316, 498, 39);
        contentPane.add(btnShopping);
		
        updateCustomerDetails(email, password);
		
	}
}
