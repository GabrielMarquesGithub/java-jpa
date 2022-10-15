package modelo.umpraum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import modelo.basico.Entidade;

@Entity
@Table(name = "Clientes")
public class Cliente implements Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	// em um relacionamento de um pra um é mais natural se descobrir o assento a
	// partir do cliente
	// cascade realiza um operação em cascata quando um cliente for persistido, o
	// assento a ele atribuído também será
	@OneToOne(cascade = CascadeType.PERSIST) // na entidade será criado um chave relacionando a tabela assento
	@JoinColumn(name = "assento_id", unique = true) // @JoinColumn é usando em atributos referentes a junções
	private Assento assento;

	public Cliente() {

	}

	public Cliente(String name, Assento assento) {
		this.name = name;
		this.assento = assento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

}
