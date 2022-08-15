package testes;

import java.time.LocalDate;
import modelo.Departamento;
import modelo.Empregado;
import persistencia.DAO;
import persistencia.DepartamentoDAO;
import persistencia.EmpregadoDAO;

public class TesteBD {

	public static void main(String[] args) {

		DAO pe = new EmpregadoDAO();
		DAO pd = new DepartamentoDAO();

		Departamento rh = new Departamento("rh");
		pd.inserir(rh);

		Empregado e = new Empregado("Teste", "teste@gmail.com", LocalDate.of(2000, 12, 3), rh);
		pe.inserir(e);

		System.out.println(rh.getId());
		System.out.println(e.getId());
		

		
	}

}
