
public class Empregado {
	private String nome;
	private String email;
	private int id;

	public Empregado(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	public Empregado(String nome, String email, int id) {
		this(nome, email);
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
}
