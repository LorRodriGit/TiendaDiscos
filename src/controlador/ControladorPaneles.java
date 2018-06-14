package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import vista.VentanaPrincipal;

public class ControladorPaneles {
	VentanaPrincipal ventanaPrincipal;

	public ControladorPaneles(VentanaPrincipal ventanaPrincipal) {
		super();
		this.ventanaPrincipal = ventanaPrincipal;
		JToolBar barraHerramientas = ventanaPrincipal.getBarraHerramientas();
		Component[] components = barraHerramientas.getComponents();
		for (Component component : components) {
			JButton boton=(JButton) component;
			boton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ventanaPrincipal.getCardLayout().show(ventanaPrincipal.getPanel(),boton.getName());
				}
			});
		}
	}
	
	
}
