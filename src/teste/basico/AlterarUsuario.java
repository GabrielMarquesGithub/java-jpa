package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("via_java");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		// buscando user
		Usuario novoUsuario = em.find(Usuario.class, 2L);
		System.out.println(novoUsuario.getNome());
		// alterando objeto retornado
		novoUsuario.setNome("Pablo");
		novoUsuario.setEmail("pablo@gmail.com");

		// realiza alteração em um dado presente no DB
		em.merge(novoUsuario);

		// vale salientar que um objeto dentro de um contexto transicional está em um
		// estado gerencial ou seja alterações sofridas por ele são relacionadas com a
		// entidade que o representa no DB

		// o método detach retira o objeto do estado gerencial evitando as constantes
		// tentativas de sincronização do objeto com sua entidade no DB
		em.detach(novoUsuario);

		em.getTransaction().commit();

		System.out.println(novoUsuario.getNome());
		System.out.println(novoUsuario.getEmail());

		em.close();
		emf.close();
	}
}
