package Persistencia;



import java.sql.SQLException;

import Dominio.Cliente;

public class ClienteDAO {

	public ClienteDAO() {
	}

	public String autenticar(Cliente cliente) throws SQLException,Exception {
		String tipo = null;
		String sentencia = "SELECT * FROM foodiesoft.usuario WHERE correo='" + cliente.getcorreo() + "' AND password= '" + cliente.getPassword() + "';";
		cliente = (Cliente) Agente.getAgente().readClient(sentencia,cliente);	
		tipo=cliente.getTipo();
		return tipo;
	}
	public boolean registro (Cliente cliente) throws SQLException,Exception{
		boolean insertado=false;
		int i;
		String sentencia ="INSERT INTO foodiesoft.usuario (correo,password,tipoUsua) VALUES ('"+cliente.getcorreo()+"','"+cliente.getPassword()+"','usuario')";
		i=Agente.getAgente().update(sentencia);
		if(i!=0){
			insertado=true;
		}
		return insertado;
		
	}
}
