import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersistEmpregado {
	public Connection getConexao() {
		String login = "postgres";
		String senha = "postgres";
		String urlcon = "jdbc:postgresql://localhost:5432/Teste1";
		Connection con = null;
		try {
			con = DriverManager.getConnection(urlcon, login, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public void inserir(Empregado e) {
		// criar a conexao
		Connection con = this.getConexao();
		// montar o SQL
		String sql = "INSERT INTO empregado (nome, email) VALUES (?,?)";
		
		// rodar o SQL
		// pegar a resposta do SQL e alterar o id de Empregado
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, e.getNome());
			pstm.setString(2, e.getEmail());
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
	}

	public void excluir(Empregado e) {
		// criar conexao
		// montar o SQL
		// rodar o SQL
	}

	public List<Empregado> listar(int limit, int offset) {
		var empregados = new ArrayList<Empregado>();
		// criar conexao
		// montar o SQL
		// rodar o SQL
		// tratar a resposta linha a linha
		// para cada linha montar um Objeto
		return empregados;
	}

}
