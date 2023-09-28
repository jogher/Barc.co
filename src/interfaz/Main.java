package interfaz;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logica.Producto;
import logica.Pedido;
import logica.Cliente;


public class Main {

	public static void main(String[] args) {
		String[] Opciones =
				{
						"Salir","Administración","Pedidos"
				};
		int  op = 0;
		do {
			op = JOptionPane.showOptionDialog(null, "Menu principal", null, 0, 0, null, Opciones, Opciones[0]);

			switch (op) {
				case 0:
					PantallaPedidos interfazPedido = new PantallaPedidos();
					Pedido pedido1 = new Pedido(1, null, "en proceso");
					
					ArrayList <Producto> productos = new ArrayList<>();
					
					Producto producto1 = new Producto(1,"leche",300, 2.5, null);
					productos.add(producto1);
					
					Producto producto2 = new Producto(2,"azucar",100,1.5,null);
					productos.add(producto2);
					
					pedido1.setProductos(productos);
					
					interfazPedido.Menu(pedido1);
					break;
				case 1:

					break;
				case 2:

					break;
				default:
					break;
			}

		} while (op!=2);

	}

}
