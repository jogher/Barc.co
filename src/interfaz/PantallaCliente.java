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
	
	public ArrayList <Producto> carrito = new 	ArrayList<>();

	public void Menu() {

		/*String[] Opciones=
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
				//agregarProductosCarrito(productosDisponibles);
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
	*/}
	
	
	
	
	
	public int getClientId() {
		Conexion conexion = new Conexion();
		Connection con = conexion.conectar();
		int idCliente = 0;
		String emailCliente = InicioSesion.email;
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
	
	public double obtenerPrecioProducto(int idProducto){
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
	public ArrayList<Producto> obtenerProductos(){
		
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
	
	public void mostrarProductos(ArrayList<Producto> productos) {
		StringBuilder mensaje = new StringBuilder ("productos disponibles:\n");
		for (Producto producto : productos) {
			mensaje.append(producto.getId()).append(". ").append(producto.getNombre()).append(" - Precio: $")
			.append(producto.getPrecio()).append("\n");
		}
		 JOptionPane.showMessageDialog(null, mensaje.toString());
	}
	
	public void agregarProductosCarrito(ArrayList<Producto> productos, int idProducto, int cantidad) {
	    try {
	        Producto productoSeleccionado = encontrarProductoPorID(productos, idProducto);
	        if (productoSeleccionado != null) {
	            productoSeleccionado.setStock(cantidad);
	            carrito.add(productoSeleccionado);
	            JOptionPane.showMessageDialog(null, "Producto agregado al carrito");
	        } else {
	            JOptionPane.showMessageDialog(null, "No se encontró el producto.");
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
	    }
	}

	
	public Producto encontrarProductoPorID(ArrayList<Producto> productos, int id) {
		for  (Producto producto : productos) {
			if  (producto.getId() == id) {
				return producto;
			}
		}
		return null;	
	}
	
	private void realizarPedido() {
  	  	Conexion conexion = new Conexion(); 
		Connection con = conexion.conectar();
		
		try {
	        Pedido pedido = new Pedido();
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
	        pedidoInfo.append("ID del pedido ").append(pedido.getIdPedido()).append("\n");
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
	
	
	public void cancelarPedido(int idPedido) {
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
	
	public ArrayList<Pedido> obtenerPedidosCliente(int idCliente) {
	    ArrayList<Pedido> pedidos = new ArrayList<>();

	    try {
	        Conexion conexion = new Conexion();
	        Connection con = conexion.conectar();
	        String query = "SELECT * FROM pedido WHERE id_cliente = ?";
	        PreparedStatement stmt = con.prepareStatement(query);
	        stmt.setInt(1, idCliente);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id_pedido = rs.getInt("id_pedido");
	            int cantidad = rs.getInt("cant_producto");
	            String estado = rs.getString("estado");
	            String destino = rs.getString("destino");
	            int id_contenedor = rs.getInt("id_contenedor");
	            int id_producto = rs.getInt("id_producto");
	            Pedido pedido = new Pedido(id_pedido, cantidad, estado, destino, id_contenedor, id_producto);
	            pedidos.add(pedido);
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error al obtener los pedidos del cliente: " + e.getMessage());
	    }

	    return pedidos;
	}

}
        


