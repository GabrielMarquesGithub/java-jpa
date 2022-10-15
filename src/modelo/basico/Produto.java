package modelo.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//como configurado no XML a criação do DDL automaticamente só necessitamos criar a classe
@Entity
@Table(name = "Produtos") // sobrescrevendo o nome padrão gerada a entidade
public class Produto implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false) // editar padrão do DDL gerado para coluna
	private String nome;

	// precision define a quantidade máxima de caracteres numéricos, scale define
	// casas após o ponto
	@Column(precision = 11, scale = 2, nullable = false)
	private Double valor;

	// O jpa obriga a existência de um construtor padrão a classe
	Produto() {

	}

	public Produto(String nome, Double price) {
		this.nome = nome;
		this.valor = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
