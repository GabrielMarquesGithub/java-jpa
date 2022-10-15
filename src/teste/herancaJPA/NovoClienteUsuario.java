package teste.herancaJPA;

import infra.DAO;
import modelo.herancaJPA.ClienteH;
import modelo.herancaJPA.UsuarioH;

public class NovoClienteUsuario {
	public static void main(String[] args) {
		ClienteH ch1 = new ClienteH(3450.00, "Gabriel");
		UsuarioH uh1 = new UsuarioH("12345678", "Leonardo");

		DAO<Object> dao = new DAO<>(Object.class);
		dao.abrirT().incluir(ch1).incluir(uh1).fecharT().close();
	}
}
