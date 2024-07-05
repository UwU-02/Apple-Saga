package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewGui frame = new ReviewGui();
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
	public ReviewGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APPLE SAGA STORE ");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblNewLabel.setBounds(44, 38, 185, 22);
		contentPane.add(lblNewLabel);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductDetailGui frame = new ProductDetailGui();
				frame.setVisible(true);
			}
		});
		buttonBack.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonBack.setBounds(44, 70, 85, 34);
		contentPane.add(buttonBack);
		
		JLabel lblNewLabel_1_1 = new JLabel("Feedback");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1_1.setBounds(419, 38, 252, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Image");
		lblNewLabel_1.setBounds(61, 207, 45, 13);
		contentPane.add(lblNewLabel_1);

		ImageIcon imageIcon = new ImageIcon(product.getProductImageURL());
        JButton productImage = new JButton(imageIcon);
        productImage.setBounds(282, 161, 150, 117);
        frame.getContentPane().add(productImage);
        productImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              //  new ProductDetailGui(productId); // Open the product details page 
            }
        });
		
		JLabel lblNewLabel_2 = new JLabel("Airpods Pro");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2.setBounds(393, 152, 137, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("RM 999");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(393, 177, 137, 22);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("White");
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(393, 198, 137, 22);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3 = new JLabel("pcs ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(731, 152, 45, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Write your feedback : ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(61, 360, 202, 22);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(61, 392, 661, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton buttonSubmit = new JButton("Submit");
		buttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductDetailGui frame = new ProductDetailGui();
				frame.setVisible(true);
			}
		});
		buttonSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonSubmit.setBounds(802, 479, 110, 34);
		contentPane.add(buttonSubmit);
	}

}
