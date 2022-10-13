package teste.basico;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("via_java");
		EntityManager em = emf.createEntityManager();

		Scanner key = new Scanner(System.in);
		System.out.print("Pessoa a ser adicionada: ");
		String name = key.nextLine();

		Usuario novoUsuario = new Usuario(name, name.toLowerCase() + "@gmail.com.br");

		// sempre em uma inserção é a transação
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();

		// O valor do ID previamente inexistente é adicionado ao ser gerado
		System.out.println("O ID do user criado foi: " + novoUsuario.getId());

		key.close();
		em.close();
		emf.close();
	}
}