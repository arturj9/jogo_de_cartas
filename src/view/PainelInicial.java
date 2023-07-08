package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PainelInicial extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel tituloJogo;
    private JButton botaoJogar, botaoComoJogar, botaoSair;
    private ImageIcon iconeJogar, iconeSair;
	
	public PainelInicial() {
		
		iconeJogar = new ImageIcon("icons/play.png");
		iconeSair = new ImageIcon("icons/exit.png");
		
		this.setLayout(new GridLayout(9, 1));
		
		this.add(new JPanel());
		
		tituloJogo = new JLabel("Dixit");
		tituloJogo.setHorizontalAlignment(SwingConstants.CENTER);
		tituloJogo.setFont(new Font("Arial", Font.BOLD, 65));
		this.add(tituloJogo);
		
		this.add(new JPanel());
		
		botaoJogar = new JButton("Jogar");
		botaoJogar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoJogar.setIcon(iconeJogar);
		this.add(botaoJogar);
		
		this.add(new JPanel());
		
		botaoComoJogar = new JButton("Como Jogar");
		botaoComoJogar.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(botaoComoJogar);
		
		this.add(new JPanel());
		
		botaoSair = new JButton("Sair");
		botaoSair.setFont(new Font("Arial", Font.BOLD, 15));
		botaoSair.setIcon(iconeSair);
		this.add(botaoSair);
		
		//this.add(new JPanel());
//        // Título
//        titleLabel = new JLabel("Título do Programa");
//        //titleLabel.setLocation(400, 500);
//        //titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 55));
//       // add(titleLabel, BorderLayout.NORTH);
//        this.add(new JPanel());
//        this.add(titleLabel);
//
//        // Painel para os botões
//        JPanel buttonPanel = new JPanel(new FlowLayout());
//
//        // Botão "Jogar"
//        playButton = new JButton("Jogar");
//        buttonPanel.add(playButton);
//
//        // Botão "Como Jogar"
//        howToPlayButton = new JButton("Como Jogar");
//        buttonPanel.add(howToPlayButton);
//
//        // Botão "Sair"
//        exitButton = new JButton("Sair");
//        buttonPanel.add(exitButton);
//
//        //add(buttonPanel, BorderLayout.CENTER);
//        this.add(buttonPanel);
		
		this.setVisible(true);
	}
}
