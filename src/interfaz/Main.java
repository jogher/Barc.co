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
