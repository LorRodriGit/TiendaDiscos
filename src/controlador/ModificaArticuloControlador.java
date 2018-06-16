package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;

import modelo.Modelo;
import vista.ModificarArticuloPanel;

public class ModificaArticuloControlador {
	BigDecimal decimal;
	private ModificarArticuloPanel articuloPanel;
	Modelo modelo=new Modelo();
	
	public ModificaArticuloControlador(ModificarArticuloPanel articuloPanel) {
		this.articuloPanel=articuloPanel;
		llenarcampos(modelo.mostrarTablaArticulos());
	}

	private void llenarcampos(Object[][] TablaArticulos) {
		articuloPanel.getComboBox().addItem(TablaArticulos[0][0]);
				for (int i = 1; i < TablaArticulos.length; i++) {
			articuloPanel.getComboBox().addItem(TablaArticulos[i][0]);
			//articuloPanel.getTxfNombre().setText((String)TablaArticulos[i][1]);
			//.setText(TablaArticulos[i][1]);
			
		
		articuloPanel.getComboBox().addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				articuloPanel.getTxfNombre().setText((String) TablaArticulos[articuloPanel.getComboBox().getSelectedIndex()][1]);
				articuloPanel.getTxfUnidades().setText(String.valueOf( TablaArticulos[articuloPanel.getComboBox().getSelectedIndex()][2]));
				decimal=( (BigDecimal) TablaArticulos[articuloPanel.getComboBox().getSelectedIndex()][4]);
				articuloPanel.getTxfPrecio().setText(String.valueOf(decimal));
				//articuloPanel.getTxfPrecio().setText((String.valueOf(Double.valueOf((String) TablaArticulos[articuloPanel.getComboBox().getSelectedIndex()][4]))));
			}
		});
		}
			articuloPanel.getBtnConfirmar().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int codigo=(int) TablaArticulos[articuloPanel.getComboBox().getSelectedIndex()][0];
					decimal=BigDecimal.valueOf(Double.valueOf(articuloPanel.getTxfPrecio().getText()));
							modelo.relizarModificacionArticulo(codigo,articuloPanel.getTxfNombre().getText()
							,decimal,articuloPanel.getTxfUnidades().getText());
				}
			});	
	}
	
	
}
