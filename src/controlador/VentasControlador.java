package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.Modelo;
import vista.Buscarcliente;
import vista.VentasPanel;

public class VentasControlador {
	private VentasPanel ventasPanel;

	// private ArticulosMock articulosMock=new ArticulosMock();
	Modelo modelo = new Modelo();
	BigDecimal importe;

	public VentasControlador(VentasPanel ventasPanel) {
		this.ventasPanel = ventasPanel;
		// String[] consulta = new BibliotecaConsultas().getConsulta("articulo");
		// cargartabla( modelo.mostrarTabla(consulta));
		// limpiar(modelo.borrarTabla);
		cargartabla(modelo.mostrarTablaArticulos());
		generarCodigoVenta();

		// seleccionar cliente
		ventasPanel.getBotonCliente().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Buscarcliente busqueda = new Buscarcliente(modelo.mostrarTablaClientes());
				// Buscarcliente dialogo=new Buscarcliente(modelo.mostrarTabla(new
				// BibliotecaConsultas().getConsulta("cliente")));
				ventasPanel.getTxtCodCliente().setText(busqueda.getCodCliente());
			}
		});

		// añadir articulos
		ventasPanel.getBtnSeleccionar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// se crea un vector aux con la tlba articulos y se pasa a la tabla venta la
				// fila seleccionada
				Vector vector = (Vector) ventasPanel.getModeloArticulos().getDataVector()
						.get(ventasPanel.getTbArticulos().getSelectedRow());
				aniadirLineaCarritoCompra(vector);

				ventasPanel.getTxTotal().setText(String.valueOf(importe = calcularImporte()));
			}
		});

		// Eliminaar Articulo
		ventasPanel.getBotonQuitar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int selectedRow = ventasPanel.getTbCarritoCompra().getSelectedRow();
				if (selectedRow >= 0) {
					ventasPanel.getModeloCarritoCompra().removeRow(selectedRow);
				}
				ventasPanel.getTxTotal().setText(String.valueOf(importe = calcularImporte()));
			}
		});

		// Realizar gestion de cobro
		ventasPanel.getBtPagar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//boolean comprobacion = false;
				// 1º compruebo cod_cliente
				//comprobacion = comprobarCliente(ventasPanel.getTxtCodVenta().getText());
				//2ºrealizar inserccciones en tablas
				if(!comprobarCliente(ventasPanel.getTxtCodCliente().getText())) {
				int codClien=Integer.parseInt(ventasPanel.getTxtCodCliente().getText());
				int coventa=Integer.parseInt( ventasPanel.getTxtCodVenta().getText());
				modelo.realizarInserccionesVenta(ventasPanel.getModeloCarritoCompra(),codClien,coventa);
				}else {
					JOptionPane.showMessageDialog(null, "Seleccion de cliente requerida", "ERROR", 0);
				}
				limpiarCarritoCompra();
				cargartabla(modelo.mostrarTablaArticulos());
				generarCodigoVenta();
				
				
			}
		});
	}

	protected void limpiarCarritoCompra() {
		int rowCount = ventasPanel.getModeloCarritoCompra().getRowCount();
		for (int i = 0; i < rowCount; i++) {
			ventasPanel.getModeloCarritoCompra().removeRow(i);
		}
		
	}

	protected boolean comprobarCliente(String cliente) {
		boolean retorno = false;
		System.out.println(cliente);
		if (cliente.equals("")) {
			retorno = true;
		}
		return retorno;
	}

	protected BigDecimal calcularImporte() {
		BigDecimal importe = null;
		String aux;
		double precio = 0;
		int rowCount = ventasPanel.getModeloCarritoCompra().getRowCount();
		for (int i = 0; i < rowCount; i++) {
			aux = String.valueOf(ventasPanel.getModeloCarritoCompra().getValueAt(i, 2));
			precio += Double.parseDouble(aux)
					* Integer.valueOf(String.valueOf(ventasPanel.getModeloCarritoCompra().getValueAt(i, 3)));

			System.out.println(precio);
			importe = BigDecimal.valueOf(precio);

		}

		return importe;
	}

	protected void aniadirLineaCarritoCompra(Vector vector) {
		Vector miVector = new Vector();
		// primero posicion del vector nuevo, segundo valor que queremos poner
		// comprueba si la tabla contiene el codigo del articulo y suma uno, si no
		// añade una fila nueva y pone uno en cantidad

		if (!modeloContiene(vector)) {
			miVector.add(0, vector.get(0));
			miVector.add(1, vector.get(1));
			miVector.add(2, vector.get(4));
			miVector.add(3, 1);// añade uno a las unidades
			ventasPanel.getModeloCarritoCompra().addRow(miVector);

		}

	}

	private boolean modeloContiene(Vector vector) {
		boolean retorno = false;
		int rowCount = ventasPanel.getModeloCarritoCompra().getRowCount();
		for (int i = 0; i < rowCount; i++) {
			if (vector.get(0).equals(ventasPanel.getModeloCarritoCompra().getValueAt(i, 0))
					&& ((int) vector.get(2)) == ((int) ventasPanel.getModeloCarritoCompra().getValueAt(i, 3))) {
				JOptionPane.showMessageDialog(null, "No se pudo añadir el articulo stock insuficiente", "ERROR", 0);
				retorno = true;
			} else if (vector.get(0).equals(ventasPanel.getModeloCarritoCompra().getValueAt(i, 0)) && !retorno) {
				ventasPanel.getModeloCarritoCompra()
						.setValueAt(((Integer) ventasPanel.getModeloCarritoCompra().getValueAt(i, 3)) + 1, i, 3);
				retorno = true;
			}

		}

		return retorno;
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
