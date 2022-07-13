package persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Empregado;
//DAO Data Access Object

public class EmpregadoDAO implements DAO<Empregado> {
	
	@Override
	public void inserir(Empregado e) {
		// criar a conexao
		Connection con = FabricaConexoes.getConexao();
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

	@Override
	public void excluir(Empregado e) {
		// criar conexao
		// montar o SQL
		// rodar o SQL
	}

	@Override
	public List<Empregado> listar(int limit, int offset) {
		var empregados = new ArrayList<Empregado>();
		// montar o SQL
		String sql = "SELECT id, nome, email FROM empregado LIMIT ? OFFSET ?";
		
		// rodar o SQL
		try(var con = FabricaConexoes.getConexao(); 
			var pstm = con.prepareStatement(sql);) {
			pstm.setInt(1, limit);
			pstm.setInt(2, offset);
			ResultSet resposta = pstm.executeQuery();
			while(resposta.next()) {
				var nome = resposta.getString("nome");
				var email = resposta.getString("email");
				var id = resposta.getInt("id");
				Empregado e = new Empregado(nome, email, id);
				empregados.add(e);
			}
			pstm.close();
			
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		return empregados;
	}
	
	@Override
	public void Alterar(Empregado e) {
		//TODO: tem q fazer esse!
	}
}
