package Dominio;

import Persistencia.ClienteDAO;


public class GestorLoginCliente {

	public String autenticar(Cliente cliente) throws Exception {
		String tipo=null;
		
			
		ClienteDAO clienteDAO= new ClienteDAO();
		tipo =clienteDAO.autenticar(cliente);

		return tipo;
	}
}
