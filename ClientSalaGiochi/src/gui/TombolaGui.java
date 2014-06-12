package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import comunicazione.Comunicazione;

public class TombolaGui extends JFrame {

	private JPanel contentPane;
	private ArrayList[] tabelline;
	/**
	 * Create the frame.
	 */
	public TombolaGui(int numCartelle,Comunicazione comunicazione) {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 0, 363, 143);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 9, 0, 0));
		for(int i=0;i<27;i++)
			panel.add(tabella1.get(i));
		
		
		
//		JLabel label = new JLabel("0");
//		panel.add(label);
//		
//		JLabel label_8 = new JLabel("0");
//		panel.add(label_8);
//		
//		JLabel label_11 = new JLabel("0");
//		panel.add(label_11);
//		
//		JLabel label_14 = new JLabel("0");
//		panel.add(label_14);
//		
//		JLabel label_15 = new JLabel("0");
//		panel.add(label_15);
//		
//		JLabel label_16 = new JLabel("0");
//		panel.add(label_16);
//		
//		JLabel label_17 = new JLabel("0");
//		panel.add(label_17);
//		
//		JLabel label_18 = new JLabel("0");
//		panel.add(label_18);
//		
//		JLabel label_19 = new JLabel("0");
//		panel.add(label_19);
//		
//		JLabel label_20 = new JLabel("0");
//		panel.add(label_20);
//		
//		JLabel label_21 = new JLabel("0");
//		panel.add(label_21);
//		
//		JLabel label_22 = new JLabel("0");
//		panel.add(label_22);
//		
//		JLabel label_12 = new JLabel("0");
//		panel.add(label_12);
//		
//		JLabel label_13 = new JLabel("0");
//		panel.add(label_13);
//		
//		JLabel label_9 = new JLabel("0");
//		panel.add(label_9);
//		
//		JLabel label_10 = new JLabel("0");
//		panel.add(label_10);
//		
//		JLabel label_1 = new JLabel("0");
//		panel.add(label_1);
//		
//		JLabel label_5 = new JLabel("0");
//		panel.add(label_5);
//		
//		JLabel lblNewLabel_4 = new JLabel("0");
//		panel.add(lblNewLabel_4);
//		
//		JLabel lblNewLabel_3 = new JLabel("0");
//		panel.add(lblNewLabel_3);
//		
//		JLabel lblNewLabel_2 = new JLabel("0");
//		panel.add(lblNewLabel_2);
//		
//		JLabel lblNewLabel_1 = new JLabel("0");
//		panel.add(lblNewLabel_1);
//		
//		JLabel label_2 = new JLabel("0");
//		panel.add(label_2);
//		
//		JLabel label_3 = new JLabel("0");
//		panel.add(label_3);
//		
//		JLabel label_4 = new JLabel("0");
//		panel.add(label_4);
//		
//		JLabel label_6 = new JLabel("0");
//		panel.add(label_6);
//		
//		JLabel label_7 = new JLabel("0");
//		panel.add(label_7);
		
		JButton btnAmbo1 = new JButton("Ambo");
		btnAmbo1.setEnabled(false);
		btnAmbo1.setBounds(12, 155, 75, 25);
		contentPane.add(btnAmbo1);
		
		JButton btnTerna1 = new JButton("Terna");
		btnTerna1.setEnabled(false);
		btnTerna1.setBounds(99, 155, 81, 25);
		contentPane.add(btnTerna1);
		
		JButton btnQuaterna = new JButton("Quaterna");
		btnQuaterna.setEnabled(false);
		btnQuaterna.setBounds(192, 155, 117, 25);
		contentPane.add(btnQuaterna);
		
		JButton btnCinquina1 = new JButton("Cinquina");
		btnCinquina1.setEnabled(false);
		btnCinquina1.setBounds(12, 192, 117, 25);
		contentPane.add(btnCinquina1);
		
		JButton btnTombola1 = new JButton("Tombola");
		btnTombola1.setEnabled(false);
		btnTombola1.setBounds(141, 192, 117, 25);
		contentPane.add(btnTombola1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 224, 363, 143);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 9, 0, 0));
		
		JLabel label_23 = new JLabel("0");
		panel_1.add(label_23);
		
		JLabel label_24 = new JLabel("0");
		panel_1.add(label_24);
		
		JLabel label_25 = new JLabel("0");
		panel_1.add(label_25);
		
		JLabel label_26 = new JLabel("0");
		panel_1.add(label_26);
		
		JLabel label_27 = new JLabel("0");
		panel_1.add(label_27);
		
		JLabel label_28 = new JLabel("0");
		panel_1.add(label_28);
		
		JLabel label_29 = new JLabel("0");
		panel_1.add(label_29);
		
		JLabel label_30 = new JLabel("0");
		panel_1.add(label_30);
		
		JLabel label_31 = new JLabel("0");
		panel_1.add(label_31);
		
		JLabel label_32 = new JLabel("0");
		panel_1.add(label_32);
		
		JLabel label_33 = new JLabel("0");
		panel_1.add(label_33);
		
		JLabel label_34 = new JLabel("0");
		panel_1.add(label_34);
		
		JLabel label_35 = new JLabel("0");
		panel_1.add(label_35);
		
		JLabel label_36 = new JLabel("0");
		panel_1.add(label_36);
		
		JLabel label_37 = new JLabel("0");
		panel_1.add(label_37);
		
		JLabel label_38 = new JLabel("0");
		panel_1.add(label_38);
		
		JLabel label_39 = new JLabel("0");
		panel_1.add(label_39);
		
		JLabel label_40 = new JLabel("0");
		panel_1.add(label_40);
		
		JLabel label_41 = new JLabel("0");
		panel_1.add(label_41);
		
		JLabel label_42 = new JLabel("0");
		panel_1.add(label_42);
		
		JLabel label_43 = new JLabel("0");
		panel_1.add(label_43);
		
		JLabel label_44 = new JLabel("0");
		panel_1.add(label_44);
		
		JLabel label_45 = new JLabel("0");
		panel_1.add(label_45);
		
		JLabel label_46 = new JLabel("0");
		panel_1.add(label_46);
		
		JLabel label_47 = new JLabel("0");
		panel_1.add(label_47);
		
		JLabel label_48 = new JLabel("0");
		panel_1.add(label_48);
		
		JLabel label_49 = new JLabel("0");
		panel_1.add(label_49);
		
		JButton btnAmbo3 = new JButton("Ambo");
		btnAmbo3.setEnabled(false);
		btnAmbo3.setBounds(12, 379, 75, 25);
		contentPane.add(btnAmbo3);
		
		JButton btnTerna3 = new JButton("Terna");
		btnTerna3.setEnabled(false);
		btnTerna3.setBounds(99, 379, 81, 25);
		contentPane.add(btnTerna3);
		
		JButton btnQuaterna3 = new JButton("Quaterna");
		btnQuaterna3.setEnabled(false);
		btnQuaterna3.setBounds(192, 379, 117, 25);
		contentPane.add(btnQuaterna3);
		
		JButton btnCinquina3 = new JButton("Cinquina");
		btnCinquina3.setEnabled(false);
		btnCinquina3.setBounds(12, 416, 117, 25);
		contentPane.add(btnCinquina3);
		
		JButton btnTombola3 = new JButton("Tombola");
		btnTombola3.setEnabled(false);
		btnTombola3.setBounds(141, 416, 117, 25);
		contentPane.add(btnTombola3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 453, 363, 143);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 9, 0, 0));
		
		JLabel label_50 = new JLabel("0");
		panel_2.add(label_50);
		
		JLabel label_51 = new JLabel("0");
		panel_2.add(label_51);
		
		JLabel label_52 = new JLabel("0");
		panel_2.add(label_52);
		
		JLabel label_53 = new JLabel("0");
		panel_2.add(label_53);
		
		JLabel label_54 = new JLabel("0");
		panel_2.add(label_54);
		
		JLabel label_55 = new JLabel("0");
		panel_2.add(label_55);
		
		JLabel label_56 = new JLabel("0");
		panel_2.add(label_56);
		
		JLabel label_57 = new JLabel("0");
		panel_2.add(label_57);
		
		JLabel label_58 = new JLabel("0");
		panel_2.add(label_58);
		
		JLabel label_59 = new JLabel("0");
		panel_2.add(label_59);
		
		JLabel label_60 = new JLabel("0");
		panel_2.add(label_60);
		
		JLabel label_61 = new JLabel("0");
		panel_2.add(label_61);
		
		JLabel label_62 = new JLabel("0");
		panel_2.add(label_62);
		
		JLabel label_63 = new JLabel("0");
		panel_2.add(label_63);
		
		JLabel label_64 = new JLabel("0");
		panel_2.add(label_64);
		
		JLabel label_65 = new JLabel("0");
		panel_2.add(label_65);
		
		JLabel label_66 = new JLabel("0");
		panel_2.add(label_66);
		
		JLabel label_67 = new JLabel("0");
		panel_2.add(label_67);
		
		JLabel label_68 = new JLabel("0");
		panel_2.add(label_68);
		
		JLabel label_69 = new JLabel("0");
		panel_2.add(label_69);
		
		JLabel label_70 = new JLabel("0");
		panel_2.add(label_70);
		
		JLabel label_71 = new JLabel("0");
		panel_2.add(label_71);
		
		JLabel label_72 = new JLabel("0");
		panel_2.add(label_72);
		
		JLabel label_73 = new JLabel("0");
		panel_2.add(label_73);
		
		JLabel label_74 = new JLabel("0");
		panel_2.add(label_74);
		
		JLabel label_75 = new JLabel("0");
		panel_2.add(label_75);
		
		JLabel label_76 = new JLabel("0");
		panel_2.add(label_76);
		
		JButton btnAmbo4 = new JButton("Ambo");
		btnAmbo4.setEnabled(false);
		btnAmbo4.setBounds(12, 608, 75, 25);
		contentPane.add(btnAmbo4);
		
		JButton btnTerna4 = new JButton("Terna");
		btnTerna4.setEnabled(false);
		btnTerna4.setBounds(99, 608, 81, 25);
		contentPane.add(btnTerna4);
		
		JButton btnQuaterna4 = new JButton("Quaterna");
		btnQuaterna4.setEnabled(false);
		btnQuaterna4.setBounds(192, 608, 117, 25);
		contentPane.add(btnQuaterna4);
		
		JButton btnCinquina4 = new JButton("Cinquina");
		btnCinquina4.setEnabled(false);
		btnCinquina4.setBounds(12, 645, 117, 25);
		contentPane.add(btnCinquina4);
		
		JButton btnTombola4 = new JButton("Tombola");
		btnTombola4.setEnabled(false);
		btnTombola4.setBounds(141, 645, 117, 25);
		contentPane.add(btnTombola4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(393, 0, 363, 143);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 9, 0, 0));
		
		JLabel label_77 = new JLabel("0");
		panel_3.add(label_77);
		
		JLabel label_78 = new JLabel("0");
		panel_3.add(label_78);
		
		JLabel label_79 = new JLabel("0");
		panel_3.add(label_79);
		
		JLabel label_80 = new JLabel("0");
		panel_3.add(label_80);
		
		JLabel label_81 = new JLabel("0");
		panel_3.add(label_81);
		
		JLabel label_82 = new JLabel("0");
		panel_3.add(label_82);
		
		JLabel label_83 = new JLabel("0");
		panel_3.add(label_83);
		
		JLabel label_84 = new JLabel("0");
		panel_3.add(label_84);
		
		JLabel label_85 = new JLabel("0");
		panel_3.add(label_85);
		
		JLabel label_86 = new JLabel("0");
		panel_3.add(label_86);
		
		JLabel label_87 = new JLabel("0");
		panel_3.add(label_87);
		
		JLabel label_88 = new JLabel("0");
		panel_3.add(label_88);
		
		JLabel label_89 = new JLabel("0");
		panel_3.add(label_89);
		
		JLabel label_90 = new JLabel("0");
		panel_3.add(label_90);
		
		JLabel label_91 = new JLabel("0");
		panel_3.add(label_91);
		
		JLabel label_92 = new JLabel("0");
		panel_3.add(label_92);
		
		JLabel label_93 = new JLabel("0");
		panel_3.add(label_93);
		
		JLabel label_94 = new JLabel("0");
		panel_3.add(label_94);
		
		JLabel label_95 = new JLabel("0");
		panel_3.add(label_95);
		
		JLabel label_96 = new JLabel("0");
		panel_3.add(label_96);
		
		JLabel label_97 = new JLabel("0");
		panel_3.add(label_97);
		
		JLabel label_98 = new JLabel("0");
		panel_3.add(label_98);
		
		JLabel label_99 = new JLabel("0");
		panel_3.add(label_99);
		
		JLabel label_100 = new JLabel("0");
		panel_3.add(label_100);
		
		JLabel label_101 = new JLabel("0");
		panel_3.add(label_101);
		
		JLabel label_102 = new JLabel("0");
		panel_3.add(label_102);
		
		JLabel label_103 = new JLabel("0");
		panel_3.add(label_103);
		
		JButton btnAmbo2 = new JButton("Ambo");
		btnAmbo2.setEnabled(false);
		btnAmbo2.setBounds(393, 155, 75, 25);
		contentPane.add(btnAmbo2);
		
		JButton btnTerna2 = new JButton("Terna");
		btnTerna2.setEnabled(false);
		btnTerna2.setBounds(486, 155, 81, 25);
		contentPane.add(btnTerna2);
		
		JButton btnQuaterna2 = new JButton("Quaterna");
		btnQuaterna2.setEnabled(false);
		btnQuaterna2.setBounds(579, 155, 117, 25);
		contentPane.add(btnQuaterna2);
		
		JButton btnCinquina2 = new JButton("Cinquina");
		btnCinquina2.setEnabled(false);
		btnCinquina2.setBounds(393, 192, 117, 25);
		contentPane.add(btnCinquina2);
		
		JButton btnTombola2 = new JButton("Tombola");
		btnTombola2.setEnabled(false);
		btnTombola2.setBounds(522, 192, 117, 25);
		contentPane.add(btnTombola2);
		
		JPanel pnlTabellone = new JPanel();
		pnlTabellone.setBounds(396, 244, 383, 426);
		contentPane.add(pnlTabellone);
		pnlTabellone.setLayout(new GridLayout(10, 9, 0, 0));
		
		JLabel label_104 = new JLabel("0");
		pnlTabellone.add(label_104);
		
		JLabel label_105 = new JLabel("0");
		pnlTabellone.add(label_105);
		
		JLabel label_158 = new JLabel("0");
		pnlTabellone.add(label_158);
		
		JLabel label_159 = new JLabel("0");
		pnlTabellone.add(label_159);
		
		JLabel label_160 = new JLabel("0");
		pnlTabellone.add(label_160);
		
		JLabel label_161 = new JLabel("0");
		pnlTabellone.add(label_161);
		
		JLabel label_162 = new JLabel("0");
		pnlTabellone.add(label_162);
		
		JLabel label_163 = new JLabel("0");
		pnlTabellone.add(label_163);
		
		JLabel label_164 = new JLabel("0");
		pnlTabellone.add(label_164);
		
		JLabel label_165 = new JLabel("0");
		pnlTabellone.add(label_165);
		
		JLabel label_167 = new JLabel("0");
		pnlTabellone.add(label_167);
		
		JLabel label_168 = new JLabel("0");
		pnlTabellone.add(label_168);
		
		JLabel label_169 = new JLabel("0");
		pnlTabellone.add(label_169);
		
		JLabel label_170 = new JLabel("0");
		pnlTabellone.add(label_170);
		
		JLabel label_171 = new JLabel("0");
		pnlTabellone.add(label_171);
		
		JLabel label_172 = new JLabel("0");
		pnlTabellone.add(label_172);
		
		JLabel label_173 = new JLabel("0");
		pnlTabellone.add(label_173);
		
		JLabel label_174 = new JLabel("0");
		pnlTabellone.add(label_174);
		
		JLabel label_175 = new JLabel("0");
		pnlTabellone.add(label_175);
		
		JLabel label_176 = new JLabel("0");
		pnlTabellone.add(label_176);
		
		JLabel label_178 = new JLabel("0");
		pnlTabellone.add(label_178);
		
		JLabel label_179 = new JLabel("0");
		pnlTabellone.add(label_179);
		
		JLabel label_180 = new JLabel("0");
		pnlTabellone.add(label_180);
		
		JLabel label_181 = new JLabel("0");
		pnlTabellone.add(label_181);
		
		JLabel label_182 = new JLabel("0");
		pnlTabellone.add(label_182);
		
		JLabel label_183 = new JLabel("0");
		pnlTabellone.add(label_183);
		
		JLabel label_184 = new JLabel("0");
		pnlTabellone.add(label_184);
		
		JLabel label_106 = new JLabel("0");
		pnlTabellone.add(label_106);
		
		JLabel label_107 = new JLabel("0");
		pnlTabellone.add(label_107);
		
		JLabel label_108 = new JLabel("0");
		pnlTabellone.add(label_108);
		
		JLabel label_110 = new JLabel("0");
		pnlTabellone.add(label_110);
		
		JLabel label_111 = new JLabel("0");
		pnlTabellone.add(label_111);
		
		JLabel label_131 = new JLabel("0");
		pnlTabellone.add(label_131);
		
		JLabel label_132 = new JLabel("0");
		pnlTabellone.add(label_132);
		
		JLabel label_133 = new JLabel("0");
		pnlTabellone.add(label_133);
		
		JLabel label_134 = new JLabel("0");
		pnlTabellone.add(label_134);
		
		JLabel label_135 = new JLabel("0");
		pnlTabellone.add(label_135);
		
		JLabel label_136 = new JLabel("0");
		pnlTabellone.add(label_136);
		
		JLabel label_137 = new JLabel("0");
		pnlTabellone.add(label_137);
		
		JLabel label_138 = new JLabel("0");
		pnlTabellone.add(label_138);
		
		JLabel label_140 = new JLabel("0");
		pnlTabellone.add(label_140);
		
		JLabel label_141 = new JLabel("0");
		pnlTabellone.add(label_141);
		
		JLabel label_142 = new JLabel("0");
		pnlTabellone.add(label_142);
		
		JLabel label_143 = new JLabel("0");
		pnlTabellone.add(label_143);
		
		JLabel label_144 = new JLabel("0");
		pnlTabellone.add(label_144);
		
		JLabel label_145 = new JLabel("0");
		pnlTabellone.add(label_145);
		
		JLabel label_146 = new JLabel("0");
		pnlTabellone.add(label_146);
		
		JLabel label_147 = new JLabel("0");
		pnlTabellone.add(label_147);
		
		JLabel label_148 = new JLabel("0");
		pnlTabellone.add(label_148);
		
		JLabel label_149 = new JLabel("0");
		pnlTabellone.add(label_149);
		
		JLabel label_151 = new JLabel("0");
		pnlTabellone.add(label_151);
		
		JLabel label_152 = new JLabel("0");
		pnlTabellone.add(label_152);
		
		JLabel label_153 = new JLabel("0");
		pnlTabellone.add(label_153);
		
		JLabel label_154 = new JLabel("0");
		pnlTabellone.add(label_154);
		
		JLabel label_155 = new JLabel("0");
		pnlTabellone.add(label_155);
		
		JLabel label_156 = new JLabel("0");
		pnlTabellone.add(label_156);
		
		JLabel label_157 = new JLabel("0");
		pnlTabellone.add(label_157);
		
		JLabel label_112 = new JLabel("0");
		pnlTabellone.add(label_112);
		
		JLabel label_113 = new JLabel("0");
		pnlTabellone.add(label_113);
		
		JLabel label_114 = new JLabel("0");
		pnlTabellone.add(label_114);
		
		JLabel label_116 = new JLabel("0");
		pnlTabellone.add(label_116);
		
		JLabel label_117 = new JLabel("0");
		pnlTabellone.add(label_117);
		
		JLabel label_118 = new JLabel("0");
		pnlTabellone.add(label_118);
		
		JLabel label_119 = new JLabel("0");
		pnlTabellone.add(label_119);
		
		JLabel label_120 = new JLabel("0");
		pnlTabellone.add(label_120);
		
		JLabel label_121 = new JLabel("0");
		pnlTabellone.add(label_121);
		
		JLabel label_122 = new JLabel("0");
		pnlTabellone.add(label_122);
		
		JLabel label_123 = new JLabel("0");
		pnlTabellone.add(label_123);
		
		JLabel label_185 = new JLabel("0");
		pnlTabellone.add(label_185);
		
		JLabel label_186 = new JLabel("0");
		pnlTabellone.add(label_186);
		
		JLabel label_188 = new JLabel("0");
		pnlTabellone.add(label_188);
		
		JLabel label_189 = new JLabel("0");
		pnlTabellone.add(label_189);
		
		JLabel label_190 = new JLabel("0");
		pnlTabellone.add(label_190);
		
		JLabel label_191 = new JLabel("0");
		pnlTabellone.add(label_191);
		
		JLabel label_192 = new JLabel("0");
		pnlTabellone.add(label_192);
		
		JLabel label_193 = new JLabel("0");
		pnlTabellone.add(label_193);
		
		JLabel label_194 = new JLabel("0");
		pnlTabellone.add(label_194);
		
		JLabel label_195 = new JLabel("0");
		pnlTabellone.add(label_195);
		
		JLabel label_196 = new JLabel("0");
		pnlTabellone.add(label_196);
		
		JLabel label_197 = new JLabel("0");
		pnlTabellone.add(label_197);
		
		JLabel label_199 = new JLabel("0");
		pnlTabellone.add(label_199);
		
		JLabel label_200 = new JLabel("0");
		pnlTabellone.add(label_200);
		
		JLabel label_201 = new JLabel("0");
		pnlTabellone.add(label_201);
		
		JLabel label_202 = new JLabel("0");
		pnlTabellone.add(label_202);
		
		JLabel label_203 = new JLabel("0");
		pnlTabellone.add(label_203);
		
		JLabel label_204 = new JLabel("0");
		pnlTabellone.add(label_204);
		
		JLabel label_205 = new JLabel("0");
		pnlTabellone.add(label_205);
		
		JLabel label_206 = new JLabel("0");
		pnlTabellone.add(label_206);
		
		JLabel label_207 = new JLabel("0");
		pnlTabellone.add(label_207);
		
		JLabel label_208 = new JLabel("0");
		pnlTabellone.add(label_208);
		
		JLabel lblNewLabel = new JLabel("Tabellone");
		lblNewLabel.setBounds(398, 227, 70, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblUltimoEstratto = new JLabel("ultimo estratto:");
		lblUltimoEstratto.setBounds(522, 227, 117, 15);
		contentPane.add(lblUltimoEstratto);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(641, 227, 70, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(641, 227, 70, 15);
		contentPane.add(lblNewLabel_6);
	}
}
