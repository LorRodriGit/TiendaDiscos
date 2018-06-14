package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modelo {
	private Conexion conexion;
	private Statement statement;
	private ResultSet resultSet;
	
	
	public String selectArticulos() {
		String rString="COD_ARTICULO | NOMBRE | UNIDADES | DURACION | PRECIO";
		try {
			conexion=new Conexion();
			statement=conexion.getConexion().createStatement();
			resultSet=statement.executeQuery("SELECT * FROM ARTICULO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Object[][] mostrarTabla(){
		int x=0;
		Object resultado[][];
		resultado=new Object[10][5];
		try {
			statement=conexion.getConexion().createStatement();
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
		return  resultado;
	}
}
