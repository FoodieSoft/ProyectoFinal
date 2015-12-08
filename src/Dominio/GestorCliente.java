package Dominio;

import java.sql.SQLException;

public class GestorCliente {
	
private Cliente cliente;

	public String autenticar(String correo,String contrasenia) throws SQLException,Exception {
		String tipo=null;
		cliente=new Cliente(correo,contrasenia);
		
		GestorLoginCliente gestorLoginCliente= new GestorLoginCliente();
		tipo=gestorLoginCliente.autenticar(cliente);
		return tipo;		
	}
	
	public boolean registro(String correo,String contrasenia) throws SQLException,Exception{
		
		boolean añadido=false;
		cliente=new Cliente(correo,contrasenia);
		GestorInsercionCliente gest=new GestorInsercionCliente();
		añadido=gest.registrar(cliente);
		
		return añadido; 
	}
}
