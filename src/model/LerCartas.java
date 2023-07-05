package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import controller.Carta;


public class LerCartas {
	private ArrayList<Carta> cartas;

	public LerCartas() {
		setCartas(new ArrayList<Carta>());
		lerDados();
	}

	public void lerDados() {
		String diretorioTxt = "dados/nomeCartas.txt";
		String diretorioCartas = "img/";
		FileReader arquivo = null;
		try {
			arquivo = new FileReader(diretorioTxt);
			BufferedReader leitura = new BufferedReader(arquivo);

			while (leitura.ready()) {
				
				cartas.add(new Carta(diretorioCartas+leitura.readLine()));
			}

		} catch (IOException e) {
			setCartas(null);
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		} finally {
			if (arquivo != null) {
				try {
					arquivo.close();
				} catch (IOException d) {
					d.printStackTrace();
				}
			}
		}
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}


}
