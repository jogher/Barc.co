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

	
	public void crearNuevoContenedor(int idContenedor,int capacidad,String color,int idBarco) {
		Conexion conexion = new Conexion();
		Connection con = conexion.conectar();
		
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
		} catch (SQLException e) {
		      JOptionPane.showMessageDialog(null, "Error al crear contenedor: " + e.getMessage());
		    }
		  }

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
				"Asignar Pedido-Contenedor",
				"Pedidos en proceso de envio",
				"Registrar pedido con proveedor",
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
					//ASIGNAR CONTENEDOR A PEDIDO
					try {
						String selectQuery = "SELECT id_pedido, destino FROM pedido WHERE id_contenedor = 1";
				        PreparedStatement selectStmt = con.prepareStatement(selectQuery);
				        ResultSet rs = selectStmt.executeQuery();
				        
				        StringBuilder new_mensaje = new StringBuilder();
				        
				        while(rs.next()){
				        	new_mensaje.append("Id Pedido: ").append(rs.getInt("id_pedido")).append("\n");
				        	new_mensaje.append("Destino: ").append(rs.getString("destino")).append("\n");
				        	
				        }
				        JOptionPane.showMessageDialog(null, new_mensaje.toString());
				        int id_pedido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Id del pedido: "));
				        int id_contenedor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Id del contenedor: "));
				        String selectQuery1 = "UPDATE pedido SET id_contenedor = ? WHERE id_pedido = "+id_pedido;
				        PreparedStatement selectStmt1;
				        try {
				        	selectStmt1 = con.prepareStatement(selectQuery1);
							selectStmt1.setInt(1, id_contenedor);
							selectStmt1.executeUpdate();
							JOptionPane.showMessageDialog(null, "Se ha asignado el pedido al contenedor correctamente");
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
					}
					
					break;
				case 4: 
					//pedidos en proceso pendiendes de envio
					String mensajePedidos = "Pedidos pendientes: \n";
					try {
						String query = "SELECT * FROM pedido WHERE estado = 'en proceso'";
						 PreparedStatement stmtp = con.prepareStatement(query);
						 ResultSet rs = stmtp.executeQuery();
						 
						 while (rs.next()) {
							 int idPedido = rs.getInt("id_pedido");
							 String destino = rs.getString("destino");
							 mensajePedidos += "Pedido Nro " + idPedido + " - Destino: " + destino + "\n";
						 }
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());						 
					}
					
					JOptionPane.showMessageDialog(null, mensajePedidos);
					
					 String nuevoDestino = JOptionPane.showInputDialog("Ingrese el nuevo destino para los pedidos pendientes:");
					// agregar destino a los pedidos pendientes
					try {
				        String updateQuery = "UPDATE pedido SET destino = ? WHERE estado = 'en proceso'";
				        PreparedStatement updateStmt = con.prepareStatement(updateQuery);
				        updateStmt.setString(1, nuevoDestino);
				        updateStmt.executeUpdate();
				        
				        JOptionPane.showMessageDialog(null, "Se ha actualizado el destino para los pedidos pendientes.");
				    } catch (SQLException e) {
				        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
				    }
					
					 Integer idPedidoSeleccionado = null;

				        String inputIdPedido = JOptionPane.showInputDialog("Ingrese el id del pedido para enviar: ");

				        if (inputIdPedido != null && !inputIdPedido.isEmpty()) {
				            try {
				                idPedidoSeleccionado = Integer.parseInt(inputIdPedido);
				            } catch (NumberFormatException e) {
				            	 JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
				                System.out.println("Error: La entrada no es un número válido.");
				                // Manejar la excepción según sea necesario
				            }
				        } else {
				        	JOptionPane.showMessageDialog(null, "no se ingreso Id del pedido ");
				           // System.out.println("No se ingresó ningún valor para el ID del pedido.");
				            return; // Salir del método si no hay entrada válida
				        }
					
					// seleccioar un pedido y asignaler un contenedor 
					//int idPedidoSeleccionado = Integer.parseInt("Ingrese el id del pedido para enviar: ");
					int idContenedorAsignado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del contenedor asignado: ").trim());
					
					try {
						String updateQuery = "UPDATE pedido SET estado = 'enviado', id_contenedor = ? WHERE id_pedido = ?";
						PreparedStatement updateStmt = con.prepareStatement(updateQuery);
						updateStmt.setInt(1, idContenedorAsignado);
						updateStmt.setInt(2, idPedidoSeleccionado);
						updateStmt.executeUpdate();
						
						 JOptionPane.showMessageDialog(null, "Pedido enviado con exito" );
					} catch (SQLException e) {
						 JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());						
					}

					break;
				case 5: 
				    // Registrar nuevo producto con proveedor
				    int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del producto:"));
				    String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
				    double tamanoProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tamaño del producto:"));
				    double precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
				    int stockProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto:"));

				    // Solicitar datos del proveedor
				    int idProNu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del proveedor:"));
				    String nombrePro = JOptionPane.showInputDialog("Ingrese el nombre del proveedor:");
				    // Otros datos del proveedor

				    // Crea el objeto Proveedor
				    Proveedor proveedorNuevo = new Proveedor();

				    // Crea el objeto Producto con los datos ingresados
				    Producto nuevoProducto = new Producto(idProducto, nombreProducto, tamanoProducto, precioProducto, stockProducto, proveedorNuevo);

				    // Registra el producto en la base de datos o realiza las acciones necesarias
				    // ...

				    JOptionPane.showMessageDialog(null, "Se ha registrado el producto con éxito.");
				    break;

				case 6: 
					JOptionPane.showMessageDialog(null, "Salir");
					InicioSesion inicioSesion = new InicioSesion();
					inicioSesion.run();
					break;
				default:
				break;		
			}
		} while (op != 6);
		
			
	}
} 
