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

public class RegisterGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldPassword;
	private JTextField textFieldConfirm;
	private JTextField textFieldAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGui frame = new RegisterGui();
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
	public RegisterGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APPLE SAGA STORE ");
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 18));
		lblNewLabel.setBounds(47, 36, 185, 22);
		contentPane.add(lblNewLabel);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginPageGui frame = new LoginPageGui();
				frame.setVisible(true);
			}
		});
		buttonBack.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonBack.setBounds(45, 64, 85, 34);
		contentPane.add(buttonBack);
		
		JLabel lblNewLabel_1 = new JLabel("Register");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel_1.setBounds(421, 31, 155, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(199, 86, 77, 22);
		contentPane.add(lblNewLabel_2);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(199, 118, 544, 27);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(199, 155, 77, 22);
		contentPane.add(lblNewLabel_3);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(199, 187, 544, 30);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(199, 227, 167, 22);
		contentPane.add(lblNewLabel_4);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setBounds(199, 259, 544, 34);
		contentPane.add(textFieldPhoneNumber);
		textFieldPhoneNumber.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(199, 335, 544, 30);
		contentPane.add(textFieldPassword);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password : ");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1.setBounds(199, 303, 167, 22);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Confirm Password : ");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1_1.setBounds(199, 375, 185, 22);
		contentPane.add(lblNewLabel_4_1_1);
		
		textFieldConfirm = new JTextField();
		textFieldConfirm.setColumns(10);
		textFieldConfirm.setBounds(199, 407, 544, 30);
		contentPane.add(textFieldConfirm);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(199, 479, 544, 63);
		contentPane.add(textFieldAddress);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Address : ");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4_1_1_1.setBounds(199, 447, 185, 22);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JButton buttonSignUp = new JButton("Sign Up");
		buttonSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		buttonSignUp.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonSignUp.setBounds(822, 505, 91, 34);
		contentPane.add(buttonSignUp);
	}
}
