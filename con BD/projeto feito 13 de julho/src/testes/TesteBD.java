package testes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Empregado;
import persistencia.DAO;
import persistencia.EmpregadoDAO;

public class TesteBD {

	public static void main(String[] args) {
		System.out.println("ola");
		System.exit(0);
		System.out.println("ola2");
		
		Empregado e = new Empregado("TEste", "teste@gmail.com");
		
		DAO pe = new EmpregadoDAO();
		
		pe.inserir(e);
		
		
	}

}
