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

public class SlotFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlotFrame frame = new SlotFrame();
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
	public SlotFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBenvenutiNellaSlot = new JLabel("Benvenuti nella slot machine");
		lblBenvenutiNellaSlot.setBounds(12, 12, 226, 15);
		contentPane.add(lblBenvenutiNellaSlot);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/home/fritz/git/ClientSalaGiochi/ClientSalaGiochi/simboliSlot/dollaro.jpg"));
		lblNewLabel.setBounds(12, 61, 115, 102);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/home/fritz/git/ClientSalaGiochi/ClientSalaGiochi/simboliSlot/dollaro.jpg"));
		lblNewLabel_1.setBounds(151, 61, 115, 102);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("/home/fritz/git/ClientSalaGiochi/ClientSalaGiochi/simboliSlot/dollaro.jpg"));
		label.setBounds(302, 61, 115, 102);
		contentPane.add(label);
		
		JButton btnRolla = new JButton("Rolla");
		btnRolla.setBounds(319, 234, 117, 25);
		contentPane.add(btnRolla);
		
		JLabel lblCrediti = new JLabel("Crediti");
		lblCrediti.setBounds(12, 239, 70, 15);
		contentPane.add(lblCrediti);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(81, 239, 70, 15);
		contentPane.add(lblNewLabel_2);
	}
}
