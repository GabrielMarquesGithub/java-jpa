package modelo.herancaJPA;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class UsuarioH extends PessoaH {
	private String password;

	public UsuarioH() {
		super();
	}

	public UsuarioH(String password, String nome) {
		super(nome, new Date());
		this.password = password;
	}

	public UsuarioH(String password, String nome, Date dataDeCadastro) {
		super(nome, dataDeCadastro);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
