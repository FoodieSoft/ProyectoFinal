package Dominio;

import java.sql.SQLException;

import Persistencia.RecetaDAO;

public class GestorGuardarReceta {

	public boolean añadir(String receta, String nombre) throws SQLException, Exception {
		boolean añadido = false;
		RecetaDAO recetaDao = new RecetaDAO();
		añadido = recetaDao.guardarReceta(receta, nombre);
		return añadido;
	}
}
