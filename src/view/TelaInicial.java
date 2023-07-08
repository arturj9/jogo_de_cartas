package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaInicial extends JFrame {
	public TelaInicial() {
		this.setSize(500,500);
		this.setForeground(Color.orange);
		JPanel painelInicial = new JPanel();
		painelInicial.setLayout(new FlowLayout());
		painelInicial.setBackground(Color.GRAY);
		
		JButton jogar = new JButton();
		jogar.setBackground(Color.yellow);
		jogar.setText("Jogar");
		jogar.addActionListener(new telaJogar(this));
		
		JButton relatorio = new JButton();
		relatorio.setBackground(Color.yellow);
		relatorio.setText("Como Jogar");
		relatorio.addActionListener(new telaRelatorio());
		
		painelInicial.add(jogar);
		painelInicial.add(relatorio);
		this.add(painelInicial);
		
		this.setVisible(true);
	}
	private class telaJogar implements ActionListener {
		private JFrame ti;
		private telaJogar(JFrame ti) {
			this.ti = ti;
		}
		public void actionPerformed(ActionEvent e) {
			TelaNomes tn = new TelaNomes();
			ti.dispose();
		}
	}
	private class telaRelatorio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//tela do relatorio
		}
	}
}
