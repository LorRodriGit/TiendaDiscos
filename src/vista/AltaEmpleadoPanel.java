package vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class AltaEmpleadoPanel extends JPanel {
	private JTextField txfCodigo, tfNombre, tfPoblacion;
	private JLabel lbCodigo, lbNombre, labelFuncion, lblAltaEmpleado;
	private JButton btnSalir, btnAceptar;

	public AltaEmpleadoPanel() {
		crearComponentes();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(lbCodigo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(labelFuncion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(92)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txfCodigo)
						.addComponent(tfNombre)
						.addComponent(tfPoblacion))
					.addGap(172))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(256)
					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(39))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(lblAltaEmpleado, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(lblAltaEmpleado, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbCodigo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(txfCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbNombre)
						.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelFuncion)
						.addComponent(tfPoblacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSalir))
					.addGap(20))
		);
		setLayout(groupLayout);


	}
	private void crearComponentes() {
		lbCodigo = new JLabel("Codigo");
		lbNombre = new JLabel("Nombre");
		labelFuncion = new JLabel("Funcion");
		txfCodigo = new JTextField();
		txfCodigo.setColumns(10);
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		tfPoblacion = new JTextField();
		tfPoblacion.setColumns(10);
		lblAltaEmpleado = new JLabel("ALTA EMPLEADO");
		lblAltaEmpleado.setFont(new Font("Wide Latin", Font.BOLD, 14));
		btnSalir = new JButton("Salir");
		btnAceptar = new JButton("Aceptar");
	}

}
