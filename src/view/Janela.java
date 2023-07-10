package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame Janela;
	private JPanel painelFlow;
	private JLabel tituloJogo;
    private JButton botaoJogar, botaoComoJogar, botaoSair;
    private ImageIcon iconeJogar, iconeComoJogar, iconeSair;

	public Janela() {
		
		this.setTitle("Dixit");
		this.setSize(700,700);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		painelFlow = configurarPainel();
		
		this.add(painelFlow, BorderLayout.CENTER);
		setVisible(true);
	}
	
	private JPanel configurarPainel() {
		
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
        
		iconeJogar = configurarIcone(20, 20, "icons/play.png");
		iconeComoJogar = configurarIcone(20, 20, "icons/howToPlay.png");
		iconeSair = configurarIcone(20, 20, "icons/exit.png");
		
		painelAux.setLayout(new GridLayout(9, 1));
		
		painelAux.add(espacoVazio());
		
		tituloJogo = new JLabel("Dixit");
		tituloJogo.setHorizontalAlignment(SwingConstants.CENTER);
		tituloJogo.setFont(new Font("Arial", Font.BOLD, 65));
		painelAux.add(tituloJogo);
		
		painelAux.add(espacoVazio());
		
		botaoJogar = new JButton("Jogar");
		botaoJogar.setBackground(Color.white);
		botaoJogar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoJogar.setPreferredSize(new Dimension(100, 100));
		botaoJogar.setIcon(iconeJogar);
		botaoJogar.addActionListener(new acaoJogar(this));
		painelAux.add(botaoJogar);
		
		painelAux.add(espacoVazio());
		
		botaoComoJogar = new JButton("Como Jogar");
		botaoComoJogar.setBackground(Color.white);
		botaoComoJogar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoComoJogar.setIcon(iconeComoJogar);
		botaoComoJogar.addActionListener(new acaoComoJogar());
		painelAux.add(botaoComoJogar);
		
		painelAux.add(espacoVazio());
		
		botaoSair = new JButton("Sair");
		botaoSair.setBackground(Color.white);
		botaoSair.setFont(new Font("Arial", Font.BOLD, 15));
		botaoSair.setIcon(iconeSair);
		botaoSair.addActionListener(new acaoExit());
		painelAux.add(botaoSair);
		
		painelAux.setVisible(true);
		
        return painelAux;
	}
	
	private JPanel espacoVazio() {
		
		JPanel painel = new JPanel();
		painel.setOpaque(false);
		
		return painel;
	}
	
	private ImageIcon configurarIcone(int x, int y, String Caminho) {
		
		ImageIcon iconeAux = new ImageIcon(Caminho); 
        Image imagem = iconeAux.getImage();
        Image novaImagem = imagem.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        ImageIcon novoIcone = new ImageIcon(novaImagem);
		
        return novoIcone;
	}
	
	private class acaoJogar implements ActionListener{
		
		private Janela janela;

		public acaoJogar(Janela janela) {
			setJanela(janela);
		}
		
		public void actionPerformed(ActionEvent e) {
			
			TelaNomes telaNomes = new TelaNomes();
			telaNomes.iniciar();
			janela.dispose();
		}

		public void setJanela(Janela janela) {
			this.janela = janela;
		}
	}
	
	private class acaoComoJogar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String texto = "REGRAS:\n\n"
					+ "Ao começar a rodada, o Jogador da vez deve eleger uma de suas 6 cartas para jogar e escrever uma dica que descreva ela.\n"
					+ "A dica não pode ser impossível e também nem tão simples, afinal, o objetivo é que uma ou duas pessoas da mesa acerte qual ela é.\n\n"
					+ "OBS: A dica pode ser uma frase, uma palavra, um refrão de uma música, um filme, ou o que achar necessário para descrevê-la.\n\n"
					+ "Cada um dos outros jogadores deverá então olhar as cartas que possui na mão e eleger uma delas para combinar com a dica do jogador\n"
					+ "da vez para poder enganar os outros, fazendo pensar que a sua carta é a escolhida da rodada.\n\n"
					+ "Após todos os jogadores escolherem uma carta da mão, todos os jogadores, exceto o jogador da rodada, escolherá a carta que acha que\n"
					+ "é do jogador da vez, não fazendo sentido escolher a sua própria carta.\n\n"
					+ "SISTEMA DE PONTOS:\n\n"
					+ "Caso todos os outros jogadores escolherem a carta do jogador da vez, ele não receberá nenhum ponto e os demais ogadores ganham 2 ponto.\n"
					+ "Se o jogador da vez der uma dica muito difícil e nenhum dos outros jogadores acertar, ele também não ganha nenhum ponto os demais\n"
					+ "jogadores marcam 2 pontos.\n\n"
					+ "Se algum jogador tiver a sua carta votada, coma a carta que representa a dica dada, ganhará 1 ponto por cada jogador que votou na sua\n"
					+ "carta.\n\n"
					+ "O jogo termina quando algum participante atingir 30 pontos.\n\n\n"
					+ "É isso. Bom jogo!!";
			
			JOptionPane.showMessageDialog(Janela, texto, "Como Jogar", JOptionPane.INFORMATION_MESSAGE, iconeComoJogar);
		}
	}
	
	private class acaoExit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
