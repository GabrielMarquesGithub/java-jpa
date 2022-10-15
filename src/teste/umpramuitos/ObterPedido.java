package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.Pedido;

public class ObterPedido {
	public static void main(String[] args) {
		DAO<Pedido> pedidoDAO = new DAO<>(Pedido.class);
		
		Pedido pedido = pedidoDAO.obeterPorId(2L);
		
		pedido.getItens().forEach(i -> System.out.println(i.getProduto().getNome()));
	}
}
