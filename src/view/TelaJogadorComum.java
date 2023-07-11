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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.Carta;
import controller.Jogador;
import controller.Partida;
import controller.Rodada;

public class TelaJogadorComum extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame janela;
	private Partida partida;
	private Rodada rodada;
	private String dica;
	private ArrayList<BotaoCarta> botoesCartas;
	private int intAux;
	private boolean selecionado;

	private BotaoCarta botaoCartaSelecionado;

	public TelaJogadorComum(Partida p, String d, int quant) {

		janela = this;
		partida = p;
		rodada = partida.getRodadaAtual();
		dica = d;
		botoesCartas = new ArrayList<BotaoCarta>();
		intAux = quant + 1;

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

		JLabel texto = new JLabel(
				"<html>Vez do/a " + rodada.getJogadorDaVez().getNome() + " - DICA: " + dica + "<html>");
		texto.setFont(new Font("", Font.BOLD, 16));
		texto.setForeground(Color.WHITE);
		texto.setHorizontalAlignment(JLabel.CENTER);

		JLabel texto2 = new JLabel();

		if (intAux >= 5) {
			texto2.setText(
					"<html>Escolha a Carta que você acha que é a do " + rodada.getJogadorDaVez().getNome() + ":<html>");
		} else {
			texto2.setText("<html>Escolha a Carta que você acha que mais combina com a Dica acima:<html>");
		}

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

		ArrayList<Carta> cartas;

		if (partida.getRodadaAtual().verificaFaseInicial()) {
			cartas = partida.getRodadaAtual().getBaralhoJogadasIniciaisEmbaralhado().getCartas();
			for (Carta carta : cartas) {
				BotaoCarta botaoCarta = new BotaoCarta("", carta, new Selecionar());
				if (partida.getRodadaAtual().getJogadaInicialByJogador(partida.getRodadaAtual().getJogadorDaJogada())
						.getCarta() != carta) {
					botoesCartas.add(botaoCarta);
					painelCartas.add(botaoCarta);
				}
			}
		} else {
			cartas = partida.getRodadaAtual().getJogadorDaJogada().getBaralho().getCartas();
			for (Carta carta : cartas) {
				BotaoCarta botaoCarta = new BotaoCarta("", carta, new Selecionar());
				botoesCartas.add(botaoCarta);
				painelCartas.add(botaoCarta);
			}
		}

		if (botoesCartas.size() == 3) {
			for (int i = 0; i < botoesCartas.size(); i++) {
				ImageIcon aux = botoesCartas.get(i).getCarta().getIcon(350, 255);
				botoesCartas.get(i).setIcon(aux);

			}
		} else if (botoesCartas.size() == 6) {
			for (int i = 0; i < botoesCartas.size(); i++) {
				ImageIcon aux = botoesCartas.get(i).getCarta().getIcon(250, 260);
				botoesCartas.get(i).setIcon(aux);
			}
		}

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

			if (selecionado) {
				partida.getRodadaAtual().getJogadorDaJogada().efetuarJogada(botaoCartaSelecionado.getCarta(),
						partida.getRodadaAtual());
				if (partida.verificaProximaRodada()) {
					Carta cartaEscolhida = partida.getRodadaAtual().getJogadaJogadorDaVez().getCarta();
					if (partida.proximaRodada()) {
						janela.dispose();
						JOptionPane.showMessageDialog(janela, "Fim", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE,
								null);
					} else {
						janela.dispose();
						new TelaResultadoRodada(partida,cartaEscolhida);
					}
				} else {
					janela.dispose();
					JOptionPane.showMessageDialog(janela,
							"Vez de " + partida.getRodadaAtual().getJogadorDaJogada().getNome(),
							"VEZ DE " + partida.getRodadaAtual().getJogadorDaJogada().getNome(),
							JOptionPane.INFORMATION_MESSAGE, null);
					new TelaJogadorComum(partida, partida.getRodadaAtual().getJogadaJogadorDaVez().getDica(), intAux);
				}
			} else {
				JOptionPane.showMessageDialog(janela, "Escolha uma carta antes de apertar no botão 'PRONTO'!", "Erro!",
						JOptionPane.ERROR_MESSAGE, null);
			}

		}
	}

	private class Selecionar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			BotaoCarta botaoCarta = (BotaoCarta) e.getSource();
			int indiceBotao = botoesCartas.indexOf(botaoCarta);
			selecionado = true;
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
