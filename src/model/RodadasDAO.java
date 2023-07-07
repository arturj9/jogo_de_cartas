package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


import controller.Rodada;

public class RodadasDAO {
	public int inserir(Rodada rodada) {
		int resposta = 0;
		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement inserir=
			conexao.prepareStatement("insert into rodadas "
					+ "(JogadorDaVez, CartaEscolhida, FraseDica, EscolhaJogador1, EscolhaJogador2, EscolhaJogador3, EscolhaJogador4, PontuaçãoJogador1, PontuaçãoJogador2, PontuaçãoJogador3, PontuaçãoJogador4)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?)");
			inserir.setInt(1, 1);
			inserir.setString(2, "Teste Banco");
			inserir.setString(3, "Testando123");
			inserir.setString(4, "Teste1");
			inserir.setString(5, "Teste2");
			inserir.setString(6, "Teste3");
			inserir.setString(7, "Teste4");
			inserir.setInt(8, 1);
			inserir.setInt(9, 2);
			inserir.setInt(10, 3);
			inserir.setInt(11, 4);
			/*
			inserir.setInt(1, rodada.getJogadorDaVez().getId());
			inserir.setString(2, rodada.getCartaEscolhida());
			inserir.setString(3, rodada.getFraseDica());
			inserir.setString(4, rodada.getEscolha1());
			inserir.setString(5, rodada.getEscolha2());
			inserir.setString(6, rodada.getEscolha3());
			inserir.setString(7, rodada.getEscolha4());
			inserir.setInt(8, rodada.getPontuacao1());
			inserir.setInt(9, rodada.getPontuacao2());
			inserir.setInt(10, rodada.getPontuacao3());
			inserir.setInt(11, rodada.getPontuacao4());
			*/
			resposta = inserir.executeUpdate();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}
}
