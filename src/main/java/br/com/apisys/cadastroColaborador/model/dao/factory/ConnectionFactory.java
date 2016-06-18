package br.com.apisys.cadastroColaborador.model.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			String url = "jdbc:postgresql://localhost/milinfo";
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","123456");
			
			DriverManager.registerDriver(new org.postgresql.Driver());
			return DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
