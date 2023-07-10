package controller;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Carta extends ImageIcon {
	private boolean sorteada;
	private String nome;

	public Carta(String pasta, String nome) {
		super(pasta+nome);
		setNome(nome);
		setSorteada(false);
	}
	
	public ImageIcon getIcon(int width, int heigth) {
		Image resizedImage = getImage().getScaledInstance(width, heigth, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}
	
	public ImageIcon getIcon() {
		return getIcon(250, 250);
	}


	public boolean isSorteada() {
		return sorteada;
	}

	public void setSorteada(boolean sorteada) {
		this.sorteada = sorteada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
