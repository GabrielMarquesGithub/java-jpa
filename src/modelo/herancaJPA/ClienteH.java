package modelo.herancaJPA;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ClienteH extends PessoaH {
	private Double amountSpent;

	public ClienteH() {
		super();
	}

	public ClienteH(Double amountSpent, String nome) {
		super(nome, new Date());
		this.amountSpent = amountSpent;
	}

	public Double getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(Double amountSpent) {
		this.amountSpent = amountSpent;
	}

}
