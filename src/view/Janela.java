package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.BaralhoJogo;
import controller.Carta;

public class Janela extends JFrame {

	public Janela(String titulo) {
		setSize(1200, 700);
		setTitle(titulo);
		setResizable(false);
		setLocation(100, 40);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		configurarPaineis();
		setVisible(true);
	}
	
	public void configurarPaineis() {
		BaralhoJogo b = new BaralhoJogo();
		Carta c = b.getCartas().get(1);
		JPanel j = new JPanel();
		j.setLayout(new GridLayout(2,3));
		add(j, new BorderLayout().CENTER);
		for (int i=0;i<6;i++) {
			JLabel bu = new JLabel();
			bu.setIcon(c.getIcon());
			j.add(bu);
		}
	}

}
