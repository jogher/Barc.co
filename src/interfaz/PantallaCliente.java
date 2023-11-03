package interfaz;

import logica.Gerente;
import logica.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import logica.Proveedor;
import logica.Contenedor;

import javax.swing.JOptionPane;

import DLL.Conexion;
import logica.Pedido;



public class PantallaCliente {
	
	private Connection con;
	
	private ArrayList <Producto> carrito = new 	ArrayList<>();

	public void Menu() {
		Conexion conexion = new Conexion(); 
		Connection con = conexion.conectar();
		
		String[] Opciones=
			{
				"Agregar Producto",	"Realizar pedido","Seguimiento de pedidos","Cancelar pedido","Salir"
			};
		int op=0;
		do {
			op= JOptionPane.showOptionDialog(null, "Menu Pedidos", null, 0, 0, null, Opciones, Opciones[0]);
			switch (op) {
			case 0:
				
				ArrayList<Producto> productosDisponibles = obtenerProductos();
				mostrarProductos(productosDisponibles);
				agregarProductosCarrito(productosDisponibles);
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
	
	private ArrayList<Producto> obtenerProductos(){
		
		ArrayList<Producto> productos = new ArrayList<>();
		
		try {
			Conexion conexion = new Conexion(); 
			Connection con = conexion.conectar();
			String query = "SELECT id_producto, nombre, precio, stock From producto";
			 PreparedStatement stmt = con.prepareStatement(query);
			 ResultSet rs = stmt.executeQuery();
			 
			 while (rs.next()) {
				 int id = rs.getInt("id");
				 String nombre = rs.getString("nombre");
				 double precio = rs.getDouble("precio");
				 int stock = rs.getInt("stock");
				 
				 Producto producto = new Producto(id, nombre, precio, stock);
				 productos.add(producto);
				
			 }
			
		} catch (SQLException e) {
			  JOptionPane.showMessageDialog(null, "Error al obtener productos de la base de datos: " + e.getMessage());
		} finally {
			 if (con != null) {
				 try {
		                con.close();
		            }  catch (SQLException e) {
		            	 JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
		            }
			 }
		}
		return productos;
	}
	
	private void mostrarProductos(ArrayList<Producto> productos) {
		StringBuilder mensaje = new StringBuilder ("productos disponibles:\n");
		for (Producto producto : productos) {
			mensaje.append(producto.getId()).append(". ").append(producto.getNombre()).append(" - Precio: $")
			.append(producto.getPrecio()).append("\n");
		}
		 JOptionPane.showMessageDialog(null, mensaje.toString());
	}
	
	private void agregarProductosCarrito(ArrayList<Producto>productos) {
		try {
			int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto para agregar al carrito (0 para finalizar)"));
			
			while (idProducto !=0) {
				Producto productoSeleccionado = encontrarProductoPorID(productos, idProducto);
				if (productoSeleccionado != null) {
					carrito.add(productoSeleccionado);
					JOptionPane.showMessageDialog(null, "Producto agregado al carrito");
				} else {
					JOptionPane.showMessageDialog(null, "Producto no encontrado");
				}
				  idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto para agregar al carrito (0 para finalizar)"));
			}
		} catch  (NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
		}
	}
	
	private Producto encontrarProductoPorID(ArrayList<Producto> productos, int id) {
		for  (Producto producto : productos) {
			if  (producto.getId() == id) {
				return producto;
			}
		}
		return null;	
	}
	
	private void realizarPedido() {
        Pedido pedido = new Pedido(1, null, "en proceso");
        pedido.setProductos(carrito);
        
        StringBuilder pedidoInfo = new StringBuilder("Detalles del Pedido:\n");
        pedidoInfo.append("ID del pedido ").append(pedido.getId()).append("\n");
        pedidoInfo.append("Estado: ").append(pedido.getEstado()).append("\n");
        
        pedidoInfo.append("Productos:\n");
        for (Producto producto : carrito) {
        	 pedidoInfo.append("Nombre: ").append(producto.getNombre()).append("\n");
        	 pedidoInfo.append("Cantidad: ").append(producto.getTamano()).append("\n");
        	 pedidoInfo.append("Precio: $").append(producto.getPrecio()).append("\n");
        	 pedidoInfo.append("---------------------------\n");
        }
        JOptionPane.showMessageDialog(null, pedidoInfo.toString(), "Detalles del pedido ", JOptionPane.INFORMATION_MESSAGE);
        
        // vaciar carrito
        carrito.clear();
	/*
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
    }*/
       }
}


