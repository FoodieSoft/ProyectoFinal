package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Dominio.Cliente;
import Dominio.Receta;

public class Agente {
	// Instancia del agente
	protected static Agente mInstancia = null;
	// Conexión con la Base de Datos
	protected static Connection mBD;

	// El url de la conexión y la contraseña
	private static String url = "jdbc:mysql://127.0.0.1:3306/?user=root";

	private static String password = "&password=iso2";

	// Driver de la base de datos
	private static String driver = "com.mysql.jdbc.Driver";

	// Constructor

	public Agente() throws Exception {
		conectar();
	}

	// Patron singleton

	public static Agente getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new Agente();
		}
		return mInstancia;
	}

	private static void conectar() throws Exception {
		Class.forName(driver);

		mBD = DriverManager.getConnection(url + password);
	}

	public void desconectar() throws Exception {
		mBD.close();
	}

	public int update(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

	public Cliente readClient(String SQL) throws SQLException, Exception {
		conectar();
		Cliente cliente = null;
		Statement select = mBD.createStatement();
		ResultSet rs = select.executeQuery(SQL);

		while (rs.next()) {
			cliente = new Cliente(rs.getString(1), rs.getString(2));
			cliente.setTipo(rs.getString(3));
		}
		select.close();
		desconectar();

		return cliente;
	}

	public Vector<Receta> leerRecetas(String sentencia) throws SQLException, Exception {

		conectar();

		Statement select = mBD.createStatement();
		ResultSet rs = select.executeQuery(sentencia);

		Vector<Receta> recetas = new Vector<Receta>();
		while (rs.next()) {
			Receta receta = new Receta(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
					rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11),
					rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));
			recetas.add(receta);
		}
		select.close();
		desconectar();

		return recetas;
	}
}
