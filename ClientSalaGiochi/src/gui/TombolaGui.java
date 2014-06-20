package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import tombola.Casella;
import tombola.SituazioneTombola;
import tombola.Tabella;
import tombola.Tabellone;
import comunicazione.Comunicazione;
import comunicazione.InvioVittorieTombola;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import eccezioni.EccezioneUtente;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JTextField;

public class TombolaGui extends JFrame implements Runnable{
	private boolean occupato;
	private JPanel contentPane;
	private ArrayList<JLabel> tabellina1;
	private ArrayList<JLabel> tabellina2;
	private ArrayList<JLabel> tabellina3;
	private ArrayList<JLabel> tabellina4;
	private SituazioneTombola situazione;
	private JComboBox combo1;
	private JComboBox combo2;
	private JComboBox combo3;
	private JComboBox combo4;
	private JButton btnAmbo1;
	private JButton btnTerna1;
	private JButton btnQuaterna1;
	private JButton btnCinquina1;
	private JButton btnTombola1;
	private JButton btnAmbo3;
	private JButton btnTerna3;
	private JButton btnQuaterna3;
	private JButton btnCinquina3;
	private JButton btnTombola3;
	private JButton btnAmbo4;
	private JButton btnTerna4;
	private JButton btnQuaterna4;
	private JButton btnCinquina4;
	private JButton btnTombola4;
	private JButton btnAmbo2;
	private JButton btnTerna2;
	private JButton btnQuaterna2;
	private JButton btnCinquina2;
	private JButton btnTombola2;
	private JPanel pnlTabellina1;
	private JPanel pnlTabellina2;
	private JPanel pnlTabellina3;
	private JPanel pnlTabellina4;
	private Comunicazione comunicazione;
	private boolean response;
	private int numCartelle;
	private JPanel pnlTabellone;
	private JLabel lblUltimoEstratto;
	private Object lock;
	private InvioVittorieTombola vittorie;
	/**
	 * Create the frame.
	 */



	public TombolaGui(int numCartelle, SituazioneTombola situzione,Comunicazione comunicazione) {
		response = false;
		vittorie = new InvioVittorieTombola(comunicazione);
		Thread t = new Thread(vittorie);
		t.start();
		this.situazione = situazione;
		this.numCartelle = numCartelle;
		this.comunicazione = comunicazione;

		//		for(int i = 0;i<27;i++){
		//			tabellina1.add(new JLabel("0"));
		//			tabellina2.add(new JLabel("0"));
		//			tabellina3.add(new JLabel("0"));
		//			tabellina4.add(new JLabel("0"));
		//		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 840);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnlTabellina1 = new JPanel();
		pnlTabellina1.setBounds(12, 0, 363, 143);
		contentPane.add(pnlTabellina1);
		pnlTabellina1.setLayout(new GridLayout(3, 9, 0, 0));


		btnAmbo1 = new JButton("Ambo");
		btnAmbo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),1,0,combo1.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnAmbo1.setEnabled(false);
		btnAmbo1.setBounds(12, 155, 75, 25);
		contentPane.add(btnAmbo1);

		btnTerna1 = new JButton("Terna");
		btnTerna1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),2,0,combo1.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnTerna1.setEnabled(false);
		btnTerna1.setBounds(99, 155, 81, 25);
		contentPane.add(btnTerna1);

		btnQuaterna1 = new JButton("Quaterna");
		btnQuaterna1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),3,0,combo1.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnQuaterna1.setEnabled(false);
		btnQuaterna1.setBounds(192, 155, 117, 25);
		contentPane.add(btnQuaterna1);

		btnCinquina1 = new JButton("Cinquina");
		btnCinquina1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),4,0,combo1.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnCinquina1.setEnabled(false);
		btnCinquina1.setBounds(12, 192, 117, 25);
		contentPane.add(btnCinquina1);

		btnTombola1 = new JButton("Tombola");
		btnTombola1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),5,0,combo1.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnTombola1.setEnabled(false);
		btnTombola1.setBounds(141, 192, 117, 25);
		contentPane.add(btnTombola1);

		pnlTabellina3 = new JPanel();
		pnlTabellina3.setBounds(12, 224, 363, 143);
		contentPane.add(pnlTabellina3);
		pnlTabellina3.setLayout(new GridLayout(3, 9, 0, 0));



		btnAmbo3 = new JButton("Ambo");
		btnAmbo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),1,2,combo3.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnAmbo3.setEnabled(false);
		btnAmbo3.setBounds(12, 379, 75, 25);
		contentPane.add(btnAmbo3);

		btnTerna3 = new JButton("Terna");
		btnTerna3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),2,2,combo3.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnTerna3.setEnabled(false);
		btnTerna3.setBounds(99, 379, 81, 25);
		contentPane.add(btnTerna3);

		btnQuaterna3 = new JButton("Quaterna");
		btnQuaterna3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),3,2,combo3.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnQuaterna3.setEnabled(false);
		btnQuaterna3.setBounds(192, 379, 117, 25);
		contentPane.add(btnQuaterna3);

		btnCinquina3 = new JButton("Cinquina");
		btnCinquina3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),4,2,combo3.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnCinquina3.setEnabled(false);
		btnCinquina3.setBounds(12, 416, 117, 25);
		contentPane.add(btnCinquina3);

		btnTombola3 = new JButton("Tombola");
		btnTombola3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),5,2,combo3.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnTombola3.setEnabled(false);
		btnTombola3.setBounds(141, 416, 117, 25);
		contentPane.add(btnTombola3);

		pnlTabellina4 = new JPanel();
		pnlTabellina4.setBounds(12, 453, 363, 143);
		contentPane.add(pnlTabellina4);
		pnlTabellina4.setLayout(new GridLayout(3, 9, 0, 0));




		btnAmbo4 = new JButton("Ambo");
		btnAmbo4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),1,3,combo4.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnAmbo4.setEnabled(false);
		btnAmbo4.setBounds(12, 608, 75, 25);
		contentPane.add(btnAmbo4);

		btnTerna4 = new JButton("Terna");
		btnTerna4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),2,3,combo4.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnTerna4.setEnabled(false);
		btnTerna4.setBounds(99, 608, 81, 25);
		contentPane.add(btnTerna4);

		btnQuaterna4 = new JButton("Quaterna");
		btnQuaterna4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),3,3,combo4.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnQuaterna4.setEnabled(false);
		btnQuaterna4.setBounds(192, 608, 117, 25);
		contentPane.add(btnQuaterna4);

		btnCinquina4 = new JButton("Cinquina");
		btnCinquina4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),4,3,combo4.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnCinquina4.setEnabled(false);
		btnCinquina4.setBounds(12, 645, 117, 25);
		contentPane.add(btnCinquina4);

		btnTombola4 = new JButton("Tombola");
		btnTombola4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),5,3,combo4.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnTombola4.setEnabled(false);
		btnTombola4.setBounds(141, 645, 117, 25);
		contentPane.add(btnTombola4);

		pnlTabellina2 = new JPanel();
		pnlTabellina2.setBounds(393, 0, 363, 143);
		contentPane.add(pnlTabellina2);
		pnlTabellina2.setLayout(new GridLayout(3, 9, 0, 0));



		btnAmbo2 = new JButton("Ambo");
		btnAmbo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),1,1,combo2.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnAmbo2.setEnabled(false);
		btnAmbo2.setBounds(393, 155, 75, 25);
		contentPane.add(btnAmbo2);

		btnTerna2 = new JButton("Terna");
		btnTerna2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),2,1,combo2.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnTerna2.setEnabled(false);
		btnTerna2.setBounds(486, 155, 81, 25);
		contentPane.add(btnTerna2);

		btnQuaterna2 = new JButton("Quaterna");
		btnQuaterna2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),3,1,combo2.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnQuaterna2.setEnabled(false);
		btnQuaterna2.setBounds(579, 155, 117, 25);
		contentPane.add(btnQuaterna2);

		btnCinquina2 = new JButton("Cinquina");
		btnCinquina2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),4,1,combo2.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnCinquina2.setEnabled(false);
		btnCinquina2.setBounds(393, 192, 117, 25);
		contentPane.add(btnCinquina2);

		btnTombola2 = new JButton("Tombola");
		btnTombola2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),5,1,combo2.getSelectedIndex());
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException | EccezioneUtente e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnTombola2.setEnabled(false);
		btnTombola2.setBounds(522, 192, 117, 25);
		contentPane.add(btnTombola2);

		pnlTabellone = new JPanel();
		pnlTabellone.setBounds(396, 243, 371, 427);
		contentPane.add(pnlTabellone);
		pnlTabellone.setLayout(new GridLayout(10, 9, 0, 0));


		JLabel lblNewLabel = new JLabel("Tabellone");
		lblNewLabel.setBounds(398, 227, 70, 15);
		contentPane.add(lblNewLabel);

		JLabel lbl5 = new JLabel("ultimo estratto:");
		lbl5.setBounds(522, 227, 117, 15);
		contentPane.add(lbl5);

		lblUltimoEstratto = new JLabel("");
		lblUltimoEstratto.setBounds(645, 222, 70, 25);
		contentPane.add(lblUltimoEstratto);

		combo1 = new JComboBox();
		combo1.setEnabled(false);
		combo1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int n = combo1.getSelectedIndex();
				aggiorna1(n);
			}
		});
		combo1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		combo1.setBounds(308, 192, 53, 24);
		contentPane.add(combo1);

		JLabel lblNewLabel_1 = new JLabel("Riga");
		lblNewLabel_1.setBounds(267, 197, 70, 15);
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("Riga");
		label.setBounds(270, 421, 70, 15);
		contentPane.add(label);

		combo3 = new JComboBox();
		combo3.setEnabled(false);
		combo3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		combo3.setBounds(311, 416, 53, 24);
		contentPane.add(combo3);

		JLabel label_1 = new JLabel("Riga");
		label_1.setBounds(270, 650, 70, 15);
		contentPane.add(label_1);

		combo4 = new JComboBox();
		combo4.setEnabled(false);
		combo4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		combo4.setBounds(311, 645, 53, 24);
		contentPane.add(combo4);

		JLabel label_2 = new JLabel("Riga");
		label_2.setBounds(651, 198, 70, 15);
		contentPane.add(label_2);

		combo2 = new JComboBox();
		combo2.setEnabled(false);
		combo2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		combo2.setBounds(692, 193, 53, 24);
		contentPane.add(combo2);

		JLabel lblAmbo = new JLabel("Ambo:");
		lblAmbo.setBounds(12, 684, 70, 15);
		contentPane.add(lblAmbo);

		JLabel lblPremioAmbo = new JLabel("New label");
		lblPremioAmbo.setBounds(66, 684, 70, 15);
		contentPane.add(lblPremioAmbo);

		JLabel lblTerna = new JLabel("Terna:");
		lblTerna.setBounds(151, 684, 70, 15);
		contentPane.add(lblTerna);

		JLabel lblPremioTerna = new JLabel("New label");
		lblPremioTerna.setBounds(205, 684, 70, 15);
		contentPane.add(lblPremioTerna);

		JLabel lblQuaterna = new JLabel("Quaterna:");
		lblQuaterna.setBounds(288, 684, 93, 15);
		contentPane.add(lblQuaterna);

		JLabel lblPremioQuaterna = new JLabel("New label");
		lblPremioQuaterna.setBounds(372, 684, 70, 15);
		contentPane.add(lblPremioQuaterna);

		JLabel lblCinquina = new JLabel("Cinquina:");
		lblCinquina.setBounds(454, 684, 70, 15);
		contentPane.add(lblCinquina);

		JLabel lblPremioCinquina = new JLabel("New label");
		lblPremioCinquina.setBounds(532, 684, 70, 15);
		contentPane.add(lblPremioCinquina);

		JLabel lblTombola = new JLabel("Tombola:");
		lblTombola.setBounds(614, 684, 70, 15);
		contentPane.add(lblTombola);

		JLabel lblPremioTombola = new JLabel("New label");
		lblPremioTombola.setBounds(686, 684, 70, 15);
		contentPane.add(lblPremioTombola);


		//		for(int i = 0;i< 27; i++){
		//			pnlTabellina1.add(tabellina1.get(i));
		//			pnlTabellina2.add(tabellina2.get(i));
		//			pnlTabellina3.add(tabellina3.get(i));
		//			pnlTabellina4.add(tabellina4.get(i));
		//		}

		//		for(int i = 0; i< 90; i++){
		//			pnlTabellone.add(new JLabel(""+(i+1)));
		//		}

		switch(numCartelle){
		case 1:{
			tabellina1 = new ArrayList<JLabel>();
			System.out.println("tabellina1 creata");
			combo1.setEnabled(true);
			break;
		}
		case 2:{
			tabellina1 = new ArrayList<JLabel>();
			tabellina2 = new ArrayList<JLabel>();
			combo1.setEnabled(true);
			combo2.setEnabled(true);
			break;
		}
		case 3:{
			tabellina1 = new ArrayList<JLabel>();
			tabellina2 = new ArrayList<JLabel>();
			tabellina3 = new ArrayList<JLabel>();
			combo1.setEnabled(true);
			combo2.setEnabled(true);
			combo3.setEnabled(true);
			break;
		}
		case 4:{
			tabellina1 = new ArrayList<JLabel>();
			tabellina2 = new ArrayList<JLabel>();
			tabellina3 = new ArrayList<JLabel>();
			tabellina4 = new ArrayList<JLabel>();
			combo1.setEnabled(true);
			combo2.setEnabled(true);
			combo3.setEnabled(true);
			combo4.setEnabled(true);
			break;
		}

		}
	}

	public void aggiorna1(int n){

		int vincente[] = situazione.getTabella(0).getVincente();

		System.out.println("vincenti tabela 1   "+vincente[0]+vincente[1]+vincente[2]);

		if(vincente[n] == 2 && situazione.getPremiDisponibili()[0]){

			btnAmbo1.setEnabled(true);
			//System.out.println("qui in bottone da validare");
		}
		else 
			btnAmbo1.setEnabled(false);

		if(vincente[n] == 3 && situazione.getPremiDisponibili()[1])
			btnTerna1.setEnabled(true);
		else 
			btnTerna1.setEnabled(false);

		if(vincente[n] == 4 && situazione.getPremiDisponibili()[2])
			btnQuaterna1.setEnabled(true);
		else 
			btnQuaterna1.setEnabled(false);

		if(vincente[n] == 5 && situazione.getPremiDisponibili()[3])
			btnCinquina1.setEnabled(true);
		else 
			btnCinquina1.setEnabled(false);
		int tomb = 0;
		for(int i = 0;i< vincente.length;i++)
			if(vincente[i] == 5)
				tomb ++;
		if(tomb == 3)
			btnTombola1.setEnabled(true);
		else 
			btnTombola1.setEnabled(false);
		revalidate();
	}

	public void aggiorna2(int n){
		int vincente[] = situazione.getTabella(0).getVincente();
		if(vincente[n] == 2 && situazione.getPremiDisponibili()[0] == true)
			btnAmbo2.setEnabled(true);
		else 
			btnAmbo2.setEnabled(false);

		if(vincente[n] == 3 && situazione.getPremiDisponibili()[1] == true)
			btnTerna2.setEnabled(true);
		else 
			btnTerna2.setEnabled(false);

		if(vincente[n] == 4 && situazione.getPremiDisponibili()[2] == true)
			btnQuaterna2.setEnabled(true);
		else 
			btnQuaterna2.setEnabled(false);

		if(vincente[n] == 5 && situazione.getPremiDisponibili()[3] == true)
			btnCinquina2.setEnabled(true);
		else 
			btnCinquina2.setEnabled(false);
		int tomb = 0;
		for(int i = 0;i< vincente.length;i++)
			if(vincente[i] == 5)
				tomb ++;
		if(tomb == 3)
			btnTombola2.setEnabled(true);
		else 
			btnTombola2.setEnabled(false);
	}

	public void aggiorna3(int n){
		int vincente[] = situazione.getTabella(0).getVincente();
		if(vincente[n] == 2 && situazione.getPremiDisponibili()[0] == true)
			btnAmbo3.setEnabled(true);
		else 
			btnAmbo3.setEnabled(false);

		if(vincente[n] == 3 && situazione.getPremiDisponibili()[1] == true)
			btnTerna3.setEnabled(true);
		else 
			btnTerna3.setEnabled(false);

		if(vincente[n] == 4 && situazione.getPremiDisponibili()[2] == true)
			btnQuaterna3.setEnabled(true);
		else 
			btnQuaterna3.setEnabled(false);

		if(vincente[n] == 5 && situazione.getPremiDisponibili()[3] == true)
			btnCinquina3.setEnabled(true);
		else 
			btnCinquina3.setEnabled(false);
		int tomb = 0;
		for(int i = 0;i< vincente.length;i++)
			if(vincente[i] == 5)
				tomb ++;
		if(tomb == 3)
			btnTombola3.setEnabled(true);
		else 
			btnTombola3.setEnabled(false);

	}

	public void aggiorna4(int n){
		int vincente[] = situazione.getTabella(0).getVincente();
		if(vincente[n] == 2 && situazione.getPremiDisponibili()[0] == true)
			btnAmbo4.setEnabled(true);
		else 
			btnAmbo4.setEnabled(false);

		if(vincente[n] == 3 && situazione.getPremiDisponibili()[1] == true)
			btnTerna4.setEnabled(true);
		else 
			btnTerna4.setEnabled(false);

		if(vincente[n] == 4 && situazione.getPremiDisponibili()[2] == true)
			btnQuaterna4.setEnabled(true);
		else 
			btnQuaterna4.setEnabled(false);

		if(vincente[n] == 5 && situazione.getPremiDisponibili()[3] == true)
			btnCinquina4.setEnabled(true);
		else 
			btnCinquina4.setEnabled(false);
		int tomb = 0;
		for(int i = 0;i< vincente.length;i++)
			if(vincente[i] == 5)
				tomb ++;
		if(tomb == 3)
			btnTombola4.setEnabled(true);
		else 
			btnTombola4.setEnabled(false);

	}


	public boolean inviaVittoria(int numPartita,int tipoVittoria,int indiceCartella, int indiceRiga) throws IOException, EccezioneUtente{
		boolean ok = false;
//		occupato = true;
//		if(comunicazione.getTipoCom()){
//			comunicazione.vintoTombolaSocket(situazione.getNumeroPartita(), tipoVittoria, indiceCartella, indiceRiga);
//			response = comunicazione.riceviVintoTombola();
//		}
//		else{
//			response = comunicazione.vintoTombolaRmi(situazione.getNumeroPartita(), tipoVittoria, indiceCartella, indiceRiga);
//		}
//		System.out.println("ho ricevuto la risposta del server ");
		ok = vittorie.invio(numPartita, tipoVittoria, indiceCartella, indiceRiga);
		return ok;
	}

	public void aggiornaCartella(ArrayList<JLabel> tabellina, int indice){
		Tabella t = situazione.getTabella(indice);
		for(int i = 0;i< Tabella.N_RIGHE;i++){
			for(int j=0;j<Tabella.N_COLONNE;j++){
				//System.out.print(t.isEstratto(i-1, j-1));
				tabellina.add(new JLabel(""+t.getNumero(i, j)));
				//tabellina.set(i*j, new JLabel(""+t.getNumero(i-1, j-1)));
				if(situazione.getTabella(indice).isEstratto(i,j)){
					tabellina.get(i*9+j).setForeground(new Color(255, 0, 0));
				}

			}
		}
	}

	public void aggiornaTabellone(){
		Casella[][] c = situazione.getTabellone().getTabellone();

		pnlTabellone.removeAll();
		for(int i = 0 ; i< Tabellone.N_RIGHE; i++){
			for(int j= 0; j< Tabellone.N_COLONNE; j++){
				String s = ""+ c[i][j].getNumero();
				JLabel l = new JLabel(s);
				if(c[i][j].isEstratto())
					l.setForeground(new Color(255, 0, 0));
				pnlTabellone.add(l);
			}
		}
	}

	public void run(){
		while(true){

			try {
				//				while(occupato == true){
				//					Thread.sleep(1000);
				//				}
				//if(occupato == false){
				//occupato = true;

				//Thread.sleep(500);
				//				synchronized(lock){
				System.out.println("Sto per richiedere aggiornamento dal server");
				if(comunicazione.getTipoCom()){
					System.out.println("sto per inviare la richiesta socket aggiornamento");
					comunicazione.aggTombolaSocket();
					System.out.println("richiesto inviata");
					System.out.println("Sto per ricevere aggiornamento");
					situazione = comunicazione.riceviAggTombolaSocket();
					System.out.println("aggiornamento ricevuto");
				}
				else {
					situazione = comunicazione.aggTombolarmi();
				}
				//occupato = false;
				System.out.println("ricevuto aggiornamento dal server");
				//				}
			} catch (/*InterruptedException | */IOException e) {
				// TODO Auto-generated catch block
				System.out.println("impossibile aggiornare da server");
				e.printStackTrace();
			}

			System.out.println("Suca");
			aggiornaTabellone();
			lblUltimoEstratto.setText(""+situazione.getUltimoEstratto());
			System.out.println("@@@@ "+numCartelle);
			switch(numCartelle){
			case 1:{
				aggiorna1(combo1.getSelectedIndex());
				aggiornaCartella(tabellina1,0);
				pnlTabellina1.removeAll();
				for(int i = 0; i<27; i++){
					pnlTabellina1.add(tabellina1.get(i));

				}
				//repaint();
				revalidate();
				break;
			}
			case 2:{
				aggiorna1(combo1.getSelectedIndex());
				aggiorna2(combo2.getSelectedIndex());
				aggiornaCartella(tabellina1,0);
				aggiornaCartella(tabellina2,1);pnlTabellina1.removeAll();
				pnlTabellina2.removeAll();for(int i = 0; i<27; i++){
					pnlTabellina1.add(tabellina1.get(i));
					pnlTabellina2.add(tabellina2.get(i));
				}
				break;}
			case 3:{
				aggiorna1(combo1.getSelectedIndex());
				aggiorna2(combo2.getSelectedIndex());
				aggiorna3(combo3.getSelectedIndex());
				aggiornaCartella(tabellina1,0);
				aggiornaCartella(tabellina2,1);
				aggiornaCartella(tabellina3,2);pnlTabellina1.removeAll();
				pnlTabellina2.removeAll();
				pnlTabellina3.removeAll();for(int i = 0; i<27; i++){
					pnlTabellina1.add(tabellina1.get(i));
					pnlTabellina2.add(tabellina2.get(i));
					pnlTabellina3.add(tabellina3.get(i));
				}
				break;
			}
			case 4:{
				aggiorna1(combo1.getSelectedIndex());
				aggiorna2(combo2.getSelectedIndex());
				aggiorna3(combo3.getSelectedIndex());
				aggiorna4(combo4.getSelectedIndex());
				aggiornaCartella(tabellina1,0);
				aggiornaCartella(tabellina2,1);
				aggiornaCartella(tabellina3,2);
				aggiornaCartella(tabellina4,3);
				pnlTabellina1.removeAll();
				pnlTabellina2.removeAll();
				pnlTabellina3.removeAll();
				pnlTabellina4.removeAll();
				for(int i = 0; i<27; i++){
					pnlTabellina1.add(tabellina1.get(i));
					pnlTabellina2.add(tabellina2.get(i));
					pnlTabellina3.add(tabellina3.get(i));
					pnlTabellina4.add(tabellina4.get(i));
				}
				break;
			}
			default:
				System.out.println("WTF?");
			}
			System.out.println("WTF?");
		}
	}

}

