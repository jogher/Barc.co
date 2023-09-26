package interfaz;
import javax.swing.JOptionPane;

import logica.Producto;
import logica.Pedido;


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
					PatanllaPedido interfazPedido = new PatanllaPedido();
					Pedido pedido1 = new Pedido(1, null, "en proceso");
					Producto producto = new  Producto(1,"leche",300, 2.5, null);
					pedido1.getProdcutos().add(Producto);
					
					producto = new Producto(2,"azucar",100,1.5,null);
					pedido1.getProductos().add(producto);
					nueva.setPrecio(nueva.determinarPrecio());
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
