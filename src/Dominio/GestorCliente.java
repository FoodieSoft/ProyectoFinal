package Dominio;

public class GestorCliente {

	public String autenticar(String correo,String contrase�a) throws Exception {
		String tipo=null;
		Cliente cliente=new Cliente(correo,contrase�a);
		
		GestorLoginCliente gestorLoginCliente= new GestorLoginCliente();
		tipo=gestorLoginCliente.autenticar(cliente);
		return tipo;
				
	}
}
