package Dominio;

public class GestorCliente {

	public String autenticar(String correo,String contraseņa) throws Exception {
		String tipo=null;
		Cliente cliente=new Cliente(correo,contraseņa);
		
		GestorLoginCliente gestorLoginCliente= new GestorLoginCliente();
		tipo=gestorLoginCliente.autenticar(cliente);
		return tipo;
				
	}
}
