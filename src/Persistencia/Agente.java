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

	public Object readClient(String SQL, Cliente cliente) throws SQLException, Exception {
		conectar();

		Statement select = mBD.createStatement();
		ResultSet rs = select.executeQuery(SQL);

		while (rs.next()) {
			cliente.setcorreo(rs.getString(1));
			cliente.setPassword(rs.getString(2));
			cliente.setTipo(rs.getString(3));
		}
		select.close();
		desconectar();

		return cliente;
	}

	public Object readRecipe(String SQL, Receta receta, int comensales) throws SQLException, Exception {
		conectar();

		Statement select = mBD.createStatement();
		ResultSet rs = select.executeQuery(SQL);

		while (rs.next()) {
			receta.setNombre(rs.getString(1));
			receta.setCantidad1(comensales * rs.getDouble(3));
			receta.setCantidad2(comensales * rs.getDouble(4));
			receta.setCantidad3(comensales * rs.getDouble(5));
			receta.setCantidad4(comensales * rs.getDouble(6));
			receta.setCantidad5(comensales * rs.getDouble(7));
			receta.setCantidad6(comensales * rs.getDouble(8));
			receta.setIngrediente1(rs.getString(9));
			receta.setIngrediente2(rs.getString(10));
			receta.setIngrediente3(rs.getString(11));
			receta.setIngrediente4(rs.getString(12));
			receta.setIngrediente5(rs.getString(13));
			receta.setIngrediente6(rs.getString(14));
			receta.setDescripcion(rs.getString(15));
		}
		select.close();
		desconectar();
		return receta;
	}

	public Vector<Receta> leerRecetas(String sentencia) throws SQLException, Exception {

		conectar();

		Statement select = mBD.createStatement();
		ResultSet rs = select.executeQuery(sentencia);

		Vector<Receta> recetas = new Vector<Receta>();
		while (rs.next()) {
			Receta receta = new Receta(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5),
					rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getString(9), rs.getString(10),
					rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));
			recetas.add(receta);
		}
		select.close();
		desconectar();

		return recetas;
	}

	public Vector<String> leerRecetasUsuario(String sentencia) throws SQLException, Exception {
		conectar();
		Statement select = mBD.createStatement();
		ResultSet rs = select.executeQuery(sentencia);
		Vector<String> nombreReceta = new Vector<String>();

		while (rs.next()) {
			nombreReceta.add(rs.getString(2));

		}
		select.close();
		desconectar();
		return nombreReceta;
	}

	public Receta leerReceta(String sentencia) throws SQLException, Exception {
		conectar();
		Statement select = mBD.createStatement();
		ResultSet rs = select.executeQuery(sentencia);
		Receta receta = null;
		while (rs.next()) {

			receta = new Receta(rs.getString(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5),
					rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getString(9), rs.getString(10),
					rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));

		}

		return receta;
	}
}