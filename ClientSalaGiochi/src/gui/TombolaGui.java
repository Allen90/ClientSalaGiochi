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

import tombola.SituazioneTombola;
import comunicazione.Comunicazione;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TombolaGui extends JFrame implements Runnable{

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
	private Comunicazione comunicazione;
	private boolean response;
	/**
	 * Create the frame.
	 */



	public TombolaGui(int numCartelle, SituazioneTombola situzione,Comunicazione comunicazione) {
		this.situazione = situazione;
		this.comunicazione = comunicazione;
		tabellina1 = new ArrayList<JLabel>();
		tabellina2 = new ArrayList<JLabel>();
		tabellina3 = new ArrayList<JLabel>();
		tabellina4 = new ArrayList<JLabel>();

		for(int i = 0;i<27;i++){
			tabellina1.add(new JLabel("0"));
			tabellina2.add(new JLabel("0"));
			tabellina3.add(new JLabel("0"));
			tabellina4.add(new JLabel("0"));
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlTabellina1 = new JPanel();
		pnlTabellina1.setBounds(12, 0, 363, 143);
		contentPane.add(pnlTabellina1);
		pnlTabellina1.setLayout(new GridLayout(3, 9, 0, 0));


		btnAmbo1 = new JButton("Ambo");
		btnAmbo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					response = inviaVittoria(situazione.getNumeroPartita(),1,1,combo1.getSelectedIndex()+1);
					if(response == false){
						JOptionPane.showMessageDialog(null, "Sei stato troppo lento, un altro giocatore si è aggiudicato il premio!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Sei riuscito a conquistare il premio!");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.print("impossibile ricevere una risposta dal server");
				}
			}
		});
		btnAmbo1.setEnabled(false);
		btnAmbo1.setBounds(12, 155, 75, 25);
		contentPane.add(btnAmbo1);

		btnTerna1 = new JButton("Terna");
		btnTerna1.setEnabled(false);
		btnTerna1.setBounds(99, 155, 81, 25);
		contentPane.add(btnTerna1);

		btnQuaterna1 = new JButton("Quaterna");
		btnQuaterna1.setEnabled(false);
		btnQuaterna1.setBounds(192, 155, 117, 25);
		contentPane.add(btnQuaterna1);

		btnCinquina1 = new JButton("Cinquina");
		btnCinquina1.setEnabled(false);
		btnCinquina1.setBounds(12, 192, 117, 25);
		contentPane.add(btnCinquina1);

		btnTombola1 = new JButton("Tombola");
		btnTombola1.setEnabled(false);
		btnTombola1.setBounds(141, 192, 117, 25);
		contentPane.add(btnTombola1);

		JPanel pnlTabellina3 = new JPanel();
		pnlTabellina3.setBounds(12, 224, 363, 143);
		contentPane.add(pnlTabellina3);
		pnlTabellina3.setLayout(new GridLayout(3, 9, 0, 0));



		btnAmbo3 = new JButton("Ambo");
		btnAmbo3.setEnabled(false);
		btnAmbo3.setBounds(12, 379, 75, 25);
		contentPane.add(btnAmbo3);

		btnTerna3 = new JButton("Terna");
		btnTerna3.setEnabled(false);
		btnTerna3.setBounds(99, 379, 81, 25);
		contentPane.add(btnTerna3);

		btnQuaterna3 = new JButton("Quaterna");
		btnQuaterna3.setEnabled(false);
		btnQuaterna3.setBounds(192, 379, 117, 25);
		contentPane.add(btnQuaterna3);

		btnCinquina3 = new JButton("Cinquina");
		btnCinquina3.setEnabled(false);
		btnCinquina3.setBounds(12, 416, 117, 25);
		contentPane.add(btnCinquina3);

		btnTombola3 = new JButton("Tombola");
		btnTombola3.setEnabled(false);
		btnTombola3.setBounds(141, 416, 117, 25);
		contentPane.add(btnTombola3);

		JPanel pnlTabellina4 = new JPanel();
		pnlTabellina4.setBounds(12, 453, 363, 143);
		contentPane.add(pnlTabellina4);
		pnlTabellina4.setLayout(new GridLayout(3, 9, 0, 0));



		
		btnAmbo4 = new JButton("Ambo");
		btnAmbo4.setEnabled(false);
		btnAmbo4.setBounds(12, 608, 75, 25);
		contentPane.add(btnAmbo4);

		btnTerna4 = new JButton("Terna");
		btnTerna4.setEnabled(false);
		btnTerna4.setBounds(99, 608, 81, 25);
		contentPane.add(btnTerna4);

		btnQuaterna4 = new JButton("Quaterna");
		btnQuaterna4.setEnabled(false);
		btnQuaterna4.setBounds(192, 608, 117, 25);
		contentPane.add(btnQuaterna4);

		btnCinquina4 = new JButton("Cinquina");
		btnCinquina4.setEnabled(false);
		btnCinquina4.setBounds(12, 645, 117, 25);
		contentPane.add(btnCinquina4);

		btnTombola4 = new JButton("Tombola");
		btnTombola4.setEnabled(false);
		btnTombola4.setBounds(141, 645, 117, 25);
		contentPane.add(btnTombola4);

		JPanel pnlTabellina2 = new JPanel();
		pnlTabellina2.setBounds(393, 0, 363, 143);
		contentPane.add(pnlTabellina2);
		pnlTabellina2.setLayout(new GridLayout(3, 9, 0, 0));



		btnAmbo2 = new JButton("Ambo");
		btnAmbo2.setEnabled(false);
		btnAmbo2.setBounds(393, 155, 75, 25);
		contentPane.add(btnAmbo2);

		btnTerna2 = new JButton("Terna");
		btnTerna2.setEnabled(false);
		btnTerna2.setBounds(486, 155, 81, 25);
		contentPane.add(btnTerna2);

		btnQuaterna2 = new JButton("Quaterna");
		btnQuaterna2.setEnabled(false);
		btnQuaterna2.setBounds(579, 155, 117, 25);
		contentPane.add(btnQuaterna2);

		btnCinquina2 = new JButton("Cinquina");
		btnCinquina2.setEnabled(false);
		btnCinquina2.setBounds(393, 192, 117, 25);
		contentPane.add(btnCinquina2);

		btnTombola2 = new JButton("Tombola");
		btnTombola2.setEnabled(false);
		btnTombola2.setBounds(522, 192, 117, 25);
		contentPane.add(btnTombola2);

		JPanel pnlTabellone = new JPanel();
		pnlTabellone.setBounds(396, 244, 383, 426);
		contentPane.add(pnlTabellone);
		pnlTabellone.setLayout(new GridLayout(10, 9, 0, 0));


		JLabel lblNewLabel = new JLabel("Tabellone");
		lblNewLabel.setBounds(398, 227, 70, 15);
		contentPane.add(lblNewLabel);

		JLabel lblUltimoEstratto = new JLabel("ultimo estratto:");
		lblUltimoEstratto.setBounds(522, 227, 117, 15);
		contentPane.add(lblUltimoEstratto);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(645, 222, 70, 25);
		contentPane.add(lblNewLabel_5);

		combo1 = new JComboBox();
		combo1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int n = combo1.getSelectedIndex() +1;
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
		combo3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		combo3.setBounds(311, 416, 53, 24);
		contentPane.add(combo3);

		JLabel label_1 = new JLabel("Riga");
		label_1.setBounds(270, 650, 70, 15);
		contentPane.add(label_1);

		combo4 = new JComboBox();
		combo4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		combo4.setBounds(311, 645, 53, 24);
		contentPane.add(combo4);

		JLabel label_2 = new JLabel("Riga");
		label_2.setBounds(651, 198, 70, 15);
		contentPane.add(label_2);

		combo2 = new JComboBox();
		combo2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		combo2.setBounds(692, 193, 53, 24);
		contentPane.add(combo2);

		for(int i = 0;i< 27; i++){
			pnlTabellina1.add(tabellina1.get(i));
			pnlTabellina2.add(tabellina2.get(i));
			pnlTabellina3.add(tabellina3.get(i));
			pnlTabellina4.add(tabellina4.get(i));
		}

		for(int i = 0; i< 90; i++){
			pnlTabellone.add(new JLabel(""+(i+1)));
		}
	}

	public void aggiorna1(int n){
		int vincente[] = situazione.getTabella(0).getVincente();
		if(vincente[n] == 2 && situazione.getPremiDisponibili()[0] == true)
			btnAmbo1.setEnabled(true);
		else 
			btnAmbo1.setEnabled(false);
		
		if(vincente[n] == 3 && situazione.getPremiDisponibili()[1] == true)
			btnTerna1.setEnabled(true);
		else 
			btnTerna1.setEnabled(false);
		
		if(vincente[n] == 4 && situazione.getPremiDisponibili()[2] == true)
			btnQuaterna1.setEnabled(true);
		else 
			btnQuaterna1.setEnabled(false);
		
		if(vincente[n] == 5 && situazione.getPremiDisponibili()[3] == true)
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
	
	
	public boolean inviaVittoria(int numParita,int tipoVittoria,int indiceCartella, int indiceRiga) throws IOException{
		boolean response = false;
		if(comunicazione.getTipoCom()){
			comunicazione.vintoTombolaSocket(situazione.getNumeroPartita(), tipoVittoria, indiceCartella, indiceRiga);
			response = comunicazione.riceviVintoTombola();
		}
		else{
			response = comunicazione.vintoTombolaRmi(situazione.getNumeroPartita(), tipoVittoria, indiceCartella, indiceRiga);
		}
		return response;
	}
	
	
	public void run(){
		try {
			Thread.sleep(2000);
			if(comunicazione.getTipoCom()){
				comunicazione.aggTombolaSocket();
				situazione = comunicazione.riceviAggTombolaSocket();
				aggiorna1(combo1.getSelectedIndex());
				aggiorna2(combo2.getSelectedIndex());
				aggiorna3(combo3.getSelectedIndex());
				aggiorna4(combo4.getSelectedIndex());
			}
			else {
				situazione = comunicazione.aggTombolarmi();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("impossibile fare la sleep");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("impossibile ricevere dal server l'aggiornamento tombola");
		}
		
	}
	
	
	

}


