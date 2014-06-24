package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JTextPane;

import java.util.ArrayList;

import rubamazzo.Carta;
import rubamazzo.Mossa;
import rubamazzo.SituazioneRubamazzo;

import comunicazione.Comunicazione;
import comunicazione.InvioMosseRubamazzo;
import eccezioni.EccezioneUtente;

public class RubamazzoGui extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup bgMano = new ButtonGroup();
	private final ButtonGroup bgCarteAvversari = new ButtonGroup();
	private Comunicazione comunicazione;
	private SituazioneRubamazzo situazione;

	//panel dei bottini avversari
	private JPanel panelCarteAvversari;
	private ArrayList<JLabel> labelCarteAvversari;
	private JPanel panelRadioAvversari;
	private ArrayList<JRadioButton> radioCarteAvversari;
	private int avversarioSel;
	private boolean primoAvvio;
	
	//panel del banco
	private JPanel panelCarteBanco;
	private ArrayList<JLabel> labelCarteBanco;
	private JPanel panelCheckBanco;
	private ArrayList<JCheckBox> checkCarteBanco;
	private ArrayList<Boolean> bancoSel;

	//panel della propria mano
	private JPanel panelCarteMano;
	private ArrayList<JLabel> labelCarteMano;
	private JPanel panelRadioMano;
	private ArrayList<JRadioButton> radioCarteMano;
	private JPanel panelBottino;
	private JLabel labelBottino;
	private int manoSel;

	//pannelli bottone gioca e log 
	private JPanel panelBottoneGioco;
	private JButton buttonGioco;
	JPanel panelLog;
	private JTextPane textPaneLog;
	private Mossa mossa;
	private Carta giocata;
	private ArrayList<Carta> bersagli;
	private int bersaglio = 0;
	private boolean ok = false;
	private JLabel labelTurno;

	private InvioMosseRubamazzo imr;

	public RubamazzoGui(Comunicazione comunicazione, SituazioneRubamazzo situazione) {
		
		imr = new InvioMosseRubamazzo(comunicazione);
		primoAvvio = true;
		
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

		bancoSel = new ArrayList<>();

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
				gioca();
			}
		});
		buttonGioco.setBounds(92, 65, 100, 100);
		panelBottoneGioco.add(buttonGioco);
		
		labelTurno = new JLabel("");
		labelTurno.setHorizontalAlignment(SwingConstants.CENTER);
		labelTurno.setBounds(103, 195, 78, 34);
		panelBottoneGioco.add(labelTurno);

		panelLog = new JPanel();
		panelLog.setBounds(700, 0, 294, 230);
		contentPane.add(panelLog);
		panelLog.setLayout(new GridLayout(1, 0, 0, 0));

		textPaneLog = new JTextPane();
		panelLog.add(textPaneLog);
		
		aggiornaTavolo();
	}

	private int getIndiceSelezionato(ArrayList<JRadioButton> gruppo){
		int i = 0;
		for(i=0; i<gruppo.size();i++){
			if(gruppo.get(i).isSelected())
				break;
		}
		if(i >= gruppo.size()) 
			i = -1;
		return i;
	}
	
	public String getPath(Carta c){
		return "/immaginiCarte/"+c.toString()+".png";
	}
	
	public String getPathRetroVert(){
		return "/immaginiCarte/RETRO#VERT#.png";
	}
	
	public void aggiornaTavolo(){
		
		JRadioButton temp;
		
		//panel dei bottini avversari
		panelCarteAvversari.removeAll();	
		
		if(!primoAvvio)
			avversarioSel = getIndiceSelezionato(radioCarteAvversari);
		
		labelCarteAvversari.removeAll(labelCarteAvversari);	
		
		System.out.println("CARTE BOTTINI ALTRUI");
		for(int i = 0; i < situazione.getBottiniAltrui().size(); i++){	
			
			System.out.println(situazione.getBottiniAltrui().get(i).toString());

			labelCarteAvversari.add(new JLabel());
			labelCarteAvversari.get(i).setIcon(new ImageIcon(RubamazzoGui.class.getResource(getPath(situazione.getBottiniAltrui().get(i)))));
			labelCarteAvversari.get(i).setToolTipText(situazione.getBottiniAltrui().get(i).toString());
			labelCarteAvversari.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			panelCarteAvversari.add(labelCarteAvversari.get(i));	
		}
		
		panelRadioAvversari.removeAll();
		
		for(int i = 0; i < radioCarteAvversari.size(); i++){
			bgCarteAvversari.remove(radioCarteAvversari.get(i));
		}
		radioCarteAvversari.removeAll(radioCarteAvversari);	
		
		for(int i = 0; i < situazione.getBottiniAltrui().size(); i++){
			temp = new JRadioButton("");
			radioCarteAvversari.add(temp);
			panelRadioAvversari.add(radioCarteAvversari.get(i));
			radioCarteAvversari.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			bgCarteAvversari.add(radioCarteAvversari.get(i));
		}
		
		avversarioSel = getIndiceSelezionato(radioCarteAvversari);
				
		//panel del banco
		panelCarteBanco.removeAll();
		
		labelCarteBanco.removeAll(labelCarteBanco);
		
		for(int i = 0; i < situazione.getBanco().size(); i++){
			labelCarteBanco.add(new JLabel(""));
			labelCarteBanco.get(i).setIcon(new ImageIcon(RubamazzoGui.class.getResource(getPath(situazione.getBanco().get(i)))));
			labelCarteBanco.get(i).setToolTipText(situazione.getBanco().get(i).toString());
			labelCarteBanco.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			panelCarteBanco.add(labelCarteBanco.get(i));
		}
				
		panelCheckBanco.removeAll();
		
		if(!primoAvvio){
			bancoSel.removeAll(bancoSel);
			for(JCheckBox cb: checkCarteBanco)
				bancoSel.add(new Boolean(cb.isSelected()));
		}
		
		checkCarteBanco.removeAll(checkCarteBanco);	
		
		for(int i = 0; i < situazione.getBanco().size(); i++){
			checkCarteBanco.add(new JCheckBox(""));
			panelCheckBanco.add(checkCarteBanco.get(i));
			checkCarteBanco.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			checkCarteBanco.get(i).setEnabled(true);
		}
		
		for(JCheckBox cb: checkCarteBanco)
			bancoSel.add(new Boolean(cb.isSelected()));
				
		//panel della propria mano
		panelCarteMano.removeAll();
		
		if(!primoAvvio)
			manoSel = getIndiceSelezionato(radioCarteMano);
		
		labelCarteMano.removeAll(labelCarteMano);
		
		for(int i = 0; i < situazione.getMano().size(); i++){
			labelCarteMano.add(new JLabel(""));
			labelCarteMano.get(i).setIcon(new ImageIcon(RubamazzoGui.class.getResource(getPath(situazione.getMano().get(i)))));
			labelCarteMano.get(i).setToolTipText(situazione.getMano().get(i).toString());
			labelCarteMano.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			panelCarteMano.add(labelCarteMano.get(i));
		}

		panelRadioMano.removeAll();
		
		for(int i = 0; i < radioCarteMano.size(); i++){
			bgMano.remove(radioCarteMano.get(i));
		}
		radioCarteMano.removeAll(radioCarteMano);	
		
		for(int i = 0; i < situazione.getMano().size(); i++){
			temp = new JRadioButton("");
			radioCarteMano.add(temp);
			panelRadioMano.add(radioCarteMano.get(i));
			radioCarteMano.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			bgMano.add(radioCarteMano.get(i));
		}
		System.out.println("" + situazione.getMioBottino());
		if(situazione.getMioBottino() != null){
			labelBottino.setIcon(new ImageIcon(RubamazzoGui.class.getResource(getPath(situazione.getMioBottino()))));
			labelBottino.setToolTipText(situazione.getMioBottino().toString());
		}
		else {
			labelBottino.setIcon(new ImageIcon(RubamazzoGui.class.getResource(getPathRetroVert())));
			labelBottino.setToolTipText(null);
		}
		
		//pannelli bottone gioca e log 
		buttonGioco.setEnabled(situazione.getAbilitato());
		labelTurno = new JLabel();
		labelTurno.setVisible(true);
		if(situazione.getAbilitato())
			labelTurno.setText("E' il tuo turno!");
		else 
			labelTurno.setText("Tocca i tuoi avversari");
		
		//refresh
		
		if(primoAvvio){
			resetSelRadio();

		}else{ 
			for(int i = 0; i < checkCarteBanco.size(); i++){
				checkCarteBanco.get(i).setSelected(bancoSel.get(i));
			}
			setSelRadio(manoSel, avversarioSel);
		}
		primoAvvio = false;
		revalidate();
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
			return -2;
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
	
	public void resetSelRadio(){
		for(int i = 0; i < radioCarteMano.size(); i++){
			radioCarteMano.get(i).setSelected(false);
		}
		for(int i = 0; i < radioCarteAvversari.size(); i++){
			radioCarteAvversari.get(i).setSelected(false);
		}
	}
	
	public void setSelRadio(int mano, int avversari){
		for(int i = 0; i < radioCarteMano.size(); i++){
			if(i == mano)
				radioCarteMano.get(i).setSelected(true);
			else 
				radioCarteMano.get(i).setSelected(false);
		}
		for(int i = 0; i < radioCarteAvversari.size(); i++){
			if(i == avversari)
				radioCarteAvversari.get(i).setSelected(true);
			else 
				radioCarteAvversari.get(i).setSelected(false);
		}
	}
	
	public void resetSelCheck(){
		for(int i = 0; i < checkCarteBanco.size(); i++){
			checkCarteBanco.get(i).setSelected(false);
		}
	}
	
	public void gioca(){
		System.out.println("bottone cliccato");
		bersagli = new ArrayList<>();
		switch(getTipoMossa()){
		case -2:
			JOptionPane.showMessageDialog(null, "Scegli una carta da giocare");
			break;
		case -1: 
			JOptionPane.showMessageDialog(null, "Scegli correttamente il bersaglio della mossa");
			break;
		case 0:
			giocata = new Carta(labelCarteMano.get(getIndiceSelezionato(radioCarteMano)).getToolTipText());
			mossa = new Mossa(giocata);
			System.out.println("mossa creata \ncarta giocata "+ giocata.toString());
			break;
		case 1:
			giocata = new Carta(labelCarteMano.get(getIndiceSelezionato(radioCarteMano)).getToolTipText());
			for(int i = 0; i < situazione.getBanco().size(); i++)
				if(checkCarteBanco.get(i).isSelected())
					bersagli.add(new Carta(labelCarteBanco.get(i).getToolTipText()));
			mossa = new Mossa(giocata, bersagli.get(0));
			break;
		case 2:
			giocata = new Carta(labelCarteMano.get(getIndiceSelezionato(radioCarteMano)).getToolTipText());
			for(int i = 0; i < situazione.getBanco().size(); i++)
				if(checkCarteBanco.get(i).isSelected())
					bersagli.add(new Carta(labelCarteBanco.get(i).getToolTipText()));
			mossa = new Mossa(giocata, bersagli);
			break;
		case 3:
			giocata = new Carta(labelCarteMano.get(getIndiceSelezionato(radioCarteMano)).getToolTipText());
			bersaglio = getIndiceSelezionato(radioCarteAvversari);
			mossa = new Mossa(giocata, bersaglio);
			break;
		}
		
		try {
			if(getTipoMossa() >= 0){
				ok = imr.invio(mossa, situazione.getPartita());
				if(!ok)
					JOptionPane.showMessageDialog(null, "Mossa illegale");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EccezioneUtente e) {
			e.printStackTrace();
		}
		try {
			if(comunicazione.getTipoCom()){
				comunicazione.aggRubamazzoSocket();
				situazione = comunicazione.riceviAggRubamazzoSocket();
			}
			else {
				situazione = comunicazione.aggRubamazzoRmi();
			}
		} catch (IOException e) {
			System.out.println("impossibile ricevere dal server l'aggiornamento rubamazzo");
			e.printStackTrace();
		}
		if(ok){
			resetSelCheck();
			resetSelRadio();
		}
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(500);
				if(comunicazione.getTipoCom()){
					comunicazione.aggRubamazzoSocket();
					situazione = comunicazione.riceviAggRubamazzoSocket();
				}
				else {
					situazione = comunicazione.aggRubamazzoRmi();
				}
			} catch (InterruptedException e) {
				System.out.println("impossibile fare la sleep");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("impossibile ricevere dal server l'aggiornamento rubamazzo");
				e.printStackTrace();
			}
			aggiornaTavolo();
		}
	}
}
