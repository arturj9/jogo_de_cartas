package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import controller.IDJogador;
import controller.Rodada;

public class RodadasDAO {
	public int inserir(Rodada rodada) {
		int resposta = 0;
		try {
			Connection conexao = new Conexao().getConexao();
			PreparedStatement inserir = conexao.prepareStatement("insert into rodadas "
					+ "(JogadorDaVez, CartaEscolhida, FraseDica, EscolhaJogador1, EscolhaJogador2, EscolhaJogador3, EscolhaJogador4, PontuaçãoJogador1, PontuaçãoJogador2, PontuaçãoJogador3, PontuaçãoJogador4)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?)");

			inserir.setInt(1, rodada.getJogadorDaVez().getId().getId());
			inserir.setString(2, rodada.getJogadaJogadorDaVez().getCarta().getNome());
			inserir.setString(3, rodada.getJogadaJogadorDaVez().getDica());
			
			inserir.setString(4, rodada.getJogadaFinalByJogadorId(IDJogador._1_).getCarta().getNome());
			inserir.setString(5, rodada.getJogadaFinalByJogadorId(IDJogador._2_).getCarta().getNome());
			inserir.setString(6, rodada.getJogadaFinalByJogadorId(IDJogador._3_).getCarta().getNome());
			inserir.setString(7, rodada.getJogadaFinalByJogadorId(IDJogador._4_).getCarta().getNome());
			
			inserir.setInt(8, rodada.getJogadorById(IDJogador._1_).getPontuacao());
			inserir.setInt(9, rodada.getJogadorById(IDJogador._2_).getPontuacao());
			inserir.setInt(10, rodada.getJogadorById(IDJogador._3_).getPontuacao());
			inserir.setInt(11, rodada.getJogadorById(IDJogador._4_).getPontuacao());

			resposta = inserir.executeUpdate();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}
}
