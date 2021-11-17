package br.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//import br.fiap.leitor.Leitor;

public class Conexao {
	private volatile static Connection connection;
	// construtor privado (n�o permite instancia��o externa)
	private Conexao() {
	}

	// m�todo para conectar e retornar a conex�o
	public static Connection conectar() {
		if (connection == null) {
			synchronized (Conexao.class) {
				if (connection == null) {
					Properties prop = Leitor.getProp();
					String driver = prop.getProperty("driver");
					String url = prop.getProperty("url");
					String user = prop.getProperty("user");
					String password = prop.getProperty("password");					
					try {
						Class.forName(driver);
						connection = DriverManager.getConnection(url, user, password);
					} catch (final ClassNotFoundException | SQLException e) {
						System.out.println(e);
					}
				}
			}
		}

		return connection;
	}
}
