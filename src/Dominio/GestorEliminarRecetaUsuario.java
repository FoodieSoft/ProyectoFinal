package Dominio;

import java.sql.SQLException;

import Persistencia.RecetaDAO;

public class GestorEliminarRecetaUsuario {
	public boolean EliminarRecetaUsuario(String email, String nombre) throws SQLException, Exception {
		boolean eliminado = false;
		RecetaDAO recDAO = new RecetaDAO();
		eliminado = recDAO.EliminarRecetaUsuario(email, nombre);
		return eliminado;

	}
}
