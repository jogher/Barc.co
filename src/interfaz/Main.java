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
					
					Usuario usuario = null;
					
					if (validador.IniciarSesion(email,contrasena,"gerente")) {
						Gerente Verificador = new Gerente();
						Verificador.Mostrar(email, contrasena);
						PantallaGerente interfazGerente = new PantallaGerente ();
						interfazGerente.Menu();
						usuario = new Usuario(Verificador.getNombre(), email, "Gerente"); 
					} else if(validador.IniciarSesion(email,contrasena,"cliente")) {
						Cliente Verificador = new Cliente();
						Verificador.Mostrar(email, contrasena);						
						PantallaCliente interfazCliente = new PantallaCliente();
						interfazCliente.Menu();
						 usuario = new Usuario(Verificador.getNombre(), email, "Cliente");
					} else if(validador.IniciarSesion(email,contrasena,"proveedor")){
						Proveedor Verificador = new Proveedor();
						Verificador.Mostrar(email, contrasena);
						PantallaProveedor interfazProveedor = new PantallaProveedor();
						Main.email = email;
						interfazProveedor.Menu();
						 usuario = new Usuario(Verificador.getNombre(), email, "Proveedor");
					} else {
						JOptionPane.showMessageDialog(null, "Email o Contraseña incorrecto \nNo se puedo iniciar la sesion");
					}
					
					if (usuario != null) {
						JOptionPane.showMessageDialog(null, "Usuario: " + usuario.getNombre() + "\n" + 
															"Email: " + usuario.getEmail() + "\n" +
															"Tipo: " + usuario.getTipo()				
								);
					   /* System.out.println("Usuario: " + usuario.getNombre());
					    System.out.println("Email: " + usuario.getEmail());
					    System.out.println("Tipo: " + usuario.getTipo());*/
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
								break;
							case 1:
								tipo = "Cliente";
								break;
							case 2:
								tipo = "Proveedor";
								break;
							default:
								break;
						}
					
					try {
						Conexion conexion = new Conexion();				 
						Connection con = conexion.conectar();
						System.out.println("Conexión a la base de datos establecida: " + (con != null));

						System.out.println("Tipo de usuario: " + tipo);
						//mensaje de depruacion para ver si funciona 
						System.out.println("Nombre: " + nombre);
						System.out.println("Mail: " + nuevoMail);
						System.out.println("Contraseña: " + nuevaContrasena);

						
						String query = "INSERT INTO " + tipo.trim() + " (nombre, email, contrasena) VALUES (?,?,?)";
						PreparedStatement stmt = con.prepareStatement(query);
						stmt.setString(1, nombre);
						stmt.setString(2, nuevoMail);
						stmt.setString(3, nuevaContrasena);
						
						System.out.println("Consulta SQL: " + query);
						
						
						int datosInsertados = stmt.executeUpdate();
						if (datosInsertados >0) {
							JOptionPane.showMessageDialog(null, " Nuevo usuario registrado como " + tipo);
							System.out.println("Filas afectadas: " + datosInsertados);
							
							
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
					JOptionPane.showMessageDialog(null, "Salir");
					break;
				default:
					break;
				}
			} while (opcion !=2);
		      
		      

		    
		
		

	}

}
