package controller;

import java.util.ArrayList;

public class Rodada {

	private Jogador jogadorDaVez;
	private ArrayList<Jogador> jogadores;

	public Rodada(Jogador jogador, ArrayList<Jogador> jogadores) {
		setJogadorDaVez(jogadorDaVez);
		setJogadores(jogadores);
	}

	private void iniciar() {

	}

	public void calcularPontuacao() {

	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Jogador getJogadorDaVez() {
		return jogadorDaVez;
	}

	public void setJogadorDaVez(Jogador jogadorDaVez) {
		this.jogadorDaVez = jogadorDaVez;
	}
}
