package Dominio;

import java.sql.SQLException;

import Persistencia.RecetaDAO;

public class GestorGuardarReceta {

	public boolean a�adir(String receta, String nombre) throws SQLException, Exception {
		boolean a�adido = false;
		RecetaDAO recetaDao = new RecetaDAO();
		a�adido = recetaDao.guardarReceta(receta, nombre);
		return a�adido;
	}
}
