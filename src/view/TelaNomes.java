package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class TelaNomes extends JFrame{
	public TelaNomes() {
		this.setLayout(new BorderLayout());
		this.setSize(500,500);
		this.setResizable(false);
		JLabel l1 = new JLabel("-------------------------------------------Nome dos jogadores:-----------------------------------------------");
		l1.setBorder(new LineBorder(Color.black));
		this.add(l1,BorderLayout.NORTH);
		
		
		JPanel j1 = new JPanel();
		j1.setLayout(new GridLayout(4,2,20,10));
		JTextField p1 = new JTextField(); 
		p1.setBounds(80, 90, 150, 20);
		JTextField p2 = new JTextField(); 
		p2.setBounds(80, 130, 100, 20);
		JTextField p3 = new JTextField(); 
		p3.setBounds(80, 170, 100, 20);
		JTextField p4 = new JTextField();
		p4.setBounds(80, 210, 100, 20);
		
		JLabel pl1 = new JLabel("Jogador 1: "); 
		JLabel pl2 = new JLabel("Jogador 2: "); 
		JLabel pl3 = new JLabel("Jogador 3: "); 
		JLabel pl4 = new JLabel("Jogador 4: "); 
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
			TelaPrincipal tp = new TelaPrincipal();
			jf.dispose();
		}
	}
}
