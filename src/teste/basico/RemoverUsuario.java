package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class RemoverUsuario {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("via_java");
		EntityManager em = emf.createEntityManager();

		// obtendo user
		Usuario usuario = em.find(Usuario.class, 3L);

		// verificando se foi retornado alguma entidade
		if (usuario != null) {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		}

		em.close();
		emf.close();
	}
}
