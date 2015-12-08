package Dominio;

import Persistencia.RecetaDAO;

public class GestorInsertarReceta {

	public boolean insertarReceta(Receta receta2) throws Exception {
		boolean insertado=false;
		RecetaDAO recetaDAO = new RecetaDAO();
		insertado = recetaDAO.insertarReceta(receta2);
		return insertado;
	}

}
