package view;

import java.awt.GridLayout;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.BaralhoJogo;
import controller.Carta;

public class Janela extends JFrame {

	public Janela(String titulo) {
		setSize(1200, 700);
		setTitle(titulo);
		setResizable(false);
		setLocation(100, 40);
		setLayout(new GridLayout(3,3));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		configurarPaineis();
		setVisible(true);
	}
	
	public void configurarPaineis() {
		BaralhoJogo b = new BaralhoJogo();
		for (Carta c : b.getCartas()) {
			JLabel bu = new JLabel();
			bu.setIcon(c.getIcon90());
			add(bu);
		}
	}

}
