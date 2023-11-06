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

	String email = Main.email;
	int idCliente;
	String nombre;
	String apellido;
	String contrasena;
	
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

				  String mensaje = "Pedidos realizados:\n";
				  getClientId();
				  try{
		      			Conexion conexion = new Conexion(); 
		    			Connection con = conexion.conectar();

				    String query = "SELECT * FROM pedido WHERE id_cliente = ?";
				    PreparedStatement stmt = con.prepareStatement(query);
				    stmt.setInt(1, idCliente);
				    
				    ResultSet rs = stmt.executeQuery();
				    
				    while(rs.next()){
				    
				      int idPedido = rs.getInt("id_pedido");
				      String estado = rs.getString("estado");
				      int idProducto = rs.getInt("id_producto"); 
				      int cantidad = rs.getInt("cant_producto");

				      double precio = obtenerPrecioProducto(idProducto);
				      
				      double total = cantidad * precio;
				      
				      mensaje += "Pedido N° " + idPedido + " - " + estado + " - $" + total + "\n";

				    }
				    
				  } catch(SQLException e){
						JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
						e.printStackTrace(); 
				  }
				  
				  JOptionPane.showMessageDialog(null, mensaje);

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
	private void getClientId() {
		Conexion conexion = new Conexion();
		Connection con = conexion.conectar();
		try {
			  String query = "SELECT * FROM cliente WHERE email = ?";
	          PreparedStatement stmt = con.prepareStatement(query);
	          stmt.setString(1, email);
	          ResultSet rs = stmt.executeQuery();
	          if (rs.next()) {
	        	this.idCliente = rs.getInt("id_cliente");
	            this.nombre = rs.getString("Nombre");
	            this.apellido = rs.getString("Apellido");
	            this.contrasena = rs.getString("contrasena");
	          }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
		}
		

	}
	
	private double obtenerPrecioProducto(int idProducto){
		Conexion conexion = new Conexion();
		Connection con = conexion.conectar();
		  double precio = 0;
		  
		  try{
		    String query = "SELECT precio FROM producto WHERE id_producto = ?";
		    PreparedStatement stmt = con.prepareStatement(query);
		    stmt.setInt(1, idProducto);

		    ResultSet rs = stmt.executeQuery();

		    if(rs.next()){
		      precio = rs.getDouble("precio");
		    }

		  } catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
		  }

		  return precio;

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
				 int id = rs.getInt("id_producto");
				 String nombre = rs.getString("nombre");
				 double precio = rs.getDouble("precio");
				 int stock = rs.getInt("stock");
				 
				 Producto producto = new Producto(id, nombre, precio, stock);
				 productos.add(producto);
				
			 }
			
		} catch (SQLException e) {
			  JOptionPane.showMessageDialog(null, "Error al obtener productos de la base de datos: " + e.getMessage());
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
				int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto:"));
				Producto productoSeleccionado = encontrarProductoPorID(productos, idProducto);
				productoSeleccionado.setStock(cantidad); 
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
  	  try {
        Pedido pedido = new Pedido(1, null, "en proceso");
        pedido.setProductos(carrito);
        getClientId();
        for(Producto p : carrito) {

        	  int idProducto = p.getId();
        	  int cantidad = p.getStock();
        	  int idPedido = 0;
      			Conexion conexion = new Conexion(); 
    			Connection con = conexion.conectar();
        		// Insertar pedido
    			String query = "INSERT INTO pedido (id_pedido, id_producto, cant_producto, id_cliente, id_contenedor, id_gerente, estado) VALUES (?, ?, ?, ?, ?,?, ?)";               
            	  PreparedStatement stmt = con.prepareStatement(query);
            	  
            	  stmt.setInt(1, idPedido); 
            	  stmt.setInt(2, idProducto);
            	  stmt.setInt(3, cantidad); 
            	  stmt.setInt(4, idCliente);
            	  stmt.setInt(5, 1); // id_contenedor por defecto se puso como 1 debido a las fk constraints
            	  stmt.setInt(6, 1); // id_gerente por defecto se puso como 1 debido a las fk constraints
            	  stmt.setString(7, "en proceso"); // por defecto se puso como "en proceso" porque es el estado inicial
            	  stmt.executeUpdate();
    	          }
        StringBuilder pedidoInfo = new StringBuilder("Detalles del Pedido:\n");
        pedidoInfo.append("ID del pedido ").append(pedido.getId()).append("\n");
        pedidoInfo.append("Estado: ").append(pedido.getEstado()).append("\n");
        
        pedidoInfo.append("Productos:\n");
        for (Producto producto : carrito) {
        	 pedidoInfo.append("Nombre: ").append(producto.getNombre()).append("\n");
        	 pedidoInfo.append("Cantidad: ").append(producto.getStock()).append("\n");
        	 pedidoInfo.append("Precio: $").append(producto.getPrecio()*producto.getStock()).append("\n");
        	 pedidoInfo.append("---------------------------\n");
        }
        JOptionPane.showMessageDialog(null, pedidoInfo.toString(), "Detalles del pedido ", JOptionPane.INFORMATION_MESSAGE);
        
        // vaciar carrito
        }
    		 catch (Exception e) {
    			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
    		}
  	 
     }
}
        


