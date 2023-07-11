package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.Carta;
import controller.Jogador;
import controller.Partida;
import controller.Rodada;

public class TelaJogadorVez extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame janela;
	private Partida partida;
	private Rodada rodada;
	private JTextField dica;
	private ArrayList<JButton> botoesCartas;

	private BotaoCarta botaoCartaSelecionado;

	public TelaJogadorVez(Partida p) {

		janela = this;
		partida = p;
		rodada = partida.getRodadaAtual();
		botoesCartas = new ArrayList<JButton>();

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
		ArrayList<Jogador> listaJogadores = rodada.getTodosJogadores();

		for (int i = 0; i < 4; i++) {
			JLabel jogador = new JLabel("<html>" + partida.getNomeJogador(i) + "<br>" + partida.getPontosJogador(i)
					+ " " + "PONTOS</html>");
			jogador.setFont(new Font("", Font.BOLD, 16));
			jogador.setForeground(Color.WHITE);

			jogador.setHorizontalAlignment(JLabel.CENTER);

			if (listaJogadores.get(i) == rodada.getJogadorDaJogada()) {
				JPanel p = configurarCorVerde();
				p.setBorder(new LineBorder(Color.black));
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

		JLabel texto = new JLabel("<html>Vez do/a " + rodada.getJogadorDaVez().getNome() + "<html>");
		texto.setFont(new Font("", Font.BOLD, 16));
		texto.setForeground(Color.WHITE);
		texto.setHorizontalAlignment(JLabel.CENTER);

		JLabel texto2 = new JLabel("<html>Escolha uma Carta<html>");
		texto2.setFont(new Font("", Font.BOLD, 16));
		texto2.setForeground(Color.WHITE);
		texto2.setHorizontalAlignment(JLabel.CENTER);

		painelNorte.add(texto);
		painelNorte.add(texto2);
		painel.add(painelNorte, BorderLayout.NORTH);

		JPanel painelCartas = configurarCor();
		painelCartas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		painelCartas.setLayout(new GridLayout(2, 3, 10, 10));
		painel.add(painelCartas, BorderLayout.CENTER);

		JOptionPane.showMessageDialog(janela, "Vez de " + partida.getRodadaAtual().getJogadorDaJogada().getNome(),
				"VEZ DE " + partida.getRodadaAtual().getJogadorDaJogada().getNome(), JOptionPane.INFORMATION_MESSAGE,
				null);

		for (Carta carta : partida.getRodadaAtual().getJogadorDaJogada().getBaralho().getCartas()) {
			BotaoCarta botaoCarta = new BotaoCarta("", carta, new Selecionar());
			botaoCarta.setIcon(botaoCarta.getCarta().getIcon(250, 250));
			botoesCartas.add(botaoCarta);
			painelCartas.add(botaoCarta);
		}

		JPanel painelSul = configurarCor();
		painelSul.setLayout(new GridLayout(2, 1));

		JLabel textoDica = new JLabel("Escreva uma dica: ");
		textoDica.setFont(new Font("", Font.BOLD, 16));
		textoDica.setForeground(Color.WHITE);
		textoDica.setHorizontalAlignment(JLabel.CENTER);

		dica = new JTextField();

		Font fonte = dica.getFont();
		float novoTamanho = fonte.getSize() + 10;
		dica.setFont(fonte.deriveFont(novoTamanho));

		painelSul.add(textoDica);
		painelSul.add(dica);

		painel.add(painelSul, BorderLayout.SOUTH);

		return painel;
	}

	private JButton botaoPronto() {

		JButton botao = new JButton("PRONTO");

		botao.setBackground(Color.white);
		botao.setFont(new Font("", Font.BOLD, 16));
		botao.addActionListener(new Avancar());

		return botao;
	}

	private class Avancar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String aux = dica.getText().trim();
			if (aux.isEmpty()) {
				JOptionPane.showMessageDialog(janela, "Escreva a DICA antes de apertar no botão 'PRONTO'!", "Erro!",
						JOptionPane.ERROR_MESSAGE, null);
			} else if (botaoCartaSelecionado == null) {
				JOptionPane.showMessageDialog(janela, "Selecione uma carta!", "Erro!",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
			try {
				janela.dispose();

				partida.getRodadaAtual().getJogadorDaJogada().efetuarJogada(botaoCartaSelecionado.getCarta(),
						dica.getText(), partida.getRodadaAtual());
				JOptionPane.showMessageDialog(janela,
						"Vez de " + partida.getRodadaAtual().getJogadorDaJogada().getNome(),
						"VEZ DE " + partida.getRodadaAtual().getJogadorDaJogada().getNome(),
						JOptionPane.INFORMATION_MESSAGE, null);
				new TelaJogadorComum(partida, dica.getText(), 1);
				janela.dispose();
			} catch (Exception ep) {
				JOptionPane.showMessageDialog(janela, "Alerta", ep.getMessage(), JOptionPane.INFORMATION_MESSAGE, null);
			}
		}
	}
}

private class Selecionar implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		BotaoCarta botaoCarta = (BotaoCarta) e.getSource();
		int indiceBotao = botoesCartas.indexOf(botaoCarta);

		for (int i = 0; i < botoesCartas.size(); i++) {
			if (i == indiceBotao) {
				botoesCartas.get(i).setBorder(new LineBorder(Color.black, 5));
			} else {
				botoesCartas.get(i).setBorder(null);
			}
		}

		setBotaoCartaSelecionado(botaoCarta);
	}

	}

	public BotaoCarta getBotaoCartaSelecionado() {
		return botaoCartaSelecionado;
	}

	public void setBotaoCartaSelecionado(BotaoCarta botaoCartaSelecionado) {
		this.botaoCartaSelecionado = botaoCartaSelecionado;
	}
}
