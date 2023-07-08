package view;

import java.awt.Color;

import javax.swing.JButton;

public class Botao extends JButton {
	private TelaPrincipal tp;
	
	public Botao(TelaPrincipal tp,Color c,String s) {
		this.tp = tp;
		this.setBackground(c);
		this.setText(s);
	}
}
