package util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public final class ConnectionSingleton {

	private static ConnectionSingleton instance;
	public Connection conexao = null;

	private ConnectionSingleton() throws SQLException, InterruptedException {

		try {
			String url = "jdbc:mysql://localhost:3306/cloneflix?useTimezone=true&serverTimezone=UTC"; 
			String user = "root"; 
			String password = "95399788"; 

			this.conexao = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static ConnectionSingleton getInstance() throws SQLException, InterruptedException {
		if (instance == null || instance.conexao.isClosed()) {
			instance = new ConnectionSingleton();
		} else {

			System.out.println("REUSO DE CONEXAO");
		}
		return instance;
	}
}
