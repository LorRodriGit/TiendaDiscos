package modelo;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo {
	private Conexion conexion = new Conexion();;
	private Statement statement;
	private ResultSet resultSet;
	PreparedStatement preparedStatement;

	public String selectArticulos() {
		String rString = "COD_ARTICULO | NOMBRE | UNIDADES | DURACION | PRECIO";
		try {
			conexion = new Conexion();
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery("SELECT * FROM ARTICULO ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	 public Object[][] mostrarTablaArticulos(){
	 Object resultado[][] = null;
	 try {
	 statement=conexion.getConexion().createStatement();
	 resultSet=statement.executeQuery("SELECT count(cod_articulo) FROM ARTICULO");
	 resultSet.next();
	 int total=resultSet.getInt(1);
	 resultado=new Object[total][5];
	 int x=0;
	 resultSet=statement.executeQuery("SELECT * FROM ARTICULO");
	 while (resultSet.next()) {
	 resultado[x][0]=resultSet.getObject("COD_ARTICULO");
	 resultado[x][1]=resultSet.getObject("NOMBRE");
	 resultado[x][2]=resultSet.getObject("UNIDADES");
	 resultado[x][3]=resultSet.getObject("DURACION");
	 resultado[x][4]=resultSet.getObject("PRECIO");
	 x++;
	 }
	 } catch (SQLException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 return resultado;
	 }
	 
	 //Metodo Bueno
//	public Object[][] mostrarTabla(String[] consulta) {
//		int x = 0;
//		Object resultado[][] = null;
//		try {
//			statement = conexion.getConexion().createStatement();
//			resultSet = statement.executeQuery(consulta[0]);
//			resultSet.next();
//			int total = resultSet.getInt(1);
//			System.out.println(total);
//			resultSet = statement.executeQuery(consulta[1]);
//			ResultSetMetaData metaData = resultSet.getMetaData();
//			int columnas = metaData.getColumnCount();
//			resultado = new Object[total][columnas];
//			while (resultSet.next()) {
//				for (int i = 1; i <= columnas; i++) {
//					resultado[x][i-1] = resultSet.getObject(i);
//				}
//				x++;
//			}
//		} catch (SQLException e) {
//			Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, e);
//
//		}
//
//		return resultado;
//	}
//
		public int generarCodigoVenta() {
			int codigo=0;
			try {
				statement=conexion.getConexion().createStatement();
				 resultSet=statement.executeQuery("SELECT max(cod_venta) FROM venta");
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return codigo ;
		}

	 public Object[][] mostrarTablaClientes() {
		 Object resultado[][] = null;
		 try {
		 statement=conexion.getConexion().createStatement();
		 resultSet=statement.executeQuery("SELECT count(cod_clien) FROM cliente");
		 //esto se uitiliza para poder hacer otra consulta
		 resultSet.next();
		 int total=resultSet.getInt(1);
		 resultado=new Object[total][3];
		 int x=0;
		 resultSet=statement.executeQuery("SELECT * FROM cliente");
		 while (resultSet.next()) {
		 resultado[x][0]=resultSet.getObject("COD_CLIEN");
		 resultado[x][1]=resultSet.getObject("NOMBRE");
		 resultado[x][2]=resultSet.getObject("POBLACION");
		 x++;
		 }
		 } catch (SQLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 return resultado;
		 }

	public void relizarModificacionArticulo(int cod_articulo, String nombre, BigDecimal precio, String unidades) {
		String sql="update ARTICULO "+
				"set nombre = ?,"+
				"unidades = ?,"+
				"precio= ? "+
				"where COD_ARTICULO= "+cod_articulo+";";
		try {
			preparedStatement=conexion.getConexion().prepareStatement(sql);
			//preparedStatement.setInt(1, cod_articulo);
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, unidades);
			preparedStatement.setBigDecimal(3, precio);
			int contador=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nuevoCliente(int codCliente,String nombre, String poblacion) {
		String st;
		ResultSet executeQuery;
		try {
			statement=conexion.getConexion().createStatement();
			st="INSERT INTO CLIENTE (COD_CLIEN, NOMBRE, POBLACION)\n" + 
					" VALUES ("+codCliente +",'"+nombre+"'," + "'"+poblacion+"');";
			 executeQuery = statement.executeQuery(st);
		} catch (SQLException e) {
			//pongo esto para evitar la excepcion, ya que la inserccion la reliza bien
			
			String message = e.getMessage();
			if (!message.contains("INSERT")) {
				e.printStackTrace();
			}
		}
	}


}
