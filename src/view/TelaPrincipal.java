package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TelaPrincipal extends JFrame {
	private JPanel[] telaCartas;
	private JPanel telaAdivinhar;
	private JPanel ti;
	private int idCarta;
	private ArrayList<Integer> ids;
	private int contRodadas;
	
	public TelaPrincipal() {
//		contRodadas = 0;
//		idCarta = -1;
//		ids = new ArrayList<Integer>();
		
		telaCartas = new JPanel[4];
		this.setSize(700,700);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		telaCartas[0] = new TelaCartas(this);
		telaCartas[1] = new TelaCartas(this);
		telaCartas[2] = new TelaCartas(this);
		telaCartas[3] = new TelaCartas(this);
		
		JPanel cartas = new JPanel();
		cartas.setBorder(new LineBorder(Color.black));
		JPanel cartas1 = new JPanel();
//		cartas1.add(l1);
		this.add(cartas1,BorderLayout.SOUTH);
//		this.add(telaCartas[0],BorderLayout.CENTER);
//		this.add(telaCartas[1],BorderLayout.CENTER);
//		this.add(telaCartas[2],BorderLayout.CENTER);
//		this.add(telaCartas[3],BorderLayout.CENTER);
//		
		visibilidadeCartas(2);
	
//		
		this.setVisible(true);
	}
	public void visibilidadeCartas(int i) {
		for(int j = 0;j<4;j++) {
			if(j == i)
				this.add(telaCartas[j],BorderLayout.CENTER);
		}
	}
//	public void rodarTelaInicial() {
//		
//	}
//
//	public void EscolherCartaAdivinhar(int id) {
//		if(idCarta < 0) {
//			idCarta = id;
//		}else {
//			ids.add(id);
//		}
//			contRodadas++;
//			
//			if(contRodadas>=4)
//			CompararCartas();
//	}
//	
//	public void CompararCartas() {
//		int cartasiguais = 0;
//		for (Integer integer : ids) {
//			if(this.idCarta == integer) {
//				cartasiguais++;
//			}
//		}
//		System.out.println("Foram encontradas: "+cartasiguais+" cartas iguais");
//		ids.removeAll(ids);
//		contRodadas = 0;
//		idCarta = -1;
//	}
}
