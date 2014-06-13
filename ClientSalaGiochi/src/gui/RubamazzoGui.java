package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

public class RubamazzoGui extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=182,709
	 */
	private final ButtonGroup bgMano = new ButtonGroup();
	/**
	 * @wbp.nonvisual location=182,249
	 */
	private final ButtonGroup bgBottini = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RubamazzoGui frame = new RubamazzoGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RubamazzoGui() {
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
		
		JPanel panelRadioAvversari = new JPanel();
		panelRadioAvversari.setBounds(200, 200, 500, 30);
		contentPane.add(panelRadioAvversari);
		panelRadioAvversari.setLayout(new GridLayout(1, 3, 0, 0));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioAvversari.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioAvversari.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioAvversari.add(rdbtnNewRadioButton);
		
		JPanel panelCarteBanco = new JPanel();
		panelCarteBanco.setBounds(0, 230, 994, 200);
		contentPane.add(panelCarteBanco);
		panelCarteBanco.setLayout(new GridLayout(1, 10, 0, 0));
		
		JPanel panelRadioBanco = new JPanel();
		panelRadioBanco.setBounds(0, 430, 994, 30);
		contentPane.add(panelRadioBanco);
		panelRadioBanco.setLayout(new GridLayout(1, 3, 0, 0));
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioBanco.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioBanco.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioBanco.add(chckbxNewCheckBox);
		
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
		
		JLabel lblNewLabel = new JLabel("Bottino");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelBottino.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(700, 460, 294, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(92, 65, 100, 100);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(700, 0, 294, 230);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextPane textPane = new JTextPane();
		panel_1.add(textPane);
	}
}
