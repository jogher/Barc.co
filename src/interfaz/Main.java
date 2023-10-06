package interfaz;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import DLL.Conexion;
import logica.Producto;
import logica.Pedido;
import logica.Gerente;
import logica.Cliente;
import logica.Contenedor;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
//usuario es "admin" y la contraseña es "pass"
		boolean loginValido = false;

		while(!loginValido) {
		  try {

		      Conexion conexion = new Conexion();
		      
		      Connection con = conexion.conectar();


		      // declaracion sql
		      String consulta = "SELECT contrasena FROM usuarios WHERE nombre = ?";
		      
		      PreparedStatement preparedStatement = con.prepareStatement(consulta);
		      String[] opciones = {"Ingresar credenciales", "Salir"};

		      int opcion = JOptionPane.showOptionDialog(null, "Iniciar sesión", null, 0, 0, null, opciones, opciones[0]);

		      if(opcion == 1) {
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

		
		}
		
		String[] Opciones =
				{
						"Pedidos",
						"Administración",
						"Proveedor",
						"Salir"
				};
		int  op = 0;
		do {
			op = JOptionPane.showOptionDialog(null, "Menu principal", null, 0, 0, null, Opciones, Opciones[0]);

			switch (op) {
				case 0:
					PantallaPedidos interfazPedido = new PantallaPedidos();
					interfazPedido.Menu();
					
					break;
				case 1:
					Gerente gerente = new Gerente(1,30445876, "Carlos", "Ramiez");
					Contenedor contenedor1 = new Contenedor(1, 1000, "Azul");
					Contenedor contenedor2 = new Contenedor(2, 1500, "Amarillo");
					Contenedor contenedor3 = new Contenedor(3, 5000, "Verde");
				
				JOptionPane.showMessageDialog(null, "Gerente: " + gerente.getNombre());
				String[] opciContenedores = {
						"Contenedor 1 - Azul",
						"Contenedor 2 - Amarillo",
						"Contenedor 3 - Verde"
				};
				int seleccioCon = JOptionPane.showOptionDialog(
                        null,
                        "Seleccione un contenedor",
                        "Selección de Contenedor",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciContenedores,
                        opciContenedores[0]
                    );
				
				Contenedor contenedorSele = null;
				switch (seleccioCon) {
					case 0:
						contenedorSele = contenedor1;
						break;
					case 1:
						contenedorSele = contenedor2;
						break;
					case 2:
						contenedorSele = contenedor3;
						break;
				}
				
				if(contenedorSele != null) {
					JOptionPane.showMessageDialog(null, contenedorSele);
					gerente.seleccionarContenedor(contenedorSele);
					
				}


					break;
				case 2:
					PantallaProveedor interfazProveedor = new PantallaProveedor();
					interfazProveedor.Menu();
					break;

				case 3:
					// código para salir
					break;

				default:
					break;
			}

		} while (op != 3);

	}

}
