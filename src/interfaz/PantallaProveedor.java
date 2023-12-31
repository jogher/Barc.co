package interfaz;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DLL.Conexion;
import interfaz.Main;
import logica.Producto;
import logica.Proveedor;

public class PantallaProveedor {
	

	public void Menu() {
		/*Opciones del menu*/
		String [] Opciones={"Agregar stock","Nuevo Producto", "Eliminar Producto","Ver Productos" ,"Salir"};
		int op = 0;
		do {
			Conexion conexion = new Conexion(); 
			Connection con = conexion.conectar();
			
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
				//nueva logica utilizando la base de datos
				  try {
				        /* Database Update */
				        String updateQuery = "UPDATE producto SET stock = stock + ? WHERE id_producto = ?";
				        PreparedStatement updateStmt = con.prepareStatement(updateQuery);
				        updateStmt.setInt(1, stock_search);
				        updateStmt.setInt(2, id_search);
				        int rowsUpdated = updateStmt.executeUpdate();
				            
				        if(rowsUpdated > 0){
				            JOptionPane.showMessageDialog(null, "Stock Actualizado for id: " + id_search);
				        } else {
				            JOptionPane.showMessageDialog(null, "Ningun registro de producto fue encontrado con la id : " + id_search);
				        }       
				    } catch (SQLException e) {
				        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
				    }
				break;
			case 1:
		          // Pedir datos para nuevo producto
		          int id = Integer.parseInt(JOptionPane.showInputDialog("Id del producto:"));
		          String nombre = JOptionPane.showInputDialog("Nombre del producto:");
		          double tamano = Double.parseDouble(JOptionPane.showInputDialog("Tamaño del producto:")); 
		          double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del producto:"));
		          int stock = Integer.parseInt(JOptionPane.showInputDialog("Stock inicial:"));

		          //nueva logica utilizando la base de datos
		          
		          // Obtener email del proveedor logueado
		          String emailProveedor = InicioSesion.email;// obtener el email ingresado en el login
		          
		          // Obtener id del proveedor
		          int idProveedor = 0;
		          try {
		          String query = "SELECT id_proveedor FROM proveedor WHERE email = ?";
		          PreparedStatement stmt = con.prepareStatement(query);
		          stmt.setString(1, emailProveedor);
		          ResultSet rs = stmt.executeQuery();
		          if (rs.next()) {
		            idProveedor = rs.getInt("id_proveedor"); 
		          }

		          // Insertar nuevo producto
		          query = "INSERT INTO producto (id_producto, nombre, tamano, precio, stock, id_proveedor) VALUES (?, ?, ?, ?, ?, ?)";
		          stmt = con.prepareStatement(query);
		          stmt.setInt(1, id);
		          stmt.setString(2, nombre);
		          stmt.setDouble(3, tamano);
		          stmt.setDouble(4, precio);
		          stmt.setInt(5, stock);
		          stmt.setInt(6, idProveedor);
		          stmt.executeUpdate();

		          JOptionPane.showMessageDialog(null, "Producto agregado");

		          } catch (SQLException e) {
		        	    JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
		        	}
				break;
			case 2:
				int id_erase = Integer.parseInt(JOptionPane.showInputDialog("Id del producto a eliminar:"));
				/*Metodo de proveedor*/
				//nueva logica utilizando la base de datos
				try {

			        String deleteQuery = "DELETE FROM producto WHERE id_producto = ?";
			        PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
			        deleteStmt.setInt(1, id_erase);
			        int rowsDeleted = deleteStmt.executeUpdate();

			        if(rowsDeleted > 0){
			            JOptionPane.showMessageDialog(null, "Id de producto eliminado: " + id_erase);
			        } else {
			            JOptionPane.showMessageDialog(null, "Ningun registro de producto fue encontrado con la id : " + id_erase);
			        }   
			    } catch (SQLException e) {
			        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
			    }
				break;
			case 3:
				// Ver Productos
				emailProveedor = InicioSesion.email;// obtener el email ingresado en el login
		          
		        // Obtener id del proveedor
		        idProveedor = 0;
			    try {
			    	  String query = "SELECT id_proveedor FROM proveedor WHERE email = ?";
			          PreparedStatement stmt = con.prepareStatement(query);
			          stmt.setString(1, emailProveedor);
			          ResultSet rs = stmt.executeQuery();
			          if (rs.next()) {
			            idProveedor = rs.getInt("id_proveedor"); 
			          }
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
				}
		
			  //nueva logica utilizando la base de datos
			    try {
			        String selectQuery = "SELECT * FROM producto WHERE id_proveedor ="+idProveedor;
			        PreparedStatement selectStmt = con.prepareStatement(selectQuery);
			        ResultSet rs = selectStmt.executeQuery();

			        StringBuilder new_mensaje = new StringBuilder();

			        while(rs.next()){
			        	new_mensaje.append("Id: ").append(rs.getInt("id_producto")).append("\n");
			        	new_mensaje.append("Nombre: ").append(rs.getString("nombre")).append("\n");
			        	new_mensaje.append("Tamaño: ").append(rs.getDouble("tamano")).append("\n");
			        	new_mensaje.append("Precio: ").append(rs.getDouble("precio")).append("\n");
			        	new_mensaje.append("Stock: ").append(rs.getInt("stock")).append("\n\n");
			        }
			            
			        JOptionPane.showMessageDialog(null, new_mensaje.toString());
			    } catch(SQLException e) {
			        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
			    }

				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Salir");
				InicioSesion inicioSesion = new InicioSesion();
				inicioSesion.run();
				break;
			default:
				break;
			}
		} while (op != 4);
	}
	
	public int getProveedorId() {
		Conexion conexion = new Conexion();
		Connection con = conexion.conectar();
		int id_proveedor = 0;
		String email = InicioSesion.email;
		try {
			  String query = "SELECT id_proveedor FROM proveedor WHERE email = ?";
	          PreparedStatement stmt = con.prepareStatement(query);
	          stmt.setString(1, email);
	          ResultSet rs = stmt.executeQuery();
	          if (rs.next()) {
	        	id_proveedor = rs.getInt("id_proveedor"); 
	          }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
		}
		return id_proveedor;
	}
	
	public ArrayList<Producto> obtenerProductosProv(){
		

		ArrayList<Producto> productos = new ArrayList<>();

	    try {
	    	Conexion conexion = new Conexion(); 
			Connection con = conexion.conectar();
	        String selectQuery = "SELECT id_producto, nombre, tamano, precio, stock FROM producto WHERE id_proveedor = ?";
	        PreparedStatement stmt = con.prepareStatement(selectQuery);
	        
	        stmt.setInt(1, getProveedorId());
	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()){
	        	int id_producto = rs.getInt("id_producto");
	        	String nombre = rs.getString("nombre");
	        	double tamano = rs.getDouble("tamano");
	        	double precio = rs.getDouble("precio");
	        	int stock = rs.getInt("stock");
	        	
	        	Producto producto = new Producto(id_producto, nombre, tamano, precio, stock);
				productos.add(producto);
	        }
	           
	    } catch(SQLException e) {
	        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
	    }
	    return productos;
	}
	
	public void agregarStock(int id_producto, int stockAgregado) {
		 try {
			 	Conexion conexion = new Conexion(); 
				Connection con = conexion.conectar();
		        String updateQuery = "UPDATE producto SET stock = stock + ? WHERE id_producto = ?";
		        PreparedStatement updateStmt = con.prepareStatement(updateQuery);
		        updateStmt.setInt(1, stockAgregado);
		        updateStmt.setInt(2, id_producto);
		        int rowsUpdated = updateStmt.executeUpdate();
		            
		       JOptionPane.showMessageDialog(null, "Stock agregado correctamente");   
		    } catch (SQLException e) {
		        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
		    }
	}
	
	public void eliminarProducto(int id_producto) {
		  try {
			  Conexion conexion = new Conexion(); 
			  Connection con = conexion.conectar();
			  String sql = "DELETE FROM producto WHERE id_producto = ?";
			  PreparedStatement stmt = con.prepareStatement(sql);
			  stmt.setInt(1, id_producto);
			  stmt.executeUpdate();
			  JOptionPane.showMessageDialog(null, "Se ha eliminado el producto correctamente!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void agregarProducto(String nombre, double tamanio, double precio, int stock) {
		 try {
			 Conexion conexion = new Conexion(); 
			 Connection con = conexion.conectar();
			 String query = "INSERT INTO producto (nombre, tamano, precio, stock, id_proveedor) VALUES (?, ?, ?, ?, ?)";
		     PreparedStatement stmt = con.prepareStatement(query);
		     
		     stmt.setString(1,nombre);
		     stmt.setDouble(2,tamanio);
		     stmt.setDouble(3, precio);
		     stmt.setInt(4, stock);
		     stmt.setInt(5, getProveedorId());
		     stmt.executeUpdate();
		     
		     JOptionPane.showMessageDialog(null, "Producto agregado");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
		}
	}
}
