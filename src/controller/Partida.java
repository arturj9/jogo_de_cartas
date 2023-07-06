package controller;

import java.util.ArrayList;

public class Partida {

	private ArrayList<Jogador> jogadores;
	private ArrayList<Rodada> rodadas;

	public Partida(ArrayList<Jogador> jogadores) {
		setJogadores(jogadores);
		setRodadas(new ArrayList<Rodada>());
	}

	public void proximaRodada() {
		Jogador proximoJogadorDaVez = getProximoJogadorDaVez();
		rodadas.add(new Rodada(proximoJogadorDaVez, getJogadoresComuns(proximoJogadorDaVez)));
	}

	public Jogador getProximoJogadorDaVez() {
		Jogador jogadorDaVez = getRodadaAtual().getJogadorDaVez();
		if (jogadorDaVez == jogadores.get(jogadores.size() - 1))
			return jogadores.get(0);
		return jogadores.get(jogadores.indexOf(jogadorDaVez) + 1);
	}

	public ArrayList<Jogador> getJogadoresComuns(Jogador proximoJogadorDaVez) {
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		for (Jogador jogador : jogadores) {
			if (jogador != proximoJogadorDaVez)
				jogadores.add(jogador);
		}
		return jogadores;
	}
	
	public boolean verificarFimDeJogo() {
		for (Jogador jogador : jogadores) {
			if(jogador.getPontuacaoAtual()>=10)
				return true;
		}
		return false;
		
	}

	public Rodada getRodadaAtual() {
		if (rodadas.size() == 0)
			return null;
		return rodadas.get(rodadas.size() - 1);
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
