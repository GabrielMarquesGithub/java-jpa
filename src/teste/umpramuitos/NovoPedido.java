package teste.umpramuitos;

import infra.DAO;
import modelo.basico.Produto;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class NovoPedido {
	public static void main(String[] args) {

		Pedido pedido = new Pedido();

		// DAO genérico
		DAO<Object> dao = new DAO<>(Object.class);

		Produto p1 = new Produto("Tv", 1499.99);
		ItemPedido item1 = new ItemPedido(pedido, p1, 2);
		Produto p2 = new Produto("Caixa de som", 465.80);
		ItemPedido item2 = new ItemPedido(pedido, p2, 3);
		Produto p3 = new Produto("Mouse", 138.00);
		ItemPedido item3 = new ItemPedido(pedido, p3, 1);

		// transação
		dao.abrirT().incluir(pedido)
		.incluir(p1).incluir(item1)
		.incluir(p2).incluir(item2)
		.incluir(p3).incluir(item3)
		.fecharT().close();
	}
}
