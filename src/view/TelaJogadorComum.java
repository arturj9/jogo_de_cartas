package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.Partida;

public class TelaJogadorComum extends JFrame{
	
	private JFrame Janela;
	private Partida partida;
	private String dica;
	private JPanel[] telaCartas;
	private JPanel telaAdivinhar;
	private JPanel ti;
	private int idCarta;
	private ArrayList<Integer> ids;
	private int contRodadas;
	
	public TelaJogadorComum(Partida p, String d) {
		
		Janela = this;
		partida = p;
		dica = d;
		
		this.setLayout(new BorderLayout());
		this.setTitle("Dixit");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel painelNorte = configurarPainelNorte();
		JPanel painelCentro = configurarPainelCentro();
		JPanel painelSul = configurarCor();
		painelSul.add(botaoPronto());
		
		this.add(painelNorte, BorderLayout.NORTH);
		this.add(painelCentro, BorderLayout.CENTER);
		this.add(painelSul, BorderLayout.SOUTH);
		
////		contRodadas = 0;
////		idCarta = -1;
////		ids = new ArrayList<Integer>();
//		
//		telaCartas = new JPanel[4];
//		this.setSize(700,700);
//		this.setLayout(new BorderLayout());
//		this.setLocationRelativeTo(null);
//		telaCartas[0] = new TelaCartas(this);
//		telaCartas[1] = new TelaCartas(this);
//		telaCartas[2] = new TelaCartas(this);
//		telaCartas[3] = new TelaCartas(this);
//		
//		JPanel cartas = new JPanel();
//		cartas.setBorder(new LineBorder(Color.black));
//		JPanel cartas1 = new JPanel();
////		cartas1.add(l1);
//		this.add(cartas1,BorderLayout.SOUTH);
////		this.add(telaCartas[0],BorderLayout.CENTER);
////		this.add(telaCartas[1],BorderLayout.CENTER);
////		this.add(telaCartas[2],BorderLayout.CENTER);
////		this.add(telaCartas[3],BorderLayout.CENTER);
////		
//		visibilidadeCartas(2);
//	
////		
		this.setVisible(true);
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
	
	private JPanel configurarCorVerde() {
		
		JPanel painelAux = new JPanel() {
			
            private static final long serialVersionUID = 1L;

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                Color cor1 = Color.GREEN;
                Color cor2 = Color.YELLOW;
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
	
	private JPanel configurarPainelNorte() {
		
		JPanel painel = configurarCor();
		painel.setLayout(new GridLayout(1, 4));
		
        for (int i = 0; i < 4; i++) {
        	JLabel jogador = new JLabel("<html>" + partida.getNomeJogador(i) + "<br>" + partida.getPontosJogador(i) + " "
        			+ "PONTOS</html>");
            		jogador.setFont(new Font("",Font.BOLD,16));
            		jogador.setForeground(Color.WHITE);
            		
            		jogador.setHorizontalAlignment(JLabel.CENTER);
            		
            		if(i == 0) {
            			jogador.setBackground(Color.white);
            			JPanel p = configurarCorVerde();
            			p.add(jogador);
            			painel.add(p);
            		} else {
            			jogador.setBorder(new LineBorder(Color.black));
            			painel.add(jogador);
            		}
        }
		
		return painel;
	}
	
	private JPanel configurarPainelCentro() {
		
		JPanel painel = configurarCor();

        painel.setLayout(new BorderLayout());
        
        JPanel painelNorte = configurarCor();
        painelNorte.setLayout(new GridLayout(2, 1));
        
        JLabel texto = new JLabel("<html>Vez do Jogador 2 - DICA: " + dica + "<html>");
        texto.setFont(new Font("",Font.BOLD,16));
		texto.setForeground(Color.WHITE);
        texto.setHorizontalAlignment(JLabel.CENTER);
        
        JLabel texto2 = new JLabel("<html>Escolha a Carta que você acha que mais combina com a Dica acima:<html>");
        texto2.setFont(new Font("",Font.BOLD,16));
		texto2.setForeground(Color.WHITE);
        texto2.setHorizontalAlignment(JLabel.CENTER);
        
        painelNorte.add(texto);
        painelNorte.add(texto2);
        painel.add(painelNorte, BorderLayout.NORTH);
        
        JPanel painelCartas = configurarCor();
        painelCartas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelCartas.setLayout(new GridLayout(2, 3, 10, 10));
        painel.add(painelCartas, BorderLayout.CENTER);
        
        ImageIcon icon = new ImageIcon("img/mundoFuturistico.jpeg");
        
        for (int i = 0; i < 6; i++) {
            JButton botaoCarta = new JButton();
            Image resizedImage = icon.getImage().getScaledInstance(250, 252, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            botaoCarta.setIcon(resizedIcon);
            painelCartas.add(botaoCarta);
        }
		
		return painel;
	}
	
	private JButton botaoPronto() {
		
		JButton botao = new JButton("PRONTO");
		
		botao.setBackground(Color.white);
		botao.setFont(new Font("",Font.BOLD,16));
		botao.addActionListener(new acaoComecar());
		
		return botao;
	}
	
	private class acaoComecar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(Janela,"Vez do Jogaodor 2", "VEZ DO JOGADOR 2", JOptionPane.INFORMATION_MESSAGE, null);	
		}
	}
	
}
