package interfaz;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DLL.Conexion;
import logica.Producto;
import logica.Proveedor;
import logica.Usuario;
import logica.MiValidador;
import logica.Validador;
import logica.Pedido;
import logica.Gerente;
import logica.Cliente;
import logica.Contenedor;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main{
	

	public static String email;

	public static void main(String[] args) {

		
		      Validador validador = new MiValidador();
		      String[] opciones = {"Ingresar credenciales", "Registrarse", "Salir"};
		      int opcion = 0;
		      
		      do {
		    	  opcion = JOptionPane.showOptionDialog(null, "Iniciar sesión", null, 0, 0, null, opciones, opciones[0]);
		    	  
		    	  
		    	  switch (opcion) {
				case 0:
					String email = "";
					String contrasena = "";
					do {
						 email = JOptionPane.showInputDialog("Ingrese su Email");
						 contrasena = JOptionPane.showInputDialog("Ingrese su Contraseña");
					} while (validador.ValidarMail(email) && validador.ValidarContrasena(contrasena));
					
					
					if (validador.IniciarSesion(email,contrasena,"gerente")) {
						Gerente Verificador = new Gerente();
						Verificador.Mostrar(email, contrasena);
						PantallaGerente interfazGerente = new PantallaGerente ();
						Main.email = email;
						interfazGerente.Menu();
					} else if(validador.IniciarSesion(email,contrasena,"cliente")) {
						Cliente Verificador = new Cliente();
						Verificador.Mostrar(email, contrasena);						
						PantallaCliente interfazCliente = new PantallaCliente();
						Main.email = email;
						interfazCliente.Menu();
					} else if(validador.IniciarSesion(email,contrasena,"proveedor")){
						Proveedor Verificador = new Proveedor();
						Verificador.Mostrar(email, contrasena);
						PantallaProveedor interfazProveedor = new PantallaProveedor();
						Main.email = email;
						interfazProveedor.Menu();	 
					} else {
						JOptionPane.showMessageDialog(null, "Email o Contraseña incorrecto \nNo se puedo iniciar la sesion");
					}
					
					break;
				case 1:
					//registro de usuario
					
					String nombre = "";
					String nuevoMail = "";
					String nuevaContrasena = "";
					
					nombre =  JOptionPane.showInputDialog("Ingrese su nombre");
					nuevoMail = JOptionPane.showInputDialog("Ingrese su nuevo mail");
					nuevaContrasena = JOptionPane.showInputDialog("Ingrese una contraseña");
					
					nombre = nombre.trim();
					nuevoMail = nuevoMail.trim();
					nuevaContrasena = nuevaContrasena.trim();
					
					String [] tiposUsuario = {"Gerente", "Cliente", "Proveedor"};
					int tipoUsuario = JOptionPane.showOptionDialog(null, "Seleccione el tipo de usuario", null, 0, 0, null, tiposUsuario, tiposUsuario[0]);
					
					String tipo = "";
						switch (tipoUsuario) {
							case 0:
								tipo = "Gerente";
								String apellido = JOptionPane.showInputDialog("Ingrese su apellido");
								
								try {
									Conexion conexion = new Conexion();				 
									Connection con = conexion.conectar();
									
									String query = "INSERT INTO gerente (nombre, apellido, email, contrasena) VALUES (?,?,?,?)";
									PreparedStatement stmt = con.prepareStatement(query);
									stmt.setString(1, nombre);
									stmt.setString(2, apellido);
									stmt.setString(3, nuevoMail);
									stmt.setString(4, nuevaContrasena);
									
									int datosInsertados = stmt.executeUpdate();
									if (datosInsertados >0) {
										JOptionPane.showMessageDialog(null, " Nuevo usuario registrado como " + tipo);
									}else {
										JOptionPane.showMessageDialog(null, "No se puedo registrar el usuario");
									}		
									stmt.close();
									con.close();
									
								} catch (SQLException e ) {
									JOptionPane.showMessageDialog(null, "Error de conexión o de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									e.printStackTrace();
								}
								break;
							case 1:
								tipo = "Cliente";
								apellido = JOptionPane.showInputDialog("Ingrese su apellido");
								String dni = JOptionPane.showInputDialog("Ingrese su numero de documento");
								String telefono = JOptionPane.showInputDialog("Ingrese su numero de telefono");
								
								try {
									Conexion conexion = new Conexion();				 
									Connection con = conexion.conectar();
									
									String query = "INSERT INTO cliente (nombre, apellido, dni, telefono, email, contrasena) VALUES (?,?,?,?,?,?)";
									PreparedStatement stmt = con.prepareStatement(query);
									stmt.setString(1, nombre);
									stmt.setString(2, apellido);
									stmt.setString(3, dni);
									stmt.setString(4, telefono);
									stmt.setString(5, nuevoMail);
									stmt.setString(6, nuevaContrasena);
									
									int datosInsertados = stmt.executeUpdate();
									if (datosInsertados >0) {
										JOptionPane.showMessageDialog(null, " Nuevo usuario registrado como " + tipo);
									}else {
										JOptionPane.showMessageDialog(null, "No se puedo registrar el usuario");
									}		
									stmt.close();
									con.close();
									
								} catch (SQLException e ) {
									JOptionPane.showMessageDialog(null, "Error de conexión o de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									e.printStackTrace();
								}
								break;
							case 2:
								tipo = "Proveedor";
								String rubro = JOptionPane.showInputDialog("Ingrese el rubro al que e dedica");
								String ubicacion = JOptionPane.showInputDialog("Ingrese su ubicacion");
								telefono = JOptionPane.showInputDialog("Ingrese su telefono");
								
								try {
									Conexion conexion = new Conexion();				 
									Connection con = conexion.conectar();
									
									String query = "INSERT INTO proveedor (nombre, rubro, ubicacion, telefono, email, contrasena) VALUES (?,?,?,?,?,?)";
									PreparedStatement stmt = con.prepareStatement(query);
									stmt.setString(1, nombre);
									stmt.setString(2, rubro);
									stmt.setString(3, ubicacion);
									stmt.setString(4, telefono);
									stmt.setString(5, nuevoMail);
									stmt.setString(6, nuevaContrasena);
									
									int datosInsertados = stmt.executeUpdate();
									if (datosInsertados >0) {
										JOptionPane.showMessageDialog(null, " Nuevo usuario registrado como " + tipo);
									}else {
										JOptionPane.showMessageDialog(null, "No se puedo registrar el usuario");
									}		
									stmt.close();
									con.close();
									
								} catch (SQLException e ) {
									JOptionPane.showMessageDialog(null, "Error de conexión o de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
									e.printStackTrace();
								}
								break;
							default:
								break;
						}
					break;
				case 2: 
					JOptionPane.showMessageDialog(null, "Salir");
					break;
				default:
					break;
				}
			} while (opcion !=2);
		      
	}

}
