package controller;

public class Jogador {

	private String nome;
	private Baralho baralho;
	private int pontuacao;

	public Jogador(String nome, int pontuacao) {
		setNome(nome);
		setPontuacao(pontuacao);
		setBaralho();
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
		if(baralho.getCartas().size()==6)
			this.baralho = baralho;
	}
	
	public void setBaralho() {
			this.baralho = new BaralhoJogo().getCartas(6);
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

}
