package br.com.logmat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.logmat.model.Usuario;

public class UsuarioDao {
	private Connection conexao;

	public UsuarioDao() {
		conexao = new ConnectionFactory().getConnection();
	}

	public Usuario logar(String email, String senha) {
		String sql = "SELECT * FROM tbl_usuario WHERE email = ? AND senha = ?";
		Usuario u = new Usuario();
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, email);
			comando.setString(2, senha);
			ResultSet rs = comando.executeQuery();
			while(rs.next()){
				u.setCod(rs.getInt("cod"));
				u.setNome(rs.getString("nome"));
				u.setCpf(rs.getString("cpf"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				u.setEndereco(rs.getString("endereco"));
				u.setNumero(rs.getString("numero"));
				u.setComplemento(rs.getString("complemento"));
				u.setCidade(rs.getString("cidade"));
				u.setEstado(rs.getString("estado"));
				u.setCep(rs.getString("cep"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public void adicionarUsuario(Usuario u) throws SQLException {
		String sql = "INSERT INTO tbl_usuario (nome, cpf, email, senha, endereco, numero, complemento, cidade, estado, cep) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {

			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, u.getNome());
			comando.setString(2, u.getCpf());
			comando.setString(3, u.getEmail());
			comando.setString(4, u.getSenha());
			comando.setString(5, u.getEndereco());
			comando.setString(6, u.getNumero());
			comando.setString(7, u.getComplemento());
			comando.setString(8, u.getCidade());
			comando.setString(9, u.getEstado());
			comando.setString(10, u.getCep());
			comando.execute();
			comando.close();
			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> listarUsuario() {

		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		String sql = "SELECT * FROM tbl_usuario";

		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setCod(rs.getInt("cod"));
				u.setNome(rs.getString("nome"));
				u.setCpf(rs.getString("cpf"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				u.setEndereco(rs.getString("endereco"));
				u.setNumero(rs.getString("numero"));
				u.setComplemento(rs.getString("complemento"));
				u.setCidade(rs.getString("cidade"));
				u.setEstado(rs.getString("estado"));
				u.setCep(rs.getString("cep"));
				listaUsuario.add(u);
			}
			rs.close();
			comando.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaUsuario;
	}

	public void excluir(Usuario u) {
		String sql = "DELETE FROM tbl_usuario WHERE cod = ?";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setInt(1, u.getCod());
			comando.execute();
			comando.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario selecionarUsuarioById(Usuario u) {
		String sql = "SELECT * tbl_usuario WHERE cod = ?";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setInt(1, u.getCod());
			ResultSet rs = comando.executeQuery();

			rs.next();
			u.setCod(rs.getInt("cod"));
			u.setNome(rs.getString("nome"));
			u.setCpf(rs.getString("cpf"));
			u.setEmail(rs.getString("email"));
			u.setSenha(rs.getString("senha"));
			u.setEndereco(rs.getString("endereco"));
			u.setNumero(rs.getString("numero"));
			u.setComplemento(rs.getString("complemento"));
			u.setCidade(rs.getString("cidade"));
			u.setEstado(rs.getString("estado"));
			u.setCep(rs.getString("cep"));

			comando.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;

	}

	public void alterarUsuario(Usuario u) {
		String sql = "UPDATE tbl_usuario set nome=?, cpf=?, email=?, senha=?, endereco=?, numero=?, complemento=? WHERE cod=?";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, u.getNome());
			comando.setString(2, u.getCpf());
			comando.setString(3, u.getEmail());
			comando.setString(4, u.getSenha());
			comando.setString(5, u.getEndereco());
			comando.setString(6, u.getNumero());
			comando.setString(7, u.getComplemento());
			comando.setString(8, u.getCidade());
			comando.setString(9, u.getEstado());
			comando.setString(10, u.getCep());
			
			comando.execute();
			comando.close();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
