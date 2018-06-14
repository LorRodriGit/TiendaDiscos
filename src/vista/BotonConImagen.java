package vista;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonConImagen extends JButton{
	
	private String nombreBoton;
	private String pathImagen;

	
	public BotonConImagen( String nombreBoton, String pathImagen , boolean velado) {
		super();
		this.pathImagen = pathImagen;
		this.setText(nombreBoton);
		this.setIcon(this.getImageIcon());
		this.setEnabled(velado);
	}


	public ImageIcon getImageIcon() {
		ImageIcon imageIcon=new ImageIcon(pathImagen);
		return new ImageIcon(imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	}
	
	
}
