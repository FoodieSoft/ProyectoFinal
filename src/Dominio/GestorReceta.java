package Dominio;

import java.sql.SQLException;
import java.util.Vector;

public class GestorReceta {

	public Vector<Receta> leerRecetas() throws SQLException, Exception {
		Vector<Receta> recetas = null;
		GestorLeerRecetas gestorLeerRecetas = new GestorLeerRecetas();
		recetas = gestorLeerRecetas.leerRecetas();
		return recetas;
	}
	
	public Vector<Receta> eliminarReceta() throws SQLException, Exception {
		Vector<Receta> recetas = null;
		GestorLeerRecetas gestorLeerRecetas = new GestorLeerRecetas();
		recetas = gestorLeerRecetas.leerRecetas();
		return recetas;
	}

}
