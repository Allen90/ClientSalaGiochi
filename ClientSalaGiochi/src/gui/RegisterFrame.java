package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import rmiServer.RmiServer;
import rmiServer.RmiTaskControl;
import userModel.InfoHome;
import userModel.Utente;
import comunicazione.Comunicazione;
import eccezioni.EccezioneUtente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCognome;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textConfPass;
	private Comunicazione comunicazione;
	private FramePrincipale home;
	private RmiServer rmiLog;
	private RmiTaskControl rmi;

	/**
	 * Create the frame.
	 */
	public RegisterFrame(final Comunicazione comunicazione) {
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
		
		JButton btnRegistra = new JButton("Registra");
		btnRegistra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textUsername.getText() == "" && textPassword.getText() == "" && textNome.getText() == "" && textCognome.getText() == "" && textConfPass.getText() == ""){
					// dialog
				}

				else{
					if(comunicazione.getTipoCom()){
						comunicazione.registraSocket(textUsername.getText(), textPassword.getText(), textConfPass.getText(), textNome.getText(), textCognome.getText());
						InfoHome ih = null;
						ih = comunicazione.riceviRegistraSocket();
							if(ih == null){
								JOptionPane.showMessageDialog(null, "Errore nella registrazione");
							}
							else{
								home = new FramePrincipale(ih.getUsername(),ih.getCrediti(),comunicazione);
								home.show();
							}
					}
					else{
						try {
							rmi = comunicazione.registraRmi(textUsername.getText(), textPassword.getText(), textConfPass.getText(), textNome.getText(), textCognome.getText());
							if(rmi == null){
								JOptionPane.showMessageDialog(null, "Errore nella registrazione");
							}
							else{
								Comunicazione c = new Comunicazione(rmi);
								InfoHome ih = c.getInfoHome();
								home = new FramePrincipale(ih.getUsername(),ih.getCrediti(),c);
								home.show();
							}
						} catch (RemoteException | EccezioneUtente e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}

			}
		});
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
		
		textPassword = new JTextField();
		textPassword.setBounds(190, 135, 114, 19);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		textConfPass = new JTextField();
		textConfPass.setBounds(190, 178, 114, 19);
		contentPane.add(textConfPass);
		textConfPass.setColumns(10);
	}
}
