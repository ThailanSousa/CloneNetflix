package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection{

  public static Connection createConnection()   {
		Connection conexao = null;
		try {
			
		
		String url = "jdbc:mysql://localhost:3306/cloneflix?useTimezone=true&serverTimezone=UTC"; //Nome da base de dados
		String user = "root"; //nome do usu�rio do MySQL
		String password = "95399788"; //senha do MySQL

		
		conexao = DriverManager.getConnection(url, user, password);

		
		} catch (SQLException e) {
			System.out.printf("Erro ao conectar ao Banco de Dados %s",e.getMessage());
		}
		finally {
			return conexao;
		}
		  
	}

}
