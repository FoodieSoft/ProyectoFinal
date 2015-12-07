package Persistencia;

import java.sql.*;
import java.util.Vector;
import Dominio.*;


public class Agente {
	//Instancia del agente
	protected static Agente mInstancia =null;
	//Conexión con la Base de Datos
	protected static Connection mBD;
	
	//El url de la conexión y la contraseña
	private static String url="jdbc:mysql://127.0.0.1:3306/?user=root";
	
	private static String password="&password=4841";
	
	//Driver de la base de datos
	private static String driver="com.mysql.jdbc.Driver";
	
	//Constructor
	
public Agente() throws Exception{
	conectar();
}

//Patron singleton

public static Agente getAgente() throws Exception{
	if(mInstancia==null){
		mInstancia=new Agente();
	}
	return mInstancia;
	}

private static void conectar() throws Exception{
	Class.forName(driver);
	
	mBD=DriverManager.getConnection(url+password);
	System.out.println("Conexion realizada con éxito");
}

public void desconectar() throws Exception{
	mBD.close();
}

public int update (String SQL) throws SQLException,Exception{
	conectar();
	PreparedStatement stmt=mBD.prepareStatement(SQL);
	int res=stmt.executeUpdate();
	stmt.close();
	desconectar();
	return res;
}

public Cliente readClient (String SQL) throws SQLException,Exception{
	conectar();
	Cliente cliente = null;
	Statement select=mBD.createStatement();
	ResultSet rs=select.executeQuery(SQL);
	
	while(rs.next()){
		cliente=new Cliente(rs.getString(1),rs.getString(2));
		cliente.setTipo(rs.getString(3));	
	}
	select.close();
	desconectar();
	
	return cliente;
}
}
