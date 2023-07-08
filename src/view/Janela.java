package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.BaralhoJogo;
import controller.Carta;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;

	public Janela(String titulo) {
		
		this.setTitle(titulo);
		this.setSize(800,800);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.add(new PainelInicial());
		//configurarPaineis();
		
		setVisible(true);
	}
	
	public void configurarPaineis() {
		BaralhoJogo b = new BaralhoJogo();
		Carta c = b.getCartas().get(1);
		JPanel j = new JPanel();
		j.setLayout(new GridLayout(2,3));
		this.add(j, BorderLayout.CENTER);
		for (int i=0;i<6;i++) {
			JLabel bu = new JLabel();
			bu.setIcon(c.getIcon());
			j.add(bu);
		}
	}

}
