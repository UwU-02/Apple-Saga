package view;

import java.awt.EventQueue;

import com.apple.model.Product;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductDetailGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldReview;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductDetailGui frame = new ProductDetailGui();
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
	public ProductDetailGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APPLE SAGA STORE ");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblNewLabel.setBounds(39, 38, 185, 22);
		contentPane.add(lblNewLabel);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductGui();  //back to ProductGui page
			
			}
		});
		buttonBack.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonBack.setBounds(39, 70, 85, 34);
		contentPane.add(buttonBack);
		
		JLabel lblNewLabel_1 = new JLabel("Image");
		lblNewLabel_1.setBounds(50, 184, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		Product product = new Product();
		ImageIcon imageIcon = new ImageIcon(product .getProductImageURL());
        JButton productImage = new JButton(imageIcon);
        productImage.setBounds(282, 161, 150, 117);
        JFrame frame = null;
		frame.getContentPane().add(productImage);
        productImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              //  new ProductGui(productId); // Open the product page 
            }
        });
		
		JLabel lblNewLabel_2 = new JLabel("Item");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2.setBounds(406, 141, 137, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("price");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(406, 173, 137, 22);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("colour");
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(406, 194, 137, 22);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Stock");
		lblNewLabel_2_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(406, 215, 137, 22);
		contentPane.add(lblNewLabel_2_3);
		
		JButton btnNewButton = new JButton("ADD TO CART");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShoppingCart();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(428, 288, 160, 34);
		contentPane.add(btnNewButton);
		
		JButton btnBuyNow = new JButton("BUY NOW");
		btnBuyNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new CheckoutGui(); //go to checkout page for payment
			}
		});
		btnBuyNow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuyNow.setBounds(631, 288, 160, 34);
		contentPane.add(btnBuyNow);
		
		JLabel lblNewLabel_3 = new JLabel("Review : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(50, 368, 85, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Customer Id : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(50, 400, 100, 13);
		contentPane.add(lblNewLabel_4);
		
		textFieldReview = new JTextField();
		textFieldReview.setBounds(60, 423, 710, 34);
		contentPane.add(textFieldReview);
		textFieldReview.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Detail");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1_1.setBounds(362, 38, 252, 39);
		contentPane.add(lblNewLabel_1_1);
	}

}
