package Dominio;

import java.sql.SQLException;

import Persistencia.RecetaDAO;

public class GestorGenerarReceta {

	public Receta generarReceta(Receta receta, int i, int comensales) throws SQLException, Exception {
		RecetaDAO receDao = new RecetaDAO();
		receta = receDao.generar(receta, i, comensales);
		return receta;
	}

}
