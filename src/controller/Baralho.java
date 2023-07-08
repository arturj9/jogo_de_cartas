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
		int max = cartas.size();
		Random random = new Random();
		Carta c = cartas.get(random.nextInt((max - min + 1)));
		if (c.isSorteada())
			return sortearCarta();
		return c;
	}

	public int quantCartas() {
		return cartas.size();
	}

	public Baralho getCartas(int quant) {
		ArrayList<Carta> cartas = new ArrayList<Carta>(quant);
		for (int i = 0; i < quant; i++) {
			Carta c = sortearCarta();
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
		int min = 0;
		int max = cartas.size();
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		while(cartas.size()<getCartas().size()) {
			Random random = new Random();
			Carta c = cartas.get(random.nextInt((max - min + 1)));
			if(!cartas.contains(c))
				cartas.add(c);
		}
		return new Baralho(cartas);
	}

}
