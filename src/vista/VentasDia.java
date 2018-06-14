package vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentasDia extends JPanel {
	private JTextField txfFecha;
	private JTextField txfArticulo;
	private JTable tablaVentas;
	private JRadioButton rdbtnFecha,rdbtnArticulo; 
	private JScrollPane scrollPane;
	 private JButton Reporte;
	public VentasDia() {
		crearComponentes();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(rdbtnFecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txfFecha, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnArticulo, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(txfArticulo, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(Reporte, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
							.addGap(58)))
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnArticulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(txfArticulo))
						.addComponent(Reporte, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(txfFecha)
						.addComponent(rdbtnFecha))
					.addGap(51)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addGap(50))
		);
		
		tablaVentas = new JTable();
		tablaVentas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Articulo", "Fecha", "Cantidad"
			}
		));
		scrollPane.setViewportView(tablaVentas);
		setLayout(groupLayout);

	}

	private void crearComponentes() {
		 rdbtnFecha = new JRadioButton("Fecha");
		 rdbtnArticulo=new JRadioButton("Articulo");
		 txfFecha = new JTextField();
			txfFecha.setColumns(10);
			txfArticulo = new JTextField();
			txfArticulo.setColumns(10);
			 Reporte = new JButton("New button");	
			 scrollPane = new JScrollPane();
			 tablaVentas = new JTable();
				tablaVentas.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Articulo", "Fecha", "Cantidad"
					}
				));
				scrollPane.setViewportView(tablaVentas);
	}
}
