package modelo.umpraum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import modelo.basico.Entidade;

@Entity
@Table(name = "Assentos")
public class Assento implements Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	// fazendo um relacionamento bi direcional
	// mappedBy indica que esse relacionamento já foi mapeado em outra tabela e esse
	// atributo só tem a função de criar um relacionamento bi direcional no ambiente
	// de OO
	@OneToOne(mappedBy = "assento") //
	private Cliente cliente;

	public Assento() {

	}

	public Assento(String name) {
		this.name = name;
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

}
