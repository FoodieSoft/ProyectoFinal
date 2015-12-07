package Dominio;

public class GestorCliente {

	public String autenticar(String correo,String contraseña) throws Exception {
		String tipo=null;
		Cliente cliente=new Cliente(correo,contraseña);
		
		GestorLoginCliente gestorLoginCliente= new GestorLoginCliente();
		tipo=gestorLoginCliente.autenticar(cliente);
		return tipo;
				
	}
}
