package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
	public static void main(String[] args) {
		DAO<Produto> DAOP1 = new DAO<>(Produto.class);

		Produto p1 = new Produto("Fone", 179.99);

		DAOP1.incluirCompleto(p1);
	}
}
