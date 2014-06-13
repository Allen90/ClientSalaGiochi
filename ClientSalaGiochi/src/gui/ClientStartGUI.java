package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import rmiServer.RmiServer;
import comunicazione.Comunicazione;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientStartGUI {

	private JFrame frame;
	private static final int port = 4445;
	private static final String host = "127.0.0.1";
	private static final String url = "rmi://127.0.0.1/server";
	private Socket socket;
	private Comunicazione comunicazione;
	private LoginGui login;
	private RegisterGui register;
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
					try {
						if (System.getSecurityManager() == null) 
							System.setSecurityManager(new SecurityManager()); 
						Registry registry = LocateRegistry.getRegistry(host); 
						//Recupero l’istanza della classe remota 
						RmiServer server = (RmiServer) registry.lookup(url);
						comunicazione = new Comunicazione(server);
						register = new RegisterGui(comunicazione);
						register.setVisible(true);
					} 
					catch (Exception e1) {
						e1.printStackTrace();
						System.out.print("impossibile connettersi al server rmi");
					} 
				}
				else{
					try {
						socket = new Socket(host , port);
						comunicazione = new Comunicazione(socket);
						register = new RegisterGui(comunicazione);
						register.setVisible(true);
					}
					catch(Exception e1){
						System.out.print("impossibile connettersi al server socket");

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
					try {
						if (System.getSecurityManager() == null) 
							System.setSecurityManager(new SecurityManager()); 
						Registry registry = LocateRegistry.getRegistry(host); 
						//Recupero l’istanza della classe remota 
						RmiServer server = (RmiServer) registry.lookup(url);
						comunicazione = new Comunicazione(server);
						login = new LoginGui(comunicazione);
						login.setVisible(true);
					} 
					catch (Exception e1) {
						e1.printStackTrace();
						System.out.print("impossibile connettersi al server rmi");
					} 
				}
				else{
					try {
						socket = new Socket(host , port);
						comunicazione = new Comunicazione(socket);
						login = new LoginGui(comunicazione);
						login.setVisible(true);
					}
					catch(Exception e1){
						System.out.print("impossibile connettersi al server socket");
					}


				}

			}
		});
		btnLogin.setBounds(181, 234, 117, 25);
		frame.getContentPane().add(btnLogin);
	}
}
