package vista;

import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.VentasControlador;

public class VentasPanel extends JPanel {
	
	private PanelArticulos panelArticulos;
	private PanelCarritoCompra panelCarritoCompra;
	private VentasControlador controlador;
	
	public VentasPanel() {
		this.setVisible(true);
		setBounds(100, 100, 693, 508);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		generarcomponentes();
		controlador=new VentasControlador(this);
		ponerComponentesEnLayout();
		
		
		
	}

	private void ponerComponentesEnLayout() {
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelArticulos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
						.addComponent(panelCarritoCompra, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panelArticulos, GroupLayout.PREFERRED_SIZE, 210, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelCarritoCompra, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(gl_contentPane);
		
	}

	private void generarcomponentes() {
		panelArticulos=new PanelArticulos();
		panelCarritoCompra=new PanelCarritoCompra();
		
	}

	public JTable getTbArticulos() {
		return panelArticulos.getTbArticulos();
	}

	public BotonConImagen getBotonCliente() {
		return panelCarritoCompra.getBotonCliente();
	}

	public JTextField getTxtCodCliente() {
		return panelCarritoCompra.getTxtCodCliente();
	}

	public JButton getBtnSeleccionar() {
		return panelArticulos.getBtnSeleccionar();
	}

	public JTable getTbCarritoCompra() {
		return panelCarritoCompra.getTbCarritoCompra();
	}

	public DefaultTableModel getModeloArticulos() {
		return panelArticulos.getModeloArticulos();
	}

	public DefaultTableModel getModeloCarritoCompra() {
		return panelCarritoCompra.getModeloCarritoCompra();
	}

	public void addLineaCarritoCompra(Vector vector) {
		Vector miVector=new Vector();
		//primero posicion del vector nuevo, segundo valor que queremos poner
		if (!modeloContiene(vector)) {
			miVector.add(0,vector.get(0));
			miVector.add(1,vector.get(1));
			miVector.add(2,vector.get(4));
			miVector.add(3,1);
			getModeloCarritoCompra().addRow(miVector);
		}
	}

	private boolean modeloContiene(Vector vector) {
		boolean retorno=false;
		int rowCount = getModeloCarritoCompra().getRowCount();
		for (int i = 0; i < rowCount; i++) {
			if(vector.get(0).equals(getModeloCarritoCompra().getValueAt(i, 0))){
				getModeloCarritoCompra().setValueAt(((Integer)getModeloCarritoCompra().getValueAt(i, 3))+1, i, 3);	
				retorno =true;
			}
			
		}
		return retorno;
	}

	public BotonConImagen getBotonQuitar() {
		return panelCarritoCompra.getBotonQuitar();
	}

	public JTextField getTxtCodVenta() {
		return panelCarritoCompra.getTxtCodVenta();
	}
}
