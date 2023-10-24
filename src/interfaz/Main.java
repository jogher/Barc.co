package interfaz;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import DLL.Conexion;
import logica.Producto;
import logica.Proveedor;
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

	public static void main(String[] args) {

//usuario es "admin" y la contraseña es "pass"
		/*boolean loginValido = false;

		
		//usuario es "admin" y la contraseña es "pass"
		boolean loginValido = false;


		while(!loginValido) {
		  try {
		      Conexion conexion = new Conexion();
		      
		      Connection con = conexion.conectar();
		      // declaracion sql
		      String consulta = "SELECT contrasena FROM usuarios WHERE nombre = ?";
		      PreparedStatement preparedStatement = con.prepareStatement(consulta);*/
				
				/*  if(opcion == 1) {
		        System.exit(0); 
		      }
		      // ingreso de contra y usuario
		      String nombreUsuario = JOptionPane.showInputDialog("Nombre de usuario:");
		      String contrasenaIngresada = JOptionPane.showInputDialog("Contraseña:");
		
		      // preparar statement
		      preparedStatement.setString(1, nombreUsuario);
		
		      // consulta
		      ResultSet resultado = preparedStatement.executeQuery();
		
		      if (resultado.next()) {
		        String contrasenaAlmacenada = resultado.getString("contrasena");
		        if (contrasenaIngresada.equals(contrasenaAlmacenada)) {
		        	loginValido = true;
		          JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
		        } else {
		          JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
		        }
		      } else {
		        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
		      }
		
		      // Cierra los recursos
		      resultado.close();
		      preparedStatement.close();
		      con.close();
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		
		
		}*/
		
		      Validador validador = new MiValidador();
		      String[] opciones = {"Ingresar credenciales", "Registrarse", "Salir"};
		      int opcion = 0;
		      
		      do {
		    	  opcion = JOptionPane.showOptionDialog(null, "Iniciar sesión", null, 0, 0, null, opciones, opciones[0]);
		    	  
		    	  
		    	  switch (opcion) {
				case 0:
					String email = JOptionPane.showInputDialog("Ingrese su Email");
					String contrasena = JOptionPane.showInputDialog("Ingrese su Contraseña");
					
					if (validador.IniciarSesion(email,contrasena,"gerente")) {
						Gerente Verificador = new Gerente();
						Verificador.Mostrar(email, contrasena);
						PantallaGerente interfazGerente = new PantallaGerente ();
						interfazGerente.Menu();
					} else if(validador.IniciarSesion(email,contrasena,"cliente")) {
						Cliente Verificador = new Cliente();
						Verificador.Mostrar(email, contrasena);
						PantallaCliente interfazCliente = new PantallaCliente();
						interfazCliente.Menu();
					} else if(validador.IniciarSesion(email,contrasena,"proveedor")){
						Proveedor Verificador = new Proveedor();
						PantallaProveedor interfazProveedor = new PantallaProveedor();
						interfazProveedor.Menu();
					} else {
						JOptionPane.showMessageDialog(null, "Email o Contraseña incorrecto \nNo se puedo iniciar la sesion");
					}
					
					break;
				case 1:
					//registro de usuario
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
