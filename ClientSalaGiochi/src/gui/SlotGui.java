package gui;


//l'oggetto SlotFrame nel costruttore ha il riferimento al frame principale, per l'aggionamento dei crediti


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import slot.Rollata;
import comunicazione.Comunicazione;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class SlotGui extends JFrame {

	private JPanel contentPane;
	private Comunicazione comunicazione;
	private JLabel creditiTotali;
	private ImageIcon dollaro = new ImageIcon("immaginiSlot/dollaro.jpg");
	private ImageIcon mela = new ImageIcon("immaginiSlot/mela.jpg"); //simbolo 1
	private ImageIcon ciliegia = new ImageIcon("immaginiSlot/ciliegia.jpg"); //simbolo 2
	private ImageIcon uva = new ImageIcon("immaginiSlot/uva.jpg"); //simbolo 3 
	private ImageIcon fragola = new ImageIcon("immaginiSlot/fragola.jpg"); //simbolo 4
	private JLabel lblSimb1;
	private JLabel lblSimb2;
	private JLabel lblSimb3;

	/**
	 * Create the frame.
	 */
	public SlotGui(final Comunicazione comunicazione) {
		this.comunicazione = comunicazione;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
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

		creditiTotali = new JLabel("New label");
		creditiTotali.setBounds(81, 239, 70, 15);
		contentPane.add(creditiTotali);

		JButton btnRolla = new JButton("Rolla");
		btnRolla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(comunicazione.getTipoCom()){
					comunicazione.rollaSocket();
					Rollata r = null;
					try {
						r = comunicazione.riceviRollaSocket();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(r.isValida() == false){
						JOptionPane.showMessageDialog(null, "Crediti insufficenti!");
					}
					else{
						creditiTotali.setText(""+r.getCrediti());
						int[] combinazione = r.getComb();
						switch(combinazione[0]){
						case 1:{lblSimb1.setIcon(mela);break;}
						case 2:{lblSimb1.setIcon(ciliegia);break;}
						case 3:{lblSimb1.setIcon(uva);break;}
						case 4:{lblSimb1.setIcon(fragola);break;}
						case 5:{lblSimb1.setIcon(dollaro);break;}
						}
						switch(combinazione[1]){
						case 1:{lblSimb2.setIcon(mela);break;}
						case 2:{lblSimb2.setIcon(ciliegia);break;}
						case 3:{lblSimb2.setIcon(uva);break;}
						case 4:{lblSimb2.setIcon(fragola);break;}
						case 5:{lblSimb2.setIcon(dollaro);break;}
						}
						switch(combinazione[2]){
						case 1:{lblSimb3.setIcon(mela);break;}
						case 2:{lblSimb3.setIcon(ciliegia);break;}
						case 3:{lblSimb3.setIcon(uva);break;}
						case 4:{lblSimb3.setIcon(fragola);break;}
						case 5:{lblSimb3.setIcon(dollaro);break;}
						}
						if(r.getPremio() > 0)
							JOptionPane.showMessageDialog(null, "hai vinto"+r.getPremio());
					}
				}
				else{

				}

			}
		});
		btnRolla.setBounds(319, 234, 117, 25);
		contentPane.add(btnRolla);


	}
}
