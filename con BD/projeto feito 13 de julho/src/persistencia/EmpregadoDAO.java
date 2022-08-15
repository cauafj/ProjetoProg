package persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.Departamento;
import modelo.Empregado;
//DAO Data Access Object
	
public class EmpregadoDAO implements DAO<Empregado> {
	
	@Override
	public void inserir(Empregado e) {
		String sql = "INSERT INTO empregado (nome, email, datanascimento, iddepartamento) VALUES (?,?,?,?)";

		try (Connection con = FabricaConexoes.getConexao();
		PreparedStatement pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, e.getNome());
			pstm.setString(2, e.getEmail());
			pstm.setObject(3, e.getDataNascimento());
			pstm.setInt(4, e.getDepartamento().getId());
			pstm.executeUpdate();

			ResultSet rs = pstm.getGeneratedKeys();
			rs.next();

			int id = rs.getInt("id");
			e.setId(id);

			pstm.close();
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}

	}

	@Override
	public void excluir(int id) {
		String sql = "DELETE FROM empregado WHERE id = ?";

		try (var con = FabricaConexoes.getConexao();
		var pstm = con.prepareStatement(sql)){
			pstm.setInt(1, id);
			pstm.execute();
			pstm.close();
		}catch (SQLException exp) {
			exp.printStackTrace();
		}
	}

	@Override
	public List<Empregado> listar(int limit, int offset) {
		var empregados = new ArrayList<Empregado>();
		String sql = "SELECT e.id, e.nome, e.email, e.datanascimento, d.id AS iddepto, d.nome AS nomedepto FROM empregado e LEFT JOIN departamento d ON e.iddepartamento = d.id LIMIT ? OFFSET ?";
		
		try(var con = FabricaConexoes.getConexao(); 
			var pstm = con.prepareStatement(sql);) {
			pstm.setInt(1, limit);
			pstm.setInt(2, offset);
			ResultSet resposta = pstm.executeQuery();

			while(resposta.next()) {
				var nome = resposta.getString("nome");
				var email = resposta.getString("email");
				var id = resposta.getInt("id");
				var dataAnivesario = resposta.getObject("datanascimento", LocalDate.class);
				int iddepto = resposta.getInt("iddepto");
				var nomedepto = resposta.getString("nomedepto");
				Empregado e = new Empregado(nome, email, dataAnivesario, new Departamento(nomedepto, iddepto), id);
				empregados.add(e);
			}
			pstm.close();
			
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		return empregados;
	}
	
	@Override
	public void alterar(Empregado e) {
		String sql = "UPDATE empregado SET nome = ?, email = ?, datanascimento = ?, iddepartamento = ? WHERE id = ?";
		
		try (var con = FabricaConexoes.getConexao();
		var pstm = con.prepareStatement(sql)){
			pstm.setString(1, e.getNome());
			pstm.setString(2, e.getEmail());
			pstm.setObject(3, e.getDataNascimento());
			pstm.setInt(4, e.getDepartamento().getId());
			pstm.setInt(5, e.getId());
			pstm.execute();
			pstm.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		}
	}

	@Override
	public Empregado buscar(int idb) {
		String sql = "SELECT e.id, e.nome, e.email, e.datanascimento, d.id AS iddepto, d.nome AS nomedepto FROM empregado e LEFT JOIN departamento d ON e.iddepartamento = d.id WHERE e.id = ?";
		Empregado e = null;

		try(var con = FabricaConexoes.getConexao(); 
			var pstm = con.prepareStatement(sql);) {
			pstm.setInt(1, idb);
			ResultSet resposta = pstm.executeQuery();
			resposta.next();

			var id = resposta.getInt("id");
			var nome = resposta.getString("nome");
			var email = resposta.getString("email");
			var dataAnivesario = resposta.getObject("datanascimento", LocalDate.class);
			var deptoid = resposta.getInt("iddepto");
			var deptonome = resposta.getString("nomedepto");
			e = new Empregado(nome, email, dataAnivesario, new Departamento(deptonome, deptoid), id);

			pstm.close();
			
		} catch (SQLException exp) {
			exp.printStackTrace();
		}
		
		return e;
	}
}
