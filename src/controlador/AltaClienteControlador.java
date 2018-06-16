package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.firebirdsql.jdbc.parser.JaybirdSqlParser.dataTypeDescriptor_return;

import modelo.Modelo;
import vista.AltaClientePanel;

public class AltaClienteControlador {
	private AltaClientePanel altaClientePanel;
	Modelo modelo=new Modelo();
	
	public AltaClienteControlador(AltaClientePanel altaClientePanel) {
		this.altaClientePanel=altaClientePanel;
		darAlta();
		
	}

	private void darAlta() {
		altaClientePanel.getBtnAceptar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.nuevoCliente(Integer.valueOf(altaClientePanel.getTxfCodigo().getText()), altaClientePanel.getTfNombre().getText(), altaClientePanel.getTfPoblacion().getText());
				
			}
		});
	}
}
