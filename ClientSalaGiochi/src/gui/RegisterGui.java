package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import rmiServer.RmiServer;
import rmiServer.RmiTaskControl;
import userModel.InfoHome;
import comunicazione.Comunicazione;
import eccezioni.EccezioneClassificaVuota;
import eccezioni.EccezioneUtente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.ParseException;

public class RegisterGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String host = "127.0.0.1";
	private static final String url = "rmi://127.0.0.1/server";
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCognome;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private JPasswordField textConfPass;
	private Comunicazione comunicazione;
	private FramePrincipale home;


	private RmiTaskControl rmi;
	private JButton btnRegistra;

	/**
	 * Create the frame.
	 * @throws NotBoundException 
	 * @throws ParseException 
	 */
	public void inviaRegistrazione() throws NotBoundException, ParseException{
		if(!(textUsername.getText().isEmpty() && textPassword.getPassword().toString().isEmpty() && textNome.getText().isEmpty() && textCognome.getText().isEmpty() && textConfPass.getPassword().toString().isEmpty())){
			JOptionPane.showMessageDialog(null, "Dati registrazione incompleti, riempi tutti i campi!");
		}

		else{
			if(comunicazione.getTipoCom()){
				System.out.println("qui in socket");
				comunicazione.registraSocket(textUsername.getText(), textPassword.getPassword().toString(), textConfPass.getPassword().toString(), textNome.getText(), textCognome.getText());
				InfoHome ih = null;
				try {
					ih = comunicazione.riceviRegistraSocket();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(ih == null){
					System.out.println("qui in ih = null");
					JOptionPane.showMessageDialog(null, "Errore nella registrazione");
				}
				else{
					try {
						home = new FramePrincipale(ih.getNome(),ih.getCrediti(),comunicazione);
					} catch (IOException | EccezioneClassificaVuota e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					home.setVisible(true);
					this.setVisible(false);
				}
			}
			else{
				System.out.println("qui in rmi");
				try {
					if (System.getSecurityManager() == null) 
						System.setSecurityManager(new SecurityManager()); 
					Registry registry = LocateRegistry.getRegistry(host); 
					//Recupero l’istanza della classe remota 
					RmiServer server = (RmiServer) registry.lookup(url);
					rmi = server.registra(textUsername.getText(), textPassword.getPassword().toString(), textConfPass.getPassword().toString(), textNome.getText(), textCognome.getText());
					//rmi = comunicazione.registraRmi(textUsername.getText(), textPassword.getPassword().toString(), textConfPass.getPassword().toString(), textNome.getText(), textCognome.getText());
					if(rmi == null){
						JOptionPane.showMessageDialog(null, "Errore nella registrazione");
					}
					else{
						Comunicazione c = new Comunicazione(rmi);
						InfoHome ih = c.getInfoHome();
						home = new FramePrincipale(ih.getNome(),ih.getCrediti(),c);
						home.setVisible(true);
						this.setVisible(false);
					}
				} catch (EccezioneUtente | IOException | EccezioneClassificaVuota e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

	}

	public RegisterGui( Comunicazione comunicazione) {
		this.comunicazione = comunicazione;
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

		btnRegistra = new JButton("Registra");
		btnRegistra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					inviaRegistrazione();
				} catch (NotBoundException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		btnRegistra.setBounds(294, 236, 144, 25);
		contentPane.add(btnRegistra);

		textNome = new JTextField();
		textNome.setBounds(190, 10, 114, 19);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textCognome = new JTextField();
		textCognome.setBounds(190, 53, 114, 19);
		contentPane.add(textCognome);
		textCognome.setColumns(10);

		textUsername = new JTextField();
		textUsername.setBounds(190, 91, 114, 19);
		contentPane.add(textUsername);
		textUsername.setColumns(10);

		textPassword = new JPasswordField();
		textPassword.setBounds(190, 135, 114, 19);
		contentPane.add(textPassword);
		textPassword.setColumns(10);

		textConfPass = new JPasswordField();
		textConfPass.setBounds(190, 178, 114, 19);
		contentPane.add(textConfPass);
		textConfPass.setColumns(10);
		}
	}
