package br.com.logmat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		Connection con = null;
		try {
			final String DRIVER = "com.mysql.cj.jdbc.Driver";
			final String URL = "jdbc:mysql://localhost:3306/bd_LOG_MAT?serverTimezone=UTC";
			final String USER = "root";
			final String PASSWORD = "";
			Class.forName(DRIVER);
			System.out.println("Classe carregada");

			con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conectado com o banco de dados");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Classe do driver não encontrada");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao abrir a conexão");
		}
		return con;
	}
}
