package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import modelo.Modelo;
import vista.Buscarcliente;
import vista.VentasPanel;

public class VentasControlador {
	private VentasPanel ventasPanel;

	// private ArticulosMock articulosMock=new ArticulosMock();
	Modelo modelo = new Modelo();

	public VentasControlador(VentasPanel ventasPanel) {
		this.ventasPanel = ventasPanel;
		// String[] consulta = new BibliotecaConsultas().getConsulta("articulo");
		// cargartabla( modelo.mostrarTabla(consulta));
		cargartabla(modelo.mostrarTablaArticulos());
		generarCodigoVenta();

		ventasPanel.getBotonCliente().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Buscarcliente busqueda = new Buscarcliente(modelo.mostrarTablaClientes());
				// Buscarcliente dialogo=new Buscarcliente(modelo.mostrarTabla(new
				// BibliotecaConsultas().getConsulta("cliente")));
				ventasPanel.getTxtCodCliente().setText(busqueda.getCodCliente());
			}
		});
		ventasPanel.getBtnSeleccionar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Vector vector = (Vector) ventasPanel.getModeloArticulos().getDataVector()
						.get(ventasPanel.getTbArticulos().getSelectedRow());
				ventasPanel.addLineaCarritoCompra(vector);
			}
		});
		ventasPanel.getBotonQuitar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = ventasPanel.getTbCarritoCompra().getSelectedRow();
				if(selectedRow>=0) {
					ventasPanel.getModeloCarritoCompra().removeRow(selectedRow);	
				}
				
			}
		});
	}

	private void generarCodigoVenta() {
		ventasPanel.getTxtCodVenta().setText(String.valueOf(modelo.generarCodigoVenta()));
		
		
	}

	private void cargartabla(Object[][] articulos) {
		DefaultTableModel model = (DefaultTableModel) ventasPanel.getTbArticulos().getModel();

		for (int i = 0; i < articulos.length; i++) {
			model.addRow(articulos[i]);
		}

	}

}
