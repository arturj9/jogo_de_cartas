package controller;

import java.util.ArrayList;

public class Partida {
	private Baralho baralho;
	private ArrayList<Jogador> jogadores;
	private ArrayList<Rodada> rodadas;

	public Partida(Baralho baralho, ArrayList<Jogador> jogadores) {
		setBaralho(baralho);
		setJogadores(jogadores);
	}

	public Baralho getBaralho() {
		return baralho;
	}

	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public ArrayList<Rodada> getRodadas() {
		return rodadas;
	}

	public void setRodadas(ArrayList<Rodada> rodadas) {
		this.rodadas = rodadas;
	}
}
