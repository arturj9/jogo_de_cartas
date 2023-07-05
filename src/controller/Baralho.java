package controller;

import java.util.ArrayList;
import java.util.Random;

public class Baralho {
	private ArrayList<Carta> cartas;

	public Baralho(ArrayList<Carta> cartas) {
		setCartas(cartas);
	}

	public Carta sortearCarta(int min, int max) {
		Random random = new Random();
		Carta c = cartas.get(random.nextInt((max - min + 1)));
		if (c.isSorteada())
			return sortearCarta(min, max);
		return c;
	}

	public int quantCartas() {
		return cartas.size();
	}

	public Baralho getCartas(int quant) {
		ArrayList<Carta> cartas = new ArrayList<Carta>(quant);
		for (int i = 0; i < quant; i++) {
			Carta c = sortearCarta(0, cartas.size());
			c.setSorteada(true);
		}
		return new Baralho(cartas);
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

}
