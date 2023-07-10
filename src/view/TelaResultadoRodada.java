package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument.BranchElement;

import controller.IDJogador;
import controller.Jogador;
import controller.Partida;

public class TelaResultadoRodada extends JFrame {
	
	public TelaResultadoRodada() {
		this.setTitle("Resultado Da Rodada");
		this.setSize(700,700);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.add(JPanelNorte(),BorderLayout.NORTH);
		this.add(JPanelCentro(),BorderLayout.CENTER);
		this.add(JPanelSul(),BorderLayout.SOUTH);
		
		
		this.setVisible(true);
	}
	private JPanel JPanelNorte() {
		JPanel painelNorte = configurarCor();
		painelNorte.setLayout(new FlowLayout());

		JLabel texto = new JLabel("Carta Da Rodada:");
		texto.setFont(new Font("", Font.BOLD, 18));
		texto.setForeground(Color.WHITE);
		texto.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel temp1 = new JPanel();
		temp1.setOpaque(false);
		
		painelNorte.add(texto);
//painelNorte.add(temp1);
		
		
		return painelNorte;
		
	}
	private JPanel JPanelCentro() {
		JPanel painelCentro = configurarCor();
		painelCentro.setLayout(new FlowLayout(FlowLayout.CENTER));
//		
		JPanel temp1 = new JPanel();
		temp1.setOpaque(false);
//
//		JPanel temp2 = new JPanel();
//		temp1.setOpaque(false);
//
//		JPanel temp3 = new JPanel();
//		temp1.setOpaque(false);
//
//		JPanel temp4 = new JPanel();
//		temp1.setOpaque(false);
//		
		JButton j1 = new JButton();
		j1.setPreferredSize(new Dimension(300,300));
		j1.setBackground(Color.black);
		
		painelCentro.add(temp1);
		painelCentro.add(j1);
//		painelCentro.add(temp2,BorderLayout.EAST);
//		painelCentro.add(temp3,BorderLayout.NORTH);
//		painelCentro.add(temp4,BorderLayout.SOUTH);
		
		return painelCentro;
	}
	private JPanel JPanelSul() {
		JPanel painelSul = configurarCor();
		painelSul.setLayout(new FlowLayout());

		JButton pr = new JButton("Começar Próxima Rodada:");
		pr.setFont(new Font("", Font.BOLD, 18));
		pr.setForeground(Color.black);
		pr.setHorizontalAlignment(JLabel.CENTER);
		pr.addActionListener(new proximaRodada());
		
		painelSul.add(pr);
		return painelSul;
	}
	private JPanel configurarCor() {

		JPanel painelAux = new JPanel() {

			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;

				Color cor1 = Color.RED;
				Color cor2 = Color.BLUE;
				int x1 = 0;
				int y1 = 0;
				int x2 = getWidth();
				int y2 = getHeight();

				GradientPaint gradient = new GradientPaint(x1, y1, cor1, x2, y2, cor2);

				g2d.setPaint(gradient);
				g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		return painelAux;
	}
	private class proximaRodada implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//ação botao
			}
		}
}
