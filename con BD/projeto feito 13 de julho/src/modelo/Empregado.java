package modelo;

import java.time.LocalDate;

public class Empregado {
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private int id;

	public Empregado(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	public Empregado(String nome, String email, LocalDate dataNascimento) {
		this(nome, email);
		this.dataNascimento = dataNascimento;
	}
	public Empregado(String nome, String email, int id) {
		this(nome, email);
		this.id = id;
	}
	public Empregado(String nome, String email, LocalDate dataNascimento, int id) {
		this(nome, email, dataNascimento);
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

	@Override
	public String toString() {
		return String.format("(%d) - nome = %s \n\t email = %s \n\t datanascimento = %02d/%02d/%04d",
			this.id, this.nome, this.email, this.dataNascimento.getDayOfMonth(), this.dataNascimento.getMonthValue(), this.dataNascimento.getYear());
	}
	
}
