package app;

import controlador.controlAcceso;
import modelo.ListaUsuarios;
import vista.RegistroUsuarios;

public class Principal {
	public static void main(String[] args) {
		new controlAcceso(new RegistroUsuarios(), new ListaUsuarios());
	}
}
