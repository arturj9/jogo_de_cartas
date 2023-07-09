package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class TelaNomes extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JFrame Janela;
	private JTextField nomeJog1;
	private JTextField nomeJog2;
	private JTextField nomeJog3;
	private JTextField nomeJog4;
	
	public TelaNomes() {
		Janela = this;
	}
	
	public void iniciar() {
		
		this.setLayout(new BorderLayout());
		this.setTitle("Dixit");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel painelNorte = configurarCor();
		
		JLabel lableAux = new JLabel("Nome Dos Jogadores:");
		lableAux.setFont(new Font("",Font.BOLD,16));
		lableAux.setForeground(Color.WHITE);
		
		painelNorte.add(lableAux);
		this.add(painelNorte,BorderLayout.NORTH);
		
		JPanel painelCentro = configurarPainelCentro();
		
		this.add(painelCentro,BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	private JPanel configurarCor() {
		
		JPanel painelAux = new JPanel() {
			
            private static final long serialVersionUID = 1L;

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                Color cor1 = Color.RED;
                Color cor2 = Color.BLUE;
                int x1 = 0;
                int y1 = 0;
                int x2 = getWidth();
                int y2 = getHeight();

                GradientPaint gradient = new GradientPaint(x1, y1, cor1, x2, y2, cor2);

                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        
        return painelAux;
	}
	
	private JPanel configurarPainelCentro() {
		
		JPanel painelNovo = configurarCor();
		
		JPanel Aux = new JPanel();
		Aux.setOpaque(false);
		
		JButton Botao = new JButton("Começar");
		Botao.setBackground(Color.white);
		Botao.setFont(new Font("",Font.BOLD,16));
		Botao.addActionListener(new acaoComecar());
		
		JLabel jogador1 = new JLabel("Jogador 1: ");
		jogador1.setForeground(Color.white);
		jogador1.setOpaque(false);
		jogador1.setFont(new Font("",Font.BOLD,16));
		JLabel jogador2 = new JLabel("Jogador 2: ");
		jogador2.setForeground(Color.white);
		jogador2.setOpaque(false);
		jogador2.setFont(new Font("",Font.BOLD,16));
		JLabel jogador3 = new JLabel("Jogador 3: ");
		jogador3.setForeground(Color.white);
		jogador3.setOpaque(false);
		jogador3.setFont(new Font("",Font.BOLD,16));
		JLabel jogador4 = new JLabel("Jogador 4: ");
		jogador4.setForeground(Color.white);
		jogador4.setOpaque(false);
		jogador4.setFont(new Font("",Font.BOLD,16));
		
		nomeJog1 = new JTextField();
		
		Font fonte = nomeJog1.getFont();
        float novoTamanho = fonte.getSize() + 10;
        
        nomeJog1.setFont(fonte.deriveFont(novoTamanho));
		nomeJog2 = new JTextField();
		nomeJog2.setFont(fonte.deriveFont(novoTamanho));
		nomeJog3 = new JTextField();
		nomeJog3.setFont(fonte.deriveFont(novoTamanho));
		nomeJog4 = new JTextField();
		nomeJog4.setFont(fonte.deriveFont(novoTamanho));
		
		painelNovo.setLayout(new GridLayout(10,2));
		
		painelNovo.add(Aux);
		painelNovo.add(Aux);
		
		painelNovo.add(jogador1);
		painelNovo.add(nomeJog1);
		
		painelNovo.add(Aux);
		painelNovo.add(Aux);
		
		painelNovo.add(jogador2);
		painelNovo.add(nomeJog2);
		
		painelNovo.add(Aux);
		painelNovo.add(Aux);
		
		painelNovo.add(jogador3);
		painelNovo.add(nomeJog3);
		
		painelNovo.add(Aux);
		painelNovo.add(Aux);
		
		painelNovo.add(jogador4);
		painelNovo.add(nomeJog4);
		
		painelNovo.add(Aux);
		painelNovo.add(Aux);
		
		painelNovo.add(Botao);
		
		return painelNovo;
	}
	
	private class acaoComecar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(nomeJog1.getText().isEmpty() || nomeJog2.getText().isEmpty() || nomeJog3.getText().isEmpty()|| nomeJog4.getText().isEmpty())
				JOptionPane.showMessageDialog(Janela,"Campos Incompletos!!", "Erro!", JOptionPane.ERROR_MESSAGE, null);	
			else {
				try {
					String nomep1 = nomeJog1.getText();
					String nomep2 = nomeJog2.getText();
					String nomep3 = nomeJog3.getText();
					String nomep4 = nomeJog4.getText();
				}catch(Exception E) {
				
				}
				TelaPrincipal tp = new TelaPrincipal();
				Janela.dispose();
			}
		}
			}
			
}
