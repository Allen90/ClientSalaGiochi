package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 12, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setBounds(12, 55, 97, 15);
		contentPane.add(lblCognome);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(12, 93, 86, 15);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 137, 86, 15);
		contentPane.add(lblPassword);
		
		JLabel lblPasswordConfimation = new JLabel("Password Confimation:");
		lblPasswordConfimation.setBounds(12, 180, 185, 15);
		contentPane.add(lblPasswordConfimation);
		
		JButton btnNewButton = new JButton("Invia");
		btnNewButton.setBounds(294, 236, 144, 25);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(190, 10, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 53, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 91, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(190, 135, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(190, 178, 114, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}
