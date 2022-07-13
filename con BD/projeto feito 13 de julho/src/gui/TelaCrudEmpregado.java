package gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Empregado;
import persistencia.DAO;
import persistencia.EmpregadoDAO;

public class TelaCrudEmpregado {
	private String[] itensMenu;
	private Scanner leitor;
	private DAO pEmp;
	
	public TelaCrudEmpregado(String...vars) {
		this.itensMenu=vars;
		leitor = new Scanner(System.in);
		pEmp = new EmpregadoDAO();
	}
	public TelaCrudEmpregado() {
		this(	"(0) sair!",
				"(1) cadastrar empregado.",
				"(2) listar empregados."); 
	}
	public void start() {
		int opcao = this.printMenu();
		this.acaoMenu(opcao);
	}
	private int printMenu() {
		System.out.println("Digite a opção desejada:");
		for(String item:this.itensMenu) {
			System.out.println(item);
		}
		int opcao = leitor.nextInt();
		return opcao;
	}
	private void acaoMenu(int opcao) {
		if(opcao==0) {
			System.exit(0);
		} else if(opcao==1) {
			Empregado e = leEmpregado();
			this.pEmp.inserir(e);
			System.out.println("Empregado inserido com sucesso");
		} else if(opcao==2) {
			List<Empregado> emps = pEmp.listar(100, 0);
			this.printaEmps(emps);
		}
		
	}
	private void printaEmps(List<Empregado> emps) {
		System.out.println("----Lista Empregados----");
		for(Empregado e: emps) {
			System.out.println(e);
		}
	}
	private Empregado leEmpregado() {
		leitor.nextLine();
		System.out.println("Digite o nome:");
		var nome = leitor.nextLine();
		System.out.println("Digite o email:");
		var email = leitor.nextLine();
		Empregado e = new Empregado(nome, email);
		return e;
	}
}
