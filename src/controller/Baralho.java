package controller;

import java.util.ArrayList;

public class Baralho {
	private ArrayList<Carta> cartas;

	public Baralho(ArrayList<Carta> cartas) {
		setCartas(cartas);
	}

	public Carta sortearCarta() {
		return cartas.get(0);
	}

	public int quantCartas() {
		return cartas.size();
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

}
