package controller;

import java.util.ArrayList;
import java.util.Random;

public class Baralho {
	private ArrayList<Carta> cartas;

	public Baralho(ArrayList<Carta> cartas) {
		setCartas(cartas);
	}

	public Carta sortearCarta() {
		int min = 0;
		int max = cartas.size() - 1;
		Random random = new Random();
		Carta c = cartas.get(random.nextInt((max - min + 1)));
		if (c.isSorteada())
			return sortearCarta();
		return c;
	}

	public Carta sortearCarta(ArrayList<Carta> cartas) {
		int min = 0;
		int max = this.cartas.size() - 1;
		Random random = new Random();
		Carta c = this.cartas.get(random.nextInt((max - min + 1)));
		if (cartas.contains(c))
			return sortearCarta(cartas);
		return c;
	}

	public int quantCartas() {
		return cartas.size();
	}

	public Baralho getCartas(int quant) {
		ArrayList<Carta> cartas = new ArrayList<Carta>(quant);
		for (int i = 0; i < quant; i++) {
			Carta c = sortearCarta();
			cartas.add(c);
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

	public Baralho getEmbaralhado() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		for (int i = 0; i < this.cartas.size(); i++) {
			Carta c = sortearCarta(cartas);
			cartas.add(c);
		}
		return new Baralho(cartas);
	}

}
