package vista;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class PanelArticulos extends JPanel {
	private JTable tbArticulos;
	private DefaultTableModel modelo;
	private String[] columnas = { "COD_ARTICULO", "NOMBRE", "UNIDADES", "DURACION", "PRECIO" };
	private JScrollPane scrollPane;
	private JButton btnSeleccionar;
	private JLabel lblArticulos;

	public PanelArticulos() {
		crearComponentes();
		ponerComponentesEnLayout();
		
	}

	private void ponerComponentesEnLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblArticulos)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addComponent(btnSeleccionar))
					.addGap(6))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblArticulos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSeleccionar)
					.addGap(26))
		);
		setLayout(groupLayout);

	}

	private void crearComponentes() {
		 lblArticulos = new JLabel("ARTICULOS");
		lblArticulos.setFont(new Font("Wide Latin", Font.BOLD, 14));

		scrollPane = new JScrollPane();

		btnSeleccionar = new JButton("Seleccionar");
		tbArticulos = new JTable();
		modelo = new DefaultTableModel(null, columnas);
		tbArticulos.setModel(modelo);
		tbArticulos.getColumnModel().getColumn(0).setPreferredWidth(91);
		scrollPane.setViewportView(tbArticulos);
	}

	
}
