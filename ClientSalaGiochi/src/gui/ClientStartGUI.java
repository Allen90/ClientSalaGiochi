package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class ClientStartGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientStartGUI window = new ClientStartGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientStartGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBenvenutiNellaSala = new JLabel("Benvenuti nella Sala Giochi");
		lblBenvenutiNellaSala.setBounds(12, 12, 200, 15);
		frame.getContentPane().add(lblBenvenutiNellaSala);
		
		JLabel lblSelezionaIlTipo = new JLabel("Seleziona il tipo di connessione:");
		lblSelezionaIlTipo.setBounds(12, 73, 253, 15);
		frame.getContentPane().add(lblSelezionaIlTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"RMI", "Socket"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(262, 68, 85, 24);
		frame.getContentPane().add(comboBox);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(306, 222, 117, 25);
		frame.getContentPane().add(btnStart);
	}
}
