package interfaz;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DLL.Conexion;
import interfaz.Main;
import logica.Producto;
import logica.Proveedor;

public class PantallaProveedor {
	

	Proveedor proveedor1 = new Proveedor(1, "Proveedor 1", "Alimentos", "Calle Falsa 123", "+541144444444", "proveedor1@email.com","1234");
	public Proveedor getProveedor() {
	    return proveedor1;
	}

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

		          Producto p = new Producto(id, nombre, tamano, precio, stock, proveedor1);
		          JOptionPane.showMessageDialog(null, "Productos agregados correctamente al proveedor.");

		          // Agregar el nuevo producto al proveedor
		          proveedor1.addProducto(p);
		          
		          //nueva logica utilizando la base de datos
		          
		          // Obtener email del proveedor logueado
		          String emailProveedor = Main.email;// obtener el email ingresado en el login
		          
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
				try {
			        /* Database Delete */
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
			      //JOptionPane.showMessageDialog(null, mensaje);
			    try {
			        /* DB */
			        String selectQuery = "SELECT * FROM producto";
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
				break;
			default:
				break;
			}
		} while (op != 4);
	}
}
