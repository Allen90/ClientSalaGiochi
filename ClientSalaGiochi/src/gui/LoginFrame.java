package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import rmiServer.RmiServer;
import rmiServer.RmiTaskControl;
import userModel.InfoHome;
import userModel.Utente;
import comunicazione.Comunicazione;
import eccezioni.EccezioneUtente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.rmi.RemoteException;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private Comunicazione comunicazione;
	private FramePrincipale home;
	private RmiTaskControl rmi;
	private JButton btnLogin;

	/**
	 * Create the frame.
	 */
	public LoginFrame(final Comunicazione comunicazione) {
		this.comunicazione = comunicazione;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(12, 67, 102, 15);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 94, 90, 15);
		contentPane.add(lblPassword);

		textUsername = new JTextField();
		textUsername.setBounds(111, 65, 114, 19);
		contentPane.add(textUsername);
		textUsername.setColumns(10);

		textPassword = new JTextField();
		textPassword.setBounds(111, 92, 114, 19);
		contentPane.add(textPassword);
		textPassword.setColumns(10);

		JLabel lblInserisciLeInformazioni = new JLabel("Inserisci le informazioni per il login");
		lblInserisciLeInformazioni.setBounds(12, 12, 410, 15);
		contentPane.add(lblInserisciLeInformazioni);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textUsername.getText() == "" && textPassword.getText() == ""){
					// dialog
				}

				else{
					if(comunicazione.getTipoCom()){
						comunicazione.loginSocket(textUsername.getText(),textPassword.getText());
						Utente utente = null;
						InfoHome ih = null;
						try {
							ih = comunicazione.riceviLoginSocket();
							if(ih == null){
								JOptionPane.showMessageDialog(null, "Login errato");
							}
							else{
								home = new FramePrincipale(ih.getUsername(),ih.getCrediti(),comunicazione);
								home.show();
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else{
						try {
							rmi = comunicazione.loginRmi(textUsername.getText(), textPassword.getText());
							if(rmi == null){
								JOptionPane.showMessageDialog(null, "Login errato");
							}
							else{
								Comunicazione c = new Comunicazione(rmi);
								InfoHome ih = c.getInfoHome();
								home = new FramePrincipale(ih.getUsername(),ih.getCrediti(),c);
								home.show();
							}
						} catch (RemoteException | EccezioneUtente e1) {
							e1.printStackTrace();
						}
						
					}
				}

			}
		});
		btnLogin.setBounds(304, 234, 132, 25);
		contentPane.add(btnLogin);
	}

}
