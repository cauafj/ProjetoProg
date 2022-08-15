package modelo;

import java.time.LocalDate;

public class Empregado {
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private int id;
	private Departamento departamento;

	
	public Empregado(String nome, String email, LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	public Empregado(String nome, String email, LocalDate dataNascimento, int id) {
		this(nome, email, dataNascimento);
		this.id = id;
	}
	public Empregado(String nome, String email, LocalDate dataNascimento, Departamento depto) {
		this(nome, email, dataNascimento);
		this.departamento = depto;
	}
	public Empregado(String nome, String email, LocalDate dataNascimento, Departamento depto, int id) {
		this(nome, email, dataNascimento, depto);
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		departamento = departamento;
	}

	@Override
	public String toString() {
		return String.format("Id: %d, Nome: %s, Email: %s, Data de nascimento: %02d, %02d, %04d",
			this.id, this.nome, this.email, this.dataNascimento.getDayOfMonth(), this.dataNascimento.getMonthValue(), this.dataNascimento.getYear());
	}

	
	
	
}
