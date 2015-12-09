package Dominio;

import java.sql.SQLException;
import java.util.Vector;

public class GestorReceta {
	private Receta receta;

	public Receta generarReceta(int i, int comensales) throws SQLException, Exception {
		receta = new Receta();
		GestorGenerarReceta gest = new GestorGenerarReceta();
		receta = gest.generarReceta(receta, i, comensales);
		return receta;

	}

	public Vector<Receta> leerRecetas() throws SQLException, Exception {
		Vector<Receta> recetas = null;
		GestorLeerRecetas gestorLeerRecetas = new GestorLeerRecetas();
		recetas = gestorLeerRecetas.leerRecetas();
		return recetas;
	}

	public boolean eliminarReceta(String nombreReceta) throws SQLException, Exception {
		boolean eliminado = false;
		GestorEliminarReceta gestorElimReceta = new GestorEliminarReceta();
		eliminado = gestorElimReceta.eliminarReceta(nombreReceta);
		return eliminado;
	}

	public boolean eliminarRecetaUsuario(String email, String nombre) throws SQLException, Exception {
		boolean eliminado = false;
		GestorEliminarRecetaUsuario gestorElimReceta = new GestorEliminarRecetaUsuario();
		eliminado = gestorElimReceta.EliminarRecetaUsuario(email, nombre);
		return eliminado;
	}

	public boolean GuardarReceta(String receta, String nombre) throws SQLException, Exception {
		boolean añadido = false;
		GestorGuardarReceta gestorGuardar = new GestorGuardarReceta();
		añadido = gestorGuardar.añadir(receta, nombre);
		return añadido;
	}

	public Vector<String> leerRecetasUsuario(String usuario) throws SQLException, Exception {

		GestorLeerRecetasUsuario gestor = new GestorLeerRecetasUsuario();
		Vector<String> nombreReceta = gestor.LeerRecetasUsuario(usuario);

		return nombreReceta;

	}

	public Receta RecetaCompletaUsuario(String nombreReceta) throws SQLException, Exception {

		GestorRecetaCompletaUsuario gestRec = new GestorRecetaCompletaUsuario();
		receta = gestRec.RecetaCompleta(nombreReceta);

		return receta;
	}

	public boolean modificarReceta(Receta receta2) throws Exception {
		boolean insertado = false;
		GestorModificarReceta gestorModificarReceta = new GestorModificarReceta();
		insertado = gestorModificarReceta.insertarReceta(receta2);
		return insertado;
	}

	public boolean insertarReceta(Receta receta2) throws Exception {
		boolean insertado = false;
		GestorInsertarReceta gestorInsertarReceta = new GestorInsertarReceta();
		insertado = gestorInsertarReceta.insertarReceta(receta2);
		return insertado;

	}

	public Receta leerReceta(String nombreReceta) throws Exception {
		Receta receta = null;
		GestorLeerReceta gestorLeerReceta = new GestorLeerReceta();
		receta = gestorLeerReceta.leerReceta(nombreReceta);
		return receta;
	}
}
