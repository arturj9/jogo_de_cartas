package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
//		jp.setBackground(new Color(163, 26, 201));
		painelCartas = new JButton[6];
		fazerTelaCartas();
		JPanel pvez= new JPanel();
		pvez.setLayout(new GridLayout(2,1,20,20));
		JPanel temp0 = new JPanel();
		
		pvez.setBackground(new Color(163, 26, 201));
		pvez.setBorder(new LineBorder(Color.BLACK));
		JLabel vez = new JLabel();
		vez.setText("------------------------------------------------------- VEZ DO JOGADOR # ---------------------------------------------------");
		vez.setFont(new Font("",Font.BOLD,14));
		vez.setForeground(Color.white);
		
		JPanel sul = new JPanel();
		JPanel temp = new JPanel();
		temp.setOpaque(false);
		
		sul.setLayout(new GridLayout(3,1,20,20));
		JButton l1 = new JButton();
		l1.setText("Escolha sua Carta");
		JTextField resposta = new JTextField();
		
		sul.add(temp);
		sul.add(resposta);
		sul.add(l1);
		pvez.add(vez);
		pvez.add(temp0);
		this.add(pvez,BorderLayout.NORTH);
		this.add(jp,BorderLayout.CENTER);
		this.add(sul,BorderLayout.SOUTH);
		
	}
	public void fazerTelaCartas() {
		for(int i = 0;i<painelCartas.length;i++) {
			painelCartas[i] = new Cartas(i,tp);
			painelCartas[i].setSize(10,10);
			jp.add(painelCartas[i]);
		}
		
		painelCartas[0].setIcon(new ImageIcon("img/robo.jpeg"));
		painelCartas[1].setBackground(Color.blue);
		painelCartas[2].setBackground(Color.cyan);
		painelCartas[3].setBackground(Color.darkGray);
		painelCartas[4].setBackground(Color.gray);
		painelCartas[5].setBackground(Color.green);
		
	}
}
