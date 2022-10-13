package modelo.basico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Entidade {

	@Id
	// por padrão o @GeneratedValue vai estar com a strategy AUTO
	// o AUTO ira criar uma tabela para armazenar a sequence do hibernate
	// Já com a strategy IDENTITY ira criar um auto-increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;

	private String email;

	public Usuario() {
	}

	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

}