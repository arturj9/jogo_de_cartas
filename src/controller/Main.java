package controller;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(new Jogador(IDJogador._1_.getId(), "Kaio"));
		jogadores.add(new Jogador(IDJogador._2_.getId(), "Kaue"));
		jogadores.add(new Jogador(IDJogador._3_.getId(), "Mat"));
		jogadores.add(new Jogador(IDJogador._4_.getId(), "Clara"));
		Partida partida = new Partida(jogadores);
		for (int i = 0; i < 4; i++) {
			System.out.println(partida.getRodadaAtual().getJogadorDaJogada().getNome());
			partida.getRodadaAtual().getJogadorDaJogada().efetuarJogada(
					partida.getRodadaAtual().getJogadorDaJogada().getBaralho().getCartas().get(0), "Planeta",
					partida.getRodadaAtual());
			System.out.println(partida.getRodadaAtual().getJogadorDaJogada().getNome());
			partida.getRodadaAtual().getJogadorDaJogada().efetuarJogada(
					partida.getRodadaAtual().getJogadorDaJogada().getBaralho().getCartas().get(0),
					partida.getRodadaAtual());
			System.out.println(partida.getRodadaAtual().getJogadorDaJogada().getNome());
			partida.getRodadaAtual().getJogadorDaJogada().efetuarJogada(
					partida.getRodadaAtual().getJogadorDaJogada().getBaralho().getCartas().get(0),
					partida.getRodadaAtual());
			System.out.println(partida.getRodadaAtual().getJogadorDaJogada().getNome());
			partida.getRodadaAtual().getJogadorDaJogada().efetuarJogada(
					partida.getRodadaAtual().getJogadorDaJogada().getBaralho().getCartas().get(0),
					partida.getRodadaAtual());
			System.out.println(partida.getRodadaAtual().getJogadorDaJogada().getNome());
			partida.getRodadaAtual().getJogadorDaJogada().efetuarJogada(
					partida.getRodadaAtual().getJogadorDaJogada().getBaralho().getCartas().get(0),
					partida.getRodadaAtual());
			System.out.println(partida.getRodadaAtual().getJogadorDaJogada().getNome());
			partida.getRodadaAtual().getJogadorDaJogada().efetuarJogada(
					partida.getRodadaAtual().getJogadorDaJogada().getBaralho().getCartas().get(0),
					partida.getRodadaAtual());
			System.out.println(partida.getRodadaAtual().getJogadorDaJogada().getNome());
			partida.getRodadaAtual().getJogadorDaJogada().efetuarJogada(
					partida.getRodadaAtual().getJogadorDaJogada().getBaralho().getCartas().get(0),
					partida.getRodadaAtual());
			partida.getRodadaAtual().calcularPontuacao();
			partida.proximaRodada();
			System.out.println(partida.verificarFimDeJogo());
		}

	}

}
