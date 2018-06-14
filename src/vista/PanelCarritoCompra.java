package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class PanelCarritoCompra extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable tbCarritoCompra;
	private DefaultTableModel modelo;
	private JTextField textField_2;
	private BotonConImagen botonCliente, botonQuitar, btPagar;
	private JLabel lblVenta, lblTotal;
	private String[] columnas = { "COD_ARTICULO", "DESCRIPCION", "UNIDADES", "PRECIO", "FECHA" };
	private JToolBar toolBar;
	private JScrollPane scrollPane;

	public PanelCarritoCompra() {
		crearComponentes();
		ponerComponentesEnLayout();

	}

	private void ponerComponentesEnLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(toolBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblVenta, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(botonQuitar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(botonCliente, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btPagar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(8)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblVenta, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(botonCliente, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(botonQuitar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotal)
						.addComponent(btPagar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	private void crearComponentes() {
		lblVenta = new JLabel("VENTA");
		lblVenta.setBackground(Color.GRAY);
		lblVenta.setFont(new Font("Wide Latin", Font.BOLD, 14));
		toolBar = new JToolBar();
		botonCliente = new BotonConImagen("", "src/imagenes/cliente.png");
		botonQuitar = new BotonConImagen("", "src/imagenes/quitar.png");

		scrollPane = new JScrollPane();

		lblTotal = new JLabel("Total:");
		lblTotal.setToolTipText("");

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		btPagar = new BotonConImagen("Pagar", "src/imagenes/Pagar.png");

		tbCarritoCompra = new JTable();
		modelo = new DefaultTableModel(null, columnas);
		tbCarritoCompra.setModel(modelo);
		tbCarritoCompra.getColumnModel().getColumn(0).setPreferredWidth(93);
		scrollPane.setViewportView(tbCarritoCompra);

		JLabel lblCodventa = new JLabel("      Cod_Venta:       ");
		toolBar.add(lblCodventa);
		toolBar.setFloatable(false);

		textField_1 = new JTextField();
		toolBar.add(textField_1);
		textField_1.setColumns(8);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setForeground(Color.WHITE);
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);

		JLabel lblCodcliente = new JLabel("      Cod_cliente:       ");
		toolBar.add(lblCodcliente);

		textField = new JTextField();
		toolBar.add(textField);
		textField.setColumns(8);
	}

}
