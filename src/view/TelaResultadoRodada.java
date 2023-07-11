package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Carta;
import controller.Partida;
import controller.Rodada;

public class TelaResultadoRodada extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JFrame janela;
	private Partida partida;
	private Rodada rodada;
	private Carta cartaEscolhida;
	
	public TelaResultadoRodada(Partida p, Carta cartaEscolhida) {
		
		janela = this;
		partida = p;
		rodada = partida.getRodadaAtual();
		setCartaEscolhida(cartaEscolhida);
		
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
		
		painelNorte.add(texto);
		
		return painelNorte;
		
	}
	
	private JPanel JPanelCentro() {
		
		JPanel painelCentro = configurarCor();
		painelCentro.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JPanel painelAux = new JPanel();
		painelAux.setOpaque(false);
		
		JButton botaoCarta = new JButton();
		botaoCarta.setPreferredSize(new Dimension(300,300));
		botaoCarta.setIcon(cartaEscolhida.getIcon(350, 300));
		
		
		painelCentro.add(painelAux);
		painelCentro.add(botaoCarta);
		
		return painelCentro;
	}
	
	private JPanel JPanelSul() {
		
		ImageIcon icone = new ImageIcon("icons/next.png");
		JPanel painelSul = configurarCor();
		painelSul.setLayout(new FlowLayout());

		JButton botao = new JButton("Começar Próxima Rodada");
		botao.setFont(new Font("", Font.BOLD, 18));
		botao.setForeground(Color.black);
		botao.setHorizontalAlignment(JLabel.CENTER);
		botao.setIcon(icone);
		botao.addActionListener(new proximaRodada());
		
		painelSul.add(botao);
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
			janela.dispose();
			new TelaJogadorVez(partida);
			}
		}
	
	public Carta getCartaEscolhida() {
		return cartaEscolhida;
	}
	public void setCartaEscolhida(Carta cartaEscolhida) {
		this.cartaEscolhida = cartaEscolhida;
	}
}
