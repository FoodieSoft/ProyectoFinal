package Dominio;

import java.util.Vector;
import Comunicacion.UsuarioDAO;

public class GestorLoginUsuario {

	public boolean autenticar(Usuario usuario) throws Exception {
		
		boolean autenticado=false;
			
		UsuarioDAO usuarioDAO= new UsuarioDAO();
		autenticado=usuarioDAO.autenticar(usuario);

		return autenticado;
	}
}
