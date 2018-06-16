package vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controlador.ModificaArticuloControlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarArticuloPanel extends JPanel {
	private JTextField txfNombre, txfUnidades, txfPrecio;
	private JLabel lblArticulo, lblNombre, lblPrecio, lblUnidades;
	private JComboBox comboBox;
	private JButton btnConfirmar;
	private ModificaArticuloControlador modificaArticuloControlador;

	/**
	 * Create the panel.
	 */
	public ModificarArticuloPanel() {
		crearComponentes();
		modificaArticuloControlador=new ModificaArticuloControlador(this);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(57)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblArticulo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNombre)
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblPrecio, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
								.addComponent(lblUnidades))
							.addGap(85)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(txfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txfUnidades, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txfPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(123))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(144)
							.addComponent(btnConfirmar)))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txfPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblArticulo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre))
							.addGap(65)
							.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUnidades)
						.addComponent(txfUnidades, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addComponent(btnConfirmar)
					.addContainerGap(34, Short.MAX_VALUE))
		);
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
		btnConfirmar = new JButton("Confirmar");
	}

	public JTextField getTxfNombre() {
		return txfNombre;
	}

	public JTextField getTxfUnidades() {
		return txfUnidades;
	}

	public JTextField getTxfPrecio() {
		return txfPrecio;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}
}
