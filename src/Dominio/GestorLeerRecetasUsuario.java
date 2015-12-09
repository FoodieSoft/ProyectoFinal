package Dominio;

import java.sql.SQLException;
import java.util.Vector;

import Persistencia.RecetaDAO;

public class GestorLeerRecetasUsuario {

	public Vector<String> LeerRecetasUsuario(String usuario) throws SQLException, Exception {

		RecetaDAO recetaDAO = new RecetaDAO();
		Vector<String> nombreReceta = recetaDAO.readRecetaUsuario(usuario);
		return nombreReceta;

	}

}
