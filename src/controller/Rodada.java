package controller;

import java.util.ArrayList;

public class Rodada {

	private Jogador jogadorDaVez;
	private ArrayList<Jogador> jogadores;
	private ArrayList<Jogada> jogadasIniciais;
	private ArrayList<Jogada> jogadasFinais;


	public Rodada(Jogador jogadorDaVez, ArrayList<Jogador> jogadores) {
		setJogadorDaVez(jogadorDaVez);
		setJogadores(jogadores);
		setJogadasIniciais(new ArrayList<Jogada>());
		setJogadasFinais(new ArrayList<Jogada>());
	}

	public Jogador getJogadorDaJogada() {
		if(jogadasFinais.size()<jogadores.size()) {
			if(jogadasIniciais.size()==0)
				return jogadorDaVez;
			if(jogadasIniciais.size()<jogadores.size()+1)
				return jogadores.get(jogadasIniciais.size()-1);
			return jogadores.get(jogadasFinais.size());
		}
		return null;
	}

	public void calcularPontuacao() {
		for (Jogador jogador : getTodosJogadores()) {
			jogador.addPontuacao(3);
		}
	}
	
	public Baralho getBaralhoJogadasFinaisEmbaralhado() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		for (Jogada jogada : jogadasFinais) {
			cartas.add(jogada.getCarta());
		}
		
		return new Baralho(cartas).getEmbaralhado();
	}

	public Jogador getJogadorById(IDJogador id) {
		for (Jogador jogador : getTodosJogadores()) {
			if (jogador.getId() == id.getId())
				return jogador;
		}
		return null;
	}
	
	public Jogada getJogadaJogadorDaVez() {
		return jogadasIniciais.get(0);
	}
	
	public Jogada getJogadaFinalByJogadorId(IDJogador id) {
		if(jogadorDaVez.getId()==id.getId())
			return getJogadaJogadorDaVez();
		for (Jogada jogada : jogadasFinais) {
			if (jogada.getJogador().getId() == id.getId())
				return jogada;
		}
		return null;
	}
	
	public ArrayList<Jogador> getTodosJogadores() {
		ArrayList<Jogador> todosJogadores = new ArrayList<Jogador>();
		todosJogadores.add(jogadorDaVez);
		for (Jogador jogador : jogadores) {
			todosJogadores.add(jogador);
		}
		return todosJogadores;
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
	
	public void addJogada(Jogada jogada) {
		if(jogadasIniciais.size()<jogadores.size()+1)
			addJogadaInicial(jogada);
		else
			addJogadaFinal(jogada);
	}
	
	public ArrayList<Jogada> getJogadasIniciais() {
		return jogadasIniciais;
	}

	public void setJogadasIniciais(ArrayList<Jogada> jogadasIniciais) {
		this.jogadasIniciais = jogadasIniciais;
	}
	
	public void addJogadaInicial(Jogada jogadaInicial) {
		jogadasIniciais.add(jogadaInicial);
	}
	
	public ArrayList<Jogada> getJogadasFinais() {
		return jogadasFinais;
	}

	public void setJogadasFinais(ArrayList<Jogada> jogadasFinais) {
		this.jogadasFinais = jogadasFinais;
	}
	
	public void addJogadaFinal(Jogada jogadaFinal) {
		jogadasFinais.add(jogadaFinal);
	}
}
