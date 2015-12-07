package Persistencia;

import java.sql.SQLException;
import java.util.Vector;

import Dominio.Receta;

public class RecetaDAO {

	public Vector<Receta> readAll() throws SQLException, Exception {
		String sentencia = "SELECT * FROM foodiesoft.receta;";
		Vector<Receta> recetas = Agente.getAgente().leerRecetas(sentencia);

		return recetas;
	}

}
