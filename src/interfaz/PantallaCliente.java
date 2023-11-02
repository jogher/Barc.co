package interfaz;

import java.util.ArrayList; 

import javax.swing.JOptionPane;

import logica.Pedido;
import logica.Producto;

public class PantallaCliente {
	
	private ArrayList <Producto> carrito = new 	ArrayList<>();

	public void Menu() {
		
		String[] Opciones=
			{
				"Agregar Producto",	"Realizar pedido","Seguimiento de pedidos","Cancelar pedido","Salir"
			};
		int op=0;
		do {
			op= JOptionPane.showOptionDialog(null, "Menu Pedidos", null, 0, 0, null, Opciones, Opciones[0]);
			switch (op) {
			case 0:
				
				agregarProducto();
				/*JOptionPane.showMessageDialog(null, "Realizar pedido \n"
						+ "Se debe ingresar(Productos)");*/
				break;
			case 1:
				
				if (carrito.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe agregar al menos un prodcuto al carrito");
				} else {
					realizarPedido();
				
				}
				
				
				/*Pedido pedido1 = new Pedido(1, null, "en proceso");
				
				ArrayList <Producto> productos = new ArrayList<>();
				
				Producto producto1 = new Producto(1,"leche",2.6, 300,2, null);
				productos.add(producto1);
				
				Producto producto2 = new Producto(2,"azucar",1.5,100,3,null);
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
			    JOptionPane.showMessageDialog(null, pedidoInfo, "Detalles del pedido ", JOptionPane.INFORMATION_MESSAGE);*/
			    	

				
				break;
			case 2:
				// seguimiento del pedido 
				
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Cancelar Pedido \n"
						+ "Seleccione pedido");
				
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Salir");
			default:
				break;
			}
		} while (op!=4);
	}
	
	private void agregarProducto() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
		double precio  = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del prodcuto"));
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad del producto"));
		
		Producto producto = new Producto (carrito.size() + 1, nombre, precio, cantidad, 0, null);
		carrito.add(producto);
		JOptionPane.showMessageDialog(null, "producto agregado al carrito");		
	}
	
	private void realizarPedido() {
        Pedido pedido = new Pedido(1, null, "en proceso");
        pedido.setProductos(carrito);

        String pedidoInfo = "Detalles del Pedido: \n";
        pedidoInfo += "ID del pedido " + pedido.getId() + "\n";
        pedidoInfo += "Estado: " + pedido.getEstado() + "\n";

        pedidoInfo += "Productos:\n";
        for (Producto producto : carrito) {
            pedidoInfo += "Nombre: " + producto.getNombre() + "\n";
            pedidoInfo += "Cantidad: " + producto.getTamano() + "\n";
            pedidoInfo += "Precio: " + producto.getPrecio() + "\n";
            pedidoInfo += "---------------------------\n";
        }
        JOptionPane.showMessageDialog(null, pedidoInfo, "Detalles del pedido ", JOptionPane.INFORMATION_MESSAGE);

        // vaciar carrito
        carrito.clear();
    }

}
