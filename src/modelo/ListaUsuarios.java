package modelo;

import java.util.HashMap;

public class ListaUsuarios {
	
	HashMap<Integer, Object> listaUsuarios=new HashMap<>();
	
	
	public ListaUsuarios() {
		aniadirUsuarios();
	}

	private void aniadirUsuarios() {
		Usuarios u1=new Usuarios(111, "Luis", "Administrador");
		Usuarios u2=new Usuarios(112, "Juan", "Ventas");
		Usuarios u3=new Usuarios(113, "Maria", "Ventas");
		listaUsuarios.put(u1.getCodigo(), u1);
		listaUsuarios.put(u2.getCodigo(), u2);
		listaUsuarios.put(u3.getCodigo(), u3);
		
	}

	public HashMap<Integer, Object> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(HashMap<Integer, Object> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
}
