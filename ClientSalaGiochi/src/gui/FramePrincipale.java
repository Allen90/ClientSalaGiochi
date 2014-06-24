package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import comunicazione.Comunicazione;
import rubamazzo.SituazioneRubamazzo;
import slot.Slot;
import tombola.SituazioneTombola;
import userModel.EntryClassifica;
import userModel.InfoHome;
import userModel.Utente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

import eccezioni.EccezioneClassificaVuota;
import eccezioni.EccezioneUtente;

public class FramePrincipale extends JFrame implements Runnable{

	private JPanel contentPane;
	private Utente utente;
	private Comunicazione comunicazione;
	private SlotGui slot;
	private TombolaGui tombola;
	private RubamazzoGui rubamazzo;
	private boolean finito;
	private ArrayList<EntryClassifica> classGlob;
	private ArrayList<EntryClassifica> classGiorn;
	private JTextArea areaGlobale;
	private JTextArea areaGiornaliera;
	private int crediti;
	private JComboBox comboTombola;
	private SituazioneTombola situazioneTomb;
	private SituazioneRubamazzo situazioneRuba;
	private JButton btnRubamazzo;
	private InfoHome ih;

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws EccezioneClassificaVuota 
	 */
	public FramePrincipale(String username,int crediti,Comunicazione comunicazione) throws IOException, EccezioneClassificaVuota{
		this.comunicazione = comunicazione;
		this.crediti = crediti;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				try {
					logout();
				} catch (IOException | EccezioneUtente e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

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
		labelUsername.setBounds(102, 12, 87, 15);
		pnlHome.add(labelUsername);

		JLabel Crediti = new JLabel("Crediti");
		Crediti.setBounds(12, 36, 70, 15);
		pnlHome.add(Crediti);

		JLabel labelCrediti = new JLabel(""+crediti);
		labelCrediti.setBounds(75, 36, 70, 15);
		pnlHome.add(labelCrediti);

		JButton btnSlot = new JButton("Slot");
		btnSlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attivaSlot();
			}
		});
		btnSlot.setBounds(12, 111, 117, 25);
		pnlHome.add(btnSlot);

		JButton btnTombola = new JButton("Tombola");
		btnTombola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					attivaTombola();
				} catch (HeadlessException | InterruptedException e1) {
					System.out.println("impossibile inviare richiesta di gioco tombola");
				}
			}
		});
		btnTombola.setBounds(167, 111, 117, 25);
		pnlHome.add(btnTombola);

		btnRubamazzo = new JButton("Rubamazzo");
		btnRubamazzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attivaRubamazzo();
			}
		});
		btnRubamazzo.setBounds(314, 111, 117, 25);
		pnlHome.add(btnRubamazzo);

		comboTombola = new JComboBox();
		comboTombola.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboTombola.setSelectedIndex(0);
		comboTombola.setBounds(192, 175, 70, 24);
		pnlHome.add(comboTombola);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					logout();
				} catch (IOException | EccezioneUtente e1) {
					System.out.println("impossibile effettuare il logout");
				}
			}
		});
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

		areaGlobale = new JTextArea();
		areaGlobale.setEditable(false);
		areaGlobale.setBounds(12, 39, 170, 193);
		pnlClassifica.add(areaGlobale);

		areaGiornaliera = new JTextArea();
		areaGiornaliera.setBounds(240, 39, 191, 193);
		pnlClassifica.add(areaGiornaliera);

		JButton btnAggClass = new JButton("A");
		btnAggClass.setBounds(407, 7, 24, 25);
		pnlClassifica.add(btnAggClass);

		if(comunicazione.getTipoCom()){
			comunicazione.aggClassSocket();
			classGlob = comunicazione.riceviClassificaGlobaleSocket();
			classGiorn = comunicazione.riceviClassificaGiornalieraSocket(); 
		}
		else{
			classGlob = comunicazione.aggClassGlobaleRmi();
			classGiorn = comunicazione.aggClassGiornRmi();
		}

		for(int i = 0;i< classGlob.size();i++){
			areaGlobale.append(classGlob.get(i).toString()+"\n");

			areaGiornaliera.append(classGiorn.get(i).toString()+"\n");
		}

	}


	public void logout() throws IOException, EccezioneUtente{
		boolean ok;
		if(comunicazione.getTipoCom()){
			comunicazione.logoutSocket();
			ok = comunicazione.riceviLogoutSocket();
		}
		else{
			ok = comunicazione.logoutRmi();
		}
		if(!ok){
			System.exit(0);
		}
	}


	public void attivaSlot(){
		slot = new SlotGui(comunicazione,crediti);
		slot.setVisible(true);
	}

	public void attivaTombola() throws HeadlessException, InterruptedException{
		boolean ok = false;
		int numCartelle = comboTombola.getSelectedIndex()+1;

		if(comunicazione.getTipoCom()){
			comunicazione.giocoTombolaSocket(numCartelle);
			try {
				ok = comunicazione.riceviGiocoTombola();
				if(ok){
					comunicazione.aggTombolaSocket();
					situazioneTomb = comunicazione.riceviAggTombolaSocket();
				}
			} catch (IOException e) {
				System.out.println("impossibile ricevere dal server una risposta sulla richiesta mandata");
			}
		}
		else{
			try {
				System.out.println("sto per chiedere di giocare");
				ok = comunicazione.giocoTombolaRmi(numCartelle);
				System.out.println("richiesta gioco mandata");
				if(ok){
					situazioneTomb = comunicazione.aggTombolarmi();
				}

			} catch (RemoteException | EccezioneUtente e) {
				System.out.println("impossibile inviare richiesta di gioco tombola");
			}
		}
		if(ok){
			int numSpawn = 0; // numero di volte inviato il messaggio di essere in coda

			while(situazioneTomb == null){
				Thread.sleep(3000);
				if(situazioneTomb == null && numSpawn == 0){
					JOptionPane.showMessageDialog(null, "Sei in coda per giocare a tombola, attendi l'arrivo di un altro giocatore");
					numSpawn++;
				}
				System.out.println(comunicazione.getTipoCom());
				if(comunicazione.getTipoCom())
				{

					
						comunicazione.aggTombolaSocket();
						try {
							situazioneTomb = comunicazione.riceviAggTombolaSocket();
						} catch (IOException e) {
							System.out.println("impossibile ricevere aggiornamento tombola");
						}
					
				}
				else{
					try {
						situazioneTomb = comunicazione.aggTombolarmi();
					} catch (RemoteException e) {
						e.printStackTrace();
						System.out.println("impossibile ricevere aggiornamento tombola");
					}
				}

			}
			tombola = new TombolaGui(numCartelle,situazioneTomb,comunicazione);
			Thread t = new Thread(tombola);
			t.start();
			tombola.setVisible(true);
		}
		else
			JOptionPane.showMessageDialog(null, "crediti insufficienti per giocare a tombola");
	}


	public void attivaRubamazzo(){
		boolean ok = false;

		if(comunicazione.getTipoCom()){
			comunicazione.giocoRubamazzoSocket();
			try {
				ok = comunicazione.riceviGiocoRubamazzo();
				if(ok){
					comunicazione.aggRubamazzoSocket();
					situazioneRuba = comunicazione.riceviAggRubamazzoSocket();
				}
			} catch (IOException e) {
				System.out.println("impossibile ricevere dal server una risposta sulla richiesta mandata");
			}
		}
		else{
			try {
				ok = comunicazione.giocoRubamazzoRmi();
				if(ok){
					situazioneRuba = comunicazione.aggRubamazzoRmi();
				}

			} catch (RemoteException | EccezioneUtente e) {
				System.out.println("impossibile inviare richiesta di gioco Rubamazzo");
			}
		}
		if(ok){
			int numSpawn = 0; // numero di volte inviato il messaggio di essere in coda

			while(situazioneRuba == null){
				try {
					Thread.sleep(3000);
					if(situazioneRuba == null && numSpawn == 0){
						JOptionPane.showMessageDialog(null, "Sei in coda per giocare a rubamazzo, attendi l'arrivo di un altro giocatore");
						numSpawn++;
					}
				} catch (InterruptedException e) {
					System.out.print("impossibile eseguire sleep richiesta");
				}
				if(comunicazione.getTipoCom())
				{

					try {
						comunicazione.aggRubamazzoSocket();
						situazioneRuba = comunicazione.riceviAggRubamazzoSocket();
					} catch (IOException e) {
						System.out.println("impossibile inviare richiesta di gioco Rubamazzo");
					}
				}
				else{
					try {
						situazioneRuba = comunicazione.aggRubamazzoRmi();
					} catch (RemoteException e) {
						System.out.println("impossibile inviare richiesta di gioco Rubamazzo");
					}
				}

			}
			rubamazzo = new RubamazzoGui(comunicazione, situazioneRuba);
			Thread t = new Thread(rubamazzo);
			t.start();
			rubamazzo.setVisible(true);
		}
		else
			JOptionPane.showMessageDialog(null, "crediti insufficienti per giocare a Rubamazzo");
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
				try {
					classGlob = comunicazione.riceviClassificaGlobaleSocket();
					classGiorn = comunicazione.riceviClassificaGiornalieraSocket();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				comunicazione.aggInfoHomeSocket();
//				ih = comunicazione.riceviInfoHomeSocket();
			}
			else{
				try {
					classGiorn = comunicazione.aggClassGlobaleRmi();
					classGlob = comunicazione.aggClassGiornRmi();
				} catch (EccezioneClassificaVuota | RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			areaGlobale.removeAll();
			areaGiornaliera.removeAll();
			for(int i = 0;i< classGlob.size();i++){
				areaGlobale.append(classGlob.get(i).toString()+"\n");
				areaGiornaliera.append(classGiorn.get(i).toString()+"\n");
			}
		}
	}
}
