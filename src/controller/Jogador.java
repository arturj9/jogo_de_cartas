package controller;

import java.util.ArrayList;

public class Jogador {

	private String nome;
	private Baralho baralho;
	private ArrayList<Integer> pontuacao;

	public Jogador(String nome, ArrayList<Integer> pontuacao) {
		setNome(nome);
		setPontuacao(pontuacao);
		setBaralho();
	}

	public Jogador(String nome, Baralho baralho) {
		setNome(nome);
		setBaralho(baralho);
		setPontuacao(new ArrayList<Integer>());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Baralho getBaralho() {
		return baralho;
	}

	public void setBaralho(Baralho baralho) {
		if (baralho.getCartas().size() == 6)
			this.baralho = baralho;
	}

	public void setBaralho() {
		setBaralho(new BaralhoJogo().getCartas(6));
	}

	public void addPontuacao(int pontuacao) {
		this.pontuacao.add(pontuacao);
	}

	public ArrayList<Integer> getPontuacao() {
		return pontuacao;
	}
	
	public Integer getPontuacaoAtual(){
		return pontuacao.get(pontuacao.size()-1);
	}

	public void setPontuacao(ArrayList<Integer> pontuacao) {
		this.pontuacao = pontuacao;
	}

}
