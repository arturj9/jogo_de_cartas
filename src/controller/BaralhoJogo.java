package controller;

import model.LerCartas;

public class BaralhoJogo extends Baralho {

	public BaralhoJogo() {
		super(new LerCartas().getCartas());
	}

}
