package Dominio;

import java.sql.SQLException;

import Persistencia.ClienteDAO;

public class GestorInsercionCliente {
	public boolean registrar(Cliente cliente) throws SQLException,Exception{
		boolean añadido=false;
		ClienteDAO clienteDAO=new ClienteDAO();
		añadido=clienteDAO.registro(cliente);
		return añadido;
	}
}
