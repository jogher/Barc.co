package interfaz;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import logica.Producto;
import logica.Proveedor;

public class PantallaProveedor {
	
	Proveedor proveedor1 = new Proveedor(1, "Proveedor 1", "Alimentos", "Calle Falsa 123", "+541144444444", "proveedor1@email.com");
	public Proveedor getProveedor() {
	    return proveedor1;
	}

	public void Menu() {
		

		/*Opciones del menu*/
		String [] Opciones={"Agregar stock","Nuevo Producto", "Eliminar Producto","Ver Productos" ,"Salir"};
		int op = 0;
		do {
			/*Muestro por pantalla las opciones*/
			op = JOptionPane.showOptionDialog(null, "Menu", null, 0, 0, null, Opciones, Opciones[0]);
			/*Dependiendo de la opcion, pido el ingresop de datos y uso la funcion indicada*/
			switch (op) {
			case 0:
				int id_search;
				int stock_search;
				id_search = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto:"));
				stock_search = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de productos que agrega al stock:"));
				
				/*Metodo de proveedor*/
				
				ArrayList<Producto> productos_1 = proveedor1.getProductos();
//Se buscan los productos del proveedor, si el id ingresado coincide con el id de un producto en el ArrayList de productos del proveedor se le agrega el stock ingresado al stock que ya se tenía (tecnicamente, tambien puede ser usado para restar stock)
				  for(Producto p : productos_1) {
				    if(p.getId() == id_search) {
				    	int updated_stock = p.getStock() + stock_search;
				      p.setStock(updated_stock);
				    }
				    else {
				        JOptionPane.showMessageDialog(null, "No se ha podido encontrar ningún producto con esa ID"); 
				      }
				  }
				
				break;
			case 1:
		          // Pedir datos para nuevo producto
		          int id = Integer.parseInt(JOptionPane.showInputDialog("Id del producto:"));
		          String nombre = JOptionPane.showInputDialog("Nombre del producto:");
		          double tamano = Double.parseDouble(JOptionPane.showInputDialog("Tamaño del producto:")); 
		          double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del producto:"));
		          int stock = Integer.parseInt(JOptionPane.showInputDialog("Stock inicial:"));

		          Producto p = new Producto(id, nombre, tamano, precio, stock, proveedor1);
		          JOptionPane.showMessageDialog(null, "Productos agregados correctamente al proveedor.");

		          // Agregar el nuevo producto al proveedor
		          proveedor1.addProducto(p);
				break;
			case 2:
				JOptionPane.showInputDialog("Ingrese id del producto que desea eliminar: ");
				/*Metodo de proveedor*/
				break;
			case 3:
				// Ver Productos
			      
				String mensaje = "";
			    
			    ArrayList<Producto> productos = proveedor1.getProductos();
			    
			    for(int i = 0; i < productos.size(); i++) {
			    	Producto p1 = productos.get(i); 
			        mensaje += "Id: " + p1.getId() + "\n";
			        mensaje += "Nombre: " + p1.getNombre() + "\n";
			        mensaje += "Tamaño: " + p1.getTamano() + "\n";
			        mensaje += "Precio: " + p1.getPrecio() + "\n";
			        mensaje += "Stock: " + p1.getStock() + "\n\n";
			      }
			      
			      JOptionPane.showMessageDialog(null, mensaje);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Salir");
				break;
			default:
				break;
			}
		} while (op != 4);
	}
}
