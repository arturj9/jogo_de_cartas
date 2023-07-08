package controller;

import java.util.ArrayList;

public class Rodada {

	private Jogador jogadorDaVez;
	private ArrayList<Jogador> jogadores;
	private ArrayList<Jogada> jogadas;


	public Rodada(Jogador jogadorDaVez, ArrayList<Jogador> jogadores) {
		setJogadorDaVez(jogadorDaVez);
		setJogadores(jogadores);
	}

	public Jogador getJogadorDaJogada() {
		if(jogadas.size()==0)
			return jogadorDaVez;
		if(jogadas.size()<jogadores.size()+1)
			return jogadores.get(jogadas.size()-1);
		return jogadores.get(jogadas.size()-jogadores.size()-1);
	}

	public void calcularPontuacao() {

	}

	public Jogador getJogadorById(int id) {
		for (Jogador jogador : jogadores) {
			if (jogador.getId() == id)
				return jogador;
		}
		return null;
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
	
	public ArrayList<Jogada> getJogadas() {
		return jogadas;
	}

	public void setJogadas(ArrayList<Jogada> jogadas) {
		this.jogadas = jogadas;
	}
	
	public void addJogada(Jogada jogada) {
		jogadas.add(jogada);
	}
}
