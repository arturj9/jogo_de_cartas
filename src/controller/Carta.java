package controller;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Carta extends ImageIcon {
	private boolean sorteada;

	public Carta(String caminho) {
		super(caminho);
		setSorteada(false);
	}
	
	public ImageIcon getIcon(int width, int heigth) {
		Image resizedImage = getImage().getScaledInstance(width, heigth, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}
	
	public ImageIcon getIcon() {
		return getIcon(200,500);
	}


	public boolean isSorteada() {
		return sorteada;
	}

	public void setSorteada(boolean sorteada) {
		this.sorteada = sorteada;
	}

}
