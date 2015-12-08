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
		
		boolean a�adido=false;
		cliente=new Cliente(correo,contrasenia);
		GestorInsercionCliente gest=new GestorInsercionCliente();
		a�adido=gest.registrar(cliente);
		
		return a�adido; 
	}
}
