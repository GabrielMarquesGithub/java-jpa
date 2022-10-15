package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {
	public static void main(String[] args) {
		Assento assento = new Assento("31H");
		Cliente cliente = new Cliente("Tiago", assento);

		// exemplo de utilização

		// DAO<Assento> assentoDAO = new DAO<>(Assento.class);
		// DAO<Cliente> clienteDAO = new DAO<>(Cliente.class);
		// assentoDAO.incluirCompleto(assento);
		// clienteDAO.incluirCompleto(cliente);

		// criando DAO genérico
		// essa DAO funcionará pois não o utilizaremos para consultas
		// DAO<Object> dao = new DAO<>(Object.class);

		// como cliente recebe um FK de assento a entidade assento deve ser inserida
		// primeiro no DB porém em uma única o hibernate consegue inferir isso e
		// realizar um update em SQL para adicionar a FK posteriormente, porém isso só
		// funciona se ambas as entidades forem adicionadas na mesma transação
		// dao.abrirT().incluir(cliente).incluir(assento).fecharT().close();

		DAO<Cliente> clienteDAO = new DAO<>(Cliente.class);
		clienteDAO.incluirCompleto(cliente);
	}
}
