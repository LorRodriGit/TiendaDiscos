package modelo;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.naming.event.ObjectChangeListener;
import javax.swing.table.DefaultTableModel;

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

	public Object[][] mostrarTablaArticulos() {
		Object resultado[][] = null;
		try {
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery("SELECT count(cod_articulo) FROM ARTICULO");
			resultSet.next();
			int total = resultSet.getInt(1);
			resultado = new Object[total][5];
			int x = 0;
			resultSet = statement.executeQuery("SELECT * FROM ARTICULO");
			while (resultSet.next()) {
				resultado[x][0] = resultSet.getObject("COD_ARTICULO");
				resultado[x][1] = resultSet.getObject("NOMBRE");
				resultado[x][2] = resultSet.getObject("UNIDADES");
				resultado[x][3] = resultSet.getObject("DURACION");
				resultado[x][4] = resultSet.getObject("PRECIO");
				x++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	// Metodo Bueno
	// public Object[][] mostrarTabla(String[] consulta) {
	// int x = 0;
	// Object resultado[][] = null;
	// try {
	// statement = conexion.getConexion().createStatement();
	// resultSet = statement.executeQuery(consulta[0]);
	// resultSet.next();
	// int total = resultSet.getInt(1);
	// System.out.println(total);
	// resultSet = statement.executeQuery(consulta[1]);
	// ResultSetMetaData metaData = resultSet.getMetaData();
	// int columnas = metaData.getColumnCount();
	// resultado = new Object[total][columnas];
	// while (resultSet.next()) {
	// for (int i = 1; i <= columnas; i++) {
	// resultado[x][i-1] = resultSet.getObject(i);
	// }
	// x++;
	// }
	// } catch (SQLException e) {
	// Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, e);
	//
	// }
	//
	// return resultado;
	// }
	//
	public int generarCodigoVenta() {
		int codigo = 0;
		try {
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery("SELECT max(cod_venta) FROM venta");
			resultSet.next();
			codigo = resultSet.getInt(1) + 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codigo;
	}

	public Object[][] mostrarTablaClientes() {
		Object resultado[][] = null;
		try {
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery("SELECT count(cod_clien) FROM cliente");
			// esto se uitiliza para poder hacer otra consulta
			resultSet.next();
			int total = resultSet.getInt(1);
			resultado = new Object[total][3];
			int x = 0;
			resultSet = statement.executeQuery("SELECT * FROM cliente");
			while (resultSet.next()) {
				resultado[x][0] = resultSet.getObject("COD_CLIEN");
				resultado[x][1] = resultSet.getObject("NOMBRE");
				resultado[x][2] = resultSet.getObject("POBLACION");
				x++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	public void relizarModificacionArticulo(int cod_articulo, String nombre, BigDecimal precio, String unidades) {
		String sql = "update ARTICULO " + "set nombre = ?," + "unidades = ?," + "precio= ? " + "where COD_ARTICULO= "
				+ cod_articulo + ";";
		try {
			preparedStatement = conexion.getConexion().prepareStatement(sql);
			// preparedStatement.setInt(1, cod_articulo);
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, unidades);
			preparedStatement.setBigDecimal(3, precio);
			int contador = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void nuevoCliente(int codCliente, String nombre, String poblacion) {
		String st;
		ResultSet executeQuery;
		try {
			statement = conexion.getConexion().createStatement();
			st = "INSERT INTO CLIENTE (COD_CLIEN, NOMBRE, POBLACION)\n" + " VALUES (" + codCliente + ",'" + nombre
					+ "'," + "'" + poblacion + "');";
			executeQuery = statement.executeQuery(st);
		} catch (SQLException e) {
			// pongo esto para evitar la excepcion, ya que la inserccion la reliza bien
			String message = e.getMessage();
			if (!message.contains("INSERT")) {
				e.printStackTrace();
			}
		}
	}

	public void realizarInserccionesVenta(DefaultTableModel modeloCarritoCompra, int codClien, int codventa) {
		int rowCount = modeloCarritoCompra.getRowCount();
		int cod_art;
		String nombre;
		BigDecimal precio;
		// String fechaDiaria=new Fecha().getfecha();
		java.util.Date date1 = new java.util.Date();
		SimpleDateFormat plantilla = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaDiaria = new Date(date1.getTime());
		int cantidad;
		for (int i = 0; i < rowCount; i++) {
			cod_art = (int) modeloCarritoCompra.getValueAt(i, 0);
			nombre = (String) modeloCarritoCompra.getValueAt(i, 1);
			precio = (BigDecimal) modeloCarritoCompra.getValueAt(i, 2);
			cantidad = (int) modeloCarritoCompra.getValueAt(i, 3);
			realizarInserccionVentas(codventa, cod_art, cantidad);
			realizarInserccionVentasCliente(codventa, codClien, precio, fechaDiaria);
			realizarInserccionArticulosVendidos(cod_art, cantidad, nombre);
			actualizarStock(cantidad, cod_art);

		}

	}

	private void actualizarStock(int cantidad, int cod_art) {
		String sql = "update ARTICULO SET unidades= -" + cantidad + "WHERE COD_ARTICULO = " + cod_art + ";";
		try {
			preparedStatement = conexion.getConexion().prepareStatement(sql);
			preparedStatement.setInt(1, cantidad);
			int contador = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void realizarInserccionArticulosVendidos(int cod_art, int cantidad, String nombre) {
		if (!actualizable(cod_art, cantidad)) {
			String query = "INSERT INTO ARTICULOS_VENDIDOS (COD_ARTICULO, UNIDADES, NOMBRE)VALUES (?,?,?)";
			try {
				preparedStatement = conexion.getConexion().prepareStatement(query);
				preparedStatement.setInt(1, cod_art);
				preparedStatement.setInt(2, cantidad);
				preparedStatement.setString(3, nombre);
				int contador = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private boolean actualizable(int cod_art, int cantidad) {
		Object resultado[][] = null;
		boolean retorno=false;
		try {
			statement = conexion.getConexion().createStatement();
			resultSet = statement.executeQuery("SELECT count(COD_ARTICULO) FROM ARTICULOS_VENDIDOS ");
			resultSet.next();
			int total = resultSet.getInt(1);
			resultado = new Object[total][3];
			resultSet = statement.executeQuery("SELECT * FROM ARTICULOS_VENDIDOS");
			int x=0;
			while (resultSet.next()) {
				resultado[x][0]=resultSet.getObject("COD_ARTICULO");
				resultado[x][1]=resultSet.getObject("UNIDADES");
				resultado[x][2]=resultSet.getObject("NOMBRE");
				x++;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		for (int i = 0; i < resultado.length; i++) {
			if (resultado[i][0].equals(cod_art)) {
				actualizarArticulosVentas(cod_art,cantidad);
				retorno=true;
			}
		}

		return retorno;
	}

	private void actualizarArticulosVentas(int cod_art, int cantidad) {
		String sql = "update ARTICULOS_VENDIDOS SET unidades= +" + cantidad + "WHERE COD_ARTICULO = " + cod_art + ";";	
		try {
			preparedStatement=conexion.getConexion().prepareStatement(sql);
			preparedStatement.setInt(1, cantidad);
			int contador = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void realizarInserccionVentasCliente(int codventa, int codClien, BigDecimal precio, Date fechaDiaria) {
		String query = "INSERT INTO VENTAS_CLIEN (COD_VENTA, COD_CLIEN, IMPORTE, FECHA) VALUES (?,?,?,?)";

		try {
			preparedStatement = conexion.getConexion().prepareStatement(query);
			preparedStatement.setInt(1, codventa);
			preparedStatement.setInt(2, codClien);
			preparedStatement.setBigDecimal(3, precio);
			preparedStatement.setDate(4, fechaDiaria);
			int contador = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void realizarInserccionVentas(int codventa, int cod_art, int cantidad) {
		String query = "INSERT INTO VENTA (COD_VENTA, COD_ARTICULO, CANTIDAD)VALUES (?,?,?)";
		try {
			preparedStatement = conexion.getConexion().prepareStatement(query);
			preparedStatement.setInt(1, codventa);
			preparedStatement.setInt(2, cod_art);
			preparedStatement.setInt(3, cantidad);
			int contador = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
