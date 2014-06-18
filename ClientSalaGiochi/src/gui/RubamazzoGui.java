package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.util.ArrayList;

import rubamazzo.Carta;
import rubamazzo.SituazioneRubamazzo;

import comunicazione.Comunicazione;

public class RubamazzoGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup bgMano = new ButtonGroup();
	private final ButtonGroup bgCarteAvversari = new ButtonGroup();
	private Comunicazione comunicazione;
	private SituazioneRubamazzo situazione;

	//panel dei bottini avversari
	JPanel panelCarteAvversari;
	private ArrayList<JLabel> labelCarteAvversari;
	JPanel panelRadioAvversari;
	private ArrayList<JRadioButton> radioCarteAvversari;

	//panel del banco
	JPanel panelCarteBanco;
	private ArrayList<JLabel> labelCarteBanco;
	JPanel panelCheckBanco;
	private ArrayList<JCheckBox> checkCarteBanco;

	//panel della propria mano
	JPanel panelCarteMano;
	private ArrayList<JLabel> labelCarteMano;
	JPanel panelRadioMano;
	private ArrayList<JRadioButton> radioCarteMano;
	JPanel panelBottino;
	JLabel labelBottino;

	//pannelli bottone gioca e log 
	JPanel panelBottoneGioco;
	JButton buttonGioco;
	JPanel panelLog;
	JTextPane textPaneLog;

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


		//panel dei bottini avversari
		labelCarteAvversari = new ArrayList<>();
		panelCarteAvversari = new JPanel();
		panelCarteAvversari.setBounds(200, 0, 500, 200);
		panelCarteAvversari.setLayout(new GridLayout(1, situazione.getBottini().size(), 0, 0));
		contentPane.add(panelCarteAvversari);

		radioCarteAvversari = new ArrayList<>();
		panelRadioAvversari = new JPanel();
		panelRadioAvversari.setBounds(200, 200, 500, 30);
		contentPane.add(panelRadioAvversari);
		panelRadioAvversari.setLayout(new GridLayout(1, situazione.getBottini().size(), 0, 0));


		//panel del banco
		labelCarteBanco = new ArrayList<>();
		panelCarteBanco = new JPanel();
		panelCarteBanco.setBounds(0, 230, 994, 200);
		contentPane.add(panelCarteBanco);
		panelCarteBanco.setLayout(new GridLayout(1, situazione.getBanco().size(), 0, 0));

		checkCarteBanco = new ArrayList<>();
		panelCheckBanco = new JPanel();
		panelCheckBanco.setBounds(0, 430, 994, 30);
		contentPane.add(panelCheckBanco);
		panelCheckBanco.setLayout(new GridLayout(1, situazione.getBanco().size(), 0, 0));


		//panel della propria mano
		labelCarteMano = new ArrayList<>();
		panelCarteMano = new JPanel();
		panelCarteMano.setBounds(200, 460, 500, 209);
		contentPane.add(panelCarteMano);
		panelCarteMano.setLayout(new GridLayout(1, situazione.getMano().size(), 0, 0));

		radioCarteMano = new ArrayList<>();
		panelRadioMano = new JPanel();
		panelRadioMano.setBounds(200, 670, 500, 30);
		contentPane.add(panelRadioMano);
		panelRadioMano.setLayout(new GridLayout(1, situazione.getMano().size(), 0, 0));

		panelBottino = new JPanel();
		panelBottino.setBounds(0, 460, 200, 240);
		contentPane.add(panelBottino);
		panelBottino.setLayout(new GridLayout(1, 1, 0, 0));

		labelBottino = new JLabel();
		labelBottino.setHorizontalAlignment(SwingConstants.CENTER);
		panelBottino.add(labelBottino);

		//pannelli bottone gioca e log 
		panelBottoneGioco = new JPanel();
		panelBottoneGioco.setBounds(700, 460, 294, 240);
		contentPane.add(panelBottoneGioco);
		panelBottoneGioco.setLayout(null);

		buttonGioco = new JButton("Gioca");
		buttonGioco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}
		});
		buttonGioco.setBounds(92, 65, 100, 100);
		panelBottoneGioco.add(buttonGioco);

		panelLog = new JPanel();
		panelLog.setBounds(700, 0, 294, 230);
		contentPane.add(panelLog);
		panelLog.setLayout(new GridLayout(1, 0, 0, 0));

		textPaneLog = new JTextPane();
		panelLog.add(textPaneLog);
		
		aggiornaTavolo();
	}

	public String getPath(Carta c){
		return "/immaginiCarte/"+c.toString()+".png";
	}
	
	public String getPathRetroVert(){
		return "/immaginiCarte/RETRO#VERT#.png";
	}
	
	public void aggiornaTavolo(){
		//panel dei bottini avversari
		JRadioButton temp;
		
		panelCarteAvversari.removeAll();
		labelCarteAvversari.removeAll(labelCarteAvversari);
		for(int i = 0; i < situazione.getBottini().size(); i++){
			labelCarteAvversari.add(new JLabel());
			labelCarteAvversari.get(i).setIcon(new ImageIcon(RubamazzoGui.class.getResource(getPath(situazione.getBottiniAltrui().get(i)))));
			panelCarteAvversari.add(labelCarteAvversari.get(i));
		}

		panelRadioAvversari.removeAll();
		for(int i = 0; i < situazione.getBottini().size(); i++){
			bgCarteAvversari.remove(radioCarteAvversari.get(i));
		}
		radioCarteAvversari.removeAll(radioCarteAvversari);	
		for(int i = 0; i < situazione.getBottini().size(); i++){
			temp = new JRadioButton("");
			radioCarteAvversari.add(temp);
			panelRadioAvversari.add(radioCarteAvversari.get(i));
			bgCarteAvversari.add(radioCarteAvversari.get(i));
		}

		//panel del banco
		panelCarteBanco.removeAll();
		labelCarteBanco.removeAll(labelCarteBanco);
		for(int i = 0; i < situazione.getBanco().size(); i++){
			labelCarteBanco.add(new JLabel(""));
			labelCarteBanco.get(i).setIcon(new ImageIcon(RubamazzoGui.class.getResource(getPath(situazione.getBanco().get(i)))));
			panelCarteBanco.add(labelCarteBanco.get(i));
		}
		panelCheckBanco.removeAll();
		checkCarteBanco.removeAll(checkCarteBanco);	
		for(int i = 0; i < situazione.getBanco().size(); i++){
			checkCarteBanco.add(new JCheckBox(""));
			panelCheckBanco.add(checkCarteBanco.get(i));
		}

		//panel della propria mano
		panelCarteMano.removeAll();
		labelCarteMano.removeAll(labelCarteMano);
		for(int i = 0; i < situazione.getMano().size(); i++){
			labelCarteMano.add(new JLabel(""));
			labelCarteMano.get(i).setIcon(new ImageIcon(RubamazzoGui.class.getResource(getPath(situazione.getBanco().get(i)))));
			panelCarteMano.add(labelCarteMano.get(i));
		}

		panelRadioMano.removeAll();
		for(int i = 0; i < situazione.getMano().size(); i++){
			bgMano.remove(radioCarteMano.get(i));
		}
		radioCarteMano.removeAll(radioCarteMano);	
		for(int i = 0; i < situazione.getMano().size(); i++){
			temp = new JRadioButton("");
			radioCarteMano.add(temp);
			panelRadioMano.add(radioCarteMano.get(i));
			bgMano.add(radioCarteMano.get(i));
		}
		if(situazione.getMioBottino() != null) 
			labelBottino.setIcon(new ImageIcon(RubamazzoGui.class.getResource(getPath(situazione.getMioBottino()))));
		else 
			labelBottino.setIcon(new ImageIcon(RubamazzoGui.class.getResource(getPathRetroVert())));
		
		//pannelli bottone gioca e log 

	}
	
	private int contaSelectBanco(){
		int quanti = 0;
		for(int i = 0; i < checkCarteBanco.size(); i++)
			if(checkCarteBanco.get(i).isSelected())
				quanti ++;
		return quanti;
	}
	
	private int getTipoMossa(){
		if(bgMano.getSelection() == null)
			return -1;
		else if(contaSelectBanco() > 0 && bgCarteAvversari.getSelection() != null)
			return -1;
		else if(bgCarteAvversari.getSelection() == null){
			switch(contaSelectBanco()){
			case 0:
				return 0;
			case 1:
				return 1;
			default: 
				return 2;
			}
		}else
			return 3;
	}
}
