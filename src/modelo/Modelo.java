package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Modelo {
	private Conexion conexion=new Conexion();;
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
	
	
//	public Object[][] mostrarTabla(){
//		int x=0;
//		Object resultado[][];
//		resultado=new Object[40][5];
//		try {
//			
//			statement=conexion.getConexion().createStatement();
//			resultSet=statement.executeQuery("SELECT * FROM ARTICULO");
//			while (resultSet.next()) {
//				resultado[x][0]=resultSet.getObject("COD_ARTICULO");
//				resultado[x][1]=resultSet.getObject("NOMBRE");
//				resultado[x][2]=resultSet.getObject("UNIDADES");
//				resultado[x][3]=resultSet.getObject("DURACION");
//				resultado[x][4]=resultSet.getObject("PRECIO");
//				x++;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return  resultado;
//	}
	public Object[][] mostrarTabla(String [] consulta){
		int x=0;
		Object resultado[][] = null;
		try {
			statement=conexion.getConexion().createStatement();
			resultSet=statement.executeQuery(consulta[0]);
			resultSet.next();
			int total=resultSet.getInt(1);
			System.out.println(total);
			
			resultSet= statement.executeQuery(consulta[1]);
			resultado=new Object[total][4];
			while (resultSet.next()) {
				resultado[x][0]=resultSet.getObject("COD_ARTICULO");
				resultado[x][1]=resultSet.getObject("NOMBRE");
				resultado[x][2]=resultSet.getObject("UNIDADES");
				resultado[x][3]=resultSet.getObject("DURACION");
				resultado[x][4]=resultSet.getObject("PRECIO");
				x++;
			}
		} catch (SQLException e) {
			Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, e);

		}
		
		return resultado;
	}

}
