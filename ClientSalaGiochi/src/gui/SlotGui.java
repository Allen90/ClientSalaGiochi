package gui;


//l'oggetto SlotFrame nel costruttore ha il riferimento al frame principale, per l'aggionamento dei crediti


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import slot.Rollata;
import comunicazione.Comunicazione;
import eccezioni.EccezioneUtente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.rmi.RemoteException;
import java.awt.Color;

public class SlotGui extends JFrame {

	private JPanel contentPane;
	private Comunicazione comunicazione;
	private JLabel creditiTotali;
	private String dollaro = new String("/immaginiSlot/dollaro.jpg");
	private String mela = new String("/immaginiSlot/mela.jpg"); //simbolo 1
	private String ciliegia = new String("/immaginiSlot/ciliegia.jpg"); //simbolo 2
	private String uva = new String("/immaginiSlot/uva.jpg"); //simbolo 3 
	private String fragola = new String("/immaginiSlot/fragola.jpg"); //simbolo 4
	private JLabel lblSimb1;
	private JLabel lblSimb2;
	private JLabel lblSimb3;
	int crediti;
	/**
	 * Create the frame.
	 */
	
	public void chiudi(){
		this.setVisible(false);
	}
	
	public SlotGui(Comunicazione comunicazione, int crediti) {
		this.comunicazione = comunicazione;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.addWindowListener(new WindowAdapter() {
			   public void windowClosing(WindowEvent evt) {
			    chiudi();
			   }
			 });
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBenvenutiNellaSlot = new JLabel("Benvenuti nella slot machine");
		lblBenvenutiNellaSlot.setBounds(12, 12, 226, 15);
		contentPane.add(lblBenvenutiNellaSlot);

		lblSimb1 = new JLabel("");
		lblSimb1.setIcon(new ImageIcon(SlotGui.class.getResource("/immaginiSlot/dollaro.jpg")));
		lblSimb1.setBounds(12, 61, 115, 102);
		contentPane.add(lblSimb1);

		lblSimb2 = new JLabel("");
		lblSimb2.setIcon(new ImageIcon(SlotGui.class.getResource("/immaginiSlot/dollaro.jpg")));
		lblSimb2.setBounds(151, 61, 115, 102);
		contentPane.add(lblSimb2);

		lblSimb3 = new JLabel("");
		lblSimb3.setIcon(new ImageIcon(SlotGui.class.getResource("/immaginiSlot/dollaro.jpg")));
		lblSimb3.setBounds(302, 61, 115, 102);
		contentPane.add(lblSimb3);

		JLabel lblCrediti = new JLabel("Crediti");
		lblCrediti.setBounds(12, 239, 70, 15);
		contentPane.add(lblCrediti);

		creditiTotali = new JLabel(""+crediti);
		creditiTotali.setBounds(81, 239, 70, 15);
		contentPane.add(creditiTotali);

		JButton btnRolla = new JButton("Rolla");
		btnRolla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rolla();
				} catch (EccezioneUtente e1) {
					System.out.println("impossibile effettuare la rollata");
				}
			}

		});
		btnRolla.setBounds(319, 234, 117, 25);
		contentPane.add(btnRolla);


	}

	public void rolla() throws EccezioneUtente{
		Rollata r = null;
		if(comunicazione.getTipoCom()){
			comunicazione.rollaSocket();

			try {
				r = comunicazione.riceviRollaSocket();
			} catch (IOException e1) {
				System.out.println("impossibile effettuare la rollata");
			}

		}
		else{
			try {
				r = comunicazione.rollaRmi();
			} catch (RemoteException e1) {
				System.out.println("impossibile effettuare la rollata");
			}
		}
		if(r.isValida() == false){
			JOptionPane.showMessageDialog(null, "Crediti insufficenti!");
		}
		else{
			creditiTotali.setText(""+r.getCrediti());
			int[] combinazione = r.getComb();
			switch(combinazione[0]){
			case 1:{lblSimb1.setIcon(new ImageIcon(SlotGui.class.getResource(mela)));break;}
			case 2:{lblSimb1.setIcon(new ImageIcon(SlotGui.class.getResource(ciliegia)));break;}
			case 3:{lblSimb1.setIcon(new ImageIcon(SlotGui.class.getResource(uva)));break;}
			case 4:{lblSimb1.setIcon(new ImageIcon(SlotGui.class.getResource(fragola)));break;}
			case 5:{lblSimb1.setIcon(new ImageIcon(SlotGui.class.getResource(dollaro)));break;}
			}
			switch(combinazione[1]){
			case 1:{lblSimb2.setIcon(new ImageIcon(SlotGui.class.getResource(mela)));break;}
			case 2:{lblSimb2.setIcon(new ImageIcon(SlotGui.class.getResource(ciliegia)));break;}
			case 3:{lblSimb2.setIcon(new ImageIcon(SlotGui.class.getResource(uva)));break;}
			case 4:{lblSimb2.setIcon(new ImageIcon(SlotGui.class.getResource(fragola)));break;}
			case 5:{lblSimb2.setIcon(new ImageIcon(SlotGui.class.getResource(dollaro)));break;}
			}
			switch(combinazione[2]){
			case 1:{lblSimb3.setIcon(new ImageIcon(SlotGui.class.getResource(mela)));break;}
			case 2:{lblSimb3.setIcon(new ImageIcon(SlotGui.class.getResource(ciliegia)));break;}
			case 3:{lblSimb3.setIcon(new ImageIcon(SlotGui.class.getResource(uva)));break;}
			case 4:{lblSimb3.setIcon(new ImageIcon(SlotGui.class.getResource(fragola)));break;}
			case 5:{lblSimb3.setIcon(new ImageIcon(SlotGui.class.getResource(dollaro)));break;}
			}
			if(r.getPremio() > 0)
				JOptionPane.showMessageDialog(null, "hai vinto"+r.getPremio());
			else JOptionPane.showMessageDialog(null, "non hai vinto nulla, ritenta!");
			revalidate();
		}
	}
}
