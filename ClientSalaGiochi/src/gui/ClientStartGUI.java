package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import comunicazione.Comunicazione;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JTextField;

import eccezioni.EccezioneUtente;

/**
 * JFrame che permette l'esecuzione del client, in base alla scelta dell'utente tramite combobox
 * viene deciso il tipo di comunicazione da utilizzare
 * @author fritz
 *
 */

public class ClientStartGUI {

	private JFrame frame;
	private static final int port = 4445;
//	private static final String host = "127.0.0.1";
	private static final String url = "rmi://127.0.0.1/server";
	private Socket socket;
	private Comunicazione comunicazione;
	private LoginGui login;
	private RegisterGui register;
	private JComboBox comboBox;
	private JTextField textIP;
	private StringTokenizer st;
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

		comboBox = new JComboBox();
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
//						if (System.getSecurityManager() == null) 
//							System.setSecurityManager(new SecurityManager()); 
//						Registry registry = LocateRegistry.getRegistry(host); 
//						//Recupero l’istanza della classe remota 
//						RmiServer server = (RmiServer) registry.lookup(url);
//						comunicazione = new Comunicazione(server);
						comunicazione = new Comunicazione();
						register = new RegisterGui(analizzaIP(textIP.getText()), comunicazione);
						register.setVisible(true);
						frame.setVisible(false);
					} 
					catch (Exception e1) {
						e1.printStackTrace();
						System.out.print("impossibile connettersi al server rmi");
					} 
				}
				else{
					try {
						//socket = new Socket(host , port);
						socket = new Socket(analizzaIP(textIP.getText()), port);
						comunicazione = new Comunicazione(socket);
						register = new RegisterGui(null, comunicazione);
						register.setVisible(true);
						frame.setVisible(false);
					}
					catch(IOException e1){
						System.out.print("impossibile connettersi al server socket");
					}catch (EccezioneUtente e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
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
//						if (System.getSecurityManager() == null) 
//							System.setSecurityManager(new SecurityManager()); 
//						Registry registry = LocateRegistry.getRegistry(host); 
//						//Recupero l’istanza della classe remota 
//						RmiServer server = (RmiServer) registry.lookup(url);
						comunicazione = new Comunicazione();
						login = new LoginGui(analizzaIP(textIP.getText()), comunicazione);
						login.setVisible(true);
						frame.setVisible(false);
					} 
					catch (Exception e1) {
						e1.printStackTrace();
						System.out.print("impossibile connettersi al server rmi");
					} 
				}
				else{
					try {
						//socket = new Socket(host , port);
						System.out.println(analizzaIP(textIP.getText()));
						socket = new Socket(analizzaIP(textIP.getText()), port);
						System.out.println("socket creato:" + socket);
						comunicazione = new Comunicazione(socket);
						login = new LoginGui(null, comunicazione);
						login.setVisible(true);
						frame.setVisible(false);
					}
					catch(IOException e1){
						System.out.print("impossibile connettersi al server socket");
					}catch (EccezioneUtente e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}


				}

			}
		});
		btnLogin.setBounds(181, 234, 117, 25);
		frame.getContentPane().add(btnLogin);
		
		textIP = new JTextField();
		textIP.setBounds(262, 138, 101, 20);
		frame.getContentPane().add(textIP);
		textIP.setColumns(10);
		
		JLabel lblInserisciLindirizzoIp = new JLabel("Inserisci l'indirizzo IP del server:");
		lblInserisciLindirizzoIp.setBounds(12, 141, 188, 14);
		frame.getContentPane().add(lblInserisciLindirizzoIp);
	}
	
	
	public String analizzaIP(String s) throws EccezioneUtente{
		int n = 0;
		String output = "";
		st = new StringTokenizer(s, ".");
		
		if(st.countTokens() != 4)
			throw new EccezioneUtente("IP inserito non corretto!");
		else{
			try{
				while(st.hasMoreTokens()){
					n = Integer.parseInt(st.nextToken());
					if(n < 0 || n > 255){
						throw new EccezioneUtente("IP inserito non corretto!");
					}else{
						output += n + ".";
					}
				}
			}catch(NumberFormatException e){
				throw new EccezioneUtente("IP inserito non corretto!");
			}
			output = output.substring(0, output.length()-1);
			return output;
		}
	}
}
