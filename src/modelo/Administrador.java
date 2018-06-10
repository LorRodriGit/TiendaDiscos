package modelo;

import controlador.Consultador;

public class Administrador {
 Consultador consultador;
	
	
	private void realizarVenta() {
		//Una vez finalizada la venta,se obtiene la informacion del pedido 
		//y se almacena
		
		//Almacena el pedido en la base de datos
		consultador.almacenaPedido(numPedido,cliente);
		//Lista los articulos desde la interfaz de usuario
		int[] articulos=listaArticulos();
		int[] cantidades=listaCantidades();	
		//Disminuye el stock en la base de datos
		disminuirStock(articulos,cantidades);
		
	}
}
