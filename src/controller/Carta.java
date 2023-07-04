package controller;

import javax.swing.ImageIcon;

public class Carta {
	private String caminho;
	private boolean sorteada;

	public Carta(String caminho) {
		setCaminho(caminho);
		setSorteada(false);
	}
	
	public ImageIcon getIcon() {
		return new ImageIcon(caminho);
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public boolean isSorteada() {
		return sorteada;
	}

	public void setSorteada(boolean sorteada) {
		this.sorteada = sorteada;
	}

}
