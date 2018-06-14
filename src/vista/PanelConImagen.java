package vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelConImagen extends JPanel {

	public PanelConImagen() {

	}
	
	@Override
	public void paintComponents(Graphics g) {
		Dimension tam=this.getSize();
		ImageIcon imagen=new ImageIcon(new ImageIcon(getClass().getResource("src/imagenes/pegar.png")).getImage());
		g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
	}
}
