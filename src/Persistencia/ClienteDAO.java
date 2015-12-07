package Persistencia;



import Dominio.Cliente;

public class ClienteDAO {

	public ClienteDAO() {
	}

	public String autenticar(Cliente cliente) throws Exception {
		String tipo = null;
		
		String sentencia = "SELECT * FROM foodiesoft.usuario WHERE correo='" + cliente.getcorreo() + "' AND password= '" + cliente.getPassword() + "';";

		cliente = Agente.getAgente().readClient(sentencia);
		
			
		tipo=cliente.getTipo();
		

		return tipo;
	}
}
