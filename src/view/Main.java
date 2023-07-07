package view;

import controller.Rodada;
import model.LerCartas;
import model.RodadasDAO;

public class Main {

	public static void main(String[] args) {
		new Janela("Jogo de Cartas");
		//Testando o banco de dados
		RodadasDAO teste = new RodadasDAO();
		teste.inserir(null);
	}

}
