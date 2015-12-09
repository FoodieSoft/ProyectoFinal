package Dominio;

import Persistencia.RecetaDAO;

public class GestorLeerReceta {

	public Receta leerReceta(String nombreReceta) throws Exception {
		Receta receta = null;
		RecetaDAO recetaDAO = new RecetaDAO();
		receta = recetaDAO.leerReceta(nombreReceta);
		return receta;
	}

}
