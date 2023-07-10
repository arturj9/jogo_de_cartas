package controller;

import model.LerCartas;

public class BaralhoJogo extends Baralho {
	
	private static BaralhoJogo baralhoJogo;

	private BaralhoJogo() {
		super(new LerCartas().getCartas());
	}
	
	public static BaralhoJogo getInstacia() {
		if (baralhoJogo == null) {
            setBaralhoJogo(new BaralhoJogo());
        }
        return getBaralhoJogo();
	}

	public static BaralhoJogo getBaralhoJogo() {
		return baralhoJogo;
	}

	public static void setBaralhoJogo(BaralhoJogo baralhoJogo) {
		BaralhoJogo.baralhoJogo = baralhoJogo;
	}

}
