package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FramePrincipale extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipale frame = new FramePrincipale();
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
	public FramePrincipale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 448, 271);
		contentPane.add(tabbedPane);
		
				JPanel panel = new JPanel();
				tabbedPane.addTab("Giochi", null, panel, null);
				panel.setLayout(null);
				
						JLabel lblUsername = new JLabel("UserName");
						lblUsername.setBounds(12, 12, 87, 15);
						panel.add(lblUsername);
						
								JLabel lblNewLabel = new JLabel("New label");
								lblNewLabel.setBounds(102, 12, 70, 15);
								panel.add(lblNewLabel);
								
										JLabel lblCrediti = new JLabel("Crediti:");
										lblCrediti.setBounds(221, 12, 70, 15);
										panel.add(lblCrediti);
										
												JLabel lblNewLabel_1 = new JLabel("New label");
												lblNewLabel_1.setBounds(289, 12, 70, 15);
												panel.add(lblNewLabel_1);
												
														JButton btnNewButton = new JButton("Slot");
														btnNewButton.setBounds(12, 111, 117, 25);
														panel.add(btnNewButton);
														
																JButton btnNewButton_1 = new JButton("Tombola");
																btnNewButton_1.setBounds(167, 111, 117, 25);
																panel.add(btnNewButton_1);
																
																		JButton btnNewButton_2 = new JButton("Rubamazzo");
																		btnNewButton_2.setBounds(314, 111, 117, 25);
																		panel.add(btnNewButton_2);
																				
																				JComboBox comboBox = new JComboBox();
																				comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
																				comboBox.setSelectedIndex(0);
																				comboBox.setBounds(214, 148, 70, 24);
																				panel.add(comboBox);
																				
																				JButton btnLogout = new JButton("Logout");
																				btnLogout.setBounds(314, 207, 117, 25);
																				panel.add(btnLogout);
																				
																						JPanel panel_1 = new JPanel();
																						tabbedPane.addTab("Classifica", null, panel_1, null);
																						panel_1.setLayout(null);
																						
																								JLabel lblGlobale = new JLabel("Globale");
																								lblGlobale.setBounds(12, 12, 70, 15);
																								panel_1.add(lblGlobale);
																								
																										JLabel lblGiornaliera = new JLabel("Giornaliera");
																										lblGiornaliera.setBounds(240, 12, 99, 15);
																										panel_1.add(lblGiornaliera);
																										
																												JTextArea textArea = new JTextArea();
																												textArea.setEditable(false);
																												textArea.setBounds(12, 39, 170, 193);
																												panel_1.add(textArea);
																												
																														JTextArea textArea_1 = new JTextArea();
																														textArea_1.setBounds(240, 39, 191, 193);
																														panel_1.add(textArea_1);
	}
}
