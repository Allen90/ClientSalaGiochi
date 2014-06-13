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

public class RubamazzoGui extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCarteAvversari = new JPanel();
		panelCarteAvversari.setBounds(0, 0, 700, 200);
		contentPane.add(panelCarteAvversari);
		
		JPanel panelRadioAvversari = new JPanel();
		panelRadioAvversari.setBounds(0, 200, 700, 30);
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
		panelCarteBanco.setBounds(0, 230, 700, 200);
		contentPane.add(panelCarteBanco);
		panelCarteBanco.setLayout(new GridLayout(1, 10, 0, 0));
		
		JPanel panelRadioBanco = new JPanel();
		panelRadioBanco.setBounds(0, 430, 700, 30);
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
		
		JPanel panelMano = new JPanel();
		panelMano.setBounds(200, 460, 500, 200);
		contentPane.add(panelMano);
		panelMano.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panelBottino = new JPanel();
		panelBottino.setBounds(0, 460, 200, 230);
		contentPane.add(panelBottino);
		panelBottino.setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Bottino");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelBottino.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(200, 660, 500, 30);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("");
		radioButton_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("");
		radioButton_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(radioButton_5);
	}
}
