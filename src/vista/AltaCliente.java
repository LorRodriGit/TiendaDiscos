package vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class AltaCliente extends JPanel {
	private JTextField txfCodigo, tfNombre, tfPoblacion;
	private JLabel lbCodigo, lbNombre, labelPoblacion, lblAltaCliente;
	private JButton btnSalir, btnAceptar;

	public AltaCliente() {
		crearComponentes();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(55)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lbNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lbCodigo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(labelPoblacion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(92)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(txfCodigo)
										.addComponent(tfNombre).addComponent(tfPoblacion))
								.addGap(63))
						.addGroup(groupLayout.createSequentialGroup().addGap(117).addComponent(lblAltaCliente,
								GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)))
				.addGap(109))
				.addGroup(groupLayout.createSequentialGroup().addGap(31)
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE).addGap(256)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE).addGap(39)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addGap(28)
						.addComponent(lblAltaCliente, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE).addGap(31)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbCodigo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(3).addComponent(txfCodigo)))
						.addGap(26)
						.addGroup(groupLayout
								.createParallelGroup(Alignment.BASELINE).addComponent(lbNombre).addComponent(tfNombre))
						.addGap(37)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(labelPoblacion)
								.addComponent(tfPoblacion))
						.addGap(49)
						.addGroup(groupLayout
								.createParallelGroup(Alignment.BASELINE).addComponent(btnAceptar,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSalir))
						.addGap(20)));
		setLayout(groupLayout);

	}

	private void crearComponentes() {
		lbCodigo = new JLabel("Codigo");
		lbNombre = new JLabel("Nombre");
		labelPoblacion = new JLabel("Poblacion");
		txfCodigo = new JTextField();
		txfCodigo.setColumns(10);
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfPoblacion = new JTextField();
		tfPoblacion.setColumns(10);
		lblAltaCliente = new JLabel("ALTA CLIENTE");
		lblAltaCliente.setFont(new Font("Wide Latin", Font.BOLD, 13));
		btnSalir = new JButton("Salir");
		btnAceptar = new JButton("Aceptar");
	}

}
