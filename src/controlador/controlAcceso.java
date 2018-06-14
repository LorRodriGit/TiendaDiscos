package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import modelo.ListaUsuarios;
import vista.AccesoAdmin;
import vista.AccesoVendedor;
import vista.RegistroUsuarios;

public class controlAcceso {
	

	RegistroUsuarios registroUsuarios;
	ListaUsuarios l1;
	HashMap<Integer, Object> lista = new HashMap<>();

	public controlAcceso(RegistroUsuarios registroUsuarios, ListaUsuarios l1) {
		super();
		this.registroUsuarios = registroUsuarios;
		this.l1 = l1;
		registroUsuarios.getBtAceptar().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				comprobarFormulario();
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		registroUsuarios.getBtAceptar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				comprobarFormulario();
				
			}
			});
		

	}

	protected void comprobarFormulario() {
		if (controlAcceso.this.registroUsuarios.getPfContrasenia().getPassword().length == 0
				|| controlAcceso.this.registroUsuarios.getTfUsuario().getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Por favor rellene todos lo campos del formulario.","Error!!!", 0);
		} else {
			char[] clave = controlAcceso.this.registroUsuarios.getPfContrasenia().getPassword();
			String contrasenia = new String(clave);
			String nombreUsuario = controlAcceso.this.registroUsuarios.getTfUsuario().getText();
			comprobarUsuario(nombreUsuario, contrasenia);
		}
	
		
	}

	protected void comprobarUsuario(String nombreUsuario, String contrasenia) {
		lista = l1.getListaUsuarios();
		Usuarios aux;
		boolean encontrado=false;
		Iterator<Entry<Integer, Object>> iterator = this.lista.entrySet().iterator();
		for (Entry<Integer, Object> usuario : lista.entrySet()) {
			String key=String.valueOf(usuario.getKey());
			if (key.equals(contrasenia)) {
				aux = (Usuarios) usuario.getValue();
				if (aux.getNombre().equals(nombreUsuario)) {
					String funcion = aux.getFuncion();
					abrirventanaUsuario(funcion);
					encontrado=true;
				} 

			}
				
		}
		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado.","Error!!!", 0);
		}

	}

	private void abrirventanaUsuario(String funcion) {
		if (funcion.equals("Administrador")) {
			registroUsuarios.dispose();
			new AccesoAdmin();
		} else if (funcion.equals("Ventas")) {
			registroUsuarios.dispose();
			new AccesoVendedor();
		}
	}

	

}
