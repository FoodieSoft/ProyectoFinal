package Dominio;

import java.sql.SQLException;

import Persistencia.RecetaDAO;
//Hay que realizarlo

public class GestorEliminarReceta {
	public boolean eliminarReceta(String nombreReceta) throws SQLException, Exception {
		boolean eliminado = false;
		RecetaDAO recetaDAO = new RecetaDAO();
		eliminado = recetaDAO.delete(nombreReceta);
		return eliminado;
	}
}