package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Cartas extends JButton {
	private int id;
	private TelaPrincipal tp;
	public Cartas(int id,TelaPrincipal tp) {
		this.tp = tp;
		this.id = id;
		this.addActionListener(new mandarId(this.id));
	}
	private class mandarId implements ActionListener {
		private int id1;
		mandarId(int id){
			id1 = id;
		}
		public void actionPerformed(ActionEvent e) {
			//tp.EscolherCartaAdivinhar(id1);
		}
	}
}
