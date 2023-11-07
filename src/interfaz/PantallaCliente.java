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
				break;
				
			case 2:
				// seguimiento del pedido 
				  String mensaje = "Pedidos realizados:\n";
				  try{
		      			Conexion conexion = new Conexion(); 
		    			Connection con = conexion.conectar();
					    String query = "SELECT * FROM pedido WHERE id_cliente = ?";
					    PreparedStatement stmt = con.prepareStatement(query);
					    stmt.setInt(1, getClientId());
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
				cancelarPedido();
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Salir");
				
			default:
				
				break;
			}			
		} while (op!=4);
	}
	
	
	
	
	
	private int getClientId() {
		Conexion conexion = new Conexion();
		Connection con = conexion.conectar();
		int idCliente = 0;
		String emailCliente = Main.email;
		try {
			  String query = "SELECT id_cliente FROM cliente WHERE email = ?";
	          PreparedStatement stmt = con.prepareStatement(query);
	          stmt.setString(1, emailCliente);
	          ResultSet rs = stmt.executeQuery();
	          if (rs.next()) {
	        	idCliente = rs.getInt("id_cliente"); 
	          }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
		}
		return idCliente;
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
  	  	String destino = JOptionPane.showInputDialog("Ingrese el destino para el pedido: ");
  	  	Conexion conexion = new Conexion(); 
		Connection con = conexion.conectar();
		
		try {
	        Pedido pedido = new Pedido(1, null, "en proceso");
	        pedido.setProductos(carrito);
	        
	        
	        for(Producto p : carrito) {
	
	        	  int idProducto = p.getId();
	        	  int cantidad = p.getStock();
	        	  int idPedido = 0;
	      			
	        		// Insertar pedido
	    			 String query = "INSERT INTO pedido (id_pedido, cant_producto, estado, destino, id_contenedor, id_producto, id_gerente, id_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";               
	    			 PreparedStatement stmt = con.prepareStatement(query);
	            	  
	            	  stmt.setInt(1, idPedido); 
	            	  stmt.setInt(2, cantidad);
	            	  stmt.setString(3, "en proceso"); // por defecto se puso como "en proceso" porque es el estado inicial
	            	  stmt.setString(4, destino);
	            	  stmt.setInt(5, 1); // id_contenedor por defecto se puso como 1 debido a las fk constraints
	            	  stmt.setInt(6, idProducto); 
	            	  stmt.setInt(7,1 );// id_gerente por defecto se puso como 1 debido a las fk constraints 
	            	  stmt.setInt(8, getClientId());
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
	
	
	private void cancelarPedido() {
		String mensaje = "Pedidos:\n";
		int idPedido = 0;
		int idProducto = 0;
		String nombre = "";
		int cantProducto = 0;
		 //MUESTRO LOS PEDIDOS QUE POSEE EL CLIENTE
		  try{
    			Conexion conexion = new Conexion(); 
    			Connection con = conexion.conectar();
			    String query = "SELECT id_pedido, id_producto, cant_producto FROM pedido WHERE id_cliente = ?";
			    PreparedStatement stmt = con.prepareStatement(query);
			    stmt.setInt(1, getClientId());
			    ResultSet rs = stmt.executeQuery();
			    
			    while(rs.next()){
				      idPedido = rs.getInt("id_pedido");
				      idProducto = rs.getInt("id_producto"); 
				      cantProducto = rs.getInt("cant_producto");
				      
				      String query2 = "SELECT nombre FROM producto WHERE id_producto = ?";
					  PreparedStatement stmt2 = con.prepareStatement(query2);
					  stmt2.setInt(1, idProducto);
					  ResultSet rs2 = stmt2.executeQuery();
					  while(rs2.next()) {
					    	nombre = rs2.getString("nombre");
					    	mensaje += "Pedido N° " + idPedido + " - "+nombre+" cantidad: "+cantProducto+"\n";  
					    }
			      } 
			        
		  } catch(SQLException e){
				JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
				e.printStackTrace(); 
		  }
		  JOptionPane.showMessageDialog(null, mensaje);
		  
		  idPedido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del pedido que desea cancelar: "));
		  try {
			  Conexion conexion = new Conexion(); 
  			  Connection con = conexion.conectar();
  			  String sql = "DELETE FROM pedido WHERE id_pedido = ?";
  			  PreparedStatement stmt = con.prepareStatement(sql);
  			  stmt.setInt(1, idPedido);
  			  stmt.executeUpdate();
  			  JOptionPane.showMessageDialog(null, "Se ha cancelado el pedido correctamente!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
        


