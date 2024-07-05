package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderHistoryGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderHistoryGui frame = new OrderHistoryGui();
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
	public OrderHistoryGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APPLE SAGA STORE ");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblNewLabel.setBounds(29, 34, 185, 22);
		contentPane.add(lblNewLabel);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProfileGui frame = new ProfileGui();
				frame.setVisible(true);
			}
		});
		buttonBack.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonBack.setBounds(29, 66, 85, 34);
		contentPane.add(buttonBack);
		
		JLabel lblNewLabel_1 = new JLabel("Order History");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1.setBounds(388, 34, 226, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Order ID : ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(96, 145, 608, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Price : ");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(96, 182, 608, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Status : ");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(96, 219, 608, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JButton buttonDetails = new JButton("Details ");
		buttonDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductGui(productId);
			
			}
		});
		buttonDetails.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonDetails.setBounds(760, 178, 103, 34);
		contentPane.add(buttonDetails);
	}

}
