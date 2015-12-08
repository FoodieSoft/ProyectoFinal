package Dominio;

import Persistencia.RecetaDAO;

public class GestorModificarReceta {

	public boolean insertarReceta(Receta receta2) throws Exception {
		boolean insertado=false;
		RecetaDAO recetaDAO = new RecetaDAO();
		insertado = recetaDAO.modificarReceta(receta2);
		return insertado;
	}

}
