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
		
		InicioSesion inicioSesion = new InicioSesion();
		inicioSesion.run();
	}

}
