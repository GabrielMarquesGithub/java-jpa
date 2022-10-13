package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Entidade;

//limitando o generic DAO só pode receber um tipo de estende de Entidade
public class DAO<E extends Entidade> {
	// DAO inicializada as classes
	private static EntityManagerFactory emf;
	private EntityManager em;
	// classe necessária
	Class<E> classe;

	// Blocos statics são executados assim que o java carrega a classe
	static {
		try {
			// instanciando o EMF com o persistence-unit
			emf = Persistence.createEntityManagerFactory("via_java");
		} catch (Exception e) {
			System.out.println("Erro no bloco statico - " + e.getMessage());
		}
	}

	DAO() {
		this(null);
	}

	// Recebe uma classe referenciada no DB
	DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}

	// métodos para transações
	// retornando o próprio objeto é possível a realização de chamadas encadeadas
	public DAO<E> abrirT() {
		em.getTransaction().begin();
		return this;
	}

	public DAO<E> fecharT() {
		em.getTransaction().commit();
		return this;
	}

	// métodos de manipulação
	public DAO<E> incluir(E entidade) {
		em.persist(entidade);
		return this;
	}

	public DAO<E> incluirCompleto(E entidade) {
		// exemplo de encadeamento
		return this.abrirT().incluir(entidade).fecharT();
	}

	// sobrecarga de método
	public List<E> obeterTodos() {
		return this.obeterTodos(10, 0);
	}

	public List<E> obeterTodos(int limit, int offset) {
		if (this.classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		// jpql dinâmico
		String jpql = "select u from" + classe.getName() + " u";
		TypedQuery<E> query = em.createQuery(jpql, this.classe);

		// setFirstResult define qual será o primeiro item a ser retornado pulando os
		// anteriores
		return query.setMaxResults(limit).setFirstResult(offset).getResultList();
	}

	public void close() {
		// emf.close(); o EFM sendo estático será utilizado em todas as instâncias
		em.close();
		classe = null;
	}
}
