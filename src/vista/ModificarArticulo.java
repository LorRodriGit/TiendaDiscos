package vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ModificarArticulo extends JPanel {
	private JTextField txfNombre, txfUnidades, txfPrecio;
	private JLabel lblArticulo, lblNombre, lblPrecio, lblUnidades;
	private JComboBox comboBox;
	private JButton btnSalir, btnConfirmar;

	/**
	 * Create the panel.
	 */
	public ModificarArticulo() {
		crearComponentes();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(42).addComponent(btnSalir)
						.addPreferredGap(ComponentPlacement.RELATED, 220, Short.MAX_VALUE).addComponent(btnConfirmar)
						.addGap(46))
				.addGroup(groupLayout.createSequentialGroup().addGap(57)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblArticulo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblPrecio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblUnidades))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(60)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(252, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup().addGap(131)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(txfNombre, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txfPrecio, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txfUnidades, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(123)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(36)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblArticulo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre)
								.addComponent(txfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblPrecio)
								.addComponent(txfPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblUnidades)
								.addComponent(txfUnidades, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnSalir)
								.addComponent(btnConfirmar))
						.addGap(21)));
		setLayout(groupLayout);

	}

	private void crearComponentes() {
		lblArticulo = new JLabel("Articulo: ");
		comboBox = new JComboBox();
		lblNombre = new JLabel("Nombre");
		lblPrecio = new JLabel("Precio");
		lblUnidades = new JLabel("Unidades");
		txfNombre = new JTextField();
		txfNombre.setColumns(10);
		txfPrecio = new JTextField();
		txfPrecio.setColumns(10);
		txfUnidades = new JTextField();
		txfUnidades.setColumns(10);
		btnSalir = new JButton("Salir");
		btnConfirmar = new JButton("Confirmar");
	}
}
