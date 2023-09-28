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
						"Pedidos","Administración","Salir"
				};
		int  op = 0;
		do {
			op = JOptionPane.showOptionDialog(null, "Menu principal", null, 0, 0, null, Opciones, Opciones[0]);

			switch (op) {
				case 0:
					PantallaPedidos interfazPedido = new PantallaPedidos();
					Pedido pedido1 = new Pedido(1, null, "en proceso");
					
					ArrayList <Producto> productos = new ArrayList<>();
					
					Producto producto1 = new Producto(1,"leche",2.6, 300, null);
					productos.add(producto1);
					
					Producto producto2 = new Producto(2,"azucar",1.5,100,null);
					productos.add(producto2);
					
					pedido1.setProductos(productos);
					
					String pedidoInfo = "Detalles del Pedido: \n";
					pedidoInfo += "ID del pedido " + pedido1.getId() + "\n";
					pedidoInfo += "Estado: " + pedido1.getEstado() + "\n";
					
					pedidoInfo += "Productos:\n";
				    for (Producto producto : pedido1.getProductos()) {
				        pedidoInfo += "Nombre: " + producto.getNombre() + "\n";
				        pedidoInfo += "Cantidad: " + producto.getTamano() + "\n";
				        pedidoInfo += "Precio: " + producto.getPrecio() + "\n";
				        pedidoInfo += "---------------------------\n";
				    }
				    JOptionPane.showMessageDialog(null, pedidoInfo, "Detalles del pedido ", JOptionPane.INFORMATION_MESSAGE);
				    	

					
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
