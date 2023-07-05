package controller;

import java.util.ArrayList;

public class Partida {

	private ArrayList<Jogador> jogadores;
	private ArrayList<Rodada> rodadas;

	public Partida(ArrayList<Jogador> jogadores) {
		setJogadores(jogadores);
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
