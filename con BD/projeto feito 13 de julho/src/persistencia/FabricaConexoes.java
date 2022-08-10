package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {
	public static Connection getConexao() {
		String login = "postgres";
		String senha = "postgres";
		String urlcon = "jdbc:postgresql://localhost:5432/javaDatabase";
		Connection con = null;
		try {
			con = DriverManager.getConnection(urlcon, login, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
