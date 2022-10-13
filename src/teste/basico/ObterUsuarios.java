package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("via_java");
		EntityManager em = emf.createEntityManager();

		// jpql é o substituto do SQL em JPA
		String jpql = "select u from Usuario u";
		// temos que passar a linha de consulta e o objeto a ser buscado
		// o JPA faz um reflection dentro do Obj.class para entender a sua construção
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		// manipulação da consulta
		query.setMaxResults(2);

		// execução da lista
		List<Usuario> userList = query.getResultList();

		userList.forEach(u -> System.out.println(u.getNome()));

		em.close();
		emf.close();
	}
}
