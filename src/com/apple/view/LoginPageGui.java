package view;

import com.apple.model.Customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(427, 55, 132, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to APPLE SAGA STORE");
		lblNewLabel_1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 24));
		lblNewLabel_1.setBounds(286, 117, 386, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(174, 193, 105, 24);
		contentPane.add(lblNewLabel_2);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(174, 227, 556, 33);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(174, 283, 105, 33);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(174, 319, 556, 33);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("Don't have an account? ");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(174, 359, 167, 22);
		contentPane.add(lblNewLabel_4);
		
		JToggleButton buttonSignUp = new JToggleButton("Sign up here");
		buttonSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Register frame = new Register();
				frame.setVisible(true);
				
			}
		});
		buttonSignUp.setBackground(UIManager.getColor("Button.darkShadow"));
		buttonSignUp.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		buttonSignUp.setBounds(340, 362, 132, 21);
		contentPane.add(buttonSignUp);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//fix this code for database
				String email = textFieldEmail.getText();
			    String password = passwordField.getText();
				if (email.equals("Austin")&&(password.equals("1234"))) {
					JOptionPane.showMessageDialog(null,  "Login Successful");
				}
				else
					JOptionPane.showMessageDialog(null,  "Invalid Credentials");
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.darkShadow"));
		btnNewButton.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 20));
		btnNewButton.setBounds(415, 434, 132, 33);
		contentPane.add(btnNewButton);
	}
}
