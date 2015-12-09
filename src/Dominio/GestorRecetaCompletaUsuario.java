package Dominio;

import java.sql.SQLException;

import Persistencia.RecetaDAO;

public class GestorRecetaCompletaUsuario {

	public Receta RecetaCompleta(String nombreReceta) throws SQLException, Exception {
		RecetaDAO recetaDAO = new RecetaDAO();
		Receta receta = recetaDAO.leerReceta(nombreReceta);

		return receta;
	}

}
