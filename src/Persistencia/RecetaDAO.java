package Persistencia;

import java.sql.SQLException;
import java.util.Vector;

import Dominio.Receta;

public class RecetaDAO {

	public Receta generar(Receta receta, int i, int comensales) throws SQLException, Exception {
		int tipoReceta = 0;
		String sentencia;
		switch (i) {
		case 1:
			tipoReceta = 1;
			break;
		case 2:
			tipoReceta = 2;
			break;
		case 3:
			tipoReceta = 3;
			break;
		case 4:
			tipoReceta = 4;
			break;
		case 5:
			tipoReceta = 5;
			break;
		}
		sentencia = "SELECT * FROM foodiesoft.receta WHERE tipo=" + tipoReceta + " ORDER BY rand()";
		receta = (Receta) Agente.getAgente().readRecipe(sentencia, receta, comensales);

		return receta;
	}

	public Vector<Receta> readAll() throws SQLException, Exception {
		String sentencia = "SELECT * FROM foodiesoft.receta;";
		Vector<Receta> recetas = Agente.getAgente().leerRecetas(sentencia);

		return recetas;
	}

	public boolean delete(String nombreReceta) throws SQLException, Exception {
		boolean eliminado = false;
		int i;
		String sentencia = "DELETE FROM foodiesoft.receta WHERE nombre='" + nombreReceta + "';";
		i = Agente.getAgente().update(sentencia);
		if (i != 0) {
			eliminado = true;
		}
		return eliminado;
	}

	public Receta leerReceta(String nombreReceta) throws Exception {
		Receta receta = null;
		String sentencia = "SELECT * FROM foodiesoft.receta WHERE nombre='" + nombreReceta + "';";
		receta = Agente.getAgente().leerReceta(sentencia);
		return receta;
	}

	public boolean insertarReceta(Receta receta2) throws Exception {
		boolean insertado = false;
		int i;
		String sentencia = "INSERT INTO foodiesoft.receta(nombre,tipo,cantidadpri,cantidadsec,cantidadthi,cantidadfou,cantidadfiv,cantidadsit,ingredientepri,ingredientesec,ingredientethi,ingredientefou,ingredientefiv,ingredientesit,descripcion)VALUES('"
				+receta2.getNombre()+"',"+receta2.getTipo()+","+receta2.getCantidad1()+","+receta2.getCantidad2()+","+receta2.getCantidad3()+","+receta2.getCantidad4()+","+receta2.getCantidad5()+","+receta2.getCantidad6()+",'"+receta2.getIngrediente1()
				+"','"+receta2.getIngrediente2()+"','"+receta2.getIngrediente3()+"','"+receta2.getIngrediente4()+"','"+receta2.getIngrediente5()+"','"+receta2.getIngrediente6()+"','"+receta2.getDescripcion()+"');";
		i = Agente.getAgente().update(sentencia);
		
		if (i != 0) {
			insertado = true;
		}
		return insertado;
	}
	
	public boolean modificarReceta(Receta receta2) throws Exception {
		boolean modificado = false;
		int i;
		String sentencia = "UPDATE foodiesoft.receta SET cantidadpri="+receta2.getCantidad1()+", cantidadsec="+receta2.getCantidad2()+", cantidadthi="+receta2.getCantidad3()+", cantidadfou="+receta2.getCantidad4()+", cantidadfiv="+receta2.getCantidad5()+", cantidadsit="+receta2.getCantidad6()
		+", ingredientepri='"+receta2.getIngrediente1()+"', ingredientesec='"+receta2.getIngrediente2()+"', ingredientethi='"+receta2.getIngrediente3()+"', ingredientefou='"+receta2.getIngrediente4()+"', ingredientefiv='"+receta2.getIngrediente5()+"', ingredientesit='"+receta2.getIngrediente6()+"', descripcion='"
		+receta2.getDescripcion()+"' WHERE nombre='"+receta2.getNombre()+"' AND tipo="+receta2.getTipo()+";";
		System.out.println(sentencia);
		i = Agente.getAgente().update(sentencia);
		
		if (i != 0) {
			modificado = true;
		}
		return modificado;
	}
	

}
