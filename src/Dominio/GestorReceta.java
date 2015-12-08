package Dominio;

import java.sql.SQLException;
import java.util.Vector;

public class GestorReceta {
private Receta receta;

	public Receta generarReceta(int i,int comensales) throws SQLException,Exception{
		receta=new Receta();
		GestorGenerarReceta gest=new GestorGenerarReceta();
		receta=gest.generarReceta(receta,i,comensales);
		return receta;
		
	}
	public Vector<Receta> leerRecetas() throws SQLException, Exception {
		Vector<Receta> recetas = null;
		GestorLeerRecetas gestorLeerRecetas = new GestorLeerRecetas();
		recetas = gestorLeerRecetas.leerRecetas();
		return recetas;
	}
	
	public boolean eliminarReceta(String nombreReceta) throws SQLException, Exception {
		boolean eliminado=false;
		GestorEliminarReceta gestorElimReceta = new GestorEliminarReceta();
		eliminado = gestorElimReceta.eliminarReceta(nombreReceta);
		return eliminado;
	}
	public Receta GuardarReceta() throws SQLException,Exception{
		
		
		return receta;
	}
	public Receta leerReceta(String nombreReceta) throws Exception {
		Receta receta=null;
		GestorLeerReceta gestorLeerReceta=new GestorLeerReceta();
		receta=gestorLeerReceta.leerReceta(nombreReceta);
		return receta;
	}
	public boolean insertarReceta(Receta receta2) throws Exception {
		boolean insertado=false;
		GestorInsertarReceta gestorInsertarReceta=new GestorInsertarReceta();
		insertado=gestorInsertarReceta.insertarReceta(receta2);
		return insertado;
		
	}
//	public boolean modificarReceta(Receta receta2) {
//		
//	}
	public boolean modificarReceta(Receta receta2) throws Exception {
		boolean insertado=false;
		GestorModificarReceta gestorModificarReceta=new GestorModificarReceta();
		insertado=gestorModificarReceta.insertarReceta(receta2);
		return insertado;
	}
}
