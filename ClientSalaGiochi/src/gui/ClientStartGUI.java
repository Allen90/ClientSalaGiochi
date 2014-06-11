package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import comunicazione.Comunicazione;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientStartGUI {

	private JFrame frame;
	private static final int port = 4445;
	private static final String host = "127.0.0.1";
	private Socket socket;
	private Comunicazione comunicazione;
	private LoginFrame login;
	private RegisterFrame register;
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
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"RMI", "Socket"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(262, 68, 85, 24);
		frame.getContentPane().add(comboBox);
		
		JButton btnStart = new JButton("Registrati");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int tipoComn = comboBox.getSelectedIndex();
				if(tipoComn == 0){
					
				}
				else{
					try {
						socket = new Socket(host , port);
						comunicazione = new Comunicazione(socket);
						resitra = new RegisterFrame(comunicazione);
					}
					catch(Exception e1){
						
					}

					
				}
				
			}
		});
		btnStart.setBounds(310, 234, 117, 25);
		frame.getContentPane().add(btnStart);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int tipoComn = comboBox.getSelectedIndex();
				if(tipoComn == 0){
					
				}
				else{
					try {
						socket = new Socket(host , port);
						comunicazione = new Comunicazione(socket);
						login = new LoginFrame(comunicazione);
					}
					catch(Exception e1){
						
					}

					
				}
				
			}
		});
		btnLogin.setBounds(181, 234, 117, 25);
		frame.getContentPane().add(btnLogin);
	}
}
