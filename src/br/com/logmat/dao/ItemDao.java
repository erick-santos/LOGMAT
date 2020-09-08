package br.com.logmat.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import br.com.logmat.model.Item;

public class ItemDao {
	private Connection conexao;

	public ItemDao() {
		conexao = new ConnectionFactory().getConnection();
	}

	public void adicionarItem(Item p) throws SQLException {
		String sql = "INSERT INTO tbl_ITEM (numItem, nomeItem, descricaoItem, marcaItem, unidadeItem, quantidadeItem, valorUnitarioItem, idArp) VALUES (?,?,?,?,?,?,?,?)";
		try {

			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, p.getNumItem());
			comando.setString(2, p.getNomeItem());
			comando.setString(3, p.getDescricaoItem());
			comando.setString(4, p.getMarcaItem());
			comando.setString(5, p.getUnidadeItem());
			comando.setDouble(6, p.getQuantidadeItem());
			comando.setDouble(7, p.getValorUnitarioItem());
			comando.setInt(8, p.getIdArp());

			comando.execute();
			comando.close();

			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Item> listarItem(String idArp) {

		List<Item> listaItem = new ArrayList<Item>();
		String sql = "SELECT * FROM tbl_Item WHERE idArp =" + idArp;

		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				Item p = new Item();
				p.setIdItem(rs.getInt("idItem"));
				p.setIdArp(rs.getInt("idArp"));

				p.setNumItem(rs.getString("numItem"));
				p.setNomeItem(rs.getString("nomeItem"));
				p.setDescricaoItem(rs.getString("descricaoItem"));
				p.setMarcaItem(rs.getString("marcaItem"));
				p.setUnidadeItem(rs.getString("unidadeItem"));

				p.setQuantidadeItem(rs.getDouble("quantidadeItem"));
				p.setValorUnitarioItem(rs.getDouble("valorUnitarioItem"));

				listaItem.add(p);
			}
			rs.close();
			comando.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaItem;
	}

	public void excluir(Item p) {
		String sql = "DELETE FROM tbl_Item WHERE idItem = ?";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setInt(1, p.getIdItem());
			comando.execute();
			comando.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Item selecionarItemById(Item p) {
		String sql = "SELECT * FROM tbl_Item WHERE idItem = ?";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setInt(1, p.getIdItem());
			ResultSet rs = comando.executeQuery();

			rs.next();
			p.setIdArp(rs.getInt("idArp"));
			p.setIdItem(rs.getInt("idItem"));

			p.setNumItem(rs.getString("numItem"));
			p.setNomeItem(rs.getString("nomeItem"));
			p.setDescricaoItem(rs.getString("descricaoItem"));
			p.setMarcaItem(rs.getString("marcaItem"));
			p.setUnidadeItem(rs.getString("unidadeItem"));

			p.setQuantidadeItem(rs.getDouble("quantidadeItem"));
			p.setValorUnitarioItem(rs.getDouble("valorUnitarioItem"));

			comando.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;

	}

	public void alterarItem(Item p) {
		String sql = "UPDATE tbl_Item SET numItem=?, nomeItem=?, descricaoItem=?, marcaItem=?, unidadeItem=?, quantidadeItem=?, valorUnitarioItem=? WHERE idItem=?";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, p.getNumItem());
			comando.setString(2, p.getNomeItem());
			comando.setString(3, p.getDescricaoItem());
			comando.setString(4, p.getMarcaItem());
			comando.setString(5, p.getUnidadeItem());
			comando.setDouble(6, p.getQuantidadeItem());
			comando.setDouble(7, p.getValorUnitarioItem());
			comando.setInt(8, p.getIdItem());
			comando.execute();

			comando.close();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
