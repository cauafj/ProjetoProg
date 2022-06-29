import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteBD {

	public static void main(String[] args) {
		System.out.println("ola");
		
		Empregado e = new Empregado("TEste", "teste@gmail.com");
		
		PersistEmpregado pe = new PersistEmpregado();
		
		pe.inserir(e);
		
		
	}

}
