package controller;

public class Jogador {

	private IDJogador id;
	private String nome;
	private Baralho baralho;
	private int pontuacao;

	public Jogador(IDJogador id, String nome) {
		setNome(nome);
		setPontuacao(0);
		setBaralho();
		setId(id);
	}

	public Jogador(IDJogador id, String nome, Baralho baralho, int pontuacao) {
		setId(id);
		setNome(nome);
		setBaralho(baralho);
		setPontuacao(pontuacao);
	}

	public void efetuarJogada(Carta carta, String dica, Rodada rodada) {
		rodada.addJogada(new Jogada(this, carta, dica));
	}

	public void efetuarJogada(Carta carta, Rodada rodada) {
		rodada.addJogada(new Jogada(this, carta));
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

	public void setBaralho() {
		setBaralho(BaralhoJogo.getInstacia().getCartas(6));
	}

	public void addPontuacao(int pontuacao) {
		setPontuacao(getPontuacao() + pontuacao);
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public IDJogador getId() {
		return id;
	}

	public void setId(IDJogador id) {
		this.id = id;
	}

}
