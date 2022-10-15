package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.ItemPedido;

public class ItemPedidoNamedQuery {
	public static void main(String[] args) {
		DAO<ItemPedido> itens = new DAO<>(ItemPedido.class);

		itens.consultas("itemValorMenorQue", "preco", 500.00).forEach(i -> System.out.println(i.getProduto().getNome()));

	}
}
