package Dominio;

import java.sql.SQLException;
import java.util.Vector;

import Persistencia.RecetaDAO;

public class GestorLeerRecetas {

	public Vector<Receta> leerRecetas() throws SQLException, Exception {
		Vector<Receta> recetas = null;
		RecetaDAO recetaDAO = new RecetaDAO();
		recetas = recetaDAO.readAll();
		return recetas;
	}

}
