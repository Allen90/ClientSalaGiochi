package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTextPane;

import comunicazione.Comunicazione;


import rubamazzo.SituazioneRubamazzo;

public class RubamazzoGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	private Comunicazione comunicazione;
	private boolean response;
	private SituazioneRubamazzo situazione;
	
	private JTextPane textPaneLog;
	
	private ArrayList<JLabel> labelMano;
	private ArrayList<JLabel> labelBanco;
	private ArrayList<JLabel> labelBottini;
	private JLabel labelBottino;
	
	private final ButtonGroup bgMano = new ButtonGroup();
	private final ButtonGroup bgBottini = new ButtonGroup();
	private ArrayList<JCheckBox> checkBanco;
	
	public RubamazzoGui(Comunicazione comunicazione, SituazioneRubamazzo situazione) {
		this.comunicazione = comunicazione;
		this.situazione = situazione;
		setResizable(false);
		setTitle("Rubamazzo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCarteAvversari = new JPanel();
		panelCarteAvversari.setBounds(200, 0, 500, 200);
		contentPane.add(panelCarteAvversari);
		panelCarteAvversari.setLayout(new GridLayout(1, 3, 0, 0));
		
		for(int i = 0; i < situazione.getBottini().size(); i++){
			labelBottini.add(new JLabel(situazione.getBottini().get(i).toString()));
			bgMano.add(new JRadioButton(""));
			
		}
		
		for(int i = 0; i < situazione.getBanco().size(); i++){
			labelBanco.add(new JLabel(situazione.getBanco().get(i).toString()));
			
		}
		
		for(int i = 0; i< situazione.getMano().size(); i++){
			labelMano.add(new JLabel(situazione.getMano().get(i).toString()));
			
		}
		
		JLabel labelBottini0 = new JLabel("New label");
		labelBottini0.setHorizontalAlignment(SwingConstants.CENTER);
		panelCarteAvversari.add(labelBottini0);
		
		JPanel panelRadioAvversari = new JPanel();
		panelRadioAvversari.setBounds(200, 200, 500, 30);
		contentPane.add(panelRadioAvversari);
		panelRadioAvversari.setLayout(new GridLayout(1, 3, 0, 0));
		
		JRadioButton radioBottini0 = new JRadioButton("New radio button");
		radioBottini0.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioAvversari.add(radioBottini0);
		
		JRadioButton radioBottini1 = new JRadioButton("New radio button");
		radioBottini1.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioAvversari.add(radioBottini1);
		
		JRadioButton radioBottini2 = new JRadioButton("New radio button");
		radioBottini2.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioAvversari.add(radioBottini2);
		
		JPanel panelCarteBanco = new JPanel();
		panelCarteBanco.setBounds(0, 230, 994, 200);
		contentPane.add(panelCarteBanco);
		panelCarteBanco.setLayout(new GridLayout(1, 10, 0, 0));
		
		JLabel labelBanco0 = new JLabel("New label");
		labelBanco0.setHorizontalAlignment(SwingConstants.CENTER);
		panelCarteBanco.add(labelBanco0);
		
		JPanel panelRadioBanco = new JPanel();
		panelRadioBanco.setBounds(0, 430, 994, 30);
		contentPane.add(panelRadioBanco);
		panelRadioBanco.setLayout(new GridLayout(1, 3, 0, 0));
		
		JCheckBox checkBanco0 = new JCheckBox("New check box");
		checkBanco0.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioBanco.add(checkBanco0);
		
		JCheckBox checkBanco1 = new JCheckBox("New check box");
		checkBanco1.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioBanco.add(checkBanco1);
		
		JCheckBox checkBanco2 = new JCheckBox("New check box");
		checkBanco2.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioBanco.add(checkBanco2);
		
		JPanel panelCarteMano = new JPanel();
		panelCarteMano.setBounds(200, 460, 500, 209);
		contentPane.add(panelCarteMano);
		panelCarteMano.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panelRadioMano = new JPanel();
		panelRadioMano.setBounds(200, 670, 500, 30);
		contentPane.add(panelRadioMano);
		panelRadioMano.setLayout(new GridLayout(1, 3, 0, 0));
		
		JRadioButton radioMano0 = new JRadioButton("");
		radioMano0.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioMano.add(radioMano0);
		
		JRadioButton radioMano1 = new JRadioButton("");
		radioMano1.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioMano.add(radioMano1);
		
		JRadioButton radioMano2 = new JRadioButton("");
		radioMano2.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioMano.add(radioMano2);
		
		JPanel panelBottino = new JPanel();
		panelBottino.setBounds(0, 460, 200, 240);
		contentPane.add(panelBottino);
		panelBottino.setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel labelBottino = new JLabel("Bottino");
		labelBottino.setHorizontalAlignment(SwingConstants.CENTER);
		panelBottino.add(labelBottino);
		
		JPanel panelGiocaCarta = new JPanel();
		panelGiocaCarta.setBounds(700, 460, 294, 240);
		contentPane.add(panelGiocaCarta);
		panelGiocaCarta.setLayout(null);
		
		JButton buttonGiocaCarta = new JButton("Gioca carta");
		buttonGiocaCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonGiocaCarta.setBounds(100, 60, 100, 100);
		panelGiocaCarta.add(buttonGiocaCarta);
		
		JPanel panelLog = new JPanel();
		panelLog.setBounds(700, 0, 294, 230);
		contentPane.add(panelLog);
		panelLog.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextPane textPaneLog = new JTextPane();
		panelLog.add(textPaneLog);
	}
}
