package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class BuscarUsuario {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("via_java");
		EntityManager em = emf.createEntityManager();

		// o método find recebe o tipo que deve retornar e a chave, neste caso um long
		Usuario novoUsuario = em.find(Usuario.class, 1L);

		System.out.println(novoUsuario.getNome());

		em.close();
		emf.close();
	}
}
