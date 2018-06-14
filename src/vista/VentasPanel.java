package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import controlador.VentasControlador;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class VentasPanel extends JPanel {
	
	private PanelArticulos panelArticulos;
	private PanelCarritoCompra panelCarritoCompra;
	private JButton otro;
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
		otro=new JButton("Otro");
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
}
