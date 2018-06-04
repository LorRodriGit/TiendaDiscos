package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegistroUsuarios extends JFrame {

	private JButton btAceptar;
	private JLabel lbUsuario, lbContraseña;
	private JTextField tfUsuario;
	private JPasswordField pfContraseña;
	private JPanel panelBtAceptar, panelUsuario;

	public RegistroUsuarios() {
		initComponents();
		this.setTitle("Acceso usuarios");
		this.setVisible(true);
		this.setBounds(600, 200, 600, 200);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.add(panelUsuario);
		this.add(panelBtAceptar);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void initComponents() {
		btAceptar = new JButton("Aceptar");
		lbUsuario = new JLabel("Usuario: ");
		lbUsuario.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 18));
		lbContraseña = new JLabel("Contraseña: ");
		lbContraseña.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 18));
		tfUsuario = new JTextField(20);
		pfContraseña = new JPasswordField(20);
		panelUsuario = new JPanel();
		panelUsuario.setLayout(new GridLayout(2, 2, 8, 8));
		panelUsuario.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelUsuario.setBackground(Color.YELLOW);
		Component componentes[] = { lbUsuario, tfUsuario, lbContraseña, pfContraseña };
		for (int i = 0; i < componentes.length; i++) {
			panelUsuario.add(componentes[i]);
		}
		panelBtAceptar = new JPanel(new FlowLayout());
		panelBtAceptar.setBackground(Color.YELLOW);
		panelBtAceptar.add(btAceptar);

	}

	public JButton getBtAceptar() {
		return btAceptar;
	}

	public JTextField getTfUsuario() {
		return tfUsuario;
	}

	public JPasswordField getPfContraseña() {
		return pfContraseña;
	}

	public void setTfUsuario(JTextField tfUsuario) {
		this.tfUsuario = tfUsuario;
	}

	public void setPfContraseña(JPasswordField pfContraseña) {
		this.pfContraseña = pfContraseña;
	}

	public void setPanelBtAceptar(JPanel panelBtAceptar) {
		this.panelBtAceptar = panelBtAceptar;
	}

	public void setPanelUsuario(JPanel panelUsuario) {
		this.panelUsuario = panelUsuario;
	}

}
