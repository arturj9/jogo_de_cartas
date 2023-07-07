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
			conexao.prepareStatement("CODIGO SQL");
			inserir.setString(1, rodada.getJogadorDaVez().getNome());
			resposta = inserir.executeUpdate();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resposta;
	}
}
