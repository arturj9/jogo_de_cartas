package controller;

public class Jogador {

	private String nome;
	private Baralho baralho;
	private int pontuacao;

	public Jogador(String nome, Baralho baralho, int pontuacao) {
		setNome(nome);
		setBaralho(baralho);
		setPontuacao(pontuacao);
	}

	public Jogador(String nome, Baralho baralho) {
		setNome(nome);
		setBaralho(baralho);
		setPontuacao(0);
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
		this.baralho = baralho;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

}
