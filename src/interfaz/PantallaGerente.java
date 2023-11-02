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

public class PantallaGerente {

	public void Menu() {
		Conexion conexion = new Conexion(); 
		Connection con = conexion.conectar();
		//guardamos los datos del gerente logueado
		String email = Main.email;
		int idGerente;
		String nombre;
		String apellido;
		String contrasena;
		try {
			  String query = "SELECT * FROM gerente WHERE email = ?";
	          PreparedStatement stmt = con.prepareStatement(query);
	          stmt.setString(1, email);
	          ResultSet rs = stmt.executeQuery();
	          if (rs.next()) {
	            idGerente = rs.getInt("id_gerente"); 
	            nombre = rs.getString("Nombre");
	            apellido = rs.getString("Apellido");
	            contrasena = rs.getString("contrasena");
	          }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
		}
		// opciones
		
		String [] Opciones = {
				"Contenedor nuevo",
				"Contenedores",
				"Barcos",
				"Salir"
		};
			
		int op = 0;
		do {
			// seleccion de menu
			op= JOptionPane.showOptionDialog(null, "Menu Gerente", null, 0, 0, null, Opciones, Opciones[0]);
			
			switch (op) {
				case 0:
					int idContenedor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del contenedor:"));
					int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad del contenedor:"));
					String color = JOptionPane.showInputDialog("Ingrese el color del contenedor:");
					int idBarco = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del barco:"));
					
					PreparedStatement stmt;
					String sql = "INSERT INTO contenedor (id_contenedor, capacidad, color, id_barco) VALUES (?, ?, ?, ?)";
					try {
						stmt = con.prepareStatement(sql);
						stmt.setInt(1, idContenedor);
						stmt.setInt(2, capacidad);
						stmt.setString(3, color);
						stmt.setInt(4, idBarco);
						stmt.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Se ha agregado el contenedor");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
					}
					
					break;
				case 1: 
					//MOSTRAR CONTENEDORES
					try {
				        String selectQuery = "SELECT * FROM contenedor";
				        PreparedStatement selectStmt = con.prepareStatement(selectQuery);
				        ResultSet rs = selectStmt.executeQuery();

				        StringBuilder new_mensaje = new StringBuilder();

				        while(rs.next()){
				        	new_mensaje.append("Id: ").append(rs.getInt("id_contenedor")).append("\n");
				        	new_mensaje.append("Capacidad: ").append(rs.getInt("capacidad")).append("\n");
				        	new_mensaje.append("Color: ").append(rs.getString("color")).append("\n");
				        	new_mensaje.append("Id Barco: ").append(rs.getInt("id_barco")).append("\n");
				        }
				            
				        JOptionPane.showMessageDialog(null, new_mensaje.toString());
				    } catch(SQLException e) {
				        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
				    }
					break;
				case 2:
					//MOSTRAR BARCOS
					try {
				        String selectQuery = "SELECT * FROM barco";
				        PreparedStatement selectStmt = con.prepareStatement(selectQuery);
				        ResultSet rs = selectStmt.executeQuery();

				        StringBuilder new_mensaje = new StringBuilder();

				        while(rs.next()){
				        	new_mensaje.append("Id: ").append(rs.getInt("id_barco")).append("\n");
				        	new_mensaje.append("Nombre: ").append(rs.getString("nombre")).append("\n");
				        	new_mensaje.append("Capacidad: ").append(rs.getInt("capacidad")).append("\n");
				        	new_mensaje.append("Destino: ").append(rs.getString("destino")).append("\n");
				        }
				            
				        JOptionPane.showMessageDialog(null, new_mensaje.toString());
				    } catch(SQLException e) {
				        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
				    }
					break;
				case 3: 
					JOptionPane.showMessageDialog(null, "Salir");
					break;
				default:
				break;
					
			}
			
			
			
		} while (op !=3);
		
		
		
				

	}
	 private static ArrayList<Producto> obtenerProductosParaPedido() {
	        ArrayList<Producto> productos = new ArrayList<>();
	        // Lógica para obtener productos
	        // Ejemplo:
	        int id = 1; // 
	        String nombre = "leche"; 
	        double tamano = 10.5; 
	        double precio = 25.99; 
	        int stock = 100; 
	        Proveedor proveedor = new Proveedor(1, "Jorge", "Alimentos", "Islas Malvinas", "1157302364", "jorgenew.@gmail.com","1234"); 
	        productos.add(new Producto(id, nombre, tamano, precio, stock, proveedor));
	        return productos;
	    }
	 
	 private static Contenedor obtenerContenedor(int opcion, Contenedor cont1, Contenedor cont2, Contenedor cont3) {
	        switch (opcion) {
	            case 0:
	                return cont1;
	            case 1:
	                return cont2;
	            case 2:
	                return cont3;
	            default:
	                return null;
	        }
	        
	    }

} 
