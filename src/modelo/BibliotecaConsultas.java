
package modelo;

import java.util.HashMap;

public class BibliotecaConsultas {
	HashMap<String, String[]> consultas;
	
	public BibliotecaConsultas() {
		String  []nombre= {"articulo", "cliente"};
		String[][] query= {{"SELECT count(cod_articulo) FROM ARTICULO", "SELECT * FROM ARTICULO"},
							{"select count(cod_clien) from cliente","select * from cliente"}};
		consultas=new HashMap<>();
		
		for (int i = 0; i < nombre.length; i++) {
			consultas.put(nombre[i], query[i]);
		}
		
	}

	public String [] getConsulta(String nombre) {
		return consultas.get(nombre);
	}
}
