package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPaneles;

public class VentanaPrincipal extends JFrame {

	private static final String ALTA_EMPLEADO = "AltaEMpleado";
	private static final String ALTA_CLIENTE = "AltaCliente";
	private static final String MODIFICAR_ARTICULO = "ModificarArticulo";
	private static final String VENTAS_DIA = "VentasDia";
	private static final String ACCESO_USUARIO = "AccesoUsuario";
	private JPanel contentPane;
	private JToolBar barraHerramientas;
	private BotonConImagen btBuscar, btVentasDia, btModificarArticulo, btAltaEmpleado, btAltaCliente;
	private VentasPanel accesoUsuario;
	private VentasDia ventasDia;
	private ModificarArticuloPanel modificarArticulo;
	private AltaClientePanel altaCliente;
	private AltaEmpleadoPanel altaEmpleado;
	private JPanel panel;
	private CardLayout cardLayout;
	private ControladorPaneles controlador;
	
	public VentanaPrincipal(String usuario) {
		this.setVisible(true);
		crearBarraHerramientas(usuario);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(barraHerramientas, BorderLayout.NORTH);	
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		cardLayout = new CardLayout(0, 0);
		panel.setLayout(cardLayout);
		accesoUsuario=new VentasPanel();
		ventasDia=new VentasDia();
		modificarArticulo=new ModificarArticuloPanel();
		altaCliente=new AltaClientePanel();
		altaEmpleado=new AltaEmpleadoPanel();
		panel.add(accesoUsuario, ACCESO_USUARIO);
		panel.add(ventasDia, VENTAS_DIA);
		panel.add(modificarArticulo,MODIFICAR_ARTICULO);
		panel.add(altaCliente,ALTA_CLIENTE);
		panel.add(altaEmpleado,ALTA_EMPLEADO);
		controlador=new ControladorPaneles(this);
		pack();
		
	}

	private void crearBarraHerramientas(String usuario) {
		boolean velado=true;
		barraHerramientas = new JToolBar();
		btBuscar=new BotonConImagen("Buscar", "src/imagenes/buscar.png",velado);
		btAltaCliente=new BotonConImagen("Nuevo Cliente", "src/imagenes/NuevoCliente.png",velado);
		velado=usuario.equals("Administrador");
		btVentasDia=new BotonConImagen("Ventas dia", "src/imagenes/VentasDia.png",velado);
		btModificarArticulo=new BotonConImagen("Modificar Articulo", "src/imagenes/Modificar.png",velado);
		btAltaEmpleado=new BotonConImagen("Nuevo empleado", "src/imagenes/buscar.png",velado);	
		barraHerramientas.add(btBuscar);
		barraHerramientas.add(btVentasDia);
		barraHerramientas.add(btModificarArticulo);
		barraHerramientas.add(btAltaCliente);
		barraHerramientas.add(btAltaEmpleado);
		btBuscar.setName(ACCESO_USUARIO);
		btVentasDia.setName(VENTAS_DIA);
		btModificarArticulo.setName(MODIFICAR_ARTICULO);
		btAltaCliente.setName(ALTA_CLIENTE);
		btAltaEmpleado.setName(ALTA_EMPLEADO);
		
	}

	public JToolBar getBarraHerramientas() {
		return barraHerramientas;
	}

	public JPanel getPanel() {
		return panel;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

}
