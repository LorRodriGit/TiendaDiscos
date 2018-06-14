package vista;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelInicio extends JPanel {

	private PanelArticulos panelArticulos;
	private PanelCarritoCompra panelCarritoCompra;
	
	
	public PanelInicio() {
		panelArticulos=new PanelArticulos();
		panelCarritoCompra=new PanelCarritoCompra();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS ));
		this.add(panelArticulos);
		this.add(panelCarritoCompra);
	}

}
