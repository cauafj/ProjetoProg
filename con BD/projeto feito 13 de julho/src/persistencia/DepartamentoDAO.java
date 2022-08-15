package persistencia;

import java.lang.reflect.GenericDeclaration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.core.SqlCommand;

import modelo.Departamento;

public class DepartamentoDAO implements DAO<Departamento> {

    @Override
    public void inserir(Departamento e) {
        String sql = "INSERT INTO departamento (nome) VALUES (?)";
		
		try (var con = FabricaConexoes.getConexao();
		var pstm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, e.getNome());
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
    public List<Departamento> listar(int limit, int offset) {
        var departamentos = new ArrayList<Departamento>();
		
		String sql = "SELECT id, nome FROM departamento LIMIT ? OFFSET ?";
		
		try(var con = FabricaConexoes.getConexao();
			var pstm = con.prepareStatement(sql)) {
			pstm.setInt(1, limit);
			pstm.setInt(2, offset);
			ResultSet resposta = pstm.executeQuery();
			while(resposta.next()) {
				var nome = resposta.getString("nome");
				var id = resposta.getInt("id");
				Departamento e = new Departamento(nome, id);
				departamentos.add(e);
			}
			pstm.close();
			
		} catch (SQLException exp) {
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		return departamentos;
    }

    @Override
    public void alterar(Departamento e) {
		String sql = "UPDATE departamento SET nome = ? WHERE id = ?";

		try(var con = FabricaConexoes.getConexao();
		var pstm = con.prepareStatement(sql)){
			pstm.setString(1, e.getNome());
			pstm.setInt(2, e.getId());
			pstm.execute();
			pstm.close();

		}catch (SQLException exp){
			exp.printStackTrace();
		}
        
    }

    @Override
    public Departamento buscar(int idb) {
        String sql = "SELECT nome, id FROM departamento WHERE id = ?";
		Departamento depto = null;

		try (var con = FabricaConexoes.getConexao();
		var pstm = con.prepareStatement(sql)) {
			pstm.setInt(1, idb);
			ResultSet resposta = pstm.executeQuery();
			resposta.next();

			var nome = resposta.getString("nome");
			int id = resposta.getInt("id");
			
			depto = new Departamento(nome, id);

			pstm.close();

		}catch(SQLException exp) {
			exp.printStackTrace();
		}
        return depto;
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM departamento WHERE id = ?";

		try (var con = FabricaConexoes.getConexao();
		var pstm = con.prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			pstm.close();

		}catch(SQLException exp) {
			exp.printStackTrace();
		}
        
    }
    
}
