package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class TombolaGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TombolaGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 0, 363, 143);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 5, 0, 0));
		
		JButton btnAmbo1 = new JButton("Ambo");
		btnAmbo1.setBounds(12, 155, 75, 25);
		contentPane.add(btnAmbo1);
		
		JButton btnTerna1 = new JButton("Terna");
		btnTerna1.setBounds(99, 155, 81, 25);
		contentPane.add(btnTerna1);
		
		JButton btnQuaterna = new JButton("Quaterna");
		btnQuaterna.setBounds(192, 155, 117, 25);
		contentPane.add(btnQuaterna);
		
		JButton btnCinquina1 = new JButton("Cinquina");
		btnCinquina1.setBounds(12, 192, 117, 25);
		contentPane.add(btnCinquina1);
		
		JButton btnTombola1 = new JButton("Tombola");
		btnTombola1.setBounds(141, 192, 117, 25);
		contentPane.add(btnTombola1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 224, 363, 143);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnAmbo3 = new JButton("Ambo");
		btnAmbo3.setBounds(12, 379, 75, 25);
		contentPane.add(btnAmbo3);
		
		JButton btnTerna3 = new JButton("Terna");
		btnTerna3.setBounds(99, 379, 81, 25);
		contentPane.add(btnTerna3);
		
		JButton btnQuaterna3 = new JButton("Quaterna");
		btnQuaterna3.setBounds(192, 379, 117, 25);
		contentPane.add(btnQuaterna3);
		
		JButton btnCinquina3 = new JButton("Cinquina");
		btnCinquina3.setBounds(12, 416, 117, 25);
		contentPane.add(btnCinquina3);
		
		JButton btnTombola3 = new JButton("Tombola");
		btnTombola3.setBounds(141, 416, 117, 25);
		contentPane.add(btnTombola3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 453, 363, 143);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnAmbo4 = new JButton("Ambo");
		btnAmbo4.setBounds(12, 608, 75, 25);
		contentPane.add(btnAmbo4);
		
		JButton btnTerna4 = new JButton("Terna");
		btnTerna4.setBounds(99, 608, 81, 25);
		contentPane.add(btnTerna4);
		
		JButton btnQuaterna4 = new JButton("Quaterna");
		btnQuaterna4.setBounds(192, 608, 117, 25);
		contentPane.add(btnQuaterna4);
		
		JButton btnCinquina4 = new JButton("Cinquina");
		btnCinquina4.setBounds(12, 645, 117, 25);
		contentPane.add(btnCinquina4);
		
		JButton btnTombola4 = new JButton("Tombola");
		btnTombola4.setBounds(141, 645, 117, 25);
		contentPane.add(btnTombola4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(393, 0, 363, 143);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnAmbo2 = new JButton("Ambo");
		btnAmbo2.setBounds(393, 155, 75, 25);
		contentPane.add(btnAmbo2);
		
		JButton btnTerna2 = new JButton("Terna");
		btnTerna2.setBounds(486, 155, 81, 25);
		contentPane.add(btnTerna2);
		
		JButton btnQuaterna2 = new JButton("Quaterna");
		btnQuaterna2.setBounds(579, 155, 117, 25);
		contentPane.add(btnQuaterna2);
		
		JButton btnCinquina2 = new JButton("Cinquina");
		btnCinquina2.setBounds(393, 192, 117, 25);
		contentPane.add(btnCinquina2);
		
		JButton btnTombola2 = new JButton("Tombola");
		btnTombola2.setBounds(522, 192, 117, 25);
		contentPane.add(btnTombola2);
		
		JPanel pnlTabellone = new JPanel();
		pnlTabellone.setBounds(396, 244, 383, 426);
		contentPane.add(pnlTabellone);
		pnlTabellone.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Tabellone");
		lblNewLabel.setBounds(398, 227, 70, 15);
		contentPane.add(lblNewLabel);
	}
}
