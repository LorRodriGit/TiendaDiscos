package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String db = "/BBDD/TIENDA_DISCOS.FDB";
	String DUBRL = "jdbc:firebirdsql:localhost/3050:" + db;
	String usuario = "SYSDBA";
	String password = "masterkey";
	String dn = "org.firebirdsql.jdbc.FBDriver";
	Connection conexion = null;

	public Conexion() {
		try {
			Class.forName(dn);
			conexion = DriverManager.getConnection(DUBRL, this.usuario, this.password);
			System.out.println("Conectado a la base de datos[ " + this.db + "]");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void desconectar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Desconectado de la base de datos[ " + this.db + "]");

	}

	public Connection getConexion() {
		return conexion;
	}
}