package Dominio;

import java.sql.SQLException;

import Persistencia.ClienteDAO;

public class GestorInsercionCliente {
	public boolean registrar(Cliente cliente) throws SQLException,Exception{
		boolean a�adido=false;
		ClienteDAO clienteDAO=new ClienteDAO();
		a�adido=clienteDAO.registro(cliente);
		return a�adido;
	}
}
