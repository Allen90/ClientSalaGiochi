package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.Socket;
import java.util.ArrayList;

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

import comunicazione.Comunicazione;
import slot.Slot;
import userModel.Utente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import eccezioni.EccezioneClassificaVuota;

public class FramePrincipale extends JFrame implements Runnable{

	private JPanel contentPane;
	private Utente utente;
	private Comunicazione comunicazione;
	private SlotGui slot;
	private boolean finito;
	private ArrayList<Utente> classGlob;
	private ArrayList<Utente> classGiorn;

	/**
	 * Create the frame.
	 */
	public FramePrincipale(String username,int crediti,final Comunicazione comunicazione) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 448, 271);
		contentPane.add(tabbedPane);

		JPanel pnlHome = new JPanel();
		tabbedPane.addTab("Giochi", null, pnlHome, null);
		pnlHome.setLayout(null);

		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(12, 12, 87, 15);
		pnlHome.add(lblUsername);

		JLabel labelUsername = new JLabel(username);
		labelUsername.setBounds(102, 12, 70, 15);
		pnlHome.add(labelUsername);

		JLabel Crediti = new JLabel("Crediti");
		Crediti.setBounds(221, 12, 70, 15);
		pnlHome.add(Crediti);

		JLabel labelCrediti = new JLabel(""+crediti);
		labelCrediti.setBounds(289, 12, 70, 15);
		pnlHome.add(labelCrediti);

		JButton btnSlot = new JButton("Slot");
		btnSlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				slot = new SlotGui(comunicazione);
							

			}
		});
		btnSlot.setBounds(12, 111, 117, 25);
		pnlHome.add(btnSlot);

		JButton btnTombola = new JButton("Tombola");
		btnTombola.setBounds(167, 111, 117, 25);
		pnlHome.add(btnTombola);

		JButton btnRubamazzo = new JButton("Rubamazzo");
		btnRubamazzo.setBounds(314, 111, 117, 25);
		pnlHome.add(btnRubamazzo);

		JComboBox comboTombola = new JComboBox();
		comboTombola.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboTombola.setSelectedIndex(0);
		comboTombola.setBounds(192, 175, 70, 24);
		pnlHome.add(comboTombola);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(314, 207, 117, 25);
		pnlHome.add(btnLogout);

		JLabel lblNewLabel = new JLabel("Num Cartelle");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(148, 148, 114, 15);
		pnlHome.add(lblNewLabel);

		JPanel pnlClassifica = new JPanel();
		tabbedPane.addTab("Classifica", null, pnlClassifica, null);
		pnlClassifica.setLayout(null);

		JLabel lblGlobale = new JLabel("Globale");
		lblGlobale.setBounds(12, 12, 70, 15);
		pnlClassifica.add(lblGlobale);

		JLabel lblGiornaliera = new JLabel("Giornaliera");
		lblGiornaliera.setBounds(240, 12, 99, 15);
		pnlClassifica.add(lblGiornaliera);

		JTextArea areaGlobale = new JTextArea();
		areaGlobale.setEditable(false);
		areaGlobale.setBounds(12, 39, 170, 193);
		pnlClassifica.add(areaGlobale);

		JTextArea areaGiornaliera = new JTextArea();
		areaGiornaliera.setBounds(240, 39, 191, 193);
		pnlClassifica.add(areaGiornaliera);
		
		JButton btnAggClass = new JButton("A");
		btnAggClass.setBounds(407, 7, 24, 25);
		pnlClassifica.add(btnAggClass);
	}
	
	public void run(){
		while(finito == false){
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(comunicazione.getTipoCom()){
				comunicazione.aggClassSocket();
				classGlob = comunicazione.riceviClassificaGlobaleSocket();
				classGiorn = comunicazione.riceviClassificaGiornalieraSocket();
			}
			else{
				try {
					classGiorn = comunicazione.aggClassGlobaleRmi();
					classGlob = comunicazione.aggClassGiornRmi();
				} catch (EccezioneClassificaVuota e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	}
}
