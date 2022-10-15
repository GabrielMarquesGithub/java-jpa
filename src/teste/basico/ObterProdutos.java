package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class ObterProdutos {
	public static void main(String[] args) {
		DAO<Produto> DAOP1 = new DAO<>(Produto.class);
		System.out.println(Produto.class.getName());

		DAOP1.obeterTodos(2, 0).forEach(p -> System.out.println(p.getNome()));

	}
}
