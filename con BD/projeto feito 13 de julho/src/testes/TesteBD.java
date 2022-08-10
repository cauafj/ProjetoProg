package testes;

import java.time.LocalDate;
import java.util.List;

import modelo.Empregado;
import persistencia.DAO;
import persistencia.EmpregadoDAO;

public class TesteBD {

	public static void main(String[] args) {
		System.out.println("ola");
		System.out.println("ola2");
		
		Empregado e = new Empregado("Teste", "teste@gmail.com", LocalDate.of(2000, 12, 3));
		
		DAO pe = new EmpregadoDAO();
		
		pe.inserir(e);
		
		List<Empregado> emps = pe.listar(10, 0);
		for (Empregado emp: emps) {
			System.out.println(emp);
		}
	}

}
