package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class TelaNomes extends JFrame{
	private JTextField p1;
	private JTextField p2;
	private JTextField p3;
	private JTextField p4;
	public TelaNomes() {
		this.setLayout(new BorderLayout());
		this.setTitle("Jogo de Cartas");
		this.setSize(500,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		JPanel plabel = new JPanel();
		plabel.setBackground(new Color(163, 26, 201));
		JLabel l1 = new JLabel("---------------------------------Nome Dos Jogadores:---------------------------------");
		l1.setFont(new Font("",Font.BOLD,14));
		l1.setForeground(Color.WHITE);
		l1.setBorder(new LineBorder(Color.black));
		plabel.add(l1);
		this.add(plabel,BorderLayout.NORTH);
		
		
		JPanel j1 = new JPanel();
		//teste
		j1.setLayout(new GridLayout(4,2,20,10));
		p1 = new JTextField(); 
		p1.setBounds(80, 90, 150, 20);
		p2 = new JTextField(); 
		p2.setBounds(80, 130, 100, 20);
		p3 = new JTextField(); 
		p3.setBounds(80, 170, 100, 20);
		p4 = new JTextField();
		p4.setBounds(80, 210, 100, 20);
		j1.setBackground(new Color(163, 26, 201));
		
		JLabel pl1 = new JLabel("Jogador 1: "); 
		pl1.setForeground(Color.white);
		JLabel pl2 = new JLabel("Jogador 2: "); 
		pl2.setForeground(Color.white);
		JLabel pl3 = new JLabel("Jogador 3: "); 
		pl3.setForeground(Color.white);
		JLabel pl4 = new JLabel("Jogador 4: "); 
		pl4.setForeground(Color.white);
		j1.add(pl1);
		j1.add(p1);
		j1.add(pl2);
		j1.add(p2);
		j1.add(pl3);
		j1.add(p3);
		j1.add(pl4);
		j1.add(p4);
		
		this.add(j1,BorderLayout.CENTER);
		
		JPanel pj = new JPanel();
		pj.setBorder(new LineBorder(Color.black));
		pj.setBackground(new Color(163, 26, 201));
		JButton jogar = new JButton("JOGAR");
		jogar.addActionListener(new newGame(this));
		pj.add(jogar);
		this.add(pj,BorderLayout.SOUTH);
		this.setVisible(true);
	}
	private class newGame implements ActionListener {
		private JFrame jf;
		private newGame(JFrame jf) {
			this.jf = jf;
		}
		public void actionPerformed(ActionEvent e) {
			if(p1.getText().isEmpty() || p2.getText().isEmpty() || p3.getText().isEmpty()|| p4.getText().isEmpty())
				JOptionPane.showMessageDialog(null,"Campos Imcompletos");
			else {
				try {
					String nomep1 = p1.getText();
					String nomep2 = p2.getText();
					String nomep3 = p3.getText();
					String nomep4 = p4.getText();
				}catch(Exception E) {
				
				}
				TelaPrincipal tp = new TelaPrincipal();
				jf.dispose();
			}
		}
			}
			
}
