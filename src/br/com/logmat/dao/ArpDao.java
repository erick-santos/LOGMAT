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

import br.com.logmat.model.Arp;

public class ArpDao {
	private Connection conexao;

	public ArpDao() {
		conexao = new ConnectionFactory().getConnection();
	}

	public void adicionarArp(Arp p) throws SQLException {
		String sql = "INSERT INTO tbl_ARP (numArp, dataAssinaturaArp, inicioVigenciaArp, fimVigenciaArp, superintendente, representanteFornecedor, fornecedorArp, fornecedorCNPJ, objetoArp, valorARP, numPregao) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {

			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, p.getNumArp());
			comando.setDate(2, Date.valueOf(p.getDataAssinaturaArp()));
			comando.setDate(3, Date.valueOf(p.getInicioVigenciaArp()));
			comando.setDate(4, Date.valueOf(p.getFimVigenciaArp()));
			comando.setString(5, p.getSuperintendente());
			comando.setString(6, p.getRepresentanteFornecedor());

			comando.setString(7, p.getFornecedorArp());
			comando.setString(8, p.getFornecedorCNPJ());
			comando.setString(9, p.getObjetoArp());
			comando.setDouble(10, p.getValorARP());
			comando.setString(11, p.getNumPregaoArp());
			comando.execute();
			comando.close();

			conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Arp> listarProduto() {

		LocalDate dataAtual = LocalDate.now();

		List<Arp> listaArp = new ArrayList<Arp>();
		String sql = "SELECT * FROM tbl_ARP ORDER BY inicioVigenciaArp ASC";
		//String sql = "SELECT * FROM tbl_ARP";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			while (rs.next()) {
				Arp p = new Arp();
				p.setIdArp(rs.getInt("idArp"));
				p.setNumArp(rs.getString("numArp"));
				p.setDataAssinaturaArp(rs.getDate("dataAssinaturaArp").toLocalDate());
				p.setInicioVigenciaArp(rs.getDate("inicioVigenciaArp").toLocalDate());
				p.setFimVigenciaArp(rs.getDate("fimVigenciaArp").toLocalDate());
				p.setSuperintendente(rs.getString("superintendente"));
				p.setRepresentanteFornecedor(rs.getString("representanteFornecedor"));
				p.setValorARP(rs.getDouble("valorARP"));
				
				int periodoAtualFim = (int) ChronoUnit.DAYS.between(dataAtual,
						(rs.getDate("fimVigenciaArp").toLocalDate()));
				p.setPrazoDisponivel(periodoAtualFim + 1);
				
				int periodoInicioFim = (int) ChronoUnit.DAYS.between((rs.getDate("inicioVigenciaArp").toLocalDate()),
						(rs.getDate("fimVigenciaArp").toLocalDate()));
				p.setPrazoPorcentagem(periodoInicioFim);
				
				p.setFornecedorArp(rs.getString("fornecedorArp"));
				p.setFornecedorCNPJ(rs.getString("fornecedorCNPJ"));
				p.setObjetoArp(rs.getString("objetoArp"));
				p.setNumPregaoArp(rs.getString("numPregao"));
				
				listaArp.add(p);
			}
			rs.close();
			comando.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaArp;
	}

	public void excluir(Arp p) {
		String sql = "DELETE FROM tbl_ARP WHERE idArp = ?";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setInt(1, p.getIdArp());
			comando.execute();
			comando.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Arp selecionarProdutoById(Arp p) {
		String sql = "SELECT * FROM tbl_ARP WHERE idArp = ?";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setInt(1, p.getIdArp());
			ResultSet rs = comando.executeQuery();

			rs.next();
			p.setIdArp(rs.getInt("idArp"));
			p.setNumArp(rs.getString("numArp"));
			p.setDataAssinaturaArp(rs.getDate("dataAssinaturaArp").toLocalDate());
			p.setInicioVigenciaArp(rs.getDate("inicioVigenciaArp").toLocalDate());
			p.setFimVigenciaArp(rs.getDate("fimVigenciaArp").toLocalDate());
			p.setSuperintendente(rs.getString("superintendente"));
			p.setRepresentanteFornecedor(rs.getString("representanteFornecedor"));
			p.setValorARP(rs.getDouble("valorARP"));
			

			LocalDate dataAtual = LocalDate.now();
			float periodoAtualFim = (float) ChronoUnit.DAYS.between(dataAtual,
					(rs.getDate("fimVigenciaArp").toLocalDate())) + 1;

			p.setPrazoDisponivel(periodoAtualFim);
			float periodoInicioFim = (float) ChronoUnit.DAYS.between((rs.getDate("inicioVigenciaArp").toLocalDate()),
					(rs.getDate("fimVigenciaArp").toLocalDate()));

			p.setPrazoPorcentagem(100 - (periodoAtualFim / periodoInicioFim) * 100);
			p.setFornecedorArp(rs.getString("fornecedorArp"));
			p.setFornecedorCNPJ(rs.getString("fornecedorCNPJ"));
			p.setObjetoArp(rs.getString("objetoArp"));
			p.setNumPregaoArp(rs.getString("numPregao"));
			
			comando.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;

	}

	public void alterarArp(Arp p) {
		String sql = "UPDATE tbl_ARP SET numArp=?, dataAssinaturaArp=?, inicioVigenciaArp=?, fimVigenciaArp=?, superintendente=?, representanteFornecedor=?, fornecedorArp=?, fornecedorCNPJ=?, objetoArp=?, valorARP=?, numPregao=? WHERE idArp=?";
		try {
			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, p.getNumArp());
			comando.setDate(2, Date.valueOf(p.getDataAssinaturaArp()));
			comando.setDate(3, Date.valueOf(p.getInicioVigenciaArp()));
			comando.setDate(4, Date.valueOf(p.getFimVigenciaArp()));
			comando.setString(5, p.getSuperintendente());
			comando.setString(6, p.getRepresentanteFornecedor());
			comando.setString(7, p.getFornecedorArp());
			comando.setString(8, p.getFornecedorCNPJ());
			comando.setString(9, p.getObjetoArp());
			comando.setDouble(10, p.getValorARP());
			comando.setString(11, p.getNumPregaoArp());

			comando.setInt(12, p.getIdArp());
			comando.execute();

			comando.close();
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Arp> relatorioProduto() {

		List<Arp> relatorioArp = new ArrayList<Arp>();
		// String sql = "SELECT * FROM tbl_produto ORDER BY tipoProduto ASC";
		String sql = "call selecionaProduto()";

		try {
			PreparedStatement comando = conexao.prepareStatement(sql);
			ResultSet rs = comando.executeQuery();
			while (rs.next()) {
				Arp p = new Arp();
				p.setIdArp(rs.getInt("idArp"));
				p.setNumArp(rs.getString("numArp"));
				p.setDataAssinaturaArp(rs.getDate("dataAssinaturaArp").toLocalDate());
				p.setInicioVigenciaArp(rs.getDate("inicioVigenciaArp").toLocalDate());
				p.setFimVigenciaArp(rs.getDate("fimVigenciaArp").toLocalDate());
				p.setSuperintendente(rs.getString("superintendente"));
				p.setRepresentanteFornecedor(rs.getString("representanteFornecedor"));
				p.setValorARP(rs.getDouble("valorARP"));
				relatorioArp.add(p);
			}
			rs.close();
			comando.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return relatorioArp;
	}

}
