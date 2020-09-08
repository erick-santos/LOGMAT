package br.com.logmat.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.logmat.model.Pregao;

public class PregaoDao {
	private Connection conexao;

	public PregaoDao() {
		conexao = new ConnectionFactory().getConnection();
	}

	public void adicionarPregao(Pregao p) throws SQLException {
		String sql = "INSERT INTO tbl_PREGAO (numPregao, processo, DouPregao, publicacaoDouPregao) VALUES (?,?,?,?)";
		try {

			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, p.getNumPregao());
			comando.setString(2, p.getProcesso());
			comando.setString(3, p.getDouPregao());
			comando.setDate(4, Date.valueOf(p.getPublicacaoDouPregao()));
			
			comando.execute();
			comando.close();

			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Pregao> listarPregao() {

		List<Pregao> listaPregao = new ArrayList<Pregao>();
		String sql = "SELECT * FROM tbl_PREGAO";

		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				Pregao p = new Pregao();
				
				p.setNumPregao(rs.getString("numPregao"));
				p.setProcesso(rs.getString("processo"));
				p.setDouPregao(rs.getString("DouPregao"));
				p.setPublicacaoDouPregao(rs.getDate("publicacaoDouPregao").toLocalDate());
				
				listaPregao.add(p);
			}
			rs.close();
			comando.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaPregao;
	}

	public void excluir(Pregao p) {
		String sql = "DELETE FROM tbl_PREGAO WHERE numPregao = ?";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, p.getNumPregao());
			comando.execute();
			comando.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Pregao selecionarPregaoById(Pregao p) {
		String sql = "SELECT * FROM tbl_PREGAO WHERE numPregao = ?";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, p.getNumPregao());
			ResultSet rs = comando.executeQuery();

			rs.next();
			
			p.setNumPregao(rs.getString("numPregao"));
			p.setProcesso(rs.getString("processo"));
			p.setDouPregao(rs.getString("DouPregao"));
			p.setPublicacaoDouPregao(rs.getDate("publicacaoDouPregao").toLocalDate());
			
			comando.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;

	}

	public void alterarPregao(Pregao p) {
		String sql = "UPDATE tbl_PREGAO SET numPregao=?, processo=?, DouPregao=?, publicacaoDouPregao=? WHERE idPregao=?";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, p.getNumPregao());
			comando.setString(2, p.getProcesso());
			comando.setString(3, p.getDouPregao());
			comando.setDate(4, Date.valueOf(p.getPublicacaoDouPregao()));
			
			comando.execute();

			comando.close();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
