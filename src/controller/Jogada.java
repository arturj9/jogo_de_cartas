package controller;

public class Jogada {
	
	private Jogador jogador;
	private Carta carta;
	private String dica;
	
	public Jogada(Jogador jogador, Carta carta, String dica){
		setJogador(jogador);
		setCarta(carta);
		setDica(dica);
	}
	
	public Jogada(Jogador jogador, Carta carta){
		setJogador(jogador);
		setCarta(carta);
	}
	
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public Carta getCarta() {
		return carta;
	}
	public void setCarta(Carta carta) {
		this.carta = carta;
	}
	public String getDica() {
		return dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
}
