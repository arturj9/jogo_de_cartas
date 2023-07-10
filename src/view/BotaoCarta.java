package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.Carta;

public class BotaoCarta extends JButton {
	
	private Carta carta;
	
	BotaoCarta(String text, Carta carta, ActionListener evento){
		super(text);
		setIcon(carta.getIcon());
		setCarta(carta);
		addActionListener(evento);
	}

	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}
}
