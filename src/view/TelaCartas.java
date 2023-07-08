package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TelaCartas extends JPanel{
	private TelaPrincipal tp;
	private JPanel jp;
	private JButton[] painelCartas;
	public TelaCartas(TelaPrincipal tp) {
		this.tp = tp;
		this.setLayout(new BorderLayout());
		jp = new JPanel();
		jp.setLayout(new GridLayout(2,6,50,50));
		painelCartas = new JButton[6];
		fazerTelaCartas();
		JLabel vez = new JLabel();
		vez.setBorder(new LineBorder(Color.black));
		vez.setText("----------------------------------------------------------------------------VEZ DO JOGADOR #:----------------------------------------------------------------");

		JTextField resposta = new JTextField();
		this.add(resposta,BorderLayout.SOUTH);
		this.add(vez,BorderLayout.NORTH);
		this.add(jp,BorderLayout.CENTER);
		
	}
	public void fazerTelaCartas() {
		for(int i = 0;i<painelCartas.length;i++) {
			painelCartas[i] = new Cartas(i,tp);
			painelCartas[i].setSize(10,10);
			jp.add(painelCartas[i]);
		}
		//ImageIcon imagem = new ImageIcon(getClass().getResource("img\\robo.jpeg"));
		painelCartas[0].setBackground(Color.black);
		painelCartas[1].setBackground(Color.blue);
		painelCartas[2].setBackground(Color.cyan);
		painelCartas[3].setBackground(Color.darkGray);
		painelCartas[4].setBackground(Color.gray);
		painelCartas[5].setBackground(Color.green);
		
	}
}
