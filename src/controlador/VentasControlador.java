package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import mock.ArticulosMock;
import mock.ClienteMOC;
import modelo.BibliotecaConsultas;
import modelo.Modelo;
import vista.Buscarcliente;
import vista.VentasPanel;

public class VentasControlador {
	private VentasPanel  ventasPanel;
	
	//private ArticulosMock articulosMock=new ArticulosMock();
	Modelo modelo=new Modelo();
	
	public VentasControlador(VentasPanel ventasPanel) {
			this.ventasPanel=ventasPanel;
			String[] consulta = new BibliotecaConsultas().getConsulta("articulo");
			cargartabla( modelo.mostrarTabla(consulta));
			ventasPanel.getBotonCliente().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
						Buscarcliente dialogo=new Buscarcliente(modelo.mostrarTabla(new BibliotecaConsultas().getConsulta("cliente")));
						ventasPanel.getTxtCodCliente().setText(dialogo.getCodCliente());
				}
			});
			ventasPanel.getBtnSeleccionar().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				Vector vector=(Vector) ventasPanel.getModeloArticulos().getDataVector().get(ventasPanel.getTbArticulos().getSelectedRow());
				ventasPanel.getModeloCarritoCompra().addRow(vector);
				}
			});
		}

		private void cargartabla(Object[][] articulos) {
			DefaultTableModel model= (DefaultTableModel) ventasPanel.getTbArticulos().getModel();	

			for (int i = 0; i < articulos.length; i++) {
				model.addRow(articulos[i]);
			}
			
		}
		
}
