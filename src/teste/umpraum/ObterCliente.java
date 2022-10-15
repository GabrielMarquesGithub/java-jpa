package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Cliente;

public class ObterCliente {
	public static void main(String[] args) {

		DAO<Cliente> clienteDAO = new DAO<>(Cliente.class);
		System.out.println(clienteDAO.obeterPorId(2L).getName());
	}
}
