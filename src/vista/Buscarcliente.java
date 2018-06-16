package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mock.ClienteMOC;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Buscarcliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBox;
	private String codCliente=null;
	
	public Buscarcliente(Object[][] clientes) {
		setModal(true);//para la ejecucion del programa hasta que termine el jdialog
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	
		comboBox = new JComboBox<String>();
		for (int i = 0; i < clientes.length; i++) {
			comboBox.addItem(clientes[i][1]);
		}
		JLabel lblNombreCliente = new JLabel("Nombre Cliente:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNombreCliente)
					.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(172))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombreCliente))
					.addContainerGap(162, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						codCliente=String.valueOf(clientes[comboBox.getSelectedIndex()][0]);
						dispose();
						
					}
				});
	
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				setVisible(true);
			}
			
		}
	}

	
	public String getCodCliente() {
		return codCliente;
	}

}
