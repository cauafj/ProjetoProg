package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {
	public static Connection getConexao() {
		String login = "postgres";
		String senha = "postgres";
		String urlcon = "jdbc:postgresql://localhost:5432/testebd";
		Connection con = null;
		try {
			con = DriverManager.getConnection(urlcon, login, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
